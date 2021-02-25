package cn.shishuihao.thirdparty.api.push.xiaomi;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class XiaomiPushProperties {
    private String channelId = "push.xiaomi";
    private List<XiaomiPushApiProperties> properties = new ArrayList<>();

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public List<XiaomiPushApiProperties> getProperties() {
        return properties;
    }

    public void setProperties(List<XiaomiPushApiProperties> properties) {
        this.properties = properties;
    }
}
