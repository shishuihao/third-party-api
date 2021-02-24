package cn.shishuihao.thirdparty.api.core.impl.memory;

import cn.shishuihao.thirdparty.api.core.Api;
import cn.shishuihao.thirdparty.api.core.Channel;
import cn.shishuihao.thirdparty.api.core.Request;
import cn.shishuihao.thirdparty.api.core.Response;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public abstract class AbstractChannelMemoryImpl implements Channel {
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
    public <A extends Api<A, T, R>, T extends Request<A, T, R>, R extends Response> Optional<A> getApi(final Class<A> apiType) {
        return Optional.ofNullable((A) this.getById(apiType).orElse(null));
    }
}
