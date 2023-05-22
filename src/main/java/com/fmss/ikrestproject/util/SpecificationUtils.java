package com.fmss.ikrestproject.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import java.util.List;
import java.util.function.BiFunction;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class SpecificationUtils {

    public static void addIfNotBlank(List<Predicate> predicates, String value, BiFunction<Expression<?>, Object, Predicate> predicateFunction, Expression<?> expression) {
        if (StringUtils.isNotBlank(value)) {
            predicates.add(predicateFunction.apply(expression, value));
        }
    }

    public static <T> void addIfNotNull(List<Predicate> predicates, T value, BiFunction<Expression<T>, T, Predicate> predicateFunction, Expression<T> expression) {
        if (value != null) {
            predicates.add(predicateFunction.apply(expression, value));
        }
    }

    public static void addIfTrue(List<Predicate> predicates, Boolean value, BiFunction<Expression<Boolean>, Boolean, Predicate> predicateFunction, Expression<Boolean> expression) {
        if (BooleanUtils.isTrue(value)) {
            predicates.add(predicateFunction.apply(expression, value));
        }
    }

    public static void addBetweenIfAllNotBlank(List<Predicate> predicates, BiFunction<Expression<?>, String[], Predicate> predicateFunction, Expression<?> expression, String... value) {
        if (StringUtils.isAnyBlank(value)) {
            return;
        }
        predicates.add(predicateFunction.apply(expression, value));
    }

    public static void addLikeIgnoreCaseIfNotBlank(List<Predicate> predicates, String value, CriteriaBuilder criteriaBuilder, Expression<String> expression) {
        if (StringUtils.isNotBlank(value)) {
            predicates.add(criteriaBuilder.like(criteriaBuilder.lower(expression), "%" + value.toLowerCase() + "%"));
        }
    }
}
