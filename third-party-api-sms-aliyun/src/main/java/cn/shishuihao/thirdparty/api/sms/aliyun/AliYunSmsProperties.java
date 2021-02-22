package cn.shishuihao.thirdparty.api.sms.aliyun;

import cn.shishuihao.thirdparty.api.sms.SmsProperties;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class AliYunSmsProperties implements SmsProperties {
    /**
     * AccessKeyId用于标识用户
     */
    private String accessKeyId;
    /**
     * AccessKeySecret是用来验证用户的密钥。AccessKeySecret必须保密。
     */
    private String accessSecret;

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public String getAccessSecret() {
        return accessSecret;
    }

    @Override
    public String id() {
        return accessKeyId;
    }
}
