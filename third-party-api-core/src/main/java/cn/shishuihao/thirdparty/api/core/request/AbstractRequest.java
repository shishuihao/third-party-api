package cn.shishuihao.thirdparty.api.core.request;

import cn.shishuihao.thirdparty.api.core.api.Api;
import cn.shishuihao.thirdparty.api.core.response.ApiResponse;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public abstract class AbstractRequest<A extends Api<A, T, R>, T extends ApiRequest<A, T, R>, R extends ApiResponse> {
    /**
     * channel id
     */
    private final String channelId;
    /**
     * properties id
     */
    private final String propertiesId;

    protected AbstractRequest(String channelId, String propertiesId) {
        this.channelId = channelId;
        this.propertiesId = propertiesId;
    }

    public String getChannelId() {
        return channelId;
    }

    public String getPropertiesId() {
        return propertiesId;
    }

    public String channelId() {
        return channelId;
    }

    public String propertiesId() {
        return propertiesId;
    }
}
