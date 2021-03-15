package cn.shishuihao.thirdparty.api.spring.boot.autoconfigure.push.huawei;

import cn.shishuihao.thirdparty.api.push.huawei.HuaweiPushApiChannel;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Configuration(proxyBeanMethods = false)
@ConditionalOnClass(HuaweiPushApiChannel.class)
@EnableConfigurationProperties(ThirdPartyApiPushHuaweiProperties.class)
public class ThirdPartyApiPushHuaweiAutoConfiguration {
}
