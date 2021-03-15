package cn.shishuihao.thirdparty.api.spring.boot.autoconfigure.push.flyme;

import cn.shishuihao.thirdparty.api.push.flyme.FlymePushApiChannelProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@ConfigurationProperties(prefix = "third-party-api.push.flyme")
public class ThirdPartyApiPushFlymeProperties
        extends FlymePushApiChannelProperties {
}
