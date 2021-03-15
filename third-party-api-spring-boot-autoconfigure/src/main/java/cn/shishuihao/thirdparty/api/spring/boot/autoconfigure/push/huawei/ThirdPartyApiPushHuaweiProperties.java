package cn.shishuihao.thirdparty.api.spring.boot.autoconfigure.push.huawei;

import cn.shishuihao.thirdparty.api.push.huawei.HuaweiPushApiChannelProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@ConfigurationProperties(prefix = "third-party-api.push.huawei")
public class ThirdPartyApiPushHuaweiProperties
        extends HuaweiPushApiChannelProperties {
}
