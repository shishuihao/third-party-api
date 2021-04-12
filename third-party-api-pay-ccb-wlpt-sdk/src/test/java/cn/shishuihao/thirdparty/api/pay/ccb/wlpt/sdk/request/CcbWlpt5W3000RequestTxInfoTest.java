package cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.request;

import cn.shishuihao.thirdparty.api.commons.xml.JacksonXmlUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class CcbWlpt5W3000RequestTxInfoTest {

    @Test
    void toXml() {
        final String xml = "<?xml version=\"1.0\" encoding=\"GB2312\" standalone=\"yes\" ?> \n" +
                "<TX> \n" +
                "  <REQUEST_SN>2007626104818</REQUEST_SN> \n" +
                "  <CUST_ID>P000607305898</CUST_ID> \n" +
                "  <USER_ID>WLPT02</USER_ID> \n" +
                "  <PASSWORD>111111</PASSWORD> \n" +
                "  <TX_CODE>5W3000</TX_CODE> \n" +
                "  <LANGUAGE>CN</LANGUAGE> \n" +
                "  <TX_INFO> \n" +
                "    <SEND_FILE>D:/TEST/UPLOAD.TXT</SEND_FILE>  \n" +
                "    <UPFILEPATH>circle</UPFILEPATH>  \n" +
                "    <LOCAL_REMOTE>1</LOCAL_REMOTE>  \n" +
                "    <KEEP_FILENAME>1</KEEP_FILENAME>  \n" +
                "  </TX_INFO> \n" +
                "</TX> \n";
        final CcbWlptRequest<CcbWlpt5W3000RequestTxInfo> request = CcbWlptRequest.<CcbWlpt5W3000RequestTxInfo>builder()
                .requestSn("2007626104818")
                .customerId("P000607305898")
                .userId("WLPT02")
                .password("111111")
                .txCode("5W3000")
                .language("CN")
                .txInfo(CcbWlpt5W3000RequestTxInfo.builder()
                        .sendFile("D:/TEST/UPLOAD.TXT")
                        .upFilePath("circle")
                        .localRemote(1)
                        .keepFilename(1)
                        .build())
                .build();
        Assertions.assertEquals(
                JacksonXmlUtils.fromXml(xml, HashMap.class),
                JacksonXmlUtils.fromXml(JacksonXmlUtils.toXml(request), HashMap.class)
        );
    }
}