package cn.shishuihao.thirdparty.api.push.huawei;

import cn.shishuihao.thirdparty.api.core.channel.AbstractApiChannelProperties;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class HuaweiPushApiChannelProperties
        extends AbstractApiChannelProperties<HuaweiPushApiProperties> {
    /**
     * new HuaweiPushApiChannelProperties.
     */
    public HuaweiPushApiChannelProperties() {
        this.setChannelId(HuaweiPushApiChannel.CHANNEL_ID);
    }
}
