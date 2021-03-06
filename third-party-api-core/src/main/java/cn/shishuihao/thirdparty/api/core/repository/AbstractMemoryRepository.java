package cn.shishuihao.thirdparty.api.core.repository;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @param <I> id
 * @param <T> entity
 * @author shishuihao
 * @version 1.0.0
 */
public abstract class AbstractMemoryRepository<I, T extends Entity<I>>
        implements Repository<I, T> {
    /**
     * map.
     */
    private final Map<I, T> map = new ConcurrentHashMap<>();

    /**
     * add entity.
     *
     * @param entity entity
     */
    @Override
    public void add(final T entity) {
        map.put(entity.id(), entity);
    }

    /**
     * get entity by id.
     *
     * @param id entity id
     * @return Optional<T>
     */
    @Override
    public Optional<T> getById(final I id) {
        return Optional.ofNullable(map.get(id));
    }

    /**
     * get map.
     *
     * @return map
     */
    protected Map<I, T> getMap() {
        return map;
    }
}
