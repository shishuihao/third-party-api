package cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.request;

import cn.shishuihao.thirdparty.api.commons.xml.JacksonXmlUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class CcbWlpt5W1016RequestTxInfoTest {
    final String xml = "<?xml version=\"1.0\" encoding=\"GB2312\" standalone=\"yes\" ?>  \n" +
            "<TX>  \n" +
            "  <REQUEST_SN>请求序列号</REQUEST_SN>  \n" +
            "  <MERCHANTID>商户号</MERCHANTID>  \n" +
            "  <USER_ID>操作员号</USER_ID>  \n" +
            "  <PASSWORD>密码</PASSWORD>  \n" +
            "  <TX_CODE>5W1016</TX_CODE>  \n" +
            "  <LANGUAGE>CN</LANGUAGE>  \n" +
            "  <TX_INFO>  \n" +
            "    <ORDERID>订单号</ORDERID>  \n" +
            "    <STARTDATE>起始日期</STARTDATE>  \n" +
            "    <ENDDATE>结束日期</ENDDATE>  \n" +
            "    <PAGE>1</PAGE>  \n" +
            "  </TX_INFO>  \n" +
            "</TX> \n";

    @Test
    void toXml() {
        final CcbWlptRequest<CcbWlpt5W1016RequestTxInfo> request = CcbWlptRequest.<CcbWlpt5W1016RequestTxInfo>builder()
                .requestSn("请求序列号")
                .merchantId("商户号")
                .userId("操作员号")
                .password("密码")
                .txCode("5W1016")
                .language("CN")
                .txInfo(CcbWlpt5W1016RequestTxInfo.builder()
                        .orderId("订单号")
                        .startDate("起始日期")
                        .endDate("结束日期")
                        .page(1)
                        .build())
                .build();
        Assertions.assertEquals(
                JacksonXmlUtils.fromXml(xml, HashMap.class),
                JacksonXmlUtils.fromXml(JacksonXmlUtils.toXml(request), HashMap.class)
        );
    }
}