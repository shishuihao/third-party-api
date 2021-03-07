package cn.shishuihao.thirdparty.api.push.vivo;

import cn.shishuihao.thirdparty.api.core.channel.AbstractApiChannelProperties;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class VivoPushApiChannelProperties
        extends AbstractApiChannelProperties<VivoPushApiProperties> {
    /**
     * new VivoPushApiChannelProperties.
     */
    public VivoPushApiChannelProperties() {
        this.setChannelId(VivoPushApiChannel.CHANNEL_ID);
    }
}
