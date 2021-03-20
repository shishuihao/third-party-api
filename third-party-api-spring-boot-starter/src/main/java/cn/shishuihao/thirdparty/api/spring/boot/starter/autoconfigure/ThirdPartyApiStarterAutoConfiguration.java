package cn.shishuihao.thirdparty.api.spring.boot.starter.autoconfigure;

import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.core.channel.ApiChannelMemoryRepository;
import cn.shishuihao.thirdparty.api.core.channel.ApiChannelRepository;
import cn.shishuihao.thirdparty.api.core.properties.ApiPropertiesMemoryRepository;
import cn.shishuihao.thirdparty.api.core.properties.ApiPropertiesRepository;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Import({ThirdPartyApiSpringContainer.class})
@Configuration
@ConditionalOnProperty(name = "third-party-api.enabled", matchIfMissing = true)
public class ThirdPartyApiStarterAutoConfiguration {
    /**
     * propertiesRepository.
     *
     * @return ApiPropertiesRepository
     */
    @Bean
    @ConditionalOnMissingBean
    protected ApiPropertiesRepository propertiesRepository() {
        return new ApiPropertiesMemoryRepository();
    }

    /**
     * channelRepository.
     *
     * @return ApiChannelRepository
     */
    @Bean
    @ConditionalOnMissingBean
    protected ApiChannelRepository channelRepository() {
        return new ApiChannelMemoryRepository();
    }

    /**
     * apiRegistry.
     *
     * @param apiChannelRepository channelRepository
     * @return ApiRegistry
     */
    @Bean
    @ConditionalOnMissingBean
    protected ApiRegistry apiRegistry(
            final ApiChannelRepository apiChannelRepository) {
        return new ApiRegistry(apiChannelRepository);
    }

    /**
     * eventPublisher.
     *
     * @param applicationContext applicationContext
     * @return ThirdPartyApiSpringEventPublisher
     */
    @Bean
    @ConditionalOnMissingBean
    protected ThirdPartyApiSpringEventPublisher eventPublisher(
            final ApplicationContext applicationContext) {
        return new ThirdPartyApiSpringEventPublisher(applicationContext);
    }
}
