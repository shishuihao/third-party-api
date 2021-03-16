package cn.shishuihao.thirdparty.api.spring.boot.autoconfigure.pay.alipay;

import cn.shishuihao.thirdparty.api.pay.alipay.AlipayPayApiChannel;
import cn.shishuihao.thirdparty.api.pay.alipay.AlipayPayApiChannelProperties;
import cn.shishuihao.thirdparty.api.pay.alipay.AlipayPayClient;
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
@ConditionalOnClass(AlipayPayApiChannel.class)
@EnableConfigurationProperties(ThirdPartyApiPayAlipayProperties.class)
public class ThirdPartyApiPayAlipayAutoConfiguration {
    /**
     * alipayPayClient.
     *
     * @return AlipayPayClient
     */
    @Bean
    @ConditionalOnMissingBean
    public AlipayPayClient alipayPayClient() {
        return new AlipayPayClient();
    }

    /**
     * alipayPayApiChannel.
     *
     * @param properties properties
     * @param client     client
     * @return AlipayPayApiChannel
     */
    @Bean
    @ConditionalOnMissingBean
    public AlipayPayApiChannel alipayPayApiChannel(
            final AlipayPayApiChannelProperties properties,
            final AlipayPayClient client) {
        return new AlipayPayApiChannel(properties, client);
    }
}
