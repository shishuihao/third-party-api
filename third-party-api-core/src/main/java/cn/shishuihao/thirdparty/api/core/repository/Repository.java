package cn.shishuihao.thirdparty.api.core.repository;

import java.util.Optional;

/**
 * @param <I> id
 * @param <T> entity
 * @author shishuihao
 * @version 1.0.0
 */
public interface Repository<I, T extends AggregateRoot<I>> {
    /**
     * add aggregateRoot.
     *
     * @param aggregateRoot aggregateRoot
     */
    void add(T aggregateRoot);

    /**
     * get aggregateRoot by id.
     *
     * @param id aggregateRoot id
     * @return optional aggregateRoot
     */
    Optional<T> get(I id);
}
