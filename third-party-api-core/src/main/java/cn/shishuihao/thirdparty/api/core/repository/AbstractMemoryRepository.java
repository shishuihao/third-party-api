package cn.shishuihao.thirdparty.api.core.repository;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @param <I> id
 * @param <T> aggregate root
 * @author shishuihao
 * @version 1.0.0
 */
public abstract class AbstractMemoryRepository<I, T extends AggregateRoot<I>>
        implements Repository<I, T> {
    /**
     * map.
     */
    private final Map<I, T> map = new ConcurrentHashMap<>();

    /**
     * add aggregate root.
     *
     * @param aggregateRoot aggregate root
     */
    @Override
    public void add(final T aggregateRoot) {
        map.put(aggregateRoot.id(), aggregateRoot);
    }

    /**
     * get aggregate root by id.
     *
     * @param id id
     * @return optional aggregate root
     */
    @Override
    public Optional<T> get(final I id) {
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
