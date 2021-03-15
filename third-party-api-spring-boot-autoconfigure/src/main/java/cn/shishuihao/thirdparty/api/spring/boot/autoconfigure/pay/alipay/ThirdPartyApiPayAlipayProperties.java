package cn.shishuihao.thirdparty.api.spring.boot.autoconfigure.pay.alipay;

import cn.shishuihao.thirdparty.api.pay.alipay.AlipayPayApiChannelProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@ConfigurationProperties(prefix = "third-party-api.pay.alipay")
public class ThirdPartyApiPayAlipayProperties
        extends AlipayPayApiChannelProperties {
}
