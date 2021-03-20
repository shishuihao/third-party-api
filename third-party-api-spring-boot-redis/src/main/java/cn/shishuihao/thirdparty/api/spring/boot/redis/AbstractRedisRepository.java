package cn.shishuihao.thirdparty.api.spring.boot.redis;

import cn.shishuihao.thirdparty.api.core.repository.AggregateRoot;
import cn.shishuihao.thirdparty.api.core.repository.Repository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.Optional;

/**
 * @param <I> id
 * @param <A> aggregate root
 * @param <T> redis template
 * @author shishuihao
 * @version 1.0.0
 */
@AllArgsConstructor
@Getter
public abstract class AbstractRedisRepository<
        I,
        A extends AggregateRoot<I>,
        T extends RedisTemplate<I, A>>
        implements Repository<I, A> {
    /**
     * redis template.
     */
    private final T redisTemplate;

    /**
     * add aggregate root.
     *
     * @param aggregateRoot aggregate root
     */
    @Override
    public void add(final A aggregateRoot) {
        ValueOperations<I, A> vo = redisTemplate.opsForValue();
        vo.set(aggregateRoot.id(), aggregateRoot);
    }

    /**
     * get aggregate root by id.
     *
     * @param id id
     * @return optional aggregate root
     */
    @Override
    public Optional<A> get(final I id) {
        return Optional.ofNullable(redisTemplate.opsForValue().get(id));
    }
}
