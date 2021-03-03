package cn.shishuihao.thirdparty.api.pay.icbc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class IcbcPayProperties {
    /**
     * channel id
     */
    private String channelId = IcbcPayApiChannel.CHANNEL_ID;
    /**
     * properties list
     */
    private List<IcbcPayApiProperties> properties = new ArrayList<>();

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public List<IcbcPayApiProperties> getProperties() {
        return properties;
    }

    public void setProperties(List<IcbcPayApiProperties> properties) {
        this.properties = properties;
    }
}
