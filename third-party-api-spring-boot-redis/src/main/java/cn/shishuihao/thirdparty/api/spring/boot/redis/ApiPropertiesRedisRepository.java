package cn.shishuihao.thirdparty.api.spring.boot.redis;

import cn.shishuihao.thirdparty.api.core.properties.ApiProperties;
import cn.shishuihao.thirdparty.api.core.properties.ApiPropertiesRepository;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.Optional;

/**
 * @author shishuihao
 * @version 1.0.0
 */
public class ApiPropertiesRedisRepository
        extends AbstractRedisRepository<
        String,
        ApiProperties,
        RedisTemplate<String, ApiProperties>>
        implements ApiPropertiesRepository {
    /**
     * new ApiPropertiesRedisRepository.
     *
     * @param redisTemplate redis template
     */
    public ApiPropertiesRedisRepository(
            final RedisTemplate<String, ApiProperties> redisTemplate) {
        super(redisTemplate);
    }

    /**
     * add api properties.
     *
     * @param apiProperties api properties
     */
    @Override
    public void add(final ApiProperties apiProperties) {
        ValueOperations<String, ApiProperties> vo = this.getRedisTemplate()
                .opsForValue();
        String key = getKey(apiProperties.channelId(), apiProperties.id());
        vo.set(key, apiProperties);
        vo.set(apiProperties.id(), apiProperties);
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
        return Optional.ofNullable(this.getRedisTemplate()
                .opsForValue()
                .get(getKey(channelId, propertiesId)));
    }

    private String getKey(final String channelId, final String propertiesId) {
        return channelId + '.' + propertiesId;
    }
}
