package cn.shishuihao.thirdparty.api.spring.boot.autoconfigure.pay.wechat;

import cn.shishuihao.thirdparty.api.pay.wechat.WechatPayApiChannelProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@ConfigurationProperties(prefix = "third-party-api.pay.wechat")
public class ThirdPartyApiPayWechatProperties
        extends WechatPayApiChannelProperties {
}
