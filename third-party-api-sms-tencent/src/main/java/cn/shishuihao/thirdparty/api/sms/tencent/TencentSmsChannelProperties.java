package cn.shishuihao.thirdparty.api.sms.tencent;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class TencentSmsChannelProperties {
    private String channelId = "sms.tencent";

    public String getChannelId() {
        return channelId;
    }

    public TencentSmsChannelProperties setChannelId(String channelId) {
        this.channelId = channelId;
        return this;
    }
}
