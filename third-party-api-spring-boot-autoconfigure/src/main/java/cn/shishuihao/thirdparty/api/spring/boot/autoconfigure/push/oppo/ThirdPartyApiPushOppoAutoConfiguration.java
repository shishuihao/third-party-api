package cn.shishuihao.thirdparty.api.spring.boot.autoconfigure.push.oppo;

import cn.shishuihao.thirdparty.api.push.oppo.OppoPushApiChannel;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Configuration(proxyBeanMethods = false)
@ConditionalOnClass(OppoPushApiChannel.class)
@EnableConfigurationProperties(ThirdPartyApiPushOppoProperties.class)
public class ThirdPartyApiPushOppoAutoConfiguration {
}
