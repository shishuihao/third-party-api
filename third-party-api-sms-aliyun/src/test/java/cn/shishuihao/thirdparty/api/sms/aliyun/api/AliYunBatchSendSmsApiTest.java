package cn.shishuihao.thirdparty.api.sms.aliyun.api;

import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.sms.aliyun.AliYunSmsProperties;
import cn.shishuihao.thirdparty.api.sms.request.SendBatchSmsRequest;
import cn.shishuihao.thirdparty.api.sms.response.SendBatchSmsResponse;
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
        AliYunSmsProperties properties = new AliYunSmsProperties();
        properties.setAccessKeyId("accessKeyId");
        properties.setAccessSecret("accessSecret");
        ApiRegistry.PROPERTIES_REPOSITORY.add(properties);
        Map<String, String> params = new TreeMap<>();
        params.put("code", "12345");
        SendBatchSmsResponse response = ApiRegistry.INSTANCE.execute(SendBatchSmsRequest.Builder.builder()
                .channelId("sms.aliyun")
                .propertiesId(properties.id())
                .phoneNumbers(Arrays.asList("+8613711112222", "+8618511122266"))
                .templateId("1234")
                .templateParams(params)
                .build());
        Assertions.assertNotNull(response);
    }
}