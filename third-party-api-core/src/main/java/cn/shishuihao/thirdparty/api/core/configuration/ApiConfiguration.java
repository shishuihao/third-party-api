package cn.shishuihao.thirdparty.api.core.configuration;

import cn.shishuihao.thirdparty.api.core.properties.ApiProperties;
import cn.shishuihao.thirdparty.api.core.repository.AggregateRoot;
import lombok.Builder;
import lombok.Getter;

/**
 * @author shishuihao
 * @version 1.0.0
 */

@Builder
@Getter
public class ApiConfiguration implements AggregateRoot<String> {
    /**
     * app id.
     */
    private final String appId;
    /**
     * channel id.
     */
    private final String channelId;
    /**
     * properties.
     */
    private final ApiProperties properties;

    /**
     * get id.
     *
     * @return id
     */
    @Override
    public String id() {
        return appId + "." + channelId;
    }
}
