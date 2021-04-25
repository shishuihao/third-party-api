package cn.shishuihao.thirdparty.api.spring.boot.autoconfigure.pay.ccb;

import cn.shishuihao.thirdparty.api.core.configuration.ApiConfiguration;
import cn.shishuihao.thirdparty.api.core.configuration.ApiConfigurationRepository;
import cn.shishuihao.thirdparty.api.pay.ccb.CcbPayApiChannel;
import cn.shishuihao.thirdparty.api.pay.ccb.CcbPayApiChannelProperties;
import cn.shishuihao.thirdparty.api.pay.ccb.sdk.CcbPayClient;
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
@ConditionalOnClass(CcbPayApiChannel.class)
@EnableConfigurationProperties(ThirdPartyApiPayCcbProperties.class)
public class ThirdPartyApiPayCcbAutoConfiguration {
    /**
     * ccbPayClient.
     *
     * @return CcbPayClient
     */
    @Bean
    @ConditionalOnMissingBean
    public CcbPayClient ccbPayClient() {
        return new CcbPayClient();
    }

    /**
     * ccbPayApiChannel.
     *
     * @param propertiesRepository properties repository
     * @param properties           properties
     * @param client               client
     * @return CcbPayApiChannel
     */
    @Bean
    @ConditionalOnMissingBean
    public CcbPayApiChannel ccbPayApiChannel(
            final ApiConfigurationRepository propertiesRepository,
            final CcbPayApiChannelProperties properties,
            final CcbPayClient client) {
        properties.getConfigurations()
                .forEach((key, list) -> list.forEach(value ->
                        propertiesRepository.save(ApiConfiguration.builder()
                                .appId(key)
                                .channelId(properties.channelId())
                                .properties(value)
                                .build())));
        return new CcbPayApiChannel(properties, client);
    }
}
