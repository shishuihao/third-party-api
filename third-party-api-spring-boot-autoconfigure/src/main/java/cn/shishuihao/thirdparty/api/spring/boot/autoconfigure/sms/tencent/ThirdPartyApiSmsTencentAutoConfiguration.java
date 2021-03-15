package cn.shishuihao.thirdparty.api.spring.boot.autoconfigure.sms.tencent;

import cn.shishuihao.thirdparty.api.sms.tencent.TencentSmsApiChannel;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Configuration(proxyBeanMethods = false)
@ConditionalOnClass(TencentSmsApiChannel.class)
@EnableConfigurationProperties(ThirdPartyApiSmsTencentProperties.class)
public class ThirdPartyApiSmsTencentAutoConfiguration {
}
