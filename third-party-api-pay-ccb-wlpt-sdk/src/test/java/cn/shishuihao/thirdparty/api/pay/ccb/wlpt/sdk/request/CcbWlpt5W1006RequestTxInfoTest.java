package cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.request;

import cn.shishuihao.thirdparty.api.commons.xml.JacksonXmlUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class CcbWlpt5W1006RequestTxInfoTest {

    @Test
    void toXml() {
        final String xml = "<?xml version=\"1.0\" encoding=\"GB2312\" standalone=\"yes\" ?>  \n" +
                "<TX>   \n" +
                "  <REQUEST_SN>请求序列号</REQUEST_SN>  \n" +
                "  <CUST_ID>商户号</CUST_ID>  \n" +
                "  <USER_ID>操作员号</USER_ID>  \n" +
                "  <PASSWORD>密码</PASSWORD>  \n" +
                "  <TX_CODE>5W1006</TX_CODE>  \n" +
                "  <LANGUAGE>CN</LANGUAGE>  \n" +
                "  <TX_INFO>  \n" +
                "    <GRANTNUM>授权号</GRANTNUM>  \n" +
                "    <BRANCHID>分行号</BRANCHID>  \n" +
                "  </TX_INFO>  \n" +
                "</TX> \n";
        final CcbWlptRequest<CcbWlpt5W1006RequestTxInfo> request = CcbWlptRequest.<CcbWlpt5W1006RequestTxInfo>builder()
                .requestSn("请求序列号")
                .customerId("商户号")
                .userId("操作员号")
                .password("密码")
                .txCode("5W1006")
                .language("CN")
                .txInfo(CcbWlpt5W1006RequestTxInfo.builder()
                        .grantNumber("授权号")
                        .branchId("分行号")
                        .build())
                .build();
        Assertions.assertEquals(
                JacksonXmlUtils.fromXml(xml, HashMap.class),
                JacksonXmlUtils.fromXml(JacksonXmlUtils.toXml(request), HashMap.class)
        );
    }
}