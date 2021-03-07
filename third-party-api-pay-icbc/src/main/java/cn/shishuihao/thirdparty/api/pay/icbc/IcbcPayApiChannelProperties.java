package cn.shishuihao.thirdparty.api.pay.icbc;

import cn.shishuihao.thirdparty.api.core.channel.AbstractApiChannelProperties;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class IcbcPayApiChannelProperties
        extends AbstractApiChannelProperties<IcbcPayApiProperties> {
    /**
     * new IcbcPayApiChannelProperties.
     */
    public IcbcPayApiChannelProperties() {
        this.setChannelId(IcbcPayApiChannel.CHANNEL_ID);
    }
}
