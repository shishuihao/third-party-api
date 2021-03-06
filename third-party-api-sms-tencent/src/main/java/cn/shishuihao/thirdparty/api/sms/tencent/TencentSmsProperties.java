package cn.shishuihao.thirdparty.api.sms.tencent;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class TencentSmsProperties {
    /**
     * channel id
     */
    private String channelId = TencentSmsApiChannel.CHANNEL_ID;
    /**
     * properties list
     */
    private List<TencentSmsApiProperties> properties = new ArrayList<>();

    /**
     * region
     */
    private String region = "";

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public List<TencentSmsApiProperties> getProperties() {
        return properties;
    }

    public void setProperties(List<TencentSmsApiProperties> properties) {
        this.properties = properties;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}
