package cn.shishuihao.thirdparty.api.push.flyme;

import cn.shishuihao.thirdparty.api.push.properties.AbstractPushApiProperties;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class FlymePushApiProperties extends AbstractPushApiProperties {
    /**
     * 应用id
     */
    private Long appId;
    /**
     * 应用密钥
     */
    private String appSecret;
    /**
     * 是否使用https接口调用：true 使用https连接，false使用http连接
     */
    private boolean useSsl;
    /**
     * 尝试次数 >=1
     */
    private int retries = 3;

    public FlymePushApiProperties() {
        this.setChannelId(FlymePushApiChannel.CHANNEL_ID);
    }

    @Override
    public String id() {
        return String.valueOf(appId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof FlymePushApiProperties)) {
            return false;
        }
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public Long getAppId() {
        return appId;
    }

    public void setAppId(Long appId) {
        this.appId = appId;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public boolean isUseSsl() {
        return useSsl;
    }

    public void setUseSsl(boolean useSsl) {
        this.useSsl = useSsl;
    }

    public int getRetries() {
        return retries;
    }

    public void setRetries(int retries) {
        this.retries = retries;
    }
}
