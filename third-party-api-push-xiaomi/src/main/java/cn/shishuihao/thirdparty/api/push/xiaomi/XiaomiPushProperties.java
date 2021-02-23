package cn.shishuihao.thirdparty.api.push.xiaomi;

import cn.shishuihao.thirdparty.api.push.PushProperties;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class XiaomiPushProperties implements PushProperties {
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

    public XiaomiPushProperties setAppId(String appId) {
        this.appId = appId;
        return this;
    }

    public String getAppSecretKey() {
        return appSecretKey;
    }

    public XiaomiPushProperties setAppSecretKey(String appSecretKey) {
        this.appSecretKey = appSecretKey;
        return this;
    }

    @Override
    public String id() {
        return appId;
    }
}
