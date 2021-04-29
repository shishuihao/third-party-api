package cn.shishuihao.thirdparty.api.pay.chinaums.sdk.request;

import cn.shishuihao.thirdparty.api.commons.json.JacksonUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class ChinaumsV1NetPaySecureCancelRequestTest {
    final String json = "{\n" +
            " \"requestTimestamp\": \"2016-09-22 16:01:42\",\n" +
            " \"msgId\": \"07S30609000023115850160142\",\n" +
            " \"mid\": \"898340149000005\",\n" +
            " \"tid\": \"12340042\",\n" +
            " \"instMid\": \"YUEDANDEFAULT\",\n" +
            " \"merOrderId\": \"20160922145952000023114819\"\n" +
            "}";

    @Test
    void toJson() {
        ChinaumsV1NetPaySecureCancelRequest request = ChinaumsV1NetPaySecureCancelRequest.builder()
                .requestTimestamp("2016-09-22 16:01:42")
                .msgId("07S30609000023115850160142")
                .mid("898340149000005")
                .tid("12340042")
                .instMid("YUEDANDEFAULT")
                .merOrderId("20160922145952000023114819")
                .build();
        Assertions.assertEquals(
                JacksonUtils.fromJson(json, HashMap.class),
                JacksonUtils.fromJson(JacksonUtils.toJson(request), HashMap.class)
        );
        Assertions.assertEquals(
                JacksonUtils.fromJson(json, HashMap.class),
                JacksonUtils.fromJson(JacksonUtils.toJson(JacksonUtils.fromJson(json,
                        ChinaumsV1NetPaySecureCancelRequest.class)), HashMap.class)
        );
    }
}