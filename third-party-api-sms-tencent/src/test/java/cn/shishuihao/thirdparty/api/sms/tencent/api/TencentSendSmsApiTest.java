package cn.shishuihao.thirdparty.api.sms.tencent.api;

import cn.shishuihao.thirdparty.api.core.ApiException;
import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.sms.domain.SmsMessage;
import cn.shishuihao.thirdparty.api.sms.request.SendSmsApiRequest;
import cn.shishuihao.thirdparty.api.sms.tencent.TencentSmsApiChannel;
import cn.shishuihao.thirdparty.api.sms.tencent.TencentSmsApiProperties;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class TencentSendSmsApiTest {

    @Test
    void execute() {
        TencentSmsApiProperties properties = new TencentSmsApiProperties();
        properties.setAppId("appId");
        properties.setSecretId("secretId");
        properties.setSecretKey("secretKey");
        properties.setSign("sign");
        properties.setSenderId(null);
        properties.setExtendCode(null);
        ApiRegistry.PROPERTIES_REPOSITORY.add(properties);
        Map<String, String> params = new TreeMap<>();
        params.put("code", "12345");
        SendSmsApiRequest request = SendSmsApiRequest.Builder.builder()
                .channelId(TencentSmsApiChannel.CHANNEL_ID)
                .propertiesId(properties.id())
                .templateId("1234")
                .message(SmsMessage.Builder.builder()
                        .phoneNumber("8613711112222")
                        .signName("test")
                        .templateParams(params)
                        .build())
                .build();
        ApiException apiException = Assertions.assertThrows(ApiException.class, () -> ApiRegistry.INSTANCE.execute(request));
        Assertions.assertTrue(apiException.getMessage().startsWith("[TencentCloudSDKException]code: AuthFailure.SecretIdNotFound message:The SecretId is not found, please ensure that your SecretId is correct. requestId:"));
    }
}