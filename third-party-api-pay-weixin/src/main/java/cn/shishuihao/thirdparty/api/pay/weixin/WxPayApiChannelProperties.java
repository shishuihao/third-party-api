package cn.shishuihao.thirdparty.api.pay.weixin;

import cn.shishuihao.thirdparty.api.core.channel.AbstractApiChannelProperties;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class WxPayApiChannelProperties
        extends AbstractApiChannelProperties<WxPayApiProperties> {
    /**
     * new WxPayApiChannelProperties.
     */
    public WxPayApiChannelProperties() {
        this.setChannelId(WxPayApiChannel.CHANNEL_ID);
    }
}
