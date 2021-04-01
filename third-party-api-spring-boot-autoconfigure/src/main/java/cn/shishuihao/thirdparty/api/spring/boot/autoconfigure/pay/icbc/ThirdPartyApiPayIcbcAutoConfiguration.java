package cn.shishuihao.thirdparty.api.spring.boot.autoconfigure.pay.icbc;

import cn.shishuihao.thirdparty.api.core.configuration.ApiConfiguration;
import cn.shishuihao.thirdparty.api.core.configuration.ApiConfigurationRepository;
import cn.shishuihao.thirdparty.api.pay.icbc.IcbcPayApiChannel;
import cn.shishuihao.thirdparty.api.pay.icbc.IcbcPayApiChannelProperties;
import cn.shishuihao.thirdparty.api.pay.icbc.IcbcPayClient;
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
@ConditionalOnClass(IcbcPayApiChannel.class)
@EnableConfigurationProperties(ThirdPartyApiPayIcbcProperties.class)
public class ThirdPartyApiPayIcbcAutoConfiguration {
    /**
     * icbcPayClient.
     *
     * @return IcbcPayClient
     */
    @Bean
    @ConditionalOnMissingBean
    public IcbcPayClient icbcPayClient() {
        return new IcbcPayClient();
    }

    /**
     * icbcPayApiChannel.
     *
     * @param propertiesRepository properties repository
     * @param properties           properties
     * @param client               client
     * @return IcbcPayApiChannel
     */
    @Bean
    @ConditionalOnMissingBean
    public IcbcPayApiChannel icbcPayApiChannel(
            final ApiConfigurationRepository propertiesRepository,
            final IcbcPayApiChannelProperties properties,
            final IcbcPayClient client) {
        properties.getConfigurations()
                .forEach((key, list) -> list.forEach(value ->
                        propertiesRepository.add(ApiConfiguration.builder()
                                .appId(key)
                                .channelId(properties.channelId())
                                .properties(value)
                                .build())));
        return new IcbcPayApiChannel(properties, client);
    }
}
