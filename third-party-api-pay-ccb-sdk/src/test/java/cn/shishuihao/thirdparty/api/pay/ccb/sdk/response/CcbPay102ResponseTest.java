package cn.shishuihao.thirdparty.api.pay.ccb.sdk.response;

import cn.shishuihao.thirdparty.api.commons.json.JacksonUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class CcbPay102ResponseTest {
    /**
     * 签名源文格式如下：.
     */
    final String signSrc = "RESULT=Y&ORDERID=20180906101102&AMOUNT=0.01";
    /**
     * 返回报文示例：.
     */
    final String json1 = "{\n" +
            "\"RESULT\":\"Y\",\n" +
            "\"ORDERID\":\"20180906101102\",\n" +
            "\"AMOUNT\":\"0.01\",\n" +
            "\"ZFB_NO\":\"\",\n" +
            "\"ZFB_STATE\":\"\",\n" +
            "\"WECHAT_NO\":\"4200000160201809050255683083\",\n" +
            "\"WECHAT_STATE\":\"SUCCESS\",\n" +
            "\"ERRCODE\":\"\",\n" +
            "\"ERRMSG\":\"\",\n" +
            "\"SIGN\":\"56f93a11ff09a8d1ce4dcd2dfd1f7e1f8af1997a549ff3e5ef9bc0b1b2b" +
            "3ccf2316a3d857453344c74e6f07a9d69135d91e08b9e33637237c61e0d91ae4362" +
            "7a77d59e3b46739c84b9aef26a9b9f2cf218d44884129806f0d121ae8d61d074a15" +
            "505e4b32ce1fd7a39470ec2e29c5ddd64e055792243061576f3e0310e6c96e9\"\n" +
            "}";
    /**
     * 报错时返回报文示例：.
     */
    final String json2 = "{\n" +
            "\"RESULT\":\"N\",\n" +
            "\"ORDERID\":\"20180906101102\",\n" +
            "\"AMOUNT\":\"\",\n" +
            "\"ZFB_NO\":\"\",\n" +
            "\"ZFB_STATE\":\"\",\n" +
            "\"WECHAT_NO\":\"\",\n" +
            "\"WECHAT_STATE\":\"\",\n" +
            "\"ERRCODE\":\"ZBLAP101WX01\",\n" +
            "\"ERRMSG\":\"支付不成功，@@ORDERNOTEXIST~~order not exist@@\",\n" +
            "\"SIGN\":\"\"\n" +
            "}";

    @Test
    void fromJson1() {
        final CcbPay102Response response = JacksonUtils
                .fromJson(json1, CcbPay102Response.class);
        Assertions.assertEquals(
                JacksonUtils.fromJson(json1, HashMap.class),
                JacksonUtils.fromJson(JacksonUtils.toJson(response), HashMap.class));
    }

    @Test
    void fromJson2() {
        final CcbPay102Response response = JacksonUtils
                .fromJson(json2, CcbPay102Response.class);
        Assertions.assertEquals(
                JacksonUtils.fromJson(json2, HashMap.class),
                JacksonUtils.fromJson(JacksonUtils.toJson(response), HashMap.class));
    }
}