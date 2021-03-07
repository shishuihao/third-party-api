package cn.shishuihao.thirdparty.api.push;

import cn.shishuihao.thirdparty.api.core.api.Api;

/**
 * @param <A> push api
 * @param <T> push api request
 * @param <R> push api response
 * @author shishuihao
 * @version 1.0.0
 */
public interface PushApi<
        A extends PushApi<A, T, R>,
        T extends PushApiRequest<A, T, R>,
        R extends PushApiResponse>
        extends Api<A, T, R> {
}
