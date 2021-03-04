package cn.shishuihao.thirdparty.api.push.vivo;

import cn.shishuihao.thirdparty.api.core.properties.AbstractApiProperties;
import cn.shishuihao.thirdparty.api.push.PushApiProperties;

import java.util.Objects;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class VivoPushApiProperties extends AbstractApiProperties implements PushApiProperties {
    /**
     * 应用key
     */
    private String appKey;
    /**
     * 密钥
     */
    private String secret;

    public VivoPushApiProperties() {
        this.setChannelId(VivoPushApiChannel.CHANNEL_ID);
    }

    @Override
    public String id() {
        return String.valueOf(appKey);
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
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
        VivoPushApiProperties that = (VivoPushApiProperties) o;
        return Objects.equals(appKey, that.appKey) && Objects.equals(secret, that.secret);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), appKey, secret);
    }
}
