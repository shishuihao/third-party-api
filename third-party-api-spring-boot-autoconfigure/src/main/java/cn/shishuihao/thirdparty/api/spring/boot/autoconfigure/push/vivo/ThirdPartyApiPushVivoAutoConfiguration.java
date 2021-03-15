package cn.shishuihao.thirdparty.api.spring.boot.autoconfigure.push.vivo;

import cn.shishuihao.thirdparty.api.push.vivo.VivoPushApiChannel;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Configuration(proxyBeanMethods = false)
@ConditionalOnClass(VivoPushApiChannel.class)
@EnableConfigurationProperties(ThirdPartyApiPushVivoProperties.class)
public class ThirdPartyApiPushVivoAutoConfiguration {
}
