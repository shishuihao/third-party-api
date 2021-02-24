package cn.shishuihao.thirdparty.api.sms.aliyun;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class AliYunSmsProperties {
    private String channelId = "sms.aliyun";
    private List<AliYunSmsApiProperties> properties = new ArrayList<>();

    public String getChannelId() {
        return channelId;
    }

    public AliYunSmsProperties setChannelId(String channelId) {
        this.channelId = channelId;
        return this;
    }

    public List<AliYunSmsApiProperties> getProperties() {
        return properties;
    }

    public AliYunSmsProperties setProperties(List<AliYunSmsApiProperties> properties) {
        this.properties = properties;
        return this;
    }
}
