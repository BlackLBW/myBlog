package com.bowen.blog.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by libowen on 2018/9/4.
 */
public class JsonUtils {private static ObjectMapper INSTANCE = new ObjectMapper();

    private JsonUtils() {
    }

    /**
     * @param obj 准备转换对象
     * @description 对象转换成json字符串
     */
    public static String toJsonStr(Object obj) {
        try {
            return INSTANCE.writeValueAsString(obj);
        } catch (IOException e) {


        }
        return null;
    }

    /**
     * @param json 准备转换json
     * @param type 转换类型
     * @description json字符串转换成对象
     */
    @SuppressWarnings("unchecked")
    public static <T> T parseJson(String json, String type) {
        try {
            return (T) parseJson(json, Class.forName(type));
        } catch (Exception e) {

        }
        return null;
    }

    /**
     * @param json 准备转换json
     * @param clazz 转换类型
     * @description json字符串转换成对象
     */
    public static <T> T parseJson(String json, Class<T> clazz) {
        try {
            return (T) INSTANCE.readValue(json, clazz);
        } catch (IOException e) {

        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public static <T> T parseJson(String json, TypeReference valueTypeRef) {
        try {
            return (T) INSTANCE.readValue(json, valueTypeRef);
        } catch (IOException e) {

        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public static <T> T parseJson(String json, JavaType valueType) {
        try {
            return (T) INSTANCE.readValue(json, valueType);
        } catch (IOException e) {

        }
        return null;
    }

    /**
     * @param json 准备转换json
     * @param clazz 集合元素类型
     * @description json字符串转换成对象集合
     */
    @SuppressWarnings("unchecked")
    public static <T> List<T> parseJsonList(String json, Class<T> clazz) {
        try {
            JavaType javaType = getCollectionType(ArrayList.class, clazz);
            return (List<T>) INSTANCE.readValue(json, javaType);
        } catch (IOException e) {

        }
        return null;
    }

    /**
     * @param collectionClass 集合类
     * @param elementClasses 集合元素类
     * @description 获取泛型的ColloectionType
     */
    private static JavaType getCollectionType(Class<?> collectionClass,
                                              Class<?>... elementClasses) {
        return INSTANCE.getTypeFactory().constructParametricType(collectionClass, elementClasses);
    }



}
