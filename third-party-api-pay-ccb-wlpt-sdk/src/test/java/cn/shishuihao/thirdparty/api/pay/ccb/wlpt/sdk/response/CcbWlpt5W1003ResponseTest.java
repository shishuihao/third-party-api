package cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.response;

import cn.shishuihao.thirdparty.api.commons.xml.JacksonXmlUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class CcbWlpt5W1003ResponseTest {
    final String xml = "<?xml version=\"1.0\" encoding=\"GB2312\" standalone=\"yes\" ?>  \n" +
            " <TX> \n" +
            "   <REQUEST_SN>请求序列号</REQUEST_SN>  \n" +
            "   <CUST_ID>商户号</CUST_ID>  \n" +
            "   <TX_CODE>5W1003</TX_CODE>  \n" +
            "   <RETURN_CODE>响应码</RETURN_CODE>  \n" +
            "   <RETURN_MSG>响应信息</RETURN_MSG> \n" +
            "   <LANGUAGE>CN</LANGUAGE> \n" +
            "   <TX_INFO> \n" +
            "    <TPAGE>10</TPAGE>  \n" +
            "    <CUR_PAGE>1</CUR_PAGE>  \n" +
            "    <LIST> \n" +
            "     <TRAN_DATE>交易日期</TRAN_DATE>  \n" +
            "     <REFUND_DATE>退款日期</REFUND_DATE>  \n" +
            "     <ORDER_NUMBER>订单号</ORDER_NUMBER>  \n" +
            "     <REFUND_ACCOUNT>退款账号</REFUND_ACCOUNT>  \n" +
            "     <PAY_AMOUNT>支付金额</PAY_AMOUNT>  \n" +
            "     <REFUNDEMENT_AMOUNT>退款金额</REFUNDEMENT_AMOUNT>  \n" +
            "     <POS_CODE>柜台号</POS_CODE>  \n" +
            "     <USERID>操作员</USERID>  \n" +
            "     <STATUS>订单状态</STATUS>  \n" +
            "     <REFUND_CODE>退款流水号</REFUND_CODE>  \n" +
            "     <REM1>备注1</REM1>  \n" +
            "     <REM2>备注2</REM2>  \n" +
            "    <PAY_MODE>支付方式</PAY_MODE>   \n" +
            "    <Orig_Amt>订单金额</Orig_Amt>   \n" +
            "    <Txn_ClrgAmt>退款结算金额</Txn_ClrgAmt>   \n" +
            "    <MrchCmsn_Amt>退款手续费金额</MrchCmsn_Amt>   \n" +
            "    <OriOvrlsttnEV_Trck_No>银行流水号</OriOvrlsttnEV_Trck_No>   \n" +
            "    <MsgRp_Jrnl_No>商户流水号</MsgRp_Jrnl_No>   \n" +
            "    <Crd_Attr_Bmp_Def_ID>卡属性位图</Crd_Attr_Bmp_Def_ID>   \n" +
            "    <DstCrd_IssuBnk_InsNo>发卡行机构号</DstCrd_IssuBnk_InsNo>   \n" +
            "    </LIST> \n" +
            "    <NOTICE>提示信息</NOTICE> \n" +
            "   </TX_INFO> \n" +
            " </TX> \n";

    @Test
    void fromXml() {
        final CcbWlpt5W1003Response response = JacksonXmlUtils
                .fromXml(xml, CcbWlpt5W1003Response.class);
        Assertions.assertEquals(
                JacksonXmlUtils.fromXml(xml, HashMap.class),
                JacksonXmlUtils.fromXml(JacksonXmlUtils.toXml(response), HashMap.class));
    }
}