package cn.shishuihao.thirdparty.api.spring.boot.redis.autoconfigure;

import cn.shishuihao.thirdparty.api.core.configuration.ApiConfiguration;
import cn.shishuihao.thirdparty.api.core.configuration.ApiConfigurationRepository;
import cn.shishuihao.thirdparty.api.spring.boot.redis.domain.ApiConfigurationRedisRepository;
import cn.shishuihao.thirdparty.api.spring.boot.redis.util.RedisTemplateUtils;
import cn.shishuihao.thirdparty.api.spring.boot.starter.autoconfigure.ThirdPartyApiStarterAutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Configuration
@ConditionalOnClass(RedisOperations.class)
@ConditionalOnProperty(
        name = "third-party-api.redis.enabled",
        matchIfMissing = true)
@AutoConfigureBefore(ThirdPartyApiStarterAutoConfiguration.class)
public class ThirdPartyApiRedisAutoConfiguration {
    /**
     * apiConfigurationRedisTemplate.
     *
     * @param redisConnectionFactory redisConnectionFactory
     * @return RedisTemplate<String, ApiConfiguration>
     */
    @Bean
    @ConditionalOnMissingBean
    protected RedisTemplate<String, ApiConfiguration> apiConfigurationRedisTemplate(
            final RedisConnectionFactory redisConnectionFactory) {
        return RedisTemplateUtils.newRedisTemplate(redisConnectionFactory,
                ApiConfiguration.class);
    }

    /**
     * apiConfigurationRepository.
     *
     * @param redisTemplate redis template
     * @return ApiConfigurationRepository.
     */
    @Bean
    @ConditionalOnMissingBean
    protected ApiConfigurationRepository apiConfigurationRepository(
            final RedisTemplate<String, ApiConfiguration> redisTemplate) {
        return new ApiConfigurationRedisRepository(redisTemplate);
    }
}
