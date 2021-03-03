package cn.shishuihao.thirdparty.api.push.xiaomi;

import cn.shishuihao.thirdparty.api.core.properties.AbstractApiProperties;
import cn.shishuihao.thirdparty.api.push.PushApiProperties;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        XiaomiPushApiProperties that = (XiaomiPushApiProperties) o;
        return Objects.equals(appId, that.appId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), appId);
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
