package cn.shishuihao.thirdparty.api.pay.weixin.sdk.request;

import cn.shishuihao.thirdparty.api.commons.xml.JacksonXmlUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class WxPayRefundQueryRequestTest {

    @Test
    void toXml() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String xml = "<xml>\n" +
                "   <appid>wx2421b1c4370ec43b</appid>\n" +
                "   <mch_id>10000100</mch_id>\n" +
                "   <nonce_str>0b9f35f484df17a732e537c37708d1d0</nonce_str>\n" +
                "   <out_refund_no></out_refund_no>\n" +
                "   <out_trade_no>1415757673</out_trade_no>\n" +
                "   <refund_id></refund_id>\n" +
                "   <transaction_id></transaction_id>\n" +
                "   <sign>66FFB727015F450D167EF38CCC549521</sign>\n" +
                "</xml>";
        WxPayRefundQueryRequest request = WxPayRefundQueryRequest.builder()
                .appId("wx2421b1c4370ec43b")
                .mchId("10000100")
                .nonceStr("0b9f35f484df17a732e537c37708d1d0")
                .outRefundNo("")
                .outTradeNo("1415757673")
                .refundId("")
                .transactionId("")
                .sign("66FFB727015F450D167EF38CCC549521")
                .build();
        Assertions.assertEquals(
                JacksonXmlUtils.fromXml(xml, HashMap.class),
                JacksonXmlUtils.fromXml(JacksonXmlUtils.toXml(request), HashMap.class)
        );
    }
}