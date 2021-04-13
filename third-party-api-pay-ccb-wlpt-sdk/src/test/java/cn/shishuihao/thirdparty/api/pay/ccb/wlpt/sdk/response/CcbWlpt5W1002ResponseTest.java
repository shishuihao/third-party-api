package cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.response;

import cn.shishuihao.thirdparty.api.commons.xml.JacksonXmlUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class CcbWlpt5W1002ResponseTest {

    @Test
    void fromXml() {
        final String xml = "<?xml version=\"1.0\" encoding=\"GB2312\" standalone=\"yes\" ?>   \n" +
                "  <TX>  \n" +
                "   <REQUEST_SN>请求序列号</REQUEST_SN>   \n" +
                "   <CUST_ID>商户号</CUST_ID>   \n" +
                "   <TX_CODE>5W1002</TX_CODE>   \n" +
                "   <RETURN_CODE>响应码</RETURN_CODE>   \n" +
                "   <RETURN_MSG>响应信息</RETURN_MSG>  \n" +
                "   <LANGUAGE>CN</LANGUAGE>  \n" +
                "  <TX_INFO>  \n" +
                "   <CUR_PAGE>1</CUR_PAGE>   \n" +
                "   <PAGE_COUNT>10</PAGE_COUNT>   \n" +
                "   <LIST>  \n" +
                "    <TRAN_DATE>交易日期</TRAN_DATE>   \n" +
                "    <ACC_DATE>记账日期</ACC_DATE>   \n" +
                "    <ORDER>订单号</ORDER>   \n" +
                "    <ACCOUNT>付款方账号</ACCOUNT>   \n" +
                "    <PAYMENT_MONEY>支付金额</PAYMENT_MONEY>   \n" +
                "    <REFUND_MONEY>退款金额</REFUND_MONEY>   \n" +
                "    <POS_ID>柜台号</POS_ID>   \n" +
                "    <REM1>备注1</REM1>>   \n" +
                "    <REM2>备注2</REM2>   \n" +
                "    <ORDER_STATUS>订单状态</ORDER_STATUS>   \n" +
                "    <PAY_MODE>支付方式</PAY_MODE>   \n" +
                "    <Orig_Amt>订单金额</Orig_Amt>   \n" +
                "    <Txn_ClrgAmt>结算金额</Txn_ClrgAmt>   \n" +
                "    <MrchCmsn_Amt>手续费金额</MrchCmsn_Amt>   \n" +
                "    <OriOvrlsttnEV_Trck_No>银行流水号</OriOvrlsttnEV_Trck_No>   \n" +
                "    <MsgRp_Jrnl_No>商户流水号</MsgRp_Jrnl_No>   \n" +
                "    <OnlnPcsgInd_1_Bmp_ECD>交易标志位图编码</OnlnPcsgInd_1_Bmp_ECD>   \n" +
                "    <TxnAmt>交易金额</TxnAmt>   \n" +
                "    <Cst_Tp_Prft_Dsc>客户类型优惠描述</Cst_Tp_Prft_Dsc>   \n" +
                "    <CrCrd_Instm_Prd_Num>信用卡分期期数</CrCrd_Instm_Prd_Num>   \n" +
                "    <Crd_Attr_Bmp_Def_ID>卡属性位图</Crd_Attr_Bmp_Def_ID>   \n" +
                "    <DstCrd_IssuBnk_InsNo>发卡行机构号</DstCrd_IssuBnk_InsNo>   \n" +
                "    <Discount_Amt>优惠金额</Discount_Amt>   \n" +
                "   </LIST>  \n" +
                "   <NOTICE>提示信息</NOTICE>  \n" +
                "  </TX_INFO>  \n" +
                "  </TX> \n";
        final CcbWlpt5W1002Response response = JacksonXmlUtils
                .fromXml(xml, CcbWlpt5W1002Response.class);
        Assertions.assertEquals(
                JacksonXmlUtils.fromXml(xml, HashMap.class),
                JacksonXmlUtils.fromXml(JacksonXmlUtils.toXml(response), HashMap.class));
    }
}