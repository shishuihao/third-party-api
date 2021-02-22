package cn.shishuihao.thirdparty.api.core;

/**
 * @author shishuihao
 * @version 1.0.0
 */
public interface Api<A extends Api<A, T, R>, T extends Request<A, T, R>, R extends Response> extends Entity<Class<?>> {
    /**
     * execute request
     *
     * @param request request
     * @return response
     * @throws ApiException api exception
     */
    R execute(T request);

    /**
     * get entity id
     *
     * @return entity id
     */
    @Override
    default Class<?> id() {
        return this.getClass();
    }
}
