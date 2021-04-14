package cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.request;

import cn.shishuihao.thirdparty.api.commons.xml.JacksonXmlUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class CcbWlpt5W10B4RequestTxInfoTest {
    final String xml = "<?xml version=\"1.0\" encoding=\"GB2312\" standalone=\"yes\" ?> \n" +
            "<TX> \n" +
            "  <REQUEST_SN>请求序列号</REQUEST_SN> \n" +
            "  <CUST_ID>商户号</CUST_ID> \n" +
            "  <USER_ID>操作员号</USER_ID> \n" +
            "  <PASSWORD>密码</PASSWORD> \n" +
            "  <TX_CODE>5W10B4</TX_CODE> \n" +
            "  <LANGUAGE>CN</LANGUAGE> \n" +
            "  <TX_INFO> \n" +
            "    <MONEY>退款金额</MONEY> \n" +
            "    <Ordr_ID>订单号码</Ordr_ID> \n" +
            "    <REFUND_CODE>退款流水号</REFUND_CODE> \n" +
            "    <Rtrvl_Ref_No>退款系统参考号</Rtrvl_Ref_No> \n" +
            "    <OriOvrlsttnEV_Trck_No>跟踪号</OriOvrlsttnEV_Trck_No> \n" +
            "    <Clrg_Txn_CD>清算交易码</Clrg_Txn_CD> \n" +
            "    <rXtNo>系统参考号</rXtNo> \n" +
            "  </TX_INFO> \n" +
            "  <SIGN_INFO>签名信息</SIGN_INFO> \n" +
            "  <SIGNCERT>签名CA信息</SIGNCERT> \n" +
            "</TX> \n";

    @Test
    void toXml() {
        final CcbWlptRequest<CcbWlpt5W10B4RequestTxInfo> request = CcbWlptRequest.<CcbWlpt5W10B4RequestTxInfo>builder()
                .requestSn("请求序列号")
                .customerId("商户号")
                .userId("操作员号")
                .password("密码")
                .txCode("5W10B4")
                .language("CN")
                .txInfo(CcbWlpt5W10B4RequestTxInfo.builder()
                        .money("退款金额")
                        .orderId("订单号码")
                        .refundCode("退款流水号")
                        .refundRefNo("退款系统参考号")
                        .trackNo("跟踪号")
                        .clearingTransactionCode("清算交易码")
                        .rxtNo("系统参考号")
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