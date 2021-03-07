package cn.shishuihao.thirdparty.api.spring.boot.redis;

import cn.shishuihao.thirdparty.api.core.properties.ApiProperties;
import cn.shishuihao.thirdparty.api.core.properties.ApiPropertiesRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.Optional;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@AllArgsConstructor
public class ApiPropertiesRedisRepository implements ApiPropertiesRepository {
    /**
     * redisTemplate.
     */
    private final RedisTemplate<String, ApiProperties> redisTemplate;

    /**
     * add entity.
     *
     * @param entity entity
     */
    @Override
    public void add(final ApiProperties entity) {
        ValueOperations<String, ApiProperties> vo = redisTemplate.opsForValue();
        vo.set(getKey(entity.channelId(), entity.id()), entity);
        vo.set(entity.id(), entity);
    }

    /**
     * get entity by id.
     *
     * @param id entity id
     * @return optional entity
     */
    @Override
    public Optional<ApiProperties> getById(final String id) {
        return Optional.ofNullable(redisTemplate.opsForValue().get(id));
    }

    /**
     * get api properties by api type.
     *
     * @param channelId    channel id
     * @param propertiesId properties id
     * @return ApiProperties
     */
    @Override
    public Optional<ApiProperties> getApiProperties(final String channelId,
                                                    final String propertiesId) {
        return Optional.ofNullable(redisTemplate.opsForValue()
                .get(getKey(channelId, propertiesId)));
    }

    private String getKey(final String channelId, final String propertiesId) {
        return channelId + '.' + propertiesId;
    }
}
