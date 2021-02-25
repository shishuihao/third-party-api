package cn.shishuihao.thirdparty.api.sms.aliyun;

import cn.shishuihao.thirdparty.api.sms.SmsApiProperties;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class AliYunSmsApiProperties implements SmsApiProperties {
    /**
     * channel id
     */
    private String channelId = AliYunSmsApiChannel.CHANNEL_ID;
    /**
     * AccessKeyId用于标识用户
     */
    private String accessKeyId;
    /**
     * AccessKeySecret是用来验证用户的密钥。AccessKeySecret必须保密。
     */
    private String accessSecret;

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public String getAccessSecret() {
        return accessSecret;
    }

    public void setAccessSecret(String accessSecret) {
        this.accessSecret = accessSecret;
    }

    @Override
    public String channelId() {
        return channelId;
    }

    @Override
    public String id() {
        return accessKeyId;
    }
}
