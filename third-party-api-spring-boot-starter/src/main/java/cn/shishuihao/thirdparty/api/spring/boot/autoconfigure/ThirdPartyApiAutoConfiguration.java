package cn.shishuihao.thirdparty.api.spring.boot.autoconfigure;

import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.core.ChannelRepository;
import cn.shishuihao.thirdparty.api.core.PropertiesRepository;
import cn.shishuihao.thirdparty.api.core.impl.memory.ChannelRepositoryMemoryImpl;
import cn.shishuihao.thirdparty.api.core.impl.memory.PropertiesRepositoryMemoryImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
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
    protected PropertiesRepository propertiesRepository() {
        return new PropertiesRepositoryMemoryImpl();
    }

    @Bean
    @ConditionalOnMissingBean
    protected ChannelRepository channelRepository() {
        return new ChannelRepositoryMemoryImpl();
    }

    @Bean
    @ConditionalOnMissingBean
    protected ApiRegistry apiRegistry(ChannelRepository channelRepository) {
        return new ApiRegistry(channelRepository);
    }
}
