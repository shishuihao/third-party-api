package cn.shishuihao.thirdparty.api.pay.wechat.sdk.request;

import cn.shishuihao.thirdparty.api.commons.xml.JacksonXmlUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * @author shishuihao
 * @version 1.0.0
 */
class WechatPayMicroPayRequestTest {
    final String xml = "<xml>\n" +
            "   <appid>wx2421b1c4370ec43b</appid>\n" +
            "   <attach>订单额外描述</attach>\n" +
            "   <auth_code>120269300684844649</auth_code>\n" +
            "   <body>付款码支付测试</body>\n" +
            "   <device_info>1000</device_info>\n" +
            "   <goods_tag></goods_tag>\n" +
            "   <mch_id>10000100</mch_id>\n" +
            "   <nonce_str>8aaee146b1dee7cec9100add9b96cbe2</nonce_str>\n" +
            "   <out_trade_no>1415757673</out_trade_no>\n" +
            "   <spbill_create_ip>14.17.22.52</spbill_create_ip>\n" +
            "   <time_expire></time_expire>\n" +
            "   <total_fee>1</total_fee>\n" +
            "   <sign>C29DB7DB1FD4136B84AE35604756362C</sign>\n" +
            "</xml>";

    @Test
    void toXml() {
        WechatPayMicroPayRequest request = WechatPayMicroPayRequest.builder()
                .appId("wx2421b1c4370ec43b")
                .attach("订单额外描述")
                .authCode("120269300684844649")
                .body("付款码支付测试")
                .deviceInfo("1000")
                .goodsTag("")
                .mchId("10000100")
                .nonceStr("8aaee146b1dee7cec9100add9b96cbe2")
                .outTradeNo("1415757673")
                .spBillCreateIp("14.17.22.52")
                .timeExpire("")
                .totalFee(1)
                .sign("C29DB7DB1FD4136B84AE35604756362C")
                .build();
        Assertions.assertEquals(
                JacksonXmlUtils.fromXml(xml, HashMap.class),
                JacksonXmlUtils.fromXml(JacksonXmlUtils.toXml(request), HashMap.class)
        );
    }
}