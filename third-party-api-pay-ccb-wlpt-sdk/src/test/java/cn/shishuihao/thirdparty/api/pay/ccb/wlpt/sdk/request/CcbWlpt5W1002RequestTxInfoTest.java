package cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.request;

import cn.shishuihao.thirdparty.api.commons.xml.JacksonXmlUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class CcbWlpt5W1002RequestTxInfoTest {
    final String xml = "<?xml version=\"1.0\" encoding=\"GB2312\" standalone=\"yes\" ?>  \n" +
            "<TX>  \n" +
            "  <REQUEST_SN>请求序列号</REQUEST_SN>  \n" +
            "  <CUST_ID>商户号</CUST_ID>  \n" +
            "  <USER_ID>操作员号</USER_ID>  \n" +
            "  <PASSWORD>操作员号密码</PASSWORD>  \n" +
            "  <TX_CODE>5W1002</TX_CODE>  \n" +
            "  <LANGUAGE>CN</LANGUAGE>  \n" +
            "  <TX_INFO>  \n" +
            "    <START>起始日期</START>  \n" +
            "    <STARTHOUR>开始小时</STARTHOUR>  \n" +
            "    <STARTMIN>开始分钟</STARTMIN>  \n" +
            "    <END>截止日期</END>  \n" +
            "    <ENDHOUR>结束小时</ENDHOUR>  \n" +
            "    <ENDMIN>结束分钟</ENDMIN>  \n" +
            "    <KIND>1</KIND>  \n" +
            "    <ORDER>订单号</ORDER>  \n" +
            "    <ACCOUNT>结算账户号</ACCOUNT>  \n" +
            "    <DEXCEL>1</DEXCEL>  \n" +
            "    <MONEY>金额</MONEY>  \n" +
            "    <NORDERBY>1</NORDERBY>  \n" +
            "    <PAGE>1</PAGE>  \n" +
            "    <POS_CODE>柜台号</POS_CODE>  \n" +
            "    <STATUS>1</STATUS>  \n" +
            "    <Mrch_No>子商户号</Mrch_No>  \n" +
            "  </TX_INFO>  \n" +
            "</TX> \n";

    @Test
    void toXml() {
        final CcbWlptRequest<CcbWlpt5W1002RequestTxInfo> request = CcbWlptRequest.<CcbWlpt5W1002RequestTxInfo>builder()
                .requestSn("请求序列号")
                .customerId("商户号")
                .userId("操作员号")
                .password("操作员号密码")
                .txCode("5W1002")
                .language("CN")
                .txInfo(CcbWlpt5W1002RequestTxInfo.builder()
                        .start("起始日期")
                        .startHour("开始小时")
                        .startMinute("开始分钟")
                        .end("截止日期")
                        .endHour("结束小时")
                        .endMinute("结束分钟")
                        .kind(1)
                        .order("订单号")
                        .account("结算账户号")
                        .fileType(1)
                        .money("金额")
                        .orderBy(1)
                        .page(1)
                        .posCode("柜台号")
                        .status(1)
                        .merchantNo("子商户号")
                        .build())
                .build();
        Assertions.assertEquals(
                JacksonXmlUtils.fromXml(xml, HashMap.class),
                JacksonXmlUtils.fromXml(JacksonXmlUtils.toXml(request), HashMap.class)
        );
    }
}