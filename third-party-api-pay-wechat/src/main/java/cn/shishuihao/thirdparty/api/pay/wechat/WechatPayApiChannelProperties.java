package cn.shishuihao.thirdparty.api.pay.wechat;

import cn.shishuihao.thirdparty.api.core.channel.AbstractApiChannelProperties;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class WechatPayApiChannelProperties
        extends AbstractApiChannelProperties<WechatPayApiProperties> {
    /**
     * new WechatPayApiChannelProperties.
     */
    public WechatPayApiChannelProperties() {
        this.setChannelId(WechatPayApiChannel.CHANNEL_ID);
    }
}
