package cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.response;

import cn.shishuihao.thirdparty.api.commons.xml.JacksonXmlUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class CcbWlpt5W1007ResponseTest {

    @Test
    void fromXml() {
        final String xml = "<?xml version=\"1.0\" encoding=\"GB2312\" standalone=\"yes\" ?> \n" +
                "<TX> \n" +
                "  <REQUEST_SN>请求序列码</REQUEST_SN>  \n" +
                "  <TX_CODE>5W1007</TX_CODE> \n" +
                "  <RETURN_CODE>响应码</RETURN_CODE>  \n" +
                "  <RETURN_MSG>响应信息</RETURN_MSG>  \n" +
                "  <LANGUAGE>CN</LANGUAGE>  \n" +
                "  <TX_INFO> \n" +
                "    <AUTH_ID>授权码</AUTH_ID> \n" +
                "    <REASONCODE>附加响应码</REASONCODE > \n" +
                "  </TX_INFO>   \n" +
                "</TX> \n";
        final CcbWlpt5W1007Response response = JacksonXmlUtils
                .fromXml(xml, CcbWlpt5W1007Response.class);
        Assertions.assertEquals(
                JacksonXmlUtils.fromXml(xml, HashMap.class),
                JacksonXmlUtils.fromXml(JacksonXmlUtils.toXml(response), HashMap.class));
    }
}