package cn.shishuihao.thirdparty.api.pay.ccb.sdk.response;

import cn.shishuihao.thirdparty.api.commons.json.JacksonUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class CcbPay107ResponseTest {
    /**
     * 签名源文格式如下：.
     */
    final String signSrc = "RESULT=Y&OPENID=20180906101102&SUB_OPENID=N";
    /**
     * 返回报文示例：.
     */
    final String json1 = "{\n" +
            "\"RESULT\":\"Y\",\n" +
            "\"OPENID\":\"wx51264215241265\",\n" +
            "\"SUB_OPENID\":\"wx51264215241266\",\n" +
            "\"ERRCODE\":\"\",\n" +
            "\"ERRMSG\":\"\",\n" +
            "\"SIGN\":\"20924b4c8018c591c62d05fffaa32c0009613050c2b739002b0228e74\"\n" +
            "}";
    /**
     * 报错时返回报文示例：.
     */
    final String json2 = "{\n" +
            "\"RESULT\":\"N\",\n" +
            "\"OPENID\":\"20180906101102\",\n" +
            "\"SUB_OPENID\":\"\",\n" +
            "\"ERRCODE\":\"9001\",\n" +
            "\"ERRMSG\":\"未查询到绑定关系\",\n" +
            "\"SIGN\":\"\"\n" +
            "}";

    @Test
    void fromJson1() {
        final CcbPay107Response response = JacksonUtils
                .fromJson(json1, CcbPay107Response.class);
        Assertions.assertEquals(
                JacksonUtils.fromJson(json1, HashMap.class),
                JacksonUtils.fromJson(JacksonUtils.toJson(response), HashMap.class));
    }

    @Test
    void fromJson2() {
        final CcbPay107Response response = JacksonUtils
                .fromJson(json2, CcbPay107Response.class);
        Assertions.assertEquals(
                JacksonUtils.fromJson(json2, HashMap.class),
                JacksonUtils.fromJson(JacksonUtils.toJson(response), HashMap.class));
    }
}