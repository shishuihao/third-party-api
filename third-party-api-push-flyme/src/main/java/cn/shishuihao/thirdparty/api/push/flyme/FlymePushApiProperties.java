package cn.shishuihao.thirdparty.api.push.flyme;

import cn.shishuihao.thirdparty.api.core.properties.AbstractApiProperties;
import cn.shishuihao.thirdparty.api.push.PushApiProperties;

import java.util.Objects;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class FlymePushApiProperties extends AbstractApiProperties implements PushApiProperties {
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
    private boolean useSSL;
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

    public boolean isUseSSL() {
        return useSSL;
    }

    public void setUseSSL(boolean useSSL) {
        this.useSSL = useSSL;
    }

    public int getRetries() {
        return retries;
    }

    public void setRetries(int retries) {
        this.retries = retries;
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
        FlymePushApiProperties that = (FlymePushApiProperties) o;
        return Objects.equals(appId, that.appId) && Objects.equals(appSecret, that.appSecret);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), appId, appSecret);
    }
}
