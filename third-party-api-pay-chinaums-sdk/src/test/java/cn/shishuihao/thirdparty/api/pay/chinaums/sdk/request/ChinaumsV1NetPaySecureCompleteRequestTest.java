package cn.shishuihao.thirdparty.api.pay.chinaums.sdk.request;

import cn.shishuihao.thirdparty.api.commons.json.JacksonUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class ChinaumsV1NetPaySecureCompleteRequestTest {
    final String json = "{\n" +
            " \"requestTimestamp\": \"2016-09-22 16:01:42\",\n" +
            " \"msgId\": \"07S30609000023115850160142\",\n" +
            " \"mid\": \"898340149000005\",\n" +
            " \"tid\": \"12340042\",\n" +
            " \"instMid\": \"YUEDANDEFAULT\",\n" +
            " \"completedAmount\": \"1\",\n" +
            " \"merOrderId\": \"20160922145952000023114819\"\n" +
            "}";

    @Test
    void toJson() {
        ChinaumsV1NetPaySecureCompleteRequest request = ChinaumsV1NetPaySecureCompleteRequest.builder()
                .requestTimestamp("2016-09-22 16:01:42")
                .msgId("07S30609000023115850160142")
                .mid("898340149000005")
                .tid("12340042")
                .instMid("YUEDANDEFAULT")
                .completedAmount(1)
                .merOrderId("20160922145952000023114819")
                .build();
        Assertions.assertEquals(
                JacksonUtils.fromJson(json, HashMap.class).toString(),
                JacksonUtils.fromJson(JacksonUtils.toJson(request), HashMap.class).toString()
        );
        Assertions.assertEquals(
                JacksonUtils.fromJson(json, HashMap.class).toString(),
                JacksonUtils.fromJson(JacksonUtils.toJson(JacksonUtils.fromJson(json,
                        ChinaumsV1NetPaySecureCompleteRequest.class)), HashMap.class).toString()
        );
    }
}