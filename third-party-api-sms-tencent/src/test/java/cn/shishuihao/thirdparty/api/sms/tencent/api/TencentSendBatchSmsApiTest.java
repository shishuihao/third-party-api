package cn.shishuihao.thirdparty.api.sms.tencent.api;

import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.sms.request.SendBatchSmsRequest;
import cn.shishuihao.thirdparty.api.sms.request.SendSmsRequest;
import cn.shishuihao.thirdparty.api.sms.response.SendBatchSmsResponse;
import cn.shishuihao.thirdparty.api.sms.response.SendSmsResponse;
import cn.shishuihao.thirdparty.api.sms.tencent.TencentSmsProperties;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class TencentSendBatchSmsApiTest {
    @Test
    void execute() {
        TencentSmsProperties properties = new TencentSmsProperties();
        properties.setAppId("appId");
        properties.setSecretId("secretId");
        properties.setSecretKey("secretKey");
        properties.setSign("sign");
        properties.setSenderId(null);
        properties.setExtendCode(null);
        ApiRegistry.PROPERTIES_REPOSITORY.add(properties);
        Map<String, String> params = new TreeMap<>();
        params.put("code", "12345");
        SendBatchSmsResponse response = ApiRegistry.INSTANCE.execute(SendBatchSmsRequest.Builder.builder()
                .channelId("sms.tencent")
                .propertiesId(properties.id())
                .requestId("requestId")
                .phoneNumbers(Arrays.asList("+8613711112222", "+8618511122266"))
                .templateId("1234")
                .templateParams(params)
                .build())
                .orElse(null);
        Assertions.assertNotNull(response);
    }
}