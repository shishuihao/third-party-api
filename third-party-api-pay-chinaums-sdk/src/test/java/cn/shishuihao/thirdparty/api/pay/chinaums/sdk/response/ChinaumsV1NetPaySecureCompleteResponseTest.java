package cn.shishuihao.thirdparty.api.pay.chinaums.sdk.response;

import cn.shishuihao.thirdparty.api.commons.json.JacksonUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class ChinaumsV1NetPaySecureCompleteResponseTest {
    final String json = "{\n" +
            " \"completedAmount\": 1,\n" +
            " \"connectSys\": \"MYBANK2\",\n" +
            " \"errMsg\": \"担保完成成功\",\n" +
            " \"merName\": \"test30\",\n" +
            " \"mid\": \"898340149000030\",\n" +
            " \"secureStatus\": \"ALL_COMPLETED\",\n" +
            " \"settleRefId\": \"00340500355N\",\n" +
            " \"tid\": \"88880001\",\n" +
            " \"totalAmount\": 1,\n" +
            " \"targetMid\": \"2088131465886624\",\n" +
            " \"responseTimestamp\": \"2018-10-22 14:23:59\",\n" +
            " \"errCode\": \"SUCCESS\",\n" +
            " \"cardAttr\": \"BALANCE\",\n" +
            " \"targetOrderId\": \"2018102222001418835415132959\",\n" +
            " \"seqId\": \"00340500355N\",\n" +
            " \"merOrderId\": \"90012018102214143494762119720\",\n" +
            " \"status\": \"TRADE_SUCCESS\",\n" +
            " \"targetSys\": \"Alipay 2.0\"\n" +
            "}";

    @Test
    void fromJson() {
        ChinaumsV1NetPaySecureCompleteResponse response = JacksonUtils.fromJson(json, ChinaumsV1NetPaySecureCompleteResponse.class);
        Assertions.assertEquals(JacksonUtils.fromJson(json, HashMap.class), JacksonUtils.fromJson(JacksonUtils.toJson(response), HashMap.class));
    }
}