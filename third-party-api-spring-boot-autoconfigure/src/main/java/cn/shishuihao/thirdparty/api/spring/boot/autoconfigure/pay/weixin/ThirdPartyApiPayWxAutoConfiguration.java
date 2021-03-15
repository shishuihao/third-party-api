package cn.shishuihao.thirdparty.api.spring.boot.autoconfigure.pay.weixin;

import cn.shishuihao.thirdparty.api.pay.weixin.WxPayApiChannel;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Configuration(proxyBeanMethods = false)
@ConditionalOnClass(WxPayApiChannel.class)
@EnableConfigurationProperties(ThirdPartyApiPayWxProperties.class)
public class ThirdPartyApiPayWxAutoConfiguration {
}
