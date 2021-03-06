package cn.shishuihao.thirdparty.api.push.oppo;

import cn.shishuihao.thirdparty.api.push.properties.AbstractPushApiProperties;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class OppoPushApiProperties extends AbstractPushApiProperties {
    /**
     * 应用key
     */
    private String appKey;
    /**
     * 密钥
     */
    private String masterSecret;

    public OppoPushApiProperties() {
        this.setChannelId(OppoPushApiChannel.CHANNEL_ID);
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
        if (!(o instanceof OppoPushApiProperties)) {
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

    public String getMasterSecret() {
        return masterSecret;
    }

    public void setMasterSecret(String masterSecret) {
        this.masterSecret = masterSecret;
    }
}
