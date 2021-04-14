package cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.response;

import cn.shishuihao.thirdparty.api.commons.xml.JacksonXmlUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class CcbWlpt520200ResponseTest {
    final String xml = "<?xml version=\"1.0\" encoding=\"GB2312\" standalone=\"yes\" ?> \n" +
            "<TX> \n" +
            "  <REQUEST_SN>请求序列码</REQUEST_SN> \n" +
            "  <TX_CODE>520200</TX_CODE> \n" +
            "  <RETURN_CODE>返回码</RETURN_CODE> \n" +
            "  <RETURN_MSG>返回码说明</RETURN_MSG> \n" +
            "  <TX_INFO> \n" +
            "    <MERCHANTID>288042975</MERCHANTID> \n" +
            "    <USER_ID>111111</USER_ID> \n" +
            "    <PAYMENT>0.01</PAYMENT> \n" +
            "    <POSID>000000000</POSID> \n" +
            "  </TX_INFO>   \n" +
            "</TX> \n";

    @Test
    void fromXml() {
        final CcbWlpt520200Response response = JacksonXmlUtils
                .fromXml(xml, CcbWlpt520200Response.class);
        Assertions.assertEquals(
                JacksonXmlUtils.fromXml(xml, HashMap.class),
                JacksonXmlUtils.fromXml(JacksonXmlUtils.toXml(response), HashMap.class));
    }
}