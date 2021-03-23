package cn.shishuihao.thirdparty.api.pay.weixin.sdk.request;

import cn.shishuihao.thirdparty.api.commons.xml.JacksonXmlUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class WxPaySecApiPayReverseRequestTest {

    @Test
    void toXml() {
        String xml = "<xml>\n" +
                "   <appid>wx2421b1c4370ec43b</appid>\n" +
                "   <mch_id>10000100</mch_id>\n" +
                "   <nonce_str>b7ffb16a7150cf08639db472c5f5bdae</nonce_str>\n" +
                "   <out_trade_no>1415717424</out_trade_no>\n" +
                "   <sign>9B2EA16C05A5CEF8E53B14D53932D012</sign>\n" +
                "</xml>";
        WxPaySecApiPayReverseRequest request = WxPaySecApiPayReverseRequest.builder()
                .appId("wx2421b1c4370ec43b")
                .mchId("10000100")
                .nonceStr("b7ffb16a7150cf08639db472c5f5bdae")
                .outTradeNo("1415717424")
                .sign("9B2EA16C05A5CEF8E53B14D53932D012")
                .build();
        Assertions.assertEquals(
                JacksonXmlUtils.fromXml(xml, HashMap.class),
                JacksonXmlUtils.fromXml(JacksonXmlUtils.toXml(request), HashMap.class)
        );
    }
}