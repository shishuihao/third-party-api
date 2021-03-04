package cn.shishuihao.thirdparty.api.push.vivo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class VivoPushProperties {
    /**
     * channel id
     */
    private String channelId = VivoPushApiChannel.CHANNEL_ID;
    /**
     * properties list
     */
    private List<VivoPushApiProperties> properties = new ArrayList<>();

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public List<VivoPushApiProperties> getProperties() {
        return properties;
    }

    public void setProperties(List<VivoPushApiProperties> properties) {
        this.properties = properties;
    }
}
