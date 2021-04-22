package cn.shishuihao.thirdparty.api.commons.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public final class JacksonUtils {
    /**
     * ObjectMapper provides functionality for reading and writing JSON,
     * either to and from basic POJOs (Plain Old Java Objects),
     * or to and from a general-purpose JSON Tree Model (JsonNode),
     * as well as related functionality for performing conversions.
     */
    private static final ObjectMapper OBJECT_MAPPER;

    static {
        // ObjectMapper
        OBJECT_MAPPER = new ObjectMapper();
        // 序列化时，跳过null属性
        OBJECT_MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    private JacksonUtils() {
    }

    /**
     * object to json.
     *
     * @param value object
     * @return json
     */
    public static String toJson(final Object value) {
        if (value == null) {
            return null;
        }
        try {
            return OBJECT_MAPPER.writeValueAsString(value);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException(e);
        }
    }

    /**
     * object convert to other.
     *
     * @param fromValue   object
     * @param toValueType toValueType
     * @param <T>         T
     * @return T
     */
    public static <T> T convert(final Object fromValue, final Class<T> toValueType) {
        return OBJECT_MAPPER.convertValue(fromValue, toValueType);
    }

    /**
     * json to object.
     *
     * @param content   json
     * @param valueType object type
     * @param <T>       object type
     * @return object
     */
    public static <T> T fromJson(final String content,
                                 final Class<T> valueType) {
        if (content == null) {
            return null;
        }
        try {
            return OBJECT_MAPPER.readValue(content, valueType);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
