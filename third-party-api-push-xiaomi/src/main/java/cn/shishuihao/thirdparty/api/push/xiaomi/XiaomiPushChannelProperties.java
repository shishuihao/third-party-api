package cn.shishuihao.thirdparty.api.push.xiaomi;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class XiaomiPushChannelProperties {
    private String channelId = "push.xiaomi";
    private List<XiaomiPushProperties> properties = new ArrayList<>();

    public String getChannelId() {
        return channelId;
    }

    public XiaomiPushChannelProperties setChannelId(String channelId) {
        this.channelId = channelId;
        return this;
    }

    public List<XiaomiPushProperties> getProperties() {
        return properties;
    }

    public XiaomiPushChannelProperties setProperties(List<XiaomiPushProperties> properties) {
        this.properties = properties;
        return this;
    }
}
