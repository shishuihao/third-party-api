package cn.shishuihao.thirdparty.api.core.impl.memory;

import cn.shishuihao.thirdparty.api.core.Api;
import cn.shishuihao.thirdparty.api.core.ApiChannel;
import cn.shishuihao.thirdparty.api.core.ApiRequest;
import cn.shishuihao.thirdparty.api.core.ApiResponse;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public abstract class AbstractChannelMemoryImpl implements ApiChannel {
    private final Map<Class<?>, Api<?, ?, ?>> map = new ConcurrentHashMap<>();

    @Override
    public void add(final Api<?, ?, ?> entity) {
        map.put(entity.id(), entity);
        map.put(entity.apiType(), entity);
    }

    @Override
    public Optional<Api<?, ?, ?>> getById(final Class<?> id) {
        return Optional.ofNullable(map.get(id));
    }

    @SuppressWarnings("unchecked")
    @Override
    public <A extends Api<A, T, R>, T extends ApiRequest<A, T, R>, R extends ApiResponse> Optional<A> getApi(final Class<A> apiType) {
        return Optional.ofNullable((A) this.getById(apiType).orElse(null));
    }
}
