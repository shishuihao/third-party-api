package cn.shishuihao.thirdparty.api.core.repository;

import java.util.Optional;

/**
 * @param <I> id
 * @param <A> aggregate root
 * @author shishuihao
 * @version 1.0.0
 */
public interface Repository<I, A extends AggregateRoot<I>> {
    /**
     * add aggregate root.
     *
     * @param aggregateRoot aggregate root
     */
    void add(A aggregateRoot);

    /**
     * get aggregate root by id.
     *
     * @param id id
     * @return optional aggregate root
     */
    Optional<A> get(I id);
}
