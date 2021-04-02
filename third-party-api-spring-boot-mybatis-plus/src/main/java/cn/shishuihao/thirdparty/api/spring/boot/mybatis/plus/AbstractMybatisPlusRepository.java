package cn.shishuihao.thirdparty.api.spring.boot.mybatis.plus;

import cn.shishuihao.thirdparty.api.core.repository.AggregateRoot;
import cn.shishuihao.thirdparty.api.core.repository.AggregateRootConverter;
import cn.shishuihao.thirdparty.api.core.repository.Repository;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Optional;

/**
 * @param <I> id
 * @param <A> aggregate root
 * @param <E> entity
 * @param <M> mybatis-plus mapper
 * @author shishuihao
 * @version 1.0.0
 */
@AllArgsConstructor
@Getter
public abstract class AbstractMybatisPlusRepository<
        I,
        A extends AggregateRoot<I>,
        E,
        M extends BaseMapper<E>>
        implements Repository<I, A> {
    /**
     * mybatis-plus base mapper.
     */
    private final M baseMapper;
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
    public void save(final A aggregateRoot) {
        Optional<E> optional = findById(aggregateRoot.id());
        E entity;
        if (optional.isPresent()) {
            entity = converter.convert(optional.get(), aggregateRoot);
            baseMapper.updateById(entity);
        } else {
            entity = converter.convert(aggregateRoot);
            baseMapper.insert(entity);
        }
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
