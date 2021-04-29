package cn.shishuihao.thirdparty.api.pay.chinaums.sdk.response;

import cn.shishuihao.thirdparty.api.commons.json.JacksonUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class ChinaumsV1NetPayCloseResponseTest {
    final String json = "{\n" +
            " \"errMsg\": \"成功关闭二维码\",\n" +
            " \"mid\": \"898340149000005\",\n" +
            " \"tid\": \"88880001\",\n" +
            " \"instMid\": \"QRPAYDEFAULT\",\n" +
            " \"responseTimestamp\": \"2016-09-22 16:55:01\",\n" +
            " \"errCode\": \"SUCCESS\"\n" +
            "}";

    @Test
    void fromJson() {
        ChinaumsV1NetPayCloseResponse response = JacksonUtils.fromJson(json, ChinaumsV1NetPayCloseResponse.class);
        Assertions.assertEquals(JacksonUtils.fromJson(json, HashMap.class), JacksonUtils.fromJson(JacksonUtils.toJson(response), HashMap.class));
    }
}