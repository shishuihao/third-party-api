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

class WxPayCloseOrderRequestTest {

    @Test
    void toXml() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String xml = "<xml>\n" +
                "   <appid>wx2421b1c4370ec43b</appid>\n" +
                "   <mch_id>10000100</mch_id>\n" +
                "   <nonce_str>4ca93f17ddf3443ceabf72f26d64fe0e</nonce_str>\n" +
                "   <out_trade_no>1415983244</out_trade_no>\n" +
                "   <sign>59FF1DF214B2D279A0EA7077C54DD95D</sign>\n" +
                "</xml>";
        WxPayCloseOrderRequest request = WxPayCloseOrderRequest.builder()
                .appId("wx2421b1c4370ec43b")
                .mchId("10000100")
                .nonceStr("4ca93f17ddf3443ceabf72f26d64fe0e")
                .outTradeNo("1415983244")
                .sign("59FF1DF214B2D279A0EA7077C54DD95D")
                .build();
        Assertions.assertEquals(XmlUtils.fromXml(xml, HashMap.class), XmlUtils.fromXml(XmlUtils.toXml(request), HashMap.class));
    }
}