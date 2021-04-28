package cn.shishuihao.thirdparty.api.pay.chinaums.sdk.request;

import cn.shishuihao.thirdparty.api.commons.json.JacksonUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class ChinaumsV1NetPayQueryRequestTest {
    final String json = "{\n" +
            " \"requestTimestamp\": \"2016-09-22 16:55:00\",\n" +
            " \"mid\": \"898340149000005\",\n" +
            " \"merOrderId\": \"1001201609234113339074548947\",\n" +
            " \"tid\": \"12345080\",\n" +
            " \"msgId\": \"800000000010\",\n" +
            " \"instMid\": \"APPDANDEFAULT\"\n" +
            "}";

    @Test
    void toJson() {
        ChinaumsV1NetPayQueryRequest request = ChinaumsV1NetPayQueryRequest.builder()
                .requestTimestamp("2016-09-22 16:55:00")
                .mid("898340149000005")
                .merOrderId("1001201609234113339074548947")
                .tid("12345080")
                .msgId("800000000010")
                .instMid("APPDANDEFAULT")
                .build();
        Assertions.assertEquals(
                JacksonUtils.fromJson(json, HashMap.class),
                JacksonUtils.fromJson(JacksonUtils.toJson(request), HashMap.class)
        );
        Assertions.assertEquals(
                JacksonUtils.fromJson(json, HashMap.class),
                JacksonUtils.fromJson(JacksonUtils.toJson(JacksonUtils.fromJson(json,
                        ChinaumsV1NetPayQueryRequest.class)), HashMap.class)
        );
    }
}