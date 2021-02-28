package cn.shishuihao.thirdparty.api.sms.aliyun.api;

import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.sms.aliyun.AliYunSmsApiChannel;
import cn.shishuihao.thirdparty.api.sms.aliyun.AliYunSmsApiProperties;
import cn.shishuihao.thirdparty.api.sms.domain.SmsMessage;
import cn.shishuihao.thirdparty.api.sms.request.SendBatchSmsApiRequest;
import cn.shishuihao.thirdparty.api.sms.response.SendBatchSmsApiResponse;
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
        SendBatchSmsApiResponse response = ApiRegistry.INSTANCE.execute(SendBatchSmsApiRequest.Builder.builder()
                .channelId(AliYunSmsApiChannel.CHANNEL_ID)
                .propertiesId(properties.id())
                .templateId("SMS_123456789")
                .messages(Arrays.asList(SmsMessage.Builder.builder()
                        .phoneNumber("8613711112222")
                        .signName("test")
                        .templateParams(params)
                        .build(), SmsMessage.Builder.builder()
                        .phoneNumber("8618511122266")
                        .signName("test")
                        .templateParams(params)
                        .build()))
                .build());
        Assertions.assertNotNull(response);
    }
}