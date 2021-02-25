package cn.shishuihao.thirdparty.api.push.xiaomi;

import cn.shishuihao.thirdparty.api.push.PushApiProperties;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class XiaomiPushApiProperties implements PushApiProperties {
    /**
     * channel id
     */
    private String channelId = XiaomiPushApiChannel.CHANNEL_ID;
    /**
     * application id
     */
    private String appId;
    /**
     * application secret key
     */
    private String appSecretKey;

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppSecretKey() {
        return appSecretKey;
    }

    public void setAppSecretKey(String appSecretKey) {
        this.appSecretKey = appSecretKey;
    }

    @Override
    public String channelId() {
        return channelId;
    }

    @Override
    public String id() {
        return appId;
    }
}
