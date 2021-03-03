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

class WxPayOrderQueryResponseTest {

    @Test
    void fromXml() throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String xml = "<xml>\n" +
                "   <return_code><![CDATA[SUCCESS]]></return_code>\n" +
                "   <return_msg><![CDATA[OK]]></return_msg>\n" +
                "   <appid><![CDATA[wx2421b1c4370ec43b]]></appid>\n" +
                "   <mch_id><![CDATA[10000100]]></mch_id>\n" +
                "   <device_info><![CDATA[1000]]></device_info>\n" +
                "   <nonce_str><![CDATA[TN55wO9Pba5yENl8]]></nonce_str>\n" +
                "   <sign><![CDATA[BDF0099C15FF7BC6B1585FBB110AB635]]></sign>\n" +
                "   <result_code><![CDATA[SUCCESS]]></result_code>\n" +
                "   <openid><![CDATA[oUpF8uN95-Ptaags6E_roPHg7AG0]]></openid>\n" +
                "   <is_subscribe><![CDATA[Y]]></is_subscribe>\n" +
                "   <trade_type><![CDATA[MICROPAY]]></trade_type>\n" +
                "   <bank_type><![CDATA[CCB_DEBIT]]></bank_type>\n" +
                "   <total_fee>1</total_fee>\n" +
                "   <fee_type><![CDATA[CNY]]></fee_type>\n" +
                "   <transaction_id><![CDATA[1008450740201411110005820873]]></transaction_id>\n" +
                "   <out_trade_no><![CDATA[1415757673]]></out_trade_no>\n" +
                "   <attach><![CDATA[订单额外描述]]></attach>\n" +
                "   <time_end><![CDATA[20141111170043]]></time_end>\n" +
                "   <trade_state><![CDATA[SUCCESS]]></trade_state>\n" +
                "</xml>";
        WxPayOrderQueryResponse response = XmlUtils.fromXml(xml, WxPayOrderQueryResponse.class);
        Assertions.assertEquals(XmlUtils.fromXml(xml, HashMap.class), XmlUtils.fromXml(XmlUtils.toXml(response), HashMap.class));
    }
}