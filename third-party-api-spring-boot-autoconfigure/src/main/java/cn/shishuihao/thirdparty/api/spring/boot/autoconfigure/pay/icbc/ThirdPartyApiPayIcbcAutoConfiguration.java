package cn.shishuihao.thirdparty.api.spring.boot.autoconfigure.pay.icbc;

import cn.shishuihao.thirdparty.api.pay.icbc.IcbcPayApiChannel;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Configuration(proxyBeanMethods = false)
@ConditionalOnClass(IcbcPayApiChannel.class)
@EnableConfigurationProperties(ThirdPartyApiPayIcbcProperties.class)
public class ThirdPartyApiPayIcbcAutoConfiguration {
}
