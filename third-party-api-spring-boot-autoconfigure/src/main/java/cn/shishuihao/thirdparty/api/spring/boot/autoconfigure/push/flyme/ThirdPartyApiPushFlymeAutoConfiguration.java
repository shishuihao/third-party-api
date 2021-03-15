package cn.shishuihao.thirdparty.api.spring.boot.autoconfigure.push.flyme;

import cn.shishuihao.thirdparty.api.push.flyme.FlymePushApiChannel;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Configuration(proxyBeanMethods = false)
@ConditionalOnClass(FlymePushApiChannel.class)
@EnableConfigurationProperties(ThirdPartyApiPushFlymeProperties.class)
public class ThirdPartyApiPushFlymeAutoConfiguration {
}
