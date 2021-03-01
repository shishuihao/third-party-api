package cn.shishuihao.thirdparty.api.push.xiaomi;

import cn.shishuihao.thirdparty.api.core.properties.AbstractApiProperties;
import cn.shishuihao.thirdparty.api.push.PushApiProperties;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class XiaomiPushApiProperties extends AbstractApiProperties implements PushApiProperties {
    public XiaomiPushApiProperties() {
        this.setChannelId(XiaomiPushApiChannel.CHANNEL_ID);
    }

    /**
     * application id
     */
    private String appId;
    /**
     * application secret key
     */
    private String appSecretKey;

    @Override
    public String id() {
        return appId;
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
}
