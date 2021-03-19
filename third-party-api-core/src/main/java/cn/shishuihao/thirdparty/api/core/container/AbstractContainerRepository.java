package cn.shishuihao.thirdparty.api.core.container;

import cn.shishuihao.thirdparty.api.core.repository.AggregateRoot;
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
        T extends AggregateRoot<I>,
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
     * add aggregateRoot.
     *
     * @param aggregateRoot aggregateRoot
     */
    @Override
    public void add(final T aggregateRoot) {
        repository.add(aggregateRoot);
    }

    /**
     * get aggregateRoot by id.
     *
     * @param id aggregateRoot id
     * @return optional aggregateRoot
     */
    @Override
    public Optional<T> get(final I id) {
        return repository.get(id);
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
