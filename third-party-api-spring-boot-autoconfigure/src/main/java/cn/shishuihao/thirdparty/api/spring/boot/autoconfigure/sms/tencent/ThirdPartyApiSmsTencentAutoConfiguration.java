package cn.shishuihao.thirdparty.api.spring.boot.autoconfigure.sms.tencent;

import cn.shishuihao.thirdparty.api.core.configuration.ApiConfiguration;
import cn.shishuihao.thirdparty.api.core.configuration.ApiConfigurationRepository;
import cn.shishuihao.thirdparty.api.sms.tencent.TencentSmsApiChannel;
import cn.shishuihao.thirdparty.api.sms.tencent.TencentSmsApiChannelProperties;
import cn.shishuihao.thirdparty.api.sms.tencent.TencentSmsClient;
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
@ConditionalOnClass(TencentSmsApiChannel.class)
@EnableConfigurationProperties(ThirdPartyApiSmsTencentProperties.class)
public class ThirdPartyApiSmsTencentAutoConfiguration {
    /**
     * tencentSmsClient.
     *
     * @param properties properties
     * @return TencentSmsClient
     */
    @Bean
    @ConditionalOnMissingBean
    public TencentSmsClient tencentSmsClient(
            final TencentSmsApiChannelProperties properties) {
        return new TencentSmsClient(properties);
    }

    /**
     * tencentSmsApiChannel.
     *
     * @param propertiesRepository properties repository
     * @param properties           properties
     * @param client               client
     * @return TencentSmsApiChannel
     */
    @Bean
    @ConditionalOnMissingBean
    public TencentSmsApiChannel tencentSmsApiChannel(
            final ApiConfigurationRepository propertiesRepository,
            final TencentSmsApiChannelProperties properties,
            final TencentSmsClient client) {
        properties.getConfigurations()
                .forEach((key, list) -> list.forEach(value ->
                        propertiesRepository.add(ApiConfiguration.builder()
                                .appId(key)
                                .channelId(properties.channelId())
                                .properties(value)
                                .build())));
        return new TencentSmsApiChannel(properties, client);
    }
}
