package cn.shishuihao.thirdparty.api.core;

import java.util.Optional;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public interface Repository<I, T extends Entity<I>> {
    /**
     * add entity
     *
     * @param entity entity
     */
    void add(final T entity);

    /**
     * get entity by id
     *
     * @param id entity id
     * @return optional entity
     */
    Optional<T> getById(final I id);
}
