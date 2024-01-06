package com.ddzj.mypomaner.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.TimeZone;

/**
 * json工具类
 *  TODO
 *  该类最终需要去掉，后期改造JacksonUtils
 *
 */
//@Slf4j
//@UtilityClass
@Deprecated
public class JsonUtils {

    private static Logger logger = LoggerFactory.getLogger(JsonUtils.class);

    public static ObjectMapper mapper = new ObjectMapper();

    static {
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        mapper.enable(DeserializationFeature.READ_UNKNOWN_ENUM_VALUES_AS_NULL);
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        mapper.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        mapper.registerModule(new JavaTimeModule());
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    /**
     * 将对象转换成json字符串
     *
     * @param object 对象
     * @return json字符串
     */
    public static String toJson(Object object) {
        try {
            return mapper.writeValueAsString(object);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    /**
     * 将对象转换成json字符串
     *
     * @param object 对象
     * @return json字符串
     */
    public static String toPrettyJson(Object object) {
        try {
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    /**
     * 将对象转换成json字符串
     *
     * @param jsonString json字符串
     * @param valueType  对象类型
     * @param <T>        对象类型
     * @return 对象
     */
    public static <T> T fromJson(String jsonString, Class<T> valueType) {
        Validate.notNull(valueType, "valueType is null ");
        if (jsonString == null || "".equals(jsonString)) {
            return null;
        }
        try {
            return mapper.readValue(jsonString, valueType);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    /**
     * 将对象转换成json字符串
     *
     * @param jsonString json字符串
     * @param valueType  对象类型
     * @param <T>        对象类型
     * @return 对象
     */
    public static <T> T fromJsonNoEx(String jsonString, Class<T> valueType) {
        Validate.notNull(valueType, "valueType is null ");
        if (jsonString == null || "".equals(jsonString)) {
            return null;
        }
        try {
            return mapper.readValue(jsonString, valueType);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return null;
        }
    }

    /**
     * 将对象转换成json字符串
     *
     * @param is        输入流
     * @param valueType 对象类型
     * @param <T>       对象类型
     * @return 对象
     */
    public static <T> T fromJson(InputStream is, Class<T> valueType) {
        Validate.notNull(valueType, "valueType is null ");
        Validate.notNull(is, "inputStream is null");
        try {
            return mapper.readValue(is, valueType);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    /**
     * 将对象转换成json字符串
     *
     * @param jsonString     json字符串
     * @param collectionType 集合类型
     * @param elementType    元素类型
     * @param <T>            集合类型
     * @param <S>            元素类型
     * @return 对象
     */
    public static <T extends Collection<S>, S> T fromJson(String jsonString, Class<T> collectionType, Class<S> elementType) {
        Validate.notNull(collectionType, "collectionType is null");
        Validate.notNull(elementType, "elementType is null");
        if (jsonString == null || "".equals(jsonString)) {
            return null;
        }
        try {
            return mapper.readValue(jsonString, mapper.getTypeFactory().constructCollectionType(collectionType, elementType));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    /**
     * 将对象转换成json字符串
     *
     * @param jsonString    json字符串
     * @param typeReference 类型引用
     * @param <T>           类型引用
     * @return 对象
     */
    public static <T> T fromJson(String jsonString, TypeReference<T> typeReference) {
        Validate.notNull(typeReference, "typeReference is null");
        if (jsonString == null || "".equals(jsonString)) {
            return null;
        }
        try {
            return mapper.readValue(jsonString, typeReference);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    /**
     * 将对象转换成json字符串
     *
     * @param file 文件
     * @param data 对象
     */
    public static void writeTo(File file, Object data) {
        try {
            mapper.writeValue(file, data);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    /**
     * 将对象转换成json字符串
     *
     * @param file 文件
     * @param data 对象
     */
    public static void writeToPretty(File file, Object data) {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(file, data);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    /**
     * 将文件内容转换为对象
     *
     * @param file           文件
     * @param collectionType 集合类型
     * @param elementType    元素类型
     * @param <T>            集合类型
     * @param <S>            元素类型
     * @return 对象
     */
    public static <T extends Collection<S>, S> T readFrom(File file, Class<T> collectionType, Class<S> elementType) {
        Validate.notNull(collectionType, "collectionType is null");
        Validate.notNull(elementType, "elementType is null");
        if (file == null || !file.canRead()) {
            return null;
        }
        try {
            return mapper.readValue(file, mapper.getTypeFactory().constructCollectionType(collectionType, elementType));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    /**
     * 将文件内容转换为对象
     *
     * @param file          文件
     * @param typeReference 类型引用
     * @param <T>           类型引用
     * @return 对象
     */
    public static <T> T readFrom(File file, TypeReference<T> typeReference) {
        Validate.notNull(typeReference, "typeReference is null");
        if (file == null || !file.canRead()) {
            return null;
        }
        try {
            return mapper.readValue(file, typeReference);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
