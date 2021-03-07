package cn.shishuihao.thirdparty.api.spring.boot.jpa.converter;

import cn.shishuihao.thirdparty.api.commons.json.JacksonTypingUtils;
import cn.shishuihao.thirdparty.api.core.properties.ApiProperties;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Converter(autoApply = true)
public class ApiPropertiesJacksonAttributeConverter
        implements AttributeConverter<ApiProperties, String> {
    /**
     * Converts the value stored in the entity attribute into the
     * data representation to be stored in the database.
     *
     * @param attribute  the entity attribute value to be converted
     * @return  the converted data to be stored in the database
     *          column
     */
    @Override
    public String convertToDatabaseColumn(final ApiProperties attribute) {
        return JacksonTypingUtils.toJson(attribute);
    }
    /**
     * Converts the data stored in the database column into the
     * value to be stored in the entity attribute.
     * Note that it is the responsibility of the converter writer to
     * specify the correct <code>dbData</code> type for the corresponding
     * column for use by the JDBC driver: i.e., persistence providers are
     * not expected to do such type conversion.
     *
     * @param dbData  the data from the database column to be
     *                converted
     * @return  the converted value to be stored in the entity
     *          attribute
     */
    @Override
    public ApiProperties convertToEntityAttribute(final String dbData) {
        return JacksonTypingUtils.fromJson(dbData, ApiProperties.class);
    }
}
