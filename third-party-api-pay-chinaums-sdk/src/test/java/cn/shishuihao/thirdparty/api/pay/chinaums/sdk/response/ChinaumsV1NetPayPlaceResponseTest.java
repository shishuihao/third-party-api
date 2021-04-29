package cn.shishuihao.thirdparty.api.pay.chinaums.sdk.response;

import cn.shishuihao.thirdparty.api.commons.json.JacksonUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class ChinaumsV1NetPayPlaceResponseTest {
    final String json = "{\n" +
            "\"connectSys\":\"UNIONPAY\",\n" +
            "\"merName\":\"银联商务微信公众号代运营平台\",\n" +
            "\"mid\":\"898201612345678\",\n" +
            "\"appPayRequest\":{\"qrCode\":\"https://qr.alipay.com/bax03465mkipjzgposlk8001\"},\n" +
            "\"settleRefId\":\"00443400012N\",\n" +
            "\"tid\":\"88880001\",\n" +
            "\"totalAmount\":1,\n" +
            "\"qrCode\":\"https://qr.alipay.com/bax03465mkipjzgposlk8001\",\n" +
            "\"targetMid\":\"2088000148435296\",\n" +
            "\"responseTimestamp\":\"2019-02-15 13:55:47\",\n" +
            "\"errCode\":\"SUCCESS\",\n" +
            "\"targetStatus\":\"10000\",\n" +
            "\"seqId\":\"00443400012N\",\n" +
            "\"merOrderId\":\"900147bf92274bbe4d51b9e9a2307279e4e9\",\n" +
            "\"status\":\"NEW_ORDER\",\n" +
            "\"targetSys\":\"Alipay 2.0\"\n" +
            "}";

    @Test
    void fromJson() {
        ChinaumsV1NetPayPlaceResponse response = JacksonUtils.fromJson(json, ChinaumsV1NetPayPlaceResponse.class);
        Assertions.assertEquals(JacksonUtils.fromJson(json, HashMap.class), JacksonUtils.fromJson(JacksonUtils.toJson(response), HashMap.class));
    }
}