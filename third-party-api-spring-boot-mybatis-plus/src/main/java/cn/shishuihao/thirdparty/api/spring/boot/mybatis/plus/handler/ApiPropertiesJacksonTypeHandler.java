package cn.shishuihao.thirdparty.api.spring.boot.mybatis.plus.handler;

import cn.shishuihao.thirdparty.api.commons.json.JacksonTypingUtils;
import cn.shishuihao.thirdparty.api.core.properties.ApiProperties;
import com.baomidou.mybatisplus.extension.handlers.AbstractJsonTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@MappedTypes({ApiProperties.class})
@MappedJdbcTypes(JdbcType.VARCHAR)
public class ApiPropertiesJacksonTypeHandler extends AbstractJsonTypeHandler<ApiProperties> {
    @Override
    protected ApiProperties parse(String json) {
        return JacksonTypingUtils.fromJson(json, ApiProperties.class);
    }

    @Override
    protected String toJson(ApiProperties obj) {
        return JacksonTypingUtils.toJson(obj);
    }
}
