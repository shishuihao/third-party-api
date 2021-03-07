package cn.shishuihao.thirdparty.api.sms.aliyun;

import cn.shishuihao.thirdparty.api.core.channel.AbstractApiChannelProperties;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class AliYunSmsApiChannelProperties
        extends AbstractApiChannelProperties<AliYunSmsApiProperties> {
    /**
     * new AliYunSmsApiChannelProperties.
     */
    public AliYunSmsApiChannelProperties() {
        this.setChannelId(AliYunSmsApiChannel.CHANNEL_ID);
    }
}
