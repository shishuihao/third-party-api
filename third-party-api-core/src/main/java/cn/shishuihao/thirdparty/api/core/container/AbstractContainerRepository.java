package cn.shishuihao.thirdparty.api.core.container;

import cn.shishuihao.thirdparty.api.core.repository.Entity;
import cn.shishuihao.thirdparty.api.core.repository.Repository;

import java.util.Optional;

/**
 * @param <I> id
 * @param <T> entity
 * @param <R> repository
 * @author shishuihao
 * @version 1.0.0
 */
public abstract class AbstractContainerRepository<
        I,
        T extends Entity<I>,
        R extends Repository<I, T>> implements Repository<I, T> {
    /**
     * repository.
     */
    private R repository;

    protected AbstractContainerRepository(final Container container,
                                          final Class<R> requiredType) {
        container.awareOrHook(it -> repository = it.getBean(requiredType));
    }

    /**
     * add entity.
     *
     * @param entity entity
     */
    @Override
    public void add(final T entity) {
        repository.add(entity);
    }

    /**
     * get entity by id.
     *
     * @param id entity id
     * @return optional entity
     */
    @Override
    public Optional<T> getById(final I id) {
        return repository.getById(id);
    }

    /**
     * get repository.
     *
     * @return repository
     */
    protected R getRepository() {
        return repository;
    }
}
