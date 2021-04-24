package cn.shishuihao.thirdparty.api.pay.ccb.sdk.response;

import cn.shishuihao.thirdparty.api.commons.json.JacksonUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class CcbPay101ResponseTest {
    /**
     * 签名源文格式如下：.
     */
    final String signSrc = "RESULT=Y&ORDERID=20180906101102&AMOUNT=0.01&WAITTIME=5";
    /**
     * 返回报文示例：.
     */
    final String json1 = "{\n" +
            "\"RESULT\":\"Y\",\n" +
            "\"ORDERID\":\"20180906101102\",\n" +
            "\"AMOUNT\":\"0.01\",\n" +
            "\"WAITTIME\":\"5\",\n" +
            "\"TRACEID\":\"1010113861527649530264100\",\n" +
            "\"OPENID\":\"99915236154128\", " +
            "\"PAID_AMOUNT\":\"2\", " +
            "\"RECEIPT_AMOUNT\":\"3\", " +
            "\"COUPONARRAY\":[{\"COUPONNAME\":\"随机立减\"},{\"COUPONNAME\":\"商户优惠券\"}],\n" +
            "\"PAYMENT_DETAILS\": {\"TYPE\":\"ALIPAY\",\"PAY_CHANNEL\":\"BANKCARD\",\"DEBIT_CREDIT_TYPE\":\"DEBIT_CARD\",\"THIRD_TRADE_NO\":\"2018010521001004890523646975\"},\n" +
            "\"ERRCODE\":\"\",\n" +
            "\"ERRMSG\":\"\",\n" +
            "\"SIGN\":\"20924b4c8018c591c62d05fffaa32c0009613050c2b739002b0228e74\"\n" +
            "}";
    /**
     * 报错时返回报文示例：.
     */
    final String json2 = "{\n" +
            "\"RESULT\":\"N\",\n" +
            "\"ORDERID\":\"\",\n" +
            "\"AMOUNT\":\"\",\n" +
            "\"WAITTIME\":\"\",\n" +
            "\"TRACEID\":\"\",\n" +
            "\"ERRCODE\":\"9001\",\n" +
            "\"ERRMSG\":\"未查询到该笔订单。\",\n" +
            "\"SIGN\":\"\"\n" +
            "}";

    @Test
    void fromJson1() {
        final CcbPay101Response response = JacksonUtils
                .fromJson(json1, CcbPay101Response.class);
        Assertions.assertEquals(
                JacksonUtils.fromJson(json1, HashMap.class),
                JacksonUtils.fromJson(JacksonUtils.toJson(response), HashMap.class));
    }

    @Test
    void fromJson2() {
        final CcbPay101Response response = JacksonUtils
                .fromJson(json2, CcbPay101Response.class);
        Assertions.assertEquals(
                JacksonUtils.fromJson(json2, HashMap.class),
                JacksonUtils.fromJson(JacksonUtils.toJson(response), HashMap.class));
    }
}