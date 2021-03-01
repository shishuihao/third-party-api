package cn.shishuihao.thirdparty.api.pay.alipay;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class AlipayPayProperties {
    /**
     * channel id
     */
    private String channelId = AlipayPayApiChannel.CHANNEL_ID;
    /**
     * properties list
     */
    private List<AlipayPayApiProperties> properties = new ArrayList<>();

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public List<AlipayPayApiProperties> getProperties() {
        return properties;
    }

    public void setProperties(List<AlipayPayApiProperties> properties) {
        this.properties = properties;
    }
}
