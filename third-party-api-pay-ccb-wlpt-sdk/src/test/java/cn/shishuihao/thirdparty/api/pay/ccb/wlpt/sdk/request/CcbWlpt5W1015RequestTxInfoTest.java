package cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.request;

import cn.shishuihao.thirdparty.api.commons.xml.JacksonXmlUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class CcbWlpt5W1015RequestTxInfoTest {
    final String xml = "<?xml version=\"1.0\" encoding=\"GB2312\" standalone=\"yes\" ?>  \n" +
            "<TX>  \n" +
            "  <REQUEST_SN>请求序列号</REQUEST_SN>  \n" +
            "  <MERCHANTID>商户号</MERCHANTID>  \n" +
            "  <USER_ID>操作员号</USER_ID>  \n" +
            "  <PASSWORD>密码</PASSWORD>  \n" +
            "  <TX_CODE>5W1015</TX_CODE>  \n" +
            "  <LANGUAGE>CN</LANGUAGE>  \n" +
            "  <TX_INFO>  \n" +
            "    <ORDERID>订单号</ORDERID>  \n" +
            "    <PAYMENT>交易金额</PAYMENT>  \n" +
            "    <CURCODE>交易货币代码</CURCODE>  \n" +
            "    <BRANCHID>商户一级分行号</BRANCHID>  \n" +
            "    <POSID>网银柜台编号</POSID>  \n" +
            "    <BACKFLAG>1</BACKFLAG>  \n" +
            "  </TX_INFO>  \n" +
            "    <SIGN_INFO>签名信息</SIGN_INFO>  \n" +
            "    <SIGNCERT>签名CA信息</SIGNCERT>  \n" +
            "</TX> \n";

    @Test
    void toXml() {
        final CcbWlptRequest<CcbWlpt5W1015RequestTxInfo> request = CcbWlptRequest.<CcbWlpt5W1015RequestTxInfo>builder()
                .requestSn("请求序列号")
                .merchantId("商户号")
                .userId("操作员号")
                .password("密码")
                .txCode("5W1015")
                .language("CN")
                .txInfo(CcbWlpt5W1015RequestTxInfo.builder()
                        .orderId("订单号")
                        .payment("交易金额")
                        .currencyCode("交易货币代码")
                        .branchId("商户一级分行号")
                        .posId("网银柜台编号")
                        .backFlag(1)
                        .build())
                .signInfo("签名信息")
                .signCert("签名CA信息")
                .build();
        Assertions.assertEquals(
                JacksonXmlUtils.fromXml(xml, HashMap.class),
                JacksonXmlUtils.fromXml(JacksonXmlUtils.toXml(request), HashMap.class)
        );
    }
}