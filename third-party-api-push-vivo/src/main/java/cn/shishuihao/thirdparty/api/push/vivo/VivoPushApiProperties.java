package cn.shishuihao.thirdparty.api.push.vivo;

import cn.shishuihao.thirdparty.api.push.properties.AbstractPushApiProperties;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class VivoPushApiProperties extends AbstractPushApiProperties {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof VivoPushApiProperties)) {
            return false;
        }
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
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
}
