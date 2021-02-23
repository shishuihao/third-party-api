package cn.shishuihao.thirdparty.api.core;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public interface Request<A extends Api<A, T, R>, T extends Request<A, T, R>, R extends Response> {
    /**
     * get response class
     * immutable
     *
     * @return response class
     */
    Class<R> responseClass();

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
