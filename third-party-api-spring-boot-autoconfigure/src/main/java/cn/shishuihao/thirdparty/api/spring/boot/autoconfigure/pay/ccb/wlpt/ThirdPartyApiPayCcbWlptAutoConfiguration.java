package cn.shishuihao.thirdparty.api.spring.boot.autoconfigure.pay.ccb.wlpt;

import cn.shishuihao.thirdparty.api.core.configuration.ApiConfiguration;
import cn.shishuihao.thirdparty.api.core.configuration.ApiConfigurationRepository;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.CcbWlptPayApiChannel;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.CcbWlptPayApiChannelProperties;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.CcbWlptPayClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Slf4j
@Configuration(proxyBeanMethods = false)
@ConditionalOnClass(CcbWlptPayApiChannel.class)
@EnableConfigurationProperties(ThirdPartyApiPayCcbWlptProperties.class)
public class ThirdPartyApiPayCcbWlptAutoConfiguration {
    /**
     * ccbWlptPayClient.
     *
     * @return CcbWlptPayClient
     */
    @Bean
    @ConditionalOnMissingBean
    public CcbWlptPayClient ccbWlptPayClient() {
        return new CcbWlptPayClient();
    }

    /**
     * ccbWlptPayApiChannel.
     *
     * @param propertiesRepository properties repository
     * @param properties           properties
     * @param client               client
     * @return CcbWlptPayApiChannel
     */
    @Bean
    @ConditionalOnMissingBean
    public CcbWlptPayApiChannel ccbWlptPayApiChannel(
            final ApiConfigurationRepository propertiesRepository,
            final CcbWlptPayApiChannelProperties properties,
            final CcbWlptPayClient client) {
        properties.getConfigurations()
                .forEach((key, list) -> list.forEach(value ->
                        propertiesRepository.save(ApiConfiguration.builder()
                                .appId(key)
                                .channelId(properties.channelId())
                                .properties(value)
                                .build())));
        return new CcbWlptPayApiChannel(properties, client);
    }
}
