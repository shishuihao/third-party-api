package cn.shishuihao.thirdparty.api.pay.weixin.sdk.request;

import cn.shishuihao.thirdparty.api.pay.weixin.sdk.util.XmlUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class WxPayUnifiedOrderRequestTest {

    @Test
    void toXml() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String xml = "<xml>\n" +
                "   <appid>wx2421b1c4370ec43b</appid>\n" +
                "   <attach>支付测试</attach>\n" +
                "   <body>JSAPI支付测试</body>\n" +
                "   <mch_id>10000100</mch_id>\n" +
                "   <detail><![CDATA[{ \"goods_detail\":[ " +
                "{ \"goods_id\":\"iphone6s_16G\", \"wxpay_goods_id\":\"1001\", \"goods_name\":\"iPhone6s 16G\", \"quantity\":1, \"price\":528800, \"goods_category\":\"123456\", \"body\":\"苹果手机\" }, " +
                "{ \"goods_id\":\"iphone6s_32G\", \"wxpay_goods_id\":\"1002\", \"goods_name\":\"iPhone6s 32G\", \"quantity\":1, \"price\":608800, \"goods_category\":\"123789\", \"body\":\"苹果手机\" } ] }]]></detail>\n" +
                "   <nonce_str>1add1a30ac87aa2db72f57a2375d8fec</nonce_str>\n" +
                "   <notify_url>http://wxpay.wxutil.com/pub_v2/pay/notify.v2.php</notify_url>\n" +
                "   <openid>oUpF8uMuAJO_M2pxb1Q9zNjWeS6o</openid>\n" +
                "   <out_trade_no>1415659990</out_trade_no>\n" +
                "   <spbill_create_ip>14.23.150.211</spbill_create_ip>\n" +
                "   <total_fee>1</total_fee>\n" +
                "   <trade_type>JSAPI</trade_type>\n" +
                "   <sign>0CB01533B8C1EF103065174F50BCA001</sign>\n" +
                "</xml>";
        WxPayUnifiedOrderRequest request = WxPayUnifiedOrderRequest.builder()
                .appId("wx2421b1c4370ec43b")
                .attach("支付测试")
                .body("JSAPI支付测试")
                .mchId("10000100")
                .detail("{ \"goods_detail\":[ " +
                        "{ \"goods_id\":\"iphone6s_16G\", \"wxpay_goods_id\":\"1001\", \"goods_name\":\"iPhone6s 16G\", \"quantity\":1, \"price\":528800, \"goods_category\":\"123456\", \"body\":\"苹果手机\" }, " +
                        "{ \"goods_id\":\"iphone6s_32G\", \"wxpay_goods_id\":\"1002\", \"goods_name\":\"iPhone6s 32G\", \"quantity\":1, \"price\":608800, \"goods_category\":\"123789\", \"body\":\"苹果手机\" } ] }")
                .nonceStr("1add1a30ac87aa2db72f57a2375d8fec")
                .notifyUrl("http://wxpay.wxutil.com/pub_v2/pay/notify.v2.php")
                .openid("oUpF8uMuAJO_M2pxb1Q9zNjWeS6o")
                .outTradeNo("1415659990")
                .spBillCreateIp("14.23.150.211")
                .totalFee(1)
                .tradeType("JSAPI")
                .sign("0CB01533B8C1EF103065174F50BCA001")
                .build();
        Assertions.assertEquals(
                XmlUtils.fromXml(xml, HashMap.class),
                XmlUtils.fromXml(XmlUtils.toXml(request), HashMap.class)
        );
    }
}