package cn.shishuihao.thirdparty.api.pay.wechat.sdk.request;

import cn.shishuihao.thirdparty.api.commons.xml.JacksonXmlUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class WechatPaySecApiPayRefundRequestTest {

    @Test
    void toXml() {
        String xml = "<xml>\n" +
                "   <appid>wx2421b1c4370ec43b</appid>\n" +
                "   <mch_id>10000100</mch_id>\n" +
                "   <nonce_str>6cefdb308e1e2e8aabd48cf79e546a02</nonce_str>\n" +
                "   <out_refund_no>1415701182</out_refund_no>\n" +
                "   <out_trade_no>1415757673</out_trade_no>\n" +
                "   <refund_fee>1</refund_fee>\n" +
                "   <total_fee>1</total_fee>\n" +
                "   <transaction_id>4006252001201705123297353072</transaction_id>\n" +
                "   <sign>FE56DD4AA85C0EECA82C35595A69E153</sign>\n" +
                "</xml>";
        WechatPaySecApiPayRefundRequest request = WechatPaySecApiPayRefundRequest.builder()
                .appId("wx2421b1c4370ec43b")
                .mchId("10000100")
                .nonceStr("6cefdb308e1e2e8aabd48cf79e546a02")
                .outRefundNo("1415701182")
                .outTradeNo("1415757673")
                .refundFee(1)
                .totalFee(1)
                .transactionId("4006252001201705123297353072")
                .sign("FE56DD4AA85C0EECA82C35595A69E153")
                .build();
        Assertions.assertEquals(
                JacksonXmlUtils.fromXml(xml, HashMap.class),
                JacksonXmlUtils.fromXml(JacksonXmlUtils.toXml(request), HashMap.class)
        );
    }
}