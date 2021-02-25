package cn.shishuihao.thirdparty.api.spring.boot.redis;

import cn.shishuihao.thirdparty.api.core.ApiProperties;
import cn.shishuihao.thirdparty.api.core.ApiPropertiesRepository;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Optional;

/**
 * @author shishuihao
 * @version 1.0.0
 */
public class ApiPropertiesRedisRepository implements ApiPropertiesRepository {
    private final RedisTemplate<String, ApiProperties> redisTemplate;

    public ApiPropertiesRedisRepository(RedisTemplate<String, ApiProperties> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void add(final ApiProperties entity) {
        redisTemplate.opsForValue().set(getKey(entity.channelId(), entity.id()), entity);
        redisTemplate.opsForValue().set(entity.id(), entity);
    }

    @Override
    public Optional<ApiProperties> getById(final String id) {
        return Optional.ofNullable(redisTemplate.opsForValue().get(id));
    }

    @Override
    public Optional<ApiProperties> getApiProperties(final String channelId, final String propertiesId) {
        return Optional.ofNullable(redisTemplate.opsForValue().get(getKey(channelId, propertiesId)));
    }

    private String getKey(String channelId, String propertiesId) {
        return channelId + '.' + propertiesId;
    }
}
