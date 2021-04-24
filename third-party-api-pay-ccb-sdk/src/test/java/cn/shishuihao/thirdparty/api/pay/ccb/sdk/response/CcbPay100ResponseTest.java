package cn.shishuihao.thirdparty.api.pay.ccb.sdk.response;

import cn.shishuihao.thirdparty.api.commons.json.JacksonUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class CcbPay100ResponseTest {
    final String json1 = "{\n" +
            "\"RESULT\":\"Y\",\n" +
            "\"ORDERID\":\"20180906101102\",\n" +
            "\"QRCODETYPE\":\"1\",\n" +
            "\"AMOUNT\":\"0.01\",\n" +
            "\"WAITTIME\":\"\",\n" +
            "\"TRACEID\":\"10101112345678901234567890\",\n" +
            "\"OPENID\":\"99915236154128\", " +
            "\"PAID_AMOUNT\":\"2\", " +
            "\"RECEIPT_AMOUNT\":\"3\", " +
            "\"COUPONARRAY\":[{\"COUPONNAME\":\"随机立减\"},{\"COUPONNAME\":\"商户优惠券\"}],\n" +
            "\"PAYMENT_DETAILS\": {\"TYPE\":\"ALIPAY\",\"PAY_CHANNEL\":\"BANKCARD\",\"DEBIT_CREDIT_TYPE\":\"DEBIT_CARD\",\"THIRD_TRADE_NO\":\"2018010521001004890523646975\"},\n" +
            "\"ERRCODE\":\"\",\n" +
            "\"ERRMSG\":\"\",\n" +
            "\"SIGN\":\"20924b4c8018c591c62d05fffaa32c0009613050c2b739002b0228e74\"\n" +
            "}";
    final String json2 = "{\n" +
            "\"RESULT\":\"\",\n" +
            "\"ORDERID\":\"20180906101102\",\n" +
            "\"QRCODETYPE\":\"1\",\n" +
            "\"AMOUNT\":\"0.01\",\n" +
            "\"WAITTIME\":\"\",\n" +
            "\"TRACEID\":\"\",\n" +
            "\"ERRCODE\":\"YTMP1000L006\",\n" +
            "\"ERRMSG\":\"二维码已过有效期\",\n" +
            "\"SIGN\":\"\"\n" +
            "}";

    @Test
    void fromJson1() {
        final CcbPay100Response response = JacksonUtils
                .fromJson(json1, CcbPay100Response.class);
        Assertions.assertEquals(
                JacksonUtils.fromJson(json1, HashMap.class),
                JacksonUtils.fromJson(JacksonUtils.toJson(response), HashMap.class));
    }

    @Test
    void fromJson2() {
        final CcbPay100Response response = JacksonUtils
                .fromJson(json2, CcbPay100Response.class);
        Assertions.assertEquals(
                JacksonUtils.fromJson(json2, HashMap.class),
                JacksonUtils.fromJson(JacksonUtils.toJson(response), HashMap.class));
    }
}