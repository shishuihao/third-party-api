package cn.shishuihao.thirdparty.api.pay.chinaums.sdk.request;

import cn.shishuihao.thirdparty.api.commons.json.JacksonUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class ChinaumsV1NetPayRefundQueryRequestTest {
    final String json = "{\n" +
            " \"requestTimestamp\": \"2019-02-01 16:01:42\",\n" +
            " \"msgId\": \"07S30609000023115850160142\",\n" +
            " \"mid\": \"898201612345678\",\n" +
            " \"tid\": \"12340042\",\n" +
            " \"instMid\": \"APPDANDEFAULT\",\n" +
            " \"merOrderId\": \"1001201609234113339074548947\"" +
            "}";

    @Test
    void toJson() {
        ChinaumsV1NetPayRefundQueryRequest request = ChinaumsV1NetPayRefundQueryRequest.builder()
                .requestTimestamp("2019-02-01 16:01:42")
                .msgId("07S30609000023115850160142")
                .mid("898201612345678")
                .tid("12340042")
                .instMid("APPDANDEFAULT")
                .merOrderId("1001201609234113339074548947")
                .build();
        Assertions.assertEquals(
                JacksonUtils.fromJson(json, HashMap.class),
                JacksonUtils.fromJson(JacksonUtils.toJson(request), HashMap.class)
        );
        Assertions.assertEquals(
                JacksonUtils.fromJson(json, HashMap.class),
                JacksonUtils.fromJson(JacksonUtils.toJson(JacksonUtils.fromJson(json,
                        ChinaumsV1NetPayRefundQueryRequest.class)), HashMap.class)
        );
    }
}