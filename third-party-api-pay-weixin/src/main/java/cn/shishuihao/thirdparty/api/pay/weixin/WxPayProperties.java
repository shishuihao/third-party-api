package cn.shishuihao.thirdparty.api.pay.weixin;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class WxPayProperties {
    /**
     * channel id
     */
    private String channelId = WxPayApiChannel.CHANNEL_ID;
    /**
     * properties list
     */
    private List<WxPayApiProperties> properties = new ArrayList<>();

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public List<WxPayApiProperties> getProperties() {
        return properties;
    }

    public void setProperties(List<WxPayApiProperties> properties) {
        this.properties = properties;
    }
}
