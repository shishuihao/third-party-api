package cn.shishuihao.thirdparty.api.pay;

import cn.shishuihao.thirdparty.api.core.api.Api;

/**
 * @param <A> pay api
 * @param <T> pay api request
 * @param <R> pay api response
 * @author shishuihao
 * @version 1.0.0
 */

public interface PayApi<
        A extends PayApi<A, T, R>,
        T extends PayApiRequest<A, T, R>,
        R extends PayApiResponse>
        extends Api<A, T, R> {
}
