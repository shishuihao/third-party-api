package cn.shishuihao.thirdparty.api.pay.chinaums.sdk.request;

import cn.shishuihao.thirdparty.api.commons.json.JacksonUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class ChinaumsV1NetPayCloseRequestTest {
    final String json = "{\n" +
            " \"merOrderId\": \"20160922145952000023114819\",\n" +
            " \"requestTimestamp\": \"2016-09-22 16:55:00\",\n" +
            " \"mid\": \"898340149000005\",\n" +
            " \"msgId\": \"800000000010\",\n" +
            " \"tid\": \"00000001\",\n" +
            " \"instMid\": \"APPDEFAULT\"\n" +
            "}";

    @Test
    void toJson() {
        ChinaumsV1NetPayCloseRequest request = ChinaumsV1NetPayCloseRequest.builder()
                .requestTimestamp("2016-09-22 16:55:00")
                .msgId("800000000010")
                .mid("898340149000005")
                .tid("00000001")
                .instMid("APPDEFAULT")
                .merOrderId("20160922145952000023114819")
                .build();
        Assertions.assertEquals(
                JacksonUtils.fromJson(json, HashMap.class),
                JacksonUtils.fromJson(JacksonUtils.toJson(request), HashMap.class)
        );
        Assertions.assertEquals(
                JacksonUtils.fromJson(json, HashMap.class),
                JacksonUtils.fromJson(JacksonUtils.toJson(JacksonUtils.fromJson(json,
                        ChinaumsV1NetPayCloseRequest.class)), HashMap.class)
        );
    }
}