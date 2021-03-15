package cn.shishuihao.thirdparty.api.spring.boot.autoconfigure.pay.weixin;

import cn.shishuihao.thirdparty.api.pay.weixin.WxPayApiChannelProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@ConfigurationProperties(prefix = "third-party-api.pay.weixin")
public class ThirdPartyApiPayWxProperties
        extends WxPayApiChannelProperties {
}
