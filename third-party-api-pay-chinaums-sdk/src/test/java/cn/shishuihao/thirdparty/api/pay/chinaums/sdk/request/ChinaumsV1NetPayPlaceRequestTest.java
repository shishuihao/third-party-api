package cn.shishuihao.thirdparty.api.pay.chinaums.sdk.request;

import cn.shishuihao.thirdparty.api.commons.json.JacksonUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class ChinaumsV1NetPayPlaceRequestTest {
    final String json = "{\n" +
            "\"requestTimestamp\":\"2019-02-15 13:45:09\",\n" +
            "\"mid\":\"898201612345678\",\n" +
            "\"tid\":\"88880001\",\n" +
            "\"instMid\":\"APPDEFAULT\",\n" +
            "\"merOrderId\":\"90018dc89764b477474d929f29bc150b80c7\",\n" +
            "\"totalAmount\":\"1\",\n" +
            "\"tradeType\":\"APP\"\n" +
            "}";

    @Test
    void toJson() {
        ChinaumsV1NetPayPlaceRequest request = ChinaumsV1NetPayPlaceRequest.builder()
                .requestTimestamp("2019-02-15 13:45:09")
                .mid("898201612345678")
                .tid("88880001")
                .instMid("APPDEFAULT")
                .totalAmount(1)
                .merOrderId("90018dc89764b477474d929f29bc150b80c7")
                .tradeType("APP")
                .build();
        Assertions.assertEquals(
                JacksonUtils.fromJson(json, HashMap.class).toString(),
                JacksonUtils.fromJson(JacksonUtils.toJson(request), HashMap.class).toString()
        );
        Assertions.assertEquals(
                JacksonUtils.fromJson(json, HashMap.class).toString(),
                JacksonUtils.fromJson(JacksonUtils.toJson(JacksonUtils.fromJson(json,
                        ChinaumsV1NetPayPlaceRequest.class)), HashMap.class).toString()
        );
    }
}