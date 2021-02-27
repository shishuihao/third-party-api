package cn.shishuihao.thirdparty.api.sms.aliyun;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class AliYunSmsProperties {
    /**
     * channel id
     */
    private String channelId = AliYunSmsApiChannel.CHANNEL_ID;
    /**
     * sms endpoint
     */
    private String endpoint = "dysmsapi.aliyuncs.com";
    /**
     * properties list
     */
    private List<AliYunSmsApiProperties> properties = new ArrayList<>();

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public List<AliYunSmsApiProperties> getProperties() {
        return properties;
    }

    public void setProperties(List<AliYunSmsApiProperties> properties) {
        this.properties = properties;
    }
}
