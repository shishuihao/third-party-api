package cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.request;

import cn.shishuihao.thirdparty.api.commons.xml.JacksonXmlUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class CcbWlpt520200RequestTxInfoTest {
    final String xml = "<?xml version=\"1.0\" encoding=\"GB2312\" standalone=\"yes\" ?> \n" +
            "<TX> \n" +
            "  <REQUEST_SN>请求序列号</REQUEST_SN> \n" +
            "  <MERCHANTID>288042975</MERCHANTID> \n" +
            "  <USER_ID>操作员号</USER_ID> \n" +
            "  <PASSWORD>密码</PASSWORD> \n" +
            "  <TX_CODE>520200</TX_CODE> \n" +
            "  <TX_INFO> \n" +
            "    <AUTHID>授权号</AUTHID> \n" +
            "    <ORDERID>订单号</ORDERID> \n" +
            "    <BRANCHID>一级行号</BRANCHID> \n" +
            "    <CURCODE>交易货币代码</CURCODE> \n" +
            "    <PAYMENT>交易金额</PAYMENT> \n" +
            "    <POSID>网银柜台编号</POSID> \n" +
            "    <REM1>备注1</REM1> \n" +
            "    <REM2>备注2</REM2> \n" +
            "    <PUB32>公钥前30位</PUB32> \n" +
            "    <MAC></MAC> \n" +
            "  </TX_INFO> \n" +
            "  <SIGN_INFO>签名信息</SIGN_INFO> \n" +
            "  <SIGNCERT>签名CA信息</SIGNCERT> \n" +
            "</TX> \n";

    @Test
    void toXml() {
        final CcbWlptRequest<CcbWlpt520200RequestTxInfo> request = CcbWlptRequest.<CcbWlpt520200RequestTxInfo>builder()
                .requestSn("请求序列号")
                .merchantId("288042975")
                .userId("操作员号")
                .password("密码")
                .txCode("520200")
                .txInfo(CcbWlpt520200RequestTxInfo.builder()
                        .authId("授权号")
                        .orderId("订单号")
                        .branchId("一级行号")
                        .currencyCode("交易货币代码")
                        .payment("交易金额")
                        .posId("网银柜台编号")
                        .remark1("备注1")
                        .remark2("备注2")
                        .pub32("公钥前30位")
                        .mac("")
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