package cn.shishuihao.thirdparty.api.push.oppo;

import cn.shishuihao.thirdparty.api.core.channel.AbstractApiChannelProperties;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class OppoPushApiChannelProperties
        extends AbstractApiChannelProperties<OppoPushApiProperties> {
    /**
     * new OppoPushApiChannelProperties.
     */
    public OppoPushApiChannelProperties() {
        this.setChannelId(OppoPushApiChannel.CHANNEL_ID);
    }
}
