package cn.shishuihao.thirdparty.api.sms.aliyun;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class AliYunSmsChannelProperties {
    private String channelId = "sms.aliyun";
    private List<AliYunSmsProperties> properties = new ArrayList<>();

    public String getChannelId() {
        return channelId;
    }

    public AliYunSmsChannelProperties setChannelId(String channelId) {
        this.channelId = channelId;
        return this;
    }

    public List<AliYunSmsProperties> getProperties() {
        return properties;
    }

    public AliYunSmsChannelProperties setProperties(List<AliYunSmsProperties> properties) {
        this.properties = properties;
        return this;
    }
}
