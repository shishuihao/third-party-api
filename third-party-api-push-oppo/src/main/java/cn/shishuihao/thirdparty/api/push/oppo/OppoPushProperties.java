package cn.shishuihao.thirdparty.api.push.oppo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class OppoPushProperties {
    /**
     * channel id
     */
    private String channelId = OppoPushApiChannel.CHANNEL_ID;
    /**
     * properties list
     */
    private List<OppoPushApiProperties> properties = new ArrayList<>();

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public List<OppoPushApiProperties> getProperties() {
        return properties;
    }

    public void setProperties(List<OppoPushApiProperties> properties) {
        this.properties = properties;
    }
}
