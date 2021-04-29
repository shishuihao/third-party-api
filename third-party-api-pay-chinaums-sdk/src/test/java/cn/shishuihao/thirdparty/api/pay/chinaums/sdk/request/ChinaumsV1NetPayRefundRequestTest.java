package cn.shishuihao.thirdparty.api.pay.chinaums.sdk.request;

import cn.shishuihao.thirdparty.api.commons.json.JacksonUtils;
import cn.shishuihao.thirdparty.api.pay.chinaums.sdk.domain.RefundSubOrder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class ChinaumsV1NetPayRefundRequestTest {
    final String json = "{\n" +
            " \"requestTimestamp\": \"2016-09-22 16:01:42\",\n" +
            " \"msgId\": \"07S30609000023115850160142\",\n" +
            " \"mid\": \"898340149000005\",\n" +
            " \"tid\": \"12340042\",\n" +
            " \"subOrders\": [\n" +
            " {\n" +
            " \"totalAmount\": 1,\n" +
            " \"mid\": \"988460101800203\"\n" +
            " }\n" +
            " ],\n" +
            " \"instMid\": \"APPDANDEFAULT\",\n" +
            " \"platformAmount\": 0,\n" +
            " \"refundAmount\": 1,\n" +
            " \"refundOrderId\": \"100020180614150844119799\",\n" +
            " \"merOrderId\": \"1001201609234113339074548947\"\n" +
            "}";

    @Test
    void toJson() {
        ChinaumsV1NetPayRefundRequest request = ChinaumsV1NetPayRefundRequest.builder()
                .requestTimestamp("2016-09-22 16:01:42")
                .msgId("07S30609000023115850160142")
                .mid("898340149000005")
                .tid("12340042")
                .subOrders(new RefundSubOrder[]{
                        RefundSubOrder.builder()
                                .totalAmount(1)
                                .mid("988460101800203")
                                .build()
                })
                .instMid("APPDANDEFAULT")
                .platformAmount(0)
                .refundAmount(1)
                .refundOrderId("100020180614150844119799")
                .merOrderId("1001201609234113339074548947")
                .instMid("APPDANDEFAULT")
                .build();
        Assertions.assertEquals(
                JacksonUtils.fromJson(json, HashMap.class),
                JacksonUtils.fromJson(JacksonUtils.toJson(request), HashMap.class)
        );
        Assertions.assertEquals(
                JacksonUtils.fromJson(json, HashMap.class),
                JacksonUtils.fromJson(JacksonUtils.toJson(JacksonUtils.fromJson(json,
                        ChinaumsV1NetPayRefundRequest.class)), HashMap.class)
        );
    }
}