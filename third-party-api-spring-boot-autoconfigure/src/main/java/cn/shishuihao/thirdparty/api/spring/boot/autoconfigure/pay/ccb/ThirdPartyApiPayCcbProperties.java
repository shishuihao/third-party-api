package cn.shishuihao.thirdparty.api.spring.boot.autoconfigure.pay.ccb;

import cn.shishuihao.thirdparty.api.pay.ccb.CcbPayApiChannelProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@ConfigurationProperties(prefix = "third-party-api.pay.ccb")
public class ThirdPartyApiPayCcbProperties
        extends CcbPayApiChannelProperties {
}
