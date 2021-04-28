package cn.shishuihao.thirdparty.api.pay.chinaums.sdk.response;

import cn.shishuihao.thirdparty.api.commons.json.JacksonUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class ChinaumsV1NetPayRefundResponseTest {
    final String json = "{\n" +
            " \"mid\": \"898340149000030\",\n" +
            " \"refundStatus\": \"SUCCESS\",\n" +
            " \"tid\": \"88880001\",\n" +
            " \"instMid\": \"QRPAYDEFAULT\",\n" +
            " \"refundOrderId\": \"9001201809201021510524644261\",\n" +
            " \"refundTargetOrderId\": \"2018092022001418830580874945\",\n" +
            " \"responseTimestamp\": \"2018-09-20 10:21:57\",\n" +
            " \"errCode\": \"SUCCESS\",\n" +
            " \"status\": \"REFUND\",\n" +
            " \"merOrderId\": \"90012018092010155005062202780\",\n" +
            " \"refundAmount\": 1 }";

    @Test
    void fromJson() {
        ChinaumsV1NetPayRefundResponse response = JacksonUtils.fromJson(json, ChinaumsV1NetPayRefundResponse.class);
        Assertions.assertEquals(JacksonUtils.fromJson(json, HashMap.class), JacksonUtils.fromJson(JacksonUtils.toJson(response), HashMap.class));
    }
}