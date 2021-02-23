package cn.shishuihao.thirdparty.api.sms.aliyun.api;

import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.sms.aliyun.AliYunSmsProperties;
import cn.shishuihao.thirdparty.api.sms.request.SendSmsRequest;
import cn.shishuihao.thirdparty.api.sms.response.SendSmsResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class AliYunSendSmsApiTest {

    @Test
    void execute() {
        AliYunSmsProperties properties = new AliYunSmsProperties();
        properties.setAccessKeyId("accessKeyId");
        properties.setAccessSecret("accessSecret");
        ApiRegistry.PROPERTIES_REPOSITORY.add(properties);
        Map<String, String> params = new TreeMap<>();
        params.put("code", "12345");
        SendSmsResponse response = ApiRegistry.INSTANCE.execute(SendSmsRequest.Builder.builder()
                .channelId("sms.aliyun")
                .propertiesId(properties.id())
                .phoneNumber("+8613711112222")
                .templateId("1234")
                .templateParams(params)
                .build());
        Assertions.assertNotNull(response);
    }
}