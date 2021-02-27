package cn.shishuihao.thirdparty.api.spring.boot.jpa.converter;

import cn.shishuihao.thirdparty.api.core.ApiProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import javax.persistence.AttributeConverter;

/**
 * @author shishuihao
 * @version 1.0.0
 */
public class ApiPropertiesJacksonAttributeConverter implements AttributeConverter<ApiProperties, String> {
    private static final ObjectMapper OBJECT_MAPPER;

    static {
        // ObjectMapper
        OBJECT_MAPPER = new ObjectMapper();
        // 将对象全类名一起保存下来，不设置的话将无法反序列化
        OBJECT_MAPPER.activateDefaultTyping(OBJECT_MAPPER.getPolymorphicTypeValidator(), ObjectMapper.DefaultTyping.NON_FINAL);
        // 序列化时，跳过null属性
        OBJECT_MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        // 序列化时，遇到空bean（无属性）时不会失败
        OBJECT_MAPPER.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        // 反序列化时，遇到未知属性（在bean上找不到对应属性）时不会失败
        OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        // 反序列化时，将空数组([])当做null来处理（以便把空数组反序列化到对象属性上——对php生成的json的map属性很有用）
        OBJECT_MAPPER.configure(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT, true);
        // 通过fields来探测（不通过标准getter探测）
        OBJECT_MAPPER.configure(MapperFeature.AUTO_DETECT_FIELDS, true);
    }

    @Override
    public String convertToDatabaseColumn(ApiProperties attribute) {
        try {
            return attribute == null ? null : OBJECT_MAPPER.writeValueAsString(attribute);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public ApiProperties convertToEntityAttribute(String dbData) {
        try {
            return dbData == null ? null : OBJECT_MAPPER.readValue(dbData, ApiProperties.class);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
