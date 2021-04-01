package cn.shishuihao.thirdparty.api.spring.boot.autoconfigure.pay.weixin;

import cn.shishuihao.thirdparty.api.core.configuration.ApiConfiguration;
import cn.shishuihao.thirdparty.api.core.configuration.ApiConfigurationRepository;
import cn.shishuihao.thirdparty.api.pay.weixin.WxPayApiChannel;
import cn.shishuihao.thirdparty.api.pay.weixin.WxPayApiChannelProperties;
import cn.shishuihao.thirdparty.api.pay.weixin.sdk.WxFactory;
import cn.shishuihao.thirdparty.api.pay.weixin.sdk.api.WxPayCodeApi;
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
@ConditionalOnClass(WxPayApiChannel.class)
@EnableConfigurationProperties(ThirdPartyApiPayWxProperties.class)
public class ThirdPartyApiPayWxAutoConfiguration {
    /**
     * wxPayCodeApi.
     *
     * @return WxPayCodeApi
     */
    @Bean
    @ConditionalOnMissingBean
    public WxPayCodeApi wxPayCodeApi() {
        return WxFactory.Payment.codeApi();
    }

    /**
     * wxPayApiChannel.
     *
     * @param propertiesRepository properties repository
     * @param properties           properties
     * @param codeApi              codeApi
     * @return WxPayApiChannel
     */
    @Bean
    @ConditionalOnMissingBean
    public WxPayApiChannel wxPayApiChannel(
            final ApiConfigurationRepository propertiesRepository,
            final WxPayApiChannelProperties properties,
            final WxPayCodeApi codeApi) {
        properties.getConfigurations()
                .forEach((key, list) -> list.forEach(value ->
                        propertiesRepository.add(ApiConfiguration.builder()
                                .appId(key)
                                .channelId(properties.channelId())
                                .properties(value)
                                .build())));
        return new WxPayApiChannel(properties, codeApi);
    }
}
