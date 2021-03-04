package cn.shishuihao.thirdparty.api.push.flyme;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class FlymePushProperties {
    /**
     * channel id
     */
    private String channelId = FlymePushApiChannel.CHANNEL_ID;
    /**
     * properties list
     */
    private List<FlymePushApiProperties> properties = new ArrayList<>();

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public List<FlymePushApiProperties> getProperties() {
        return properties;
    }

    public void setProperties(List<FlymePushApiProperties> properties) {
        this.properties = properties;
    }
}
