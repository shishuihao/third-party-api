package cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.request;

import cn.shishuihao.thirdparty.api.commons.xml.JacksonXmlUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class CcbWlpt5W101BRequestTxInfoTest {
    final String xml = "<?xml version=\"1.0\" encoding=\"GB2312\" standalone=\"yes\" ?>  \n" +
            "<TX>  \n" +
            "  <REQUEST_SN>请求序列号</REQUEST_SN>  \n" +
            "  <CUST_ID>商户号</CUST_ID>  \n" +
            "  <USER_ID>操作员号</USER_ID>  \n" +
            "  <PASSWORD>密码</PASSWORD>  \n" +
            "  <TX_CODE>5W101B</TX_CODE>  \n" +
            "  <LANGUAGE>CN</LANGUAGE>  \n" +
            "  <TX_INFO>  \n" +
            "    <TX_SPECIAL_EC>交易类型</TX_SPECIAL_EC>  \n" +
            "    <Clrg_StCd>流水类型</Clrg_StCd>  \n" +
            "    <StDt_Tm>开始日期时间</StDt_Tm>  \n" +
            "    <EdDt_Tm>结束日期时间</EdDt_Tm>  \n" +
            "    <Rtrvl_Ref_No>系统参考号</Rtrvl_Ref_No>  \n" +
            "    <OnLn_Py_Txn_Ordr_ID>订单编号</OnLn_Py_Txn_Ordr_ID>  \n" +
            "    <Scn_Idr>场景标识</Scn_Idr>  \n" +
            "    <Seq_Mod_CgyCd>排序方式类别代码</Seq_Mod_CgyCd>  \n" +
            "    <POS_ID>POS终端编号</POS_ID>  \n" +
            "    <Cst_AccNo>交易卡号</Cst_AccNo>  \n" +
            "    <Rng_Min_Amt>交易区间最小金额</Rng_Min_Amt>  \n" +
            "    <Rng_Max_Amt>交易区间最大金额</Rng_Max_Amt>  \n" +
            "    <Txn_Status>交易状态</Txn_Status>  \n" +
            "    <EBNK_VCHR_NO>网银凭证号</EBNK_VCHR_NO>  \n" +
            "    <OriOvrlsttnEV_Trck_No>流水跟踪号</OriOvrlsttnEV_Trck_No>  \n" +
            "    <Ori_Txn_ECD>原交易的清算交易码</Ori_Txn_ECD>  \n" +
            "    <Mrch_No>子商户号</Mrch_No>  \n" +
            "    <PAGE>1</PAGE>  \n" +
            "  </TX_INFO>  \n" +
            "</TX> \n";

    @Test
    void toXml() {
        final CcbWlptRequest<CcbWlpt5W101BRequestTxInfo> request = CcbWlptRequest.<CcbWlpt5W101BRequestTxInfo>builder()
                .requestSn("请求序列号")
                .customerId("商户号")
                .userId("操作员号")
                .password("密码")
                .txCode("5W101B")
                .language("CN")
                .txInfo(CcbWlpt5W101BRequestTxInfo.builder()
                        .transactionSpecialEc("交易类型")
                        .clearingStatusCode("流水类型")
                        .startDateTime("开始日期时间")
                        .endDateTime("结束日期时间")
                        .refNo("系统参考号")
                        .orderId("订单编号")
                        .sceneId("场景标识")
                        .seqModCategoryCode("排序方式类别代码")
                        .posId("POS终端编号")
                        .cstAccNo("交易卡号")
                        .rangeMinAmount("交易区间最小金额")
                        .rangeMaxAmount("交易区间最大金额")
                        .transactionStatus("交易状态")
                        .ebankVoucherNo("网银凭证号")
                        .trackNo("流水跟踪号")
                        .originTransactionEcd("原交易的清算交易码")
                        .merchantNo("子商户号")
                        .page(1)
                        .build())
                .build();
        Assertions.assertEquals(
                JacksonXmlUtils.fromXml(xml, HashMap.class),
                JacksonXmlUtils.fromXml(JacksonXmlUtils.toXml(request), HashMap.class)
        );
    }
}