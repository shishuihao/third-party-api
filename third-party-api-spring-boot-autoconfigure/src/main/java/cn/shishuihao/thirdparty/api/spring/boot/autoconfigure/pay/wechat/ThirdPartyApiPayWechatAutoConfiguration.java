package cn.shishuihao.thirdparty.api.spring.boot.autoconfigure.pay.wechat;

import cn.shishuihao.thirdparty.api.core.configuration.ApiConfiguration;
import cn.shishuihao.thirdparty.api.core.configuration.ApiConfigurationRepository;
import cn.shishuihao.thirdparty.api.pay.wechat.WechatPayApiChannel;
import cn.shishuihao.thirdparty.api.pay.wechat.WechatPayApiChannelProperties;
import cn.shishuihao.thirdparty.api.pay.wechat.sdk.WechatPayClient;
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
@ConditionalOnClass(WechatPayApiChannel.class)
@EnableConfigurationProperties(ThirdPartyApiPayWechatProperties.class)
public class ThirdPartyApiPayWechatAutoConfiguration {
    /**
     * wechatPayClient.
     *
     * @return WechatPayClient
     */
    @Bean
    @ConditionalOnMissingBean
    public WechatPayClient wechatPayClient() {
        return new WechatPayClient();
    }

    /**
     * wechatPayApiChannel.
     *
     * @param propertiesRepository properties repository
     * @param properties           properties
     * @param client               client
     * @return WechatPayApiChannel
     */
    @Bean
    @ConditionalOnMissingBean
    public WechatPayApiChannel wechatPayApiChannel(
            final ApiConfigurationRepository propertiesRepository,
            final WechatPayApiChannelProperties properties,
            final WechatPayClient client) {
        properties.getConfigurations()
                .forEach((key, list) -> list.forEach(value ->
                        propertiesRepository.save(ApiConfiguration.builder()
                                .appId(key)
                                .channelId(properties.channelId())
                                .properties(value)
                                .build())));
        return new WechatPayApiChannel(properties, client);
    }
}
