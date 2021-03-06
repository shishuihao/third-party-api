package cn.shishuihao.thirdparty.api.spring.boot.mongodb.converter;

import cn.shishuihao.thirdparty.api.commons.json.JacksonUtils;
import cn.shishuihao.thirdparty.api.core.properties.ApiProperties;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;


/**
 * @author shishuihao
 * @version 1.0.0
 */
public class ApiPropertiesToJacksonConverter implements Converter<ApiProperties, String> {
    @Nullable
    @Override
    public String convert(@NonNull ApiProperties source) {
        return JacksonUtils.toJson(source);
    }
}
