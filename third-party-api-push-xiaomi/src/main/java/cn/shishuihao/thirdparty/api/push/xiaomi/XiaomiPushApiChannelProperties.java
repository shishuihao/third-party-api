package cn.shishuihao.thirdparty.api.push.xiaomi;

import cn.shishuihao.thirdparty.api.core.channel.AbstractApiChannelProperties;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class XiaomiPushApiChannelProperties
        extends AbstractApiChannelProperties<XiaomiPushApiProperties> {
    /**
     * new XiaomiPushApiChannelProperties.
     */
    public XiaomiPushApiChannelProperties() {
        this.setChannelId(XiaomiPushApiChannel.CHANNEL_ID);
    }
}
