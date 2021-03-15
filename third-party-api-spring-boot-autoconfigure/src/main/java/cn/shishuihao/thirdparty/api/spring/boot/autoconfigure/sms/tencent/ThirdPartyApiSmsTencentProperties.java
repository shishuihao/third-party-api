package cn.shishuihao.thirdparty.api.spring.boot.autoconfigure.sms.tencent;

import cn.shishuihao.thirdparty.api.sms.tencent.TencentSmsApiChannelProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@ConfigurationProperties(prefix = "third-party-api.sms.tencent")
public class ThirdPartyApiSmsTencentProperties
        extends TencentSmsApiChannelProperties {
}
