package cn.shishuihao.thirdparty.api.pay.weixin;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class WeixinPayProperties {
    /**
     * channel id
     */
    private String channelId = WeixinPayApiChannel.CHANNEL_ID;
    /**
     * properties list
     */
    private List<WeixinPayApiProperties> properties = new ArrayList<>();

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public List<WeixinPayApiProperties> getProperties() {
        return properties;
    }

    public void setProperties(List<WeixinPayApiProperties> properties) {
        this.properties = properties;
    }
}
