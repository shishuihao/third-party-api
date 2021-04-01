package cn.shishuihao.thirdparty.api.spring.boot.autoconfigure.push.vivo;

import cn.shishuihao.thirdparty.api.core.configuration.ApiConfiguration;
import cn.shishuihao.thirdparty.api.core.configuration.ApiConfigurationRepository;
import cn.shishuihao.thirdparty.api.push.vivo.VivoPushApiChannel;
import cn.shishuihao.thirdparty.api.push.vivo.VivoPushApiChannelProperties;
import cn.shishuihao.thirdparty.api.push.vivo.VivoPushClient;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Configuration(proxyBeanMethods = false)
@ConditionalOnClass(VivoPushApiChannel.class)
@EnableConfigurationProperties(ThirdPartyApiPushVivoProperties.class)
public class ThirdPartyApiPushVivoAutoConfiguration {
    /**
     * vivoPushClient.
     *
     * @return VivoPushClient
     */
    @Bean
    @ConditionalOnMissingBean
    public VivoPushClient vivoPushClient() {
        return new VivoPushClient();
    }

    /**
     * vivoPushApiChannel.
     *
     * @param propertiesRepository properties repository
     * @param properties           properties
     * @param client               client
     * @return VivoPushApiChannel
     */
    @Bean
    @ConditionalOnMissingBean
    public VivoPushApiChannel vivoPushApiChannel(
            final ApiConfigurationRepository propertiesRepository,
            final VivoPushApiChannelProperties properties,
            final VivoPushClient client) {
        properties.getConfigurations()
                .forEach((key, list) -> list.forEach(value ->
                        propertiesRepository.add(ApiConfiguration.builder()
                                .appId(key)
                                .channelId(properties.channelId())
                                .properties(value)
                                .build())));
        return new VivoPushApiChannel(properties, client);
    }
}
