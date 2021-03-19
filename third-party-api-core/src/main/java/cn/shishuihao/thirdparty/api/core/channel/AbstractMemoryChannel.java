package cn.shishuihao.thirdparty.api.core.channel;

import cn.shishuihao.thirdparty.api.core.api.Api;
import cn.shishuihao.thirdparty.api.core.properties.ApiProperties;
import cn.shishuihao.thirdparty.api.core.request.ApiRequest;
import cn.shishuihao.thirdparty.api.core.response.ApiResponse;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @param <P> api properties
 * @author shishuihao
 * @version 1.0.0
 */
public abstract class AbstractMemoryChannel<
        P extends ApiProperties>
        implements ApiChannel<P> {
    /**
     * map.
     */
    private final Map<Class<?>, Api<?, ?, ?>> map = new ConcurrentHashMap<>();

    /**
     * add aggregateRoot.
     *
     * @param aggregateRoot aggregateRoot
     */
    @Override
    public void add(final Api<?, ?, ?> aggregateRoot) {
        map.put(aggregateRoot.id(), aggregateRoot);
        map.put(aggregateRoot.apiType(), aggregateRoot);
    }

    /**
     * get aggregateRoot by id.
     *
     * @param id aggregateRoot id
     * @return optional aggregateRoot
     */
    @Override
    public Optional<Api<?, ?, ?>> get(final Class<?> id) {
        return Optional.ofNullable(map.get(id));
    }

    /**
     * get api by api type.
     *
     * @param apiType api type
     * @param <A>     api
     * @param <T>     request
     * @param <R>     response
     * @return Optional<A>
     */
    @SuppressWarnings("unchecked")
    @Override
    public <A extends Api<A, T, R>,
            T extends ApiRequest<A, T, R>,
            R extends ApiResponse> Optional<A> getApi(final Class<A> apiType) {
        return Optional.ofNullable((A) this.get(apiType).orElse(null));
    }
}
