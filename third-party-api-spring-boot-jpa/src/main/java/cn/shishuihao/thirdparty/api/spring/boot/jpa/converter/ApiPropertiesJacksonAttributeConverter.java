package cn.shishuihao.thirdparty.api.spring.boot.jpa.converter;

import cn.shishuihao.thirdparty.api.commons.json.JacksonUtils;
import cn.shishuihao.thirdparty.api.core.properties.ApiProperties;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Converter(autoApply = true)
public class ApiPropertiesJacksonAttributeConverter implements AttributeConverter<ApiProperties, String> {
    @Override
    public String convertToDatabaseColumn(ApiProperties attribute) {
        return JacksonUtils.toJson(attribute);
    }

    @Override
    public ApiProperties convertToEntityAttribute(String dbData) {
        return JacksonUtils.fromJson(dbData, ApiProperties.class);
    }
}
