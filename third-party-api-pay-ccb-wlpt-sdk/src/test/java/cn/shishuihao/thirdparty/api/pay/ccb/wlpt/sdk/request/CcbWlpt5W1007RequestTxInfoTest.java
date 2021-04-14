package cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.request;

import cn.shishuihao.thirdparty.api.commons.xml.JacksonXmlUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class CcbWlpt5W1007RequestTxInfoTest {

    @Test
    void toXml() {
        final String xml = "<?xml version=\"1.0\" encoding=\"GB2312\" standalone=\"yes\" ?> \n" +
                "<TX> \n" +
                "  <REQUEST_SN>请求序列号</REQUEST_SN> \n" +
                "  <CUST_ID>商户号</CUST_ID> \n" +
                "  <USER_ID>操作员号</USER_ID> \n" +
                "  <PASSWORD>密码</PASSWORD> \n" +
                "  <TX_CODE>5W1007</TX_CODE> \n" +
                "  <LANGUAGE>CN</LANGUAGE>  \n" +
                "  <TX_INFO> \n" +
                "    <CARD_LEN>卡号长度</CARD_LEN> \n" +
                "    <ACCT_NO>卡号</ACCT_NO> \n" +
                "    <AMT1>金额</AMT1> \n" +
                "    <EXPIRE_DATE>卡有效期</EXPIRE_DATE> \n" +
                "    <AGENT_BANK>受理行代码</AGENT_BANK> \n" +
                "    <MERCHANT_NO>商户号</MERCHANT_NO> \n" +
                "    <CUNT_NO>柜台代码</CUNT_NO> \n" +
                "    <CVV2>卡验证安全码</CVV2> \n" +
                "    <TERMINAL_FLOW>终端流水号</TERMINAL_FLOW> \n" +
                "    <TRADE_TIME>交易时间</TRADE_TIME> \n" +
                "    <TERMINAL_ID>终端号</TERMINAL_ID> \n" +
                "    <SECURE_LEV>安全级别</SECURE_LEV> \n" +
                "    <ORDER_NO>订单号</ORDER_NO> \n" +
                "    <CAVV>持卡人认证信息</CAVV> \n" +
                "    <EXT1>附加域</EXT1> \n" +
                "    <ECSLI>ECSLI值</ECSLI> \n" +
                "    <CHECK_RESULT>验证场景</CHECK_RESULT> \n" +
                "  </TX_INFO> \n" +
                "    <SIGN_INFO>签名信息</SIGN_INFO> \n" +
                "    <SIGNCERT>签名CA信息</SIGNCERT> \n" +
                "</TX> \n";
        final CcbWlptRequest<CcbWlpt5W1007RequestTxInfo> request = CcbWlptRequest.<CcbWlpt5W1007RequestTxInfo>builder()
                .requestSn("请求序列号")
                .customerId("商户号")
                .userId("操作员号")
                .password("密码")
                .txCode("5W1007")
                .language("CN")
                .txInfo(CcbWlpt5W1007RequestTxInfo.builder()
                        .cardLength("卡号长度")
                        .acctNo("卡号")
                        .amt1("金额")
                        .expireDate("卡有效期")
                        .agentBank("受理行代码")
                        .merchantNo("商户号")
                        .counterNo("柜台代码")
                        .cvv2("卡验证安全码")
                        .terminalFlow("终端流水号")
                        .tradeTime("交易时间")
                        .terminalId("终端号")
                        .secureLevel("安全级别")
                        .orderNo("订单号")
                        .cavv("持卡人认证信息")
                        .ext1("附加域")
                        .ecsli("ECSLI值")
                        .checkResult("验证场景")
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