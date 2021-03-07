package cn.shishuihao.thirdparty.api.core.channel;

import cn.shishuihao.thirdparty.api.core.api.Api;
import cn.shishuihao.thirdparty.api.core.api.ApiRepository;
import cn.shishuihao.thirdparty.api.core.properties.ApiProperties;
import cn.shishuihao.thirdparty.api.core.repository.Entity;
import cn.shishuihao.thirdparty.api.core.request.ApiRequest;
import cn.shishuihao.thirdparty.api.core.response.ApiResponse;

import java.util.Optional;

/**
 * @param <P> api properties
 * @author shishuihao
 * @version 1.0.0
 */
public interface ApiChannel<
        P extends ApiProperties>
        extends Entity<String>, ApiRepository {
    /**
     * get api by api type.
     *
     * @param apiType api type
     * @param <A>     api
     * @param <T>     request
     * @param <R>     response
     * @return Optional<A>
     */
    <
            A extends Api<A, T, R>,
            T extends ApiRequest<A, T, R>,
            R extends ApiResponse> Optional<A> getApi(Class<A> apiType);

    /**
     * get properties type.
     * immutable
     *
     * @return properties type
     */
    Class<P> propertiesType();
}
