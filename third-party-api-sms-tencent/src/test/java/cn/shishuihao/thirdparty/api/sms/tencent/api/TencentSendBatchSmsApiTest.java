package cn.shishuihao.thirdparty.api.sms.tencent.api;

import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.core.configuration.ApiConfiguration;
import cn.shishuihao.thirdparty.api.core.exception.ApiException;
import cn.shishuihao.thirdparty.api.sms.domain.SmsMessage;
import cn.shishuihao.thirdparty.api.sms.request.SendBatchSmsApiRequest;
import cn.shishuihao.thirdparty.api.sms.tencent.TencentSmsApiChannel;
import cn.shishuihao.thirdparty.api.sms.tencent.TencentSmsApiProperties;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class TencentSendBatchSmsApiTest {

    @Test
    void execute() {
        TencentSmsApiProperties properties = new TencentSmsApiProperties();
        properties.setAppId("appId");
        properties.setSecretId("secretId");
        properties.setSecretKey("secretKey");
        properties.setSign("sign");
        properties.setSenderId(null);
        properties.setExtendCode(null);
        ApiConfiguration configuration = ApiConfiguration.builder()
                .appId("appId")
                .channelId(properties.channelId())
                .properties(properties)
                .build();
        ApiRegistry.CONFIGURATION_REPOSITORY.save(configuration);
        Map<String, String> params = new TreeMap<>();
        params.put("code", "12345");
        SendBatchSmsApiRequest request = SendBatchSmsApiRequest.builder()
                .channelId(TencentSmsApiChannel.CHANNEL_ID)
                .appId(configuration.getAppId())
                .templateId("1234")
                .messages(Arrays.asList(SmsMessage.builder()
                        .phoneNumber("+8613711112222")
                        .signName("test")
                        .templateParams(params)
                        .build(), SmsMessage.builder()
                        .phoneNumber("+8618511122266")
                        .signName("test")
                        .templateParams(params)
                        .build()))
                .build();
        ApiException apiException = Assertions.assertThrows(ApiException.class, () -> ApiRegistry.INSTANCE.execute(request));
        Assertions.assertTrue(apiException.getMessage().startsWith("[TencentCloudSDKException]code: AuthFailure.SecretIdNotFound message:The SecretId is not found, please ensure that your SecretId is correct. requestId:"));
    }
}