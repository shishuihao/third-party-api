package cn.shishuihao.thirdparty.api.spring.boot.autoconfigure.push.xiaomi;

import cn.shishuihao.thirdparty.api.core.properties.ApiPropertiesRepository;
import cn.shishuihao.thirdparty.api.push.xiaomi.XiaomiPushApiChannel;
import cn.shishuihao.thirdparty.api.push.xiaomi.XiaomiPushApiChannelProperties;
import cn.shishuihao.thirdparty.api.push.xiaomi.XiaomiPushClient;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Configuration(proxyBeanMethods = false)
@ConditionalOnClass(XiaomiPushApiChannel.class)
@EnableConfigurationProperties(ThirdPartyApiPushXiaomiProperties.class)
public class ThirdPartyApiPayAlipayAutoConfiguration {
    /**
     * xiaomiPushClient.
     *
     * @return XiaomiPushClient
     */
    @Bean
    @ConditionalOnMissingBean
    public XiaomiPushClient xiaomiPushClient() {
        return new XiaomiPushClient();
    }

    /**
     * xiaomiPushApiChannel.
     *
     * @param propertiesRepository properties repository
     * @param properties           properties
     * @param client               client
     * @return XiaomiPushApiChannel
     */
    @Bean
    @ConditionalOnMissingBean
    public XiaomiPushApiChannel xiaomiPushApiChannel(
            final ApiPropertiesRepository propertiesRepository,
            final XiaomiPushApiChannelProperties properties,
            final XiaomiPushClient client) {
        properties.getPropertiesList().forEach(propertiesRepository::add);
        return new XiaomiPushApiChannel(properties, client);
    }
}
