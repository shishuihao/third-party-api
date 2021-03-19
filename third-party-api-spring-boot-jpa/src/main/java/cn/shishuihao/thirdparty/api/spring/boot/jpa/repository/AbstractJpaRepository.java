package cn.shishuihao.thirdparty.api.spring.boot.jpa.repository;

import cn.shishuihao.thirdparty.api.core.repository.AggregateRoot;
import cn.shishuihao.thirdparty.api.core.repository.AggregateRootConverter;
import cn.shishuihao.thirdparty.api.core.repository.Repository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * @param <I> id
 * @param <A> aggregate root
 * @param <E> entity
 * @param <R> jpa repository
 * @author shishuihao
 * @version 1.0.0
 */
@AllArgsConstructor
@Getter
public abstract class AbstractJpaRepository<
        I,
        A extends AggregateRoot<I>,
        E,
        R extends CrudRepository<E, ?>>
        implements Repository<I, A> {
    /**
     * jpaRepository.
     */
    private final R jpaRepository;
    /**
     * aggregate root converter.
     */
    private final AggregateRootConverter<I, A, E> converter;

    /**
     * get entity by id.
     *
     * @param id id
     * @return option entity
     */
    public abstract Optional<E> findById(I id);

    /**
     * add aggregate root.
     *
     * @param aggregateRoot aggregate root
     */
    @Override
    public void add(final A aggregateRoot) {
        E entity = findById(aggregateRoot.id())
                .map(it -> converter.convert(it, aggregateRoot))
                .orElseGet(() -> converter.convert(aggregateRoot));
        jpaRepository.save(entity);
    }

    /**
     * get aggregate root by id.
     *
     * @param id id
     * @return optional aggregate root
     */
    @Override
    public Optional<A> get(final I id) {
        return findById(id)
                .map(converter::convert);
    }
}
