package cn.shishuihao.thirdparty.api.spring.boot.autoconfigure.push.flyme;

import cn.shishuihao.thirdparty.api.core.properties.ApiPropertiesRepository;
import cn.shishuihao.thirdparty.api.push.flyme.FlymePushApiChannel;
import cn.shishuihao.thirdparty.api.push.flyme.FlymePushApiChannelProperties;
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
@ConditionalOnClass(FlymePushApiChannel.class)
@EnableConfigurationProperties(ThirdPartyApiPushFlymeProperties.class)
public class ThirdPartyApiPushFlymeAutoConfiguration {
    /**
     * flymePushApiChannel.
     *
     * @param propertiesRepository properties repository
     * @param properties           properties
     * @return FlymePushApiChannel
     */
    @Bean
    @ConditionalOnMissingBean
    public FlymePushApiChannel flymePushApiChannel(
            final ApiPropertiesRepository propertiesRepository,
            final FlymePushApiChannelProperties properties) {
        properties.getPropertiesList().forEach(propertiesRepository::add);
        return new FlymePushApiChannel(properties);
    }
}
