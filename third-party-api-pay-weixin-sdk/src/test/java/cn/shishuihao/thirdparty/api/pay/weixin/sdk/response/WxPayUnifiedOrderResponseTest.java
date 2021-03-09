package cn.shishuihao.thirdparty.api.pay.weixin.sdk.response;

import cn.shishuihao.thirdparty.api.pay.weixin.sdk.util.XmlUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class WxPayUnifiedOrderResponseTest {

    @Test
    void fromXml() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String xml = "<xml>\n" +
                "   <return_code><![CDATA[SUCCESS]]></return_code>\n" +
                "   <return_msg><![CDATA[OK]]></return_msg>\n" +
                "   <appid><![CDATA[wx2421b1c4370ec43b]]></appid>\n" +
                "   <mch_id><![CDATA[10000100]]></mch_id>\n" +
                "   <nonce_str><![CDATA[IITRi8Iabbblz1Jc]]></nonce_str>\n" +
                "   <sign><![CDATA[7921E432F65EB8ED0CE9755F0E86D72F]]></sign>\n" +
                "   <result_code><![CDATA[SUCCESS]]></result_code>\n" +
                "   <prepay_id><![CDATA[wx201411101639507cbf6ffd8b0779950874]]></prepay_id>\n" +
                "   <trade_type><![CDATA[JSAPI]]></trade_type>\n" +
                "</xml>";
        WxPayUnifiedOrderResponse response = XmlUtils.fromXml(xml, WxPayUnifiedOrderResponse.class);
        Assertions.assertEquals(XmlUtils.fromXml(xml, HashMap.class), XmlUtils.fromXml(XmlUtils.toXml(response), HashMap.class));
    }
}