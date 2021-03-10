package cn.shishuihao.thirdparty.api.commons.xml;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public final class JacksonXmlUtils {
    /**
     * ObjectMapper provides functionality for reading and writing JSON,
     * either to and from basic POJOs (Plain Old Java Objects),
     * or to and from a general-purpose JSON Tree Model (JsonNode),
     * as well as related functionality for performing conversions.
     */
    private static final ObjectMapper XML_MAPPER;

    static {
        // ObjectMapper
        XML_MAPPER = new XmlMapper();
        XML_MAPPER.configure(
                DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        XML_MAPPER.configure(
                SerializationFeature.WRAP_ROOT_VALUE, false);
        XML_MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        XML_MAPPER.enable(MapperFeature.USE_STD_BEAN_NAMING);
    }

    private JacksonXmlUtils() {
    }

    /**
     * object to xml.
     *
     * @param value object
     * @return xml
     */
    public static String toXml(final Object value) {
        if (value == null) {
            return null;
        }
        try {
            return XML_MAPPER.writeValueAsString(value);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException(e);
        }
    }

    /**
     * xml to object.
     *
     * @param content   xml
     * @param valueType object type
     * @param <T>       object type
     * @return object
     */
    public static <T> T fromXml(final String content,
                                final Class<T> valueType) {
        if (content == null) {
            return null;
        }
        try {
            return XML_MAPPER.readValue(content, valueType);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
