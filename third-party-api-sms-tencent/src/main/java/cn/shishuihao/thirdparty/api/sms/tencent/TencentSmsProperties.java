package cn.shishuihao.thirdparty.api.sms.tencent;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class TencentSmsProperties {
    private String channelId = "sms.tencent";
    private List<TencentSmsApiProperties> properties = new ArrayList<>();

    public String getChannelId() {
        return channelId;
    }

    public TencentSmsProperties setChannelId(String channelId) {
        this.channelId = channelId;
        return this;
    }

    public List<TencentSmsApiProperties> getProperties() {
        return properties;
    }

    public TencentSmsProperties setProperties(List<TencentSmsApiProperties> properties) {
        this.properties = properties;
        return this;
    }
}
