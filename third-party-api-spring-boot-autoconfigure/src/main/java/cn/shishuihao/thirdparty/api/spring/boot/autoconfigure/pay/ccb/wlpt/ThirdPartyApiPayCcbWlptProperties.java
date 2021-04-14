package cn.shishuihao.thirdparty.api.spring.boot.autoconfigure.pay.ccb.wlpt;

import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.CcbWlptPayApiChannelProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@ConfigurationProperties(prefix = "third-party-api.pay.ccb.wlpt")
public class ThirdPartyApiPayCcbWlptProperties
        extends CcbWlptPayApiChannelProperties {
}
