package cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.request;

import cn.shishuihao.thirdparty.api.commons.xml.JacksonXmlUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class CcbWlpt5W1005RequestTxInfoTest {
    final String xml = "<?xml version=\"1.0\" encoding=\"GB2312\" standalone=\"yes\" ?>  \n" +
            "<TX>   \n" +
            "  <REQUEST_SN>请求序列号</REQUEST_SN>  \n" +
            "  <CUST_ID>商户号</CUST_ID>  \n" +
            "  <USER_ID>操作员号</USER_ID>  \n" +
            "  <PASSWORD>操作员号密码</PASSWORD>  \n" +
            "  <TX_CODE>5W1005</TX_CODE>  \n" +
            "  <LANGUAGE>CN</LANGUAGE>  \n" +
            "  <TX_INFO>  \n" +
            "    <DATE>日期</DATE>  \n" +
            "    <KIND>1</KIND>  \n" +
            "    <FILETYPE>1</FILETYPE>  \n" +
            "    <TYPE>1</TYPE>  \n" +
            "    <NORDERBY>1</NORDERBY>  \n" +
            "    <POS_CODE>柜台号</POS_CODE>  \n" +
            "    <ORDER>订单号</ORDER>  \n" +
            "    <STATUS>1</STATUS>  \n" +
            "    <BILL_FLAG>0</BILL_FLAG>  \n" +
            "    <Mrch_No>子商户号</Mrch_No>  \n" +
            "    <GROUP_FLAG>0</GROUP_FLAG>  \n" +
            "  </TX_INFO>  \n" +
            "</TX> \n";

    @Test
    void toXml() {
        final CcbWlptRequest<CcbWlpt5W1005RequestTxInfo> request = CcbWlptRequest.<CcbWlpt5W1005RequestTxInfo>builder()
                .requestSn("请求序列号")
                .customerId("商户号")
                .userId("操作员号")
                .password("操作员号密码")
                .txCode("5W1005")
                .language("CN")
                .txInfo(CcbWlpt5W1005RequestTxInfo.builder()
                        .date("日期")
                        .kind(1)
                        .fileType(1)
                        .type(1)
                        .orderBy(1)
                        .posCode("柜台号")
                        .order("订单号")
                        .status(1)
                        .billFlag(0)
                        .merchantNo("子商户号")
                        .groupFlag(0)
                        .build())
                .build();
        Assertions.assertEquals(
                JacksonXmlUtils.fromXml(xml, HashMap.class),
                JacksonXmlUtils.fromXml(JacksonXmlUtils.toXml(request), HashMap.class)
        );
    }
}