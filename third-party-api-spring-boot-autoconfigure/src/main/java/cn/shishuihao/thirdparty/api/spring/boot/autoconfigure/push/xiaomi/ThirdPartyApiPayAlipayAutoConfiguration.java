package cn.shishuihao.thirdparty.api.spring.boot.autoconfigure.push.xiaomi;

import cn.shishuihao.thirdparty.api.push.xiaomi.XiaomiPushApiChannel;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Configuration(proxyBeanMethods = false)
@ConditionalOnClass(XiaomiPushApiChannel.class)
@EnableConfigurationProperties(ThirdPartyApiPushXiaomiProperties.class)
public class ThirdPartyApiPayAlipayAutoConfiguration {
}
