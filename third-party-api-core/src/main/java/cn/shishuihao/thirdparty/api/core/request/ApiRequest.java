package cn.shishuihao.thirdparty.api.core.request;

import cn.shishuihao.thirdparty.api.core.api.Api;
import cn.shishuihao.thirdparty.api.core.response.ApiResponse;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public interface ApiRequest<A extends Api<A, T, R>, T extends ApiRequest<A, T, R>, R extends ApiResponse> {
    /**
     * get api type
     * immutable
     *
     * @return api type
     */
    Class<A> apiType();

    /**
     * get response type
     * immutable
     *
     * @return response type
     */
    Class<R> responseType();

    /**
     * get channel id
     * immutable
     *
     * @return channel id
     */
    String channelId();

    /**
     * get properties id
     * immutable
     *
     * @return properties id
     */
    String propertiesId();
}
