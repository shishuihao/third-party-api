package cn.shishuihao.thirdparty.api.core.repository;

import java.util.Optional;

/**
 * @param <I> id
 * @param <T> entity
 * @author shishuihao
 * @version 1.0.0
 */
public interface Repository<I, T extends Entity<I>> {
    /**
     * add entity.
     *
     * @param entity entity
     */
    void add(T entity);

    /**
     * get entity by id.
     *
     * @param id entity id
     * @return optional entity
     */
    Optional<T> getById(I id);
}
