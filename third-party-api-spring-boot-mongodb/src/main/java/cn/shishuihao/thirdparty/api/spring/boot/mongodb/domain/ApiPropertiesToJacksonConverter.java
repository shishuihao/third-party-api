package cn.shishuihao.thirdparty.api.spring.boot.mongodb.domain;

import cn.shishuihao.thirdparty.api.commons.json.JacksonTypingUtils;
import cn.shishuihao.thirdparty.api.core.properties.ApiProperties;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;


/**
 * @author shishuihao
 * @version 1.0.0
 */
public class ApiPropertiesToJacksonConverter
        implements Converter<ApiProperties, String> {
    /**
     * Convert the source object of type {@code S} to target type {@code T}.
     *
     * @param source the source object to convert
     * @return the converted object
     * @throws IllegalArgumentException if  cannot be converted
     */
    @Nullable
    @Override
    public String convert(final @NonNull ApiProperties source) {
        return JacksonTypingUtils.toJson(source);
    }
}
