package cn.shishuihao.thirdparty.api.core.impl.container;

import cn.shishuihao.thirdparty.api.core.Container;
import cn.shishuihao.thirdparty.api.core.Entity;
import cn.shishuihao.thirdparty.api.core.Repository;

import java.util.Optional;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public abstract class AbstractContainerRepository<I, T extends Entity<I>> implements Repository<I, T> {
    private Repository<I, T> repository;

    protected AbstractContainerRepository(Container container, Class<? extends Repository<I, T>> requiredType) {
        container.awareOrHook(it -> repository = it.getBean(requiredType));
    }

    @Override
    public void add(final T entity) {
        repository.add(entity);
    }

    @Override
    public Optional<T> getById(final I id) {
        return repository.getById(id);
    }
}
