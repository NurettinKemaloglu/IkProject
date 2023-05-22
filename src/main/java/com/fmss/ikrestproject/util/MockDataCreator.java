package com.fmss.ikrestproject.util;


import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MockDataCreator {

    private static final String BASE_PACKAGE_NAME = "com.advicemybackend";

    /**
     * Create mock object list
     * @param clazz
     * @param size
     * @param <T>
     * @return
     */
    public static <T> List<T> createData(Class<T> clazz, int size) {

        return IntStream.range(0, size).mapToObj(e -> (T) createData(clazz)).collect(Collectors.toList());
    }


    /**
     * Create mock object set
     * @param clazz
     * @param size
     * @param <T>
     * @return
     */
    public static <T> Set<T> createSetData(Class<T> clazz, int size) {

        return IntStream.range(0, size).mapToObj(e -> (T) createData(clazz)).collect(Collectors.toSet());
    }

    /**
     * Create mock object
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T createData(Class<T> clazz) {
        Node baseNode = new Node(clazz.getName());
        return createData(clazz, baseNode, baseNode);
    }

    public static <T> T createData(Class<T> clazz, Node headNode, Node defaultNode) {
        Object createObject = null;

        try {
            if (!clazz.getName().contains("$")) {
                createObject = clazz.newInstance();

                for (Method method : clazz.getMethods()) {
                    if (method.getName().startsWith("set")) {
                        Class<?>[] methodParameters = method.getParameterTypes();
                        if (methodParameters.length == 1) {
                            Class<?> parameter = methodParameters[0];

                            if (!ObjectUtils.isEmpty(parameter.getEnumConstants())) { // Enum ise
                                setEnumField(createObject, parameter, method);
                            } else if (parameter.getName().equals(List.class.getName())) {
                                setListFields(createObject, method, headNode);
                            } else if (parameter.getPackage().getName().contains(BASE_PACKAGE_NAME)) {
                                if (!Node.isNodeAlreadyUsed(headNode, defaultNode, parameter.getName())) {
                                    final Node subNode = new Node(defaultNode, parameter.getName());
                                    defaultNode.getNodeList().add(subNode);
                                    final Object subObject = createData(parameter, headNode, subNode);
                                    setCustomField(createObject, method, subObject);
                                }
                            } else {
                                setDefaultValues(createObject, parameter, method);
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {

        }
        return (T) createObject;
    }

    private static void setCustomField(Object createObject, Method method, Object subObject) throws InvocationTargetException, IllegalAccessException {
        method.invoke(createObject, subObject);
    }

    private static void setDefaultValues(Object object, Class<?> parameter, Method method) throws InvocationTargetException, IllegalAccessException {
        if (parameter.isAssignableFrom(String.class)) {
            setStringField(object, method);
        } else if (parameter.isAssignableFrom(Integer.class)) {
            setIntegerField(object, method);
        } else if (parameter.isAssignableFrom(Long.class)) {
            setLongField(object, method);
        } else if (parameter.isAssignableFrom(Double.class)) {
            setDoubleField(object, method);
        } else if (parameter.isAssignableFrom(BigDecimal.class)) {
            setBigDecimalField(object, method);
        } else if (parameter.isAssignableFrom(Date.class)) {
            method.invoke(object, new Date());
        }
    }

    private static void setListFields(Object object, Method method, Node headNode) throws IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        final Type[] genericParameterTypes = method.getGenericParameterTypes();
        final ParameterizedType pType = (ParameterizedType) genericParameterTypes[0];

        Class clazz = Class.forName(Arrays.stream(((ParameterizedType) pType).getActualTypeArguments()).findFirst().get().getTypeName());

        Node listHeadNode = new Node(headNode, clazz.getName());
        final Object data = createData(clazz, listHeadNode, listHeadNode);

        method.invoke(object, Arrays.asList(data));
    }

    private static void setEnumField(Object object, Class<?> parameter, Method method) throws InvocationTargetException, IllegalAccessException {
        final Object[] enumConstants = parameter.getEnumConstants();
        final int enumIndex = RandomUtils.nextInt(0, enumConstants.length - 1);
        method.invoke(object, parameter.getEnumConstants()[enumIndex]);
    }

    private static void setDoubleField(Object object, Method method) throws IllegalAccessException, InvocationTargetException {
        method.invoke(object, Double.valueOf(RandomUtils.nextInt()));
    }

    private static void setLongField(Object object, Method method) throws IllegalAccessException, InvocationTargetException {
        method.invoke(object, Long.valueOf(RandomUtils.nextInt()));
    }

    private static void setBigDecimalField(Object object, Method method) throws IllegalAccessException, InvocationTargetException {
        method.invoke(object, BigDecimal.valueOf(RandomUtils.nextInt()));
    }

    private static void setIntegerField(Object object, Method method) throws IllegalAccessException, InvocationTargetException {
        method.invoke(object, Integer.valueOf(RandomUtils.nextInt()));
    }

    private static void setStringField(Object createObject, Method method) throws InvocationTargetException, IllegalAccessException {
        method.invoke(createObject, RandomStringUtils.randomAlphabetic(10));
    }
}
