package cn.shishuihao.thirdparty.api.pay.chinaums.sdk.response;

import cn.shishuihao.thirdparty.api.commons.json.JacksonUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class ChinaumsV1NetPayQueryResponseTest {
    final String json = "{\n" +
            " \"buyerUsername\": \"119***@qq.com\",\n" +
            " \"payTime\": \"2018-09-20 09:50:33\",\n" +
            " \"seqId\": \"00315100000N\",\n" +
            " \"invoiceAmount\": 1,\n" +
            " \"settleDate\": \"2018-09-20\",\n" +
            " \"buyerId\": \"2088702631618837\",\n" +
            " \"totalAmount\": 1,\n" +
            " \"couponAmount\": 0,\n" +
            " \"buyerPayAmount\": 1,\n" +
            " \"targetOrderId\": \"2018092022001418830581229369\",\n" +
            " \"merOrderId\": \"90012018092009395265848826440\",\n" +
            " \"status\": \"TRADE_SUCCESS\",\n" +
            " \"targetSys\": \"Alipay 2.0\",\n" +
            " \"merName\": \"test30\",\n" +
            " \"mid\": \"898340149000030\",\n" +
            " \"tid\": \"88880001\",\n" +
            " \"instMid\": \"YUEDANDEFAULT\",\n" +
            " \"totalAmount\": 1,\n" +
            " \"responseTimestamp\": \"2018-09-20 10:00:53\",\n" +
            " \"errCode\": \"SUCCESS\"\n" +
            "}";

    @Test
    void fromJson() {
        ChinaumsV1NetPayQueryResponse response = JacksonUtils.fromJson(json, ChinaumsV1NetPayQueryResponse.class);
        Assertions.assertEquals(JacksonUtils.fromJson(json, HashMap.class), JacksonUtils.fromJson(JacksonUtils.toJson(response), HashMap.class));
    }
}