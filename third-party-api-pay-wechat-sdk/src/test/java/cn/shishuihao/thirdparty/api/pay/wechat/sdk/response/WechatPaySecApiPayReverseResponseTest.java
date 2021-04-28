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

class WechatPaySecApiPayReverseResponseTest {
    final String xml = "<xml>\n" +
            "   <return_code><![CDATA[SUCCESS]]></return_code>\n" +
            "   <return_msg><![CDATA[OK]]></return_msg>\n" +
            "   <appid><![CDATA[wx2421b1c4370ec43b]]></appid>\n" +
            "   <mch_id><![CDATA[10000100]]></mch_id>\n" +
            "   <nonce_str><![CDATA[o5bAKF3o2ypC8hwa]]></nonce_str>\n" +
            "   <sign><![CDATA[6F5080EDDD196FFCDE53F786BBB93899]]></sign>\n" +
            "   <result_code><![CDATA[SUCCESS]]></result_code>\n" +
            "   <recall><![CDATA[N]]></recall>\n" +
            "</xml>";

    @Test
    void fromXml() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        WechatPaySecApiPayReverseResponse response = XmlUtils.fromXml(xml, WechatPaySecApiPayReverseResponse.class);
        Assertions.assertEquals(XmlUtils.fromXml(xml, HashMap.class), XmlUtils.fromXml(XmlUtils.toXml(response), HashMap.class));
    }
}