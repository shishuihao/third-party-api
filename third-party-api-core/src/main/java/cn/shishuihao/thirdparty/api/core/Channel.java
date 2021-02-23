package cn.shishuihao.thirdparty.api.core;

import java.util.Optional;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public interface Channel extends Entity<String>, ApiRepository {
    /**
     * get api by api type
     *
     * @param apiType api type
     * @return api
     */
    <A extends Api<A, T, R>, T extends Request<A, T, R>, R extends Response> Optional<A> getApi(final Class<A> apiType);
}
