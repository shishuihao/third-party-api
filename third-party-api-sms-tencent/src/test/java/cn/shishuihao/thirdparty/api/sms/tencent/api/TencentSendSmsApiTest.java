package cn.shishuihao.thirdparty.api.sms.tencent.api;

import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.sms.request.SendSmsRequest;
import cn.shishuihao.thirdparty.api.sms.response.SendSmsResponse;
import cn.shishuihao.thirdparty.api.sms.tencent.TencentSmsProperties;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class TencentSendSmsApiTest {
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
        SendSmsResponse response = ApiRegistry.INSTANCE.execute(SendSmsRequest.Builder.builder()
                .channelId("sms.tencent")
                .propertiesId(properties.id())
                .requestId("requestId")
                .phoneNumber("+8613711112222")
                .templateId("1234")
                .templateParams(params)
                .build())
                .orElse(null);
        Assertions.assertNotNull(response);
    }
}