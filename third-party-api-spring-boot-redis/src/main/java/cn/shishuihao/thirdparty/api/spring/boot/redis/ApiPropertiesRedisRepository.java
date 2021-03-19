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
     * add api properties.
     *
     * @param apiProperties api properties
     */
    @Override
    public void add(final ApiProperties apiProperties) {
        ValueOperations<String, ApiProperties> vo = redisTemplate.opsForValue();
        String key = getKey(apiProperties.channelId(), apiProperties.id());
        vo.set(key, apiProperties);
        vo.set(apiProperties.id(), apiProperties);
    }

    /**
     * get api properties by properties id.
     *
     * @param propertiesId api properties id
     * @return optional api properties
     */
    @Override
    public Optional<ApiProperties> get(final String propertiesId) {
        return Optional.ofNullable(redisTemplate.opsForValue()
                .get(propertiesId));
    }

    /**
     * get api properties by channel id and properties id.
     *
     * @param channelId    channel id
     * @param propertiesId properties id
     * @return optional api properties
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
