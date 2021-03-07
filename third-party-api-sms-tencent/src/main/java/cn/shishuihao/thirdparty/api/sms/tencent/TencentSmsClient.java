package cn.shishuihao.thirdparty.api.sms.tencent;

import cn.shishuihao.thirdparty.api.core.properties.AbstractApiProperties;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.sms.v20190711.SmsClient;
import lombok.AllArgsConstructor;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@AllArgsConstructor
public class TencentSmsClient {
    /**
     * channel repository.
     */
    private final TencentSmsApiChannelProperties channelProperties;
    /**
     * map.
     */
    private final Map<AbstractApiProperties, SmsClient> map
            = new ConcurrentHashMap<>();

    /**
     * get tencent sms client.
     *
     * @param properties properties
     * @return SmsClient
     */
    public SmsClient getClient(final TencentSmsApiProperties properties) {
        return map.computeIfAbsent(properties, k -> {
            /* 必要步骤：
             * 实例化一个认证对象，入参需要传入腾讯云账户密钥对 secretId 和 secretKey
             * 本示例采用从环境变量读取的方式，需要预先在环境变量中设置这两个值
             * 您也可以直接在代码中写入密钥对，但需谨防泄露，不要将代码复制、上传或者分享给他人
             * CAM 密钥查询：https://console.cloud.tencent.com/cam/capi
             */
            Credential cred = new Credential(
                    properties.getSecretId(),
                    properties.getSecretKey());
            /* 非必要步骤:
             * 实例化一个客户端配置对象，可以指定超时时间等配置 */
            ClientProfile clientProfile = new ClientProfile();
            /* SDK 默认用 TC3-HMAC-SHA256 进行签名
             * 非必要请不要修改该字段 */
            clientProfile.setSignMethod("HmacSHA256");
            /* 实例化 SMS 的 client 对象第二个参数是地域信息，可以直接填写字符串 ap-guangzhou，或者引用预设的常量 */
            return new SmsClient(
                    cred,
                    channelProperties.getRegion(),
                    clientProfile);
        });
    }
}
