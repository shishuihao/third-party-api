package cn.shishuihao.thirdparty.api.sms.aliyun.api;

import cn.shishuihao.thirdparty.api.core.exception.ApiException;
import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.sms.aliyun.AliYunSmsApiChannel;
import cn.shishuihao.thirdparty.api.sms.aliyun.AliYunSmsApiProperties;
import cn.shishuihao.thirdparty.api.sms.domain.SmsMessage;
import cn.shishuihao.thirdparty.api.sms.request.SendBatchSmsApiRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class AliYunBatchSendSmsApiTest {

    @Test
    void execute() {
        AliYunSmsApiProperties properties = new AliYunSmsApiProperties();
        properties.setAccessKeyId("AccessKeyId");
        properties.setAccessSecret("AccessSecret");
        ApiRegistry.PROPERTIES_REPOSITORY.add(properties);
        Map<String, String> params = new TreeMap<>();
        params.put("code", "12345");
        SendBatchSmsApiRequest request = SendBatchSmsApiRequest.builder()
                .channelId(AliYunSmsApiChannel.CHANNEL_ID)
                .propertiesId(properties.id())
                .templateId("SMS_123456789")
                .messages(Arrays.asList(SmsMessage.builder()
                        .phoneNumber("8613711112222")
                        .signName("test")
                        .templateParams(params)
                        .build(), SmsMessage.builder()
                        .phoneNumber("8618511122266")
                        .signName("test")
                        .templateParams(params)
                        .build()))
                .build();
        ApiException apiException = Assertions.assertThrows(ApiException.class, () -> ApiRegistry.INSTANCE.execute(request));
        Assertions.assertTrue(apiException.getMessage().startsWith("com.aliyun.tea.TeaException: code: 404, Specified access key is not found. request id: "));
    }
}