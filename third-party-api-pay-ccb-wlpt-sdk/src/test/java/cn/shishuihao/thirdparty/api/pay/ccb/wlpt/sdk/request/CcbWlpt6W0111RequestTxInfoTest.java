package cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.request;

import cn.shishuihao.thirdparty.api.commons.xml.JacksonXmlUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class CcbWlpt6W0111RequestTxInfoTest {
    final String xml = "<?xml version=\"1.0\" encoding=\"GB2312\" standalone=\"yes\" ?> \n" +
            "<TX> \n" +
            "  <REQUEST_SN>2007626104818</REQUEST_SN> \n" +
            "  <CUST_ID>P000607305898</CUST_ID> \n" +
            "  <USER_ID>WLPT02</USER_ID> \n" +
            "  <PASSWORD>111111</PASSWORD> \n" +
            "  <TX_CODE>6W0111</TX_CODE> \n" +
            "  <LANGUAGE>CN</LANGUAGE> \n" +
            "  <TX_INFO> \n" +
            "    <SOURCE>CBB1172476199728</SOURCE>  \n" +
            "    <FILEPATH>merchant/shls</FILEPATH>  \n" +
            "    <LOCAL_REMOTE>0</LOCAL_REMOTE>  \n" +
            "  </TX_INFO> \n" +
            "</TX> \n";

    @Test
    void toXml() {
        final CcbWlptRequest<CcbWlpt6W0111RequestTxInfo> request = CcbWlptRequest.<CcbWlpt6W0111RequestTxInfo>builder()
                .requestSn("2007626104818")
                .customerId("P000607305898")
                .userId("WLPT02")
                .password("111111")
                .txCode("6W0111")
                .language("CN")
                .txInfo(CcbWlpt6W0111RequestTxInfo.builder()
                        .source("CBB1172476199728")
                        .filePath("merchant/shls")
                        .localRemote(0)
                        .build())
                .build();
        Assertions.assertEquals(
                JacksonXmlUtils.fromXml(xml, HashMap.class),
                JacksonXmlUtils.fromXml(JacksonXmlUtils.toXml(request), HashMap.class)
        );
    }
}