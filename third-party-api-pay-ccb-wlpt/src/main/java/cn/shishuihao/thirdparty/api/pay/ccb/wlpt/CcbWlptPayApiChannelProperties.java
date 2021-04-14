package cn.shishuihao.thirdparty.api.pay.ccb.wlpt;

import cn.shishuihao.thirdparty.api.core.channel.AbstractApiChannelProperties;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class CcbWlptPayApiChannelProperties
        extends AbstractApiChannelProperties<CcbWlptPayApiProperties> {
    /**
     * new CcbWlptPayApiChannelProperties.
     */
    public CcbWlptPayApiChannelProperties() {
        this.setChannelId(CcbWlptPayApiChannel.CHANNEL_ID);
    }
}
