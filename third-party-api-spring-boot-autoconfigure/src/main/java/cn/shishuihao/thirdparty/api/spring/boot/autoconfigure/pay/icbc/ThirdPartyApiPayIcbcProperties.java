package cn.shishuihao.thirdparty.api.spring.boot.autoconfigure.pay.icbc;

import cn.shishuihao.thirdparty.api.pay.icbc.IcbcPayApiChannelProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@ConfigurationProperties(prefix = "third-party-api.pay.icbc")
public class ThirdPartyApiPayIcbcProperties
        extends IcbcPayApiChannelProperties {
}
