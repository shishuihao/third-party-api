package cn.shishuihao.thirdparty.api.spring.boot.autoconfigure;

import cn.shishuihao.thirdparty.api.core.ApiChannelRepository;
import cn.shishuihao.thirdparty.api.core.ApiPropertiesRepository;
import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.core.impl.memory.ApiChannelMemoryRepository;
import cn.shishuihao.thirdparty.api.core.impl.memory.ApiPropertiesMemoryRepository;
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
public class ThirdPartyApiAutoConfiguration {
    @Bean
    @ConditionalOnMissingBean
    protected ApiPropertiesRepository propertiesRepository() {
        return new ApiPropertiesMemoryRepository();
    }

    @Bean
    @ConditionalOnMissingBean
    protected ApiChannelRepository channelRepository() {
        return new ApiChannelMemoryRepository();
    }

    @Bean
    @ConditionalOnMissingBean
    protected ApiRegistry apiRegistry(ApiChannelRepository channelRepository) {
        return new ApiRegistry(channelRepository);
    }

    @Bean
    @ConditionalOnMissingBean
    protected ThirdPartyApiSpringEventPublisher eventPublisher(ApplicationContext applicationContext) {
        return new ThirdPartyApiSpringEventPublisher(applicationContext);
    }
}
