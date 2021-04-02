package cn.shishuihao.thirdparty.api.spring.boot.redis.domain;

import cn.shishuihao.thirdparty.api.core.configuration.ApiConfiguration;
import cn.shishuihao.thirdparty.api.core.configuration.ApiConfigurationRepository;
import cn.shishuihao.thirdparty.api.spring.boot.redis.AbstractRedisRepository;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.Optional;

/**
 * @author shishuihao
 * @version 1.0.0
 */
public class ApiConfigurationRedisRepository
        extends AbstractRedisRepository<
        String,
        ApiConfiguration,
        RedisTemplate<String, ApiConfiguration>>
        implements ApiConfigurationRepository {
    /**
     * new ApiConfigurationRedisRepository.
     *
     * @param redisTemplate redis template
     */
    public ApiConfigurationRedisRepository(
            final RedisTemplate<String, ApiConfiguration> redisTemplate) {
        super(redisTemplate);
    }

    /**
     * get api configuration.
     *
     * @param apiConfiguration api configuration
     */
    @Override
    public void save(final ApiConfiguration apiConfiguration) {
        ValueOperations<String, ApiConfiguration> vo = this.getRedisTemplate()
                .opsForValue();
        String key = getKey(
                apiConfiguration.getAppId(),
                apiConfiguration.getChannelId());
        vo.set(key, apiConfiguration);
        vo.set(apiConfiguration.id(), apiConfiguration);
    }

    /**
     * get api configuration.
     *
     * @param appId     app id
     * @param channelId channel id
     * @return Optional<ApiConfiguration>
     */
    @Override
    public Optional<ApiConfiguration> getApiConfiguration(
            final String appId,
            final String channelId) {
        return Optional.ofNullable(this.getRedisTemplate()
                .opsForValue()
                .get(getKey(appId, channelId)));
    }

    private String getKey(final String appId, final String channelId) {
        return appId + '.' + channelId;
    }
}
