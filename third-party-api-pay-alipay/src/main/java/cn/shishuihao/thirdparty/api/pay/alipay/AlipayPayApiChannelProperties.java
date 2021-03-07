package cn.shishuihao.thirdparty.api.pay.alipay;

import cn.shishuihao.thirdparty.api.core.channel.AbstractApiChannelProperties;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class AlipayPayApiChannelProperties
        extends AbstractApiChannelProperties<AlipayPayApiProperties> {
    /**
     * new AlipayPayApiChannelProperties.
     */
    public AlipayPayApiChannelProperties() {
        this.setChannelId(AlipayPayApiChannel.CHANNEL_ID);
    }
}
