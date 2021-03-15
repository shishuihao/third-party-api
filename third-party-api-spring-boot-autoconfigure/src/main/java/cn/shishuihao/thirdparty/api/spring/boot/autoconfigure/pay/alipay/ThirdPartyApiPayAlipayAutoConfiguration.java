package cn.shishuihao.thirdparty.api.spring.boot.autoconfigure.pay.alipay;

import cn.shishuihao.thirdparty.api.pay.alipay.AlipayPayApiChannel;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Configuration(proxyBeanMethods = false)
@ConditionalOnClass(AlipayPayApiChannel.class)
@EnableConfigurationProperties(ThirdPartyApiPayAlipayProperties.class)
public class ThirdPartyApiPayAlipayAutoConfiguration {
}
