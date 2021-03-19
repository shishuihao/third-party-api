package cn.shishuihao.thirdparty.api.core.api;

import cn.shishuihao.thirdparty.api.core.repository.AggregateRoot;
import cn.shishuihao.thirdparty.api.core.request.ApiRequest;
import cn.shishuihao.thirdparty.api.core.response.ApiResponse;

/**
 * @param <A> api
 * @param <T> api request
 * @param <R> api response
 * @author shishuihao
 * @version 1.0.0
 */
public interface Api<
        A extends Api<A, T, R>,
        T extends ApiRequest<A, T, R>,
        R extends ApiResponse>
        extends AggregateRoot<Class<?>> {
    /**
     * execute request.
     *
     * @param request request
     * @return response
     */
    R execute(T request);

    /**
     * get id.
     *
     * @return id
     */
    @Override
    default Class<?> id() {
        return this.getClass();
    }

    /**
     * get api type.
     * immutable
     *
     * @return api type
     */
    Class<A> apiType();
}
