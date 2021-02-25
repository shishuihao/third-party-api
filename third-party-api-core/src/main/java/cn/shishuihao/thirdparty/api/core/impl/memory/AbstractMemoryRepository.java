package cn.shishuihao.thirdparty.api.core.impl.memory;

import cn.shishuihao.thirdparty.api.core.Entity;
import cn.shishuihao.thirdparty.api.core.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public abstract class AbstractMemoryRepository<I, T extends Entity<I>> implements Repository<I, T> {
    private final Map<I, T> map = new ConcurrentHashMap<>();

    @Override
    public void add(final T entity) {
        map.put(entity.id(), entity);
    }

    @Override
    public Optional<T> getById(final I id) {
        return Optional.ofNullable(map.get(id));
    }
}
