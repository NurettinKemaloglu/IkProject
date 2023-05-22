package com.fmss.ikrestproject.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.experimental.UtilityClass;

@UtilityClass
public class JsonConverter {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static <T> T toJson(String json, Class<T> targetClass) throws JsonProcessingException {
        return objectMapper.readValue(json, targetClass);
    }

    public static <T> String jsonToString(T object) throws JsonProcessingException {
        return objectMapper.writeValueAsString(object);
    }
}