package cn.shishuihao.thirdparty.api.spring.boot.redis.autoconfigure;

import cn.shishuihao.thirdparty.api.core.properties.ApiProperties;
import cn.shishuihao.thirdparty.api.core.properties.ApiPropertiesRepository;
import cn.shishuihao.thirdparty.api.spring.boot.starter.autoconfigure.ThirdPartyApiStarterAutoConfiguration;
import cn.shishuihao.thirdparty.api.spring.boot.redis.ApiPropertiesRedisRepository;
import cn.shishuihao.thirdparty.api.spring.boot.redis.util.RedisTemplateUtils;
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
     * apiPropertiesRedisTemplate.
     *
     * @param redisConnectionFactory redisConnectionFactory
     * @return RedisTemplate<String, ApiProperties>
     */
    @Bean
    @ConditionalOnMissingBean
    protected RedisTemplate<String, ApiProperties> apiPropertiesRedisTemplate(
            final RedisConnectionFactory redisConnectionFactory) {
        return RedisTemplateUtils.newRedisTemplate(redisConnectionFactory,
                ApiProperties.class);
    }

    /**
     * propertiesRepository.
     *
     * @param redisTemplate redis template
     * @return ApiPropertiesRepository.
     */
    @Bean
    @ConditionalOnMissingBean
    protected ApiPropertiesRepository propertiesRepository(
            final RedisTemplate<String, ApiProperties> redisTemplate) {
        return new ApiPropertiesRedisRepository(redisTemplate);
    }
}
