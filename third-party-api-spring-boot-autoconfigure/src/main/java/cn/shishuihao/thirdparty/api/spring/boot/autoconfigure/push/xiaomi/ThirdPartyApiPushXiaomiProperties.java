package cn.shishuihao.thirdparty.api.spring.boot.autoconfigure.push.xiaomi;

import cn.shishuihao.thirdparty.api.push.xiaomi.XiaomiPushApiChannelProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@ConfigurationProperties(prefix = "third-party-api.push.xiaomi")
public class ThirdPartyApiPushXiaomiProperties
        extends XiaomiPushApiChannelProperties {
}
