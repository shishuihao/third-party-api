package cn.shishuihao.thirdparty.api.spring.boot.redis.util;

import cn.shishuihao.thirdparty.api.commons.json.JacksonTypingUtils;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public final class RedisTemplateUtils {
    /**
     * KEY_SERIALIZER.
     */
    public static final RedisSerializer<?> KEY_SERIALIZER
            = new StringRedisSerializer();

    private RedisTemplateUtils() {
    }

    /**
     * new RedisTemplate<I, A>.
     *
     * @param redisConnectionFactory redisConnectionFactory
     * @param type                   aggregate root type
     * @param <I>                    id
     * @param <A>                    aggregate root
     * @return RedisTemplate<I, A>
     */
    public static <I, A> RedisTemplate<I, A> newRedisTemplate(
            final RedisConnectionFactory redisConnectionFactory,
            final Class<A> type) {
        RedisTemplate<I, A> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        // DefaultSerializer
        Jackson2JsonRedisSerializer<A> serializer
                = new Jackson2JsonRedisSerializer<>(type);
        serializer.setObjectMapper(JacksonTypingUtils.OBJECT_MAPPER);
        redisTemplate.setDefaultSerializer(serializer);
        redisTemplate.setKeySerializer(KEY_SERIALIZER);
        redisTemplate.setHashKeySerializer(KEY_SERIALIZER);
        return redisTemplate;
    }
}
