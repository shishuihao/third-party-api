package cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.response;

import cn.shishuihao.thirdparty.api.commons.xml.JacksonXmlUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class CcbWlpt5W3000ResponseTest {

    @Test
    void fromXml() {
        final String xml = "<?xml version=\"1.0\" encoding=\"GB2312\" standalone=\"yes\" ?> \n" +
                "<TX> \n" +
                "  <REQUEST_SN>2007626104818</REQUEST_SN> \n" +
                "  <CUST_ID>P000607305898</CUST_ID> \n" +
                "  <TX_CODE>5W2000</TX_CODE> \n" +
                "  <RETURN_CODE>000000</RETURN_CODE> \n" +
                "  <RETURN_MSG>文件已经发往后台</RETURN_MSG> \n" +
                "  <LANGUAGE>CN</LANGUAGE> \n" +
                "  <TX_INFO> \n" +
                "    <ORI_FILE>UPLOAD.TXT</ORI_FILE> \n" +
                "    <SEND_FILE>CBB1172476199728</SEND_FILE> \n" +
                "    <UP_FILE_PATH>circle</UP_FILE_PATH> \n" +
                "  </TX_INFO>   \n" +
                "</TX> \n";
        final CcbWlpt5W3000Response response = JacksonXmlUtils
                .fromXml(xml, CcbWlpt5W3000Response.class);
        Assertions.assertEquals(
                JacksonXmlUtils.fromXml(xml, HashMap.class),
                JacksonXmlUtils.fromXml(JacksonXmlUtils.toXml(response), HashMap.class));
    }
}