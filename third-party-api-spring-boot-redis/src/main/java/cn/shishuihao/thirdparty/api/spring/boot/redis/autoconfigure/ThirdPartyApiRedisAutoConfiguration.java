package cn.shishuihao.thirdparty.api.spring.boot.redis.autoconfigure;

import cn.shishuihao.thirdparty.api.commons.json.JacksonTypingUtils;
import cn.shishuihao.thirdparty.api.core.properties.ApiProperties;
import cn.shishuihao.thirdparty.api.core.properties.ApiPropertiesRepository;
import cn.shishuihao.thirdparty.api.spring.boot.autoconfigure.ThirdPartyApiAutoConfiguration;
import cn.shishuihao.thirdparty.api.spring.boot.redis.ApiPropertiesRedisRepository;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Configuration
@ConditionalOnClass(RedisOperations.class)
@ConditionalOnProperty(
        name = "third-party-api.redis.enabled",
        matchIfMissing = true)
@AutoConfigureBefore(ThirdPartyApiAutoConfiguration.class)
public class ThirdPartyApiRedisAutoConfiguration {
    /**
     * propertiesRedisTemplate.
     *
     * @param redisConnectionFactory redisConnectionFactory
     * @return RedisTemplate<String, ApiProperties>
     */
    @Bean
    @ConditionalOnMissingBean
    protected RedisTemplate<String, ApiProperties> propertiesRedisTemplate(
            final RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, ApiProperties> redisTemplate
                = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        // DefaultSerializer
        Jackson2JsonRedisSerializer<ApiProperties> serializer
                = new Jackson2JsonRedisSerializer<>(ApiProperties.class);
        serializer.setObjectMapper(JacksonTypingUtils.OBJECT_MAPPER);
        redisTemplate.setDefaultSerializer(serializer);
        // StringRedisSerializer
        StringRedisSerializer keySerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(keySerializer);
        redisTemplate.setHashKeySerializer(keySerializer);
        return redisTemplate;
    }

    /**
     * propertiesRepository.
     *
     * @param redisTemplate redisTemplate
     * @return ApiPropertiesRepository.
     */
    @Bean
    @ConditionalOnMissingBean
    protected ApiPropertiesRepository propertiesRepository(
            final RedisTemplate<String, ApiProperties> redisTemplate) {
        return new ApiPropertiesRedisRepository(redisTemplate);
    }
}
