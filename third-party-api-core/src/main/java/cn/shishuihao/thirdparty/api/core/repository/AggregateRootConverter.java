package cn.shishuihao.thirdparty.api.core.repository;

/**
 * @param <I> id
 * @param <A> aggregate root
 * @param <E> entity
 * @author shishuihao
 * @version 1.0.0
 */
public interface AggregateRootConverter<I, A extends AggregateRoot<I>, E> {
    /**
     * aggregate root to entity.
     *
     * @param aggregateRoot aggregate root
     * @return entity
     */
    E convert(A aggregateRoot);

    /**
     * aggregate root to entity.
     *
     * @param entity        entity
     * @param aggregateRoot aggregate root
     * @return entity
     */
    E convert(E entity, A aggregateRoot);

    /**
     * entity to aggregate root.
     *
     * @param entity entity
     * @return aggregate root
     */
    A convert(E entity);
}
