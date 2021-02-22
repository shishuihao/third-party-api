package cn.shishuihao.thirdparty.api.sms.tencent;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class TencentSmsChannelProperties {
    private String channelId = "sms.tencent";
    private List<TencentSmsProperties> properties = new ArrayList<>();

    public String getChannelId() {
        return channelId;
    }

    public TencentSmsChannelProperties setChannelId(String channelId) {
        this.channelId = channelId;
        return this;
    }

    public List<TencentSmsProperties> getProperties() {
        return properties;
    }

    public TencentSmsChannelProperties setProperties(List<TencentSmsProperties> properties) {
        this.properties = properties;
        return this;
    }
}
