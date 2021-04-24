package cn.shishuihao.thirdparty.api.pay.ccb;

import cn.shishuihao.thirdparty.api.core.channel.AbstractApiChannelProperties;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class CcbPayApiChannelProperties
        extends AbstractApiChannelProperties<CcbPayApiProperties> {
    /**
     * new CcbPayApiChannelProperties.
     */
    public CcbPayApiChannelProperties() {
        this.setChannelId(CcbPayApiChannel.CHANNEL_ID);
    }
}
