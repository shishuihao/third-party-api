package cn.shishuihao.thirdparty.api.core.request;

import cn.shishuihao.thirdparty.api.core.api.Api;
import cn.shishuihao.thirdparty.api.core.response.ApiResponse;

/**
 * @param <A> api
 * @param <T> request
 * @param <R> response
 * @author shishuihao
 * @version 1.0.0
 */
public abstract class AbstractRequest<
        A extends Api<A, T, R>,
        T extends ApiRequest<A, T, R>,
        R extends ApiResponse> {
    /**
     * channel id.
     */
    private final String channelId;
    /**
     * properties id.
     */
    private final String propertiesId;

    /**
     * new AbstractRequest.
     *
     * @param pChannelId    channel id
     * @param pPropertiesId properties id
     */
    protected AbstractRequest(final String pChannelId,
                              final String pPropertiesId) {
        this.channelId = pChannelId;
        this.propertiesId = pPropertiesId;
    }

    /**
     * get channel id.
     *
     * @return String
     */
    public String getChannelId() {
        return channelId;
    }

    /**
     * get properties id.
     *
     * @return String
     */
    public String getPropertiesId() {
        return propertiesId;
    }

    /**
     * get channel id.
     *
     * @return String
     */
    public String channelId() {
        return channelId;
    }

    /**
     * get properties id.
     *
     * @return String
     */
    public String propertiesId() {
        return propertiesId;
    }
}
