package cn.shishuihao.thirdparty.api.spring.boot.redis.autoconfigure;

import cn.shishuihao.thirdparty.api.core.properties.ApiProperties;
import cn.shishuihao.thirdparty.api.core.properties.ApiPropertiesRepository;
import cn.shishuihao.thirdparty.api.spring.boot.autoconfigure.ThirdPartyApiAutoConfiguration;
import cn.shishuihao.thirdparty.api.spring.boot.redis.ApiPropertiesRedisRepository;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
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
@ConditionalOnProperty(name = "third-party-api.redis.enabled", matchIfMissing = true)
@AutoConfigureBefore(ThirdPartyApiAutoConfiguration.class)
public class ThirdPartyApiRedisAutoConfiguration {
    @Bean
    @ConditionalOnMissingBean
    protected RedisTemplate<String, ApiProperties> propertiesRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, ApiProperties> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        // ObjectMapper
        ObjectMapper objectMapper = new ObjectMapper();
        // 将对象全类名一起保存下来，不设置的话将无法反序列化
        objectMapper.activateDefaultTyping(objectMapper.getPolymorphicTypeValidator(), ObjectMapper.DefaultTyping.NON_FINAL);
        // 序列化时，跳过null属性
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        // 序列化时，遇到空bean（无属性）时不会失败
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        // 反序列化时，遇到未知属性（在bean上找不到对应属性）时不会失败
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        // 反序列化时，将空数组([])当做null来处理（以便把空数组反序列化到对象属性上——对php生成的json的map属性很有用）
        objectMapper.configure(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT, true);
        // 通过fields来探测（不通过标准getter探测）
        objectMapper.configure(MapperFeature.AUTO_DETECT_FIELDS, true);
        // DefaultSerializer
        Jackson2JsonRedisSerializer<ApiProperties> serializer = new Jackson2JsonRedisSerializer<>(ApiProperties.class);
        serializer.setObjectMapper(objectMapper);
        redisTemplate.setDefaultSerializer(serializer);
        // StringRedisSerializer
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringRedisSerializer);
        redisTemplate.setHashKeySerializer(stringRedisSerializer);
        return redisTemplate;
    }

    @Bean
    @ConditionalOnMissingBean
    protected ApiPropertiesRepository propertiesRepository(RedisTemplate<String, ApiProperties> redisTemplate) {
        return new ApiPropertiesRedisRepository(redisTemplate);
    }
}
