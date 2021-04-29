package cn.shishuihao.thirdparty.api.pay.chinaums.sdk.response;

import cn.shishuihao.thirdparty.api.commons.json.JacksonUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class ChinaumsV1NetPayRefundQueryResponseTest {
    final String json = "{\n" +
            " \"payTime\": \"2019-02-01 16:46:52\",\n" +
            " \"connectSys\": \"OPENCHANNEL\",\n" +
            " \"errMsg\": \"查询成功\",\n" +
            " \"merName\": \"银联商务微信公众号代运营平台\",\n" +
            " \"mid\": \"898201612345678\",\n" +
            " \"refundStatus\": \"SUCCESS\",\n" +
            " \"settleDate\": \"2019-02-01\",\n" +
            " \"settleRefId\": \"00438100009N\",\n" +
            " \"tid\": \"88880001\",\n" +
            " \"refundOrderId\": \"10001902011824652164172283\",\n" +
            " \"refundTargetOrderId\": \"50000409362019020108231692550\",\n" +
            " \"totalAmount\": 1,\n" +
            " \"targetMid\": \"266103381\",\n" +
            " \"responseTimestamp\": \"2019-02-01 17:30:17\",\n" +
            " \"errCode\": \"SUCCESS\",\n" +
            " \"targetStatus\": \"SUCCESS\",\n" +
            " \"seqId\": \"00438100010N\",\n" +
            " \"merOrderId\": \"9001201902011645182672629078\",\n" +
            " \"status\": \"TRADE_SUCCESS\",\n" +
            " \"targetSys\": \"WXPay\"\n" +
            "}";

    @Test
    void fromJson() {
        ChinaumsV1NetPayRefundQueryResponse response = JacksonUtils.fromJson(json, ChinaumsV1NetPayRefundQueryResponse.class);
        Assertions.assertEquals(JacksonUtils.fromJson(json, HashMap.class), JacksonUtils.fromJson(JacksonUtils.toJson(response), HashMap.class));
    }
}