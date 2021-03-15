package cn.shishuihao.thirdparty.api.spring.boot.autoconfigure.sms.aliyun;

import cn.shishuihao.thirdparty.api.sms.aliyun.AliYunSmsApiChannel;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Configuration(proxyBeanMethods = false)
@ConditionalOnClass(AliYunSmsApiChannel.class)
@EnableConfigurationProperties(ThirdPartyApiSmsAliyunProperties.class)
public class ThirdPartyApiSmsAliyunAutoConfiguration {
}
