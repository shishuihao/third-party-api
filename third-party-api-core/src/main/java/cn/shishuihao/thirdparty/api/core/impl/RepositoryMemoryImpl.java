package cn.shishuihao.thirdparty.api.core.impl;

import cn.shishuihao.thirdparty.api.core.Entity;
import cn.shishuihao.thirdparty.api.core.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class RepositoryMemoryImpl<I, T extends Entity<I>> implements Repository<I, T> {
    private final Map<I, T> map = new ConcurrentHashMap<>();

    @Override
    public void add(T entity) {
        map.put(entity.id(), entity);
    }

    @Override
    public Optional<T> getById(I id) {
        return Optional.ofNullable(map.get(id));
    }
}
