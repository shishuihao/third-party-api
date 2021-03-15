package cn.shishuihao.thirdparty.api.spring.boot.autoconfigure.push.vivo;

import cn.shishuihao.thirdparty.api.push.vivo.VivoPushApiChannelProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@ConfigurationProperties(prefix = "third-party-api.push.vivo")
public class ThirdPartyApiPushVivoProperties
        extends VivoPushApiChannelProperties {
}
