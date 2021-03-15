package cn.shishuihao.thirdparty.api.spring.boot.autoconfigure.push.oppo;

import cn.shishuihao.thirdparty.api.push.oppo.OppoPushApiChannelProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@ConfigurationProperties(prefix = "third-party-api.push.oppo")
public class ThirdPartyApiPushOppoProperties
        extends OppoPushApiChannelProperties {
}
