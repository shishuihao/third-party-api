package cn.shishuihao.thirdparty.api.sms.tencent;

import cn.shishuihao.thirdparty.api.core.channel.AbstractApiChannelProperties;
import lombok.Getter;
import lombok.Setter;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Getter
@Setter
public class TencentSmsApiChannelProperties
        extends AbstractApiChannelProperties<TencentSmsApiProperties> {
    /**
     * region.
     */
    private String region = "";

    /**
     * new TencentSmsApiChannelProperties.
     */
    public TencentSmsApiChannelProperties() {
        this.setChannelId(TencentSmsApiChannel.CHANNEL_ID);
    }
}
