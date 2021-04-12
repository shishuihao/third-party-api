package cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.response;

import cn.shishuihao.thirdparty.api.commons.xml.JacksonXmlUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class CcbWlpt6W0111ResponseTest {

    @Test
    void fromXml() {
        final String xml = "<TX> \n" +
                "  <REQUEST_SN>2007626104818</REQUEST_SN> \n" +
                "  <CUST_ID>P000607305898</CUST_ID> \n" +
                "  <TX_CODE>6W0111</TX_CODE> \n" +
                "  <RETURN_CODE>000000</RETURN_CODE> \n" +
                "  <RETURN_MSG>下载文件成功</RETURN_MSG> \n" +
                "  <LANGUAGE>CN</LANGUAGE> \n" +
                "</TX> \n";
        final CcbWlpt6W0111Response response = JacksonXmlUtils
                .fromXml(xml, CcbWlpt6W0111Response.class);
        Assertions.assertEquals(
                JacksonXmlUtils.fromXml(xml, HashMap.class),
                JacksonXmlUtils.fromXml(JacksonXmlUtils.toXml(response), HashMap.class));
    }
}