package cn.shishuihao.thirdparty.api.spring.boot.autoconfigure.push.huawei;

import cn.shishuihao.thirdparty.api.core.properties.ApiPropertiesRepository;
import cn.shishuihao.thirdparty.api.push.huawei.HuaweiPushApiChannel;
import cn.shishuihao.thirdparty.api.push.huawei.HuaweiPushApiChannelProperties;
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
@ConditionalOnClass(HuaweiPushApiChannel.class)
@EnableConfigurationProperties(ThirdPartyApiPushHuaweiProperties.class)
public class ThirdPartyApiPushHuaweiAutoConfiguration {
    /**
     * huaweiPushApiChannel.
     *
     * @param propertiesRepository properties repository
     * @param properties           properties
     * @return HuaweiPushApiChannel
     */
    @Bean
    @ConditionalOnMissingBean
    public HuaweiPushApiChannel huaweiPushApiChannel(
            final ApiPropertiesRepository propertiesRepository,
            final HuaweiPushApiChannelProperties properties) {
        properties.getPropertiesList().forEach(propertiesRepository::add);
        return new HuaweiPushApiChannel(properties);
    }
}
