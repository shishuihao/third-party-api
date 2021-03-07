package cn.shishuihao.thirdparty.api.push.flyme;

import cn.shishuihao.thirdparty.api.core.channel.AbstractApiChannelProperties;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class FlymePushApiChannelProperties
        extends AbstractApiChannelProperties<FlymePushApiProperties> {
    /**
     * new FlymePushApiChannelProperties.
     */
    public FlymePushApiChannelProperties() {
        this.setChannelId(FlymePushApiChannel.CHANNEL_ID);
    }
}
