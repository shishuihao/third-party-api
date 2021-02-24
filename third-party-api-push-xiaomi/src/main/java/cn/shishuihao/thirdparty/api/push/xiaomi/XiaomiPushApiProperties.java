package cn.shishuihao.thirdparty.api.push.xiaomi;

import cn.shishuihao.thirdparty.api.push.PushApiProperties;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class XiaomiPushApiProperties implements PushApiProperties {
    /**
     * application id
     */
    private String appId;
    /**
     * application secret key
     */
    private String appSecretKey;

    public String getAppId() {
        return appId;
    }

    public XiaomiPushApiProperties setAppId(String appId) {
        this.appId = appId;
        return this;
    }

    public String getAppSecretKey() {
        return appSecretKey;
    }

    public XiaomiPushApiProperties setAppSecretKey(String appSecretKey) {
        this.appSecretKey = appSecretKey;
        return this;
    }

    @Override
    public String id() {
        return appId;
    }
}
