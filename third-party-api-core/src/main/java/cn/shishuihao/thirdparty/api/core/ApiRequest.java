package cn.shishuihao.thirdparty.api.core;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public interface ApiRequest<A extends Api<A, T, R>, T extends ApiRequest<A, T, R>, R extends ApiResponse> {
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
     * get api type
     * immutable
     *
     * @return api type
     */
    Class<A> apiType();
}
