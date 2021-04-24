package cn.shishuihao.thirdparty.api.pay.wechat.sdk.response;

import cn.shishuihao.thirdparty.api.pay.wechat.sdk.util.XmlUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class WechatPayCloseOrderResponseTest {

    @Test
    void fromXml() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String xml = "<xml>\n" +
                "   <return_code><![CDATA[SUCCESS]]></return_code>\n" +
                "   <return_msg><![CDATA[OK]]></return_msg>\n" +
                "   <appid><![CDATA[wx2421b1c4370ec43b]]></appid>\n" +
                "   <mch_id><![CDATA[10000100]]></mch_id>\n" +
                "   <nonce_str><![CDATA[BFK89FC6rxKCOjLX]]></nonce_str>\n" +
                "   <sign><![CDATA[72B321D92A7BFA0B2509F3D13C7B1631]]></sign>\n" +
                "   <result_code><![CDATA[SUCCESS]]></result_code>\n" +
                "   <result_msg><![CDATA[OK]]></result_msg>\n" +
                "</xml>";
        WechatPayCloseOrderResponse response = XmlUtils.fromXml(xml, WechatPayCloseOrderResponse.class);
        Assertions.assertEquals(XmlUtils.fromXml(xml, HashMap.class), XmlUtils.fromXml(XmlUtils.toXml(response), HashMap.class));
    }
}