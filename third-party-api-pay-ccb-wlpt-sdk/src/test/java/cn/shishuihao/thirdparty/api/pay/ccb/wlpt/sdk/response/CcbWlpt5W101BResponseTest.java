package cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.response;

import cn.shishuihao.thirdparty.api.commons.xml.JacksonXmlUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class CcbWlpt5W101BResponseTest {
    final String xml = "<?xml version=\"1.0\" encoding=\"GB2312\" standalone=\"yes\" ?>   \n" +
            "  <TX>  \n" +
            "   <REQUEST_SN>请求序列码</REQUEST_SN>   \n" +
            "   <CUST_ID>商户号</CUST_ID>   \n" +
            "   <TX_CODE>5W101B</TX_CODE>   \n" +
            "   <RETURN_CODE>响应码</RETURN_CODE>   \n" +
            "   <RETURN_MSG>响应信息</RETURN_MSG>  \n" +
            "   <LANGUAGE>CN</LANGUAGE>  \n" +
            "  <TX_INFO>  \n" +
            "   <CUR_PAGE>1</CUR_PAGE>   \n" +
            "   <PAGE_COUNT>10</PAGE_COUNT>   \n" +
            "   <Ed_Crd_Prty_Idr_CD>商户号</Ed_Crd_Prty_Idr_CD>   \n" +
            "   <Py_Amt>支付金额</Py_Amt>   \n" +
            "   <Mrch_Rfnd_Amt>商户退款金额</Mrch_Rfnd_Amt>   \n" +
            "   <LIST>  \n" +
            "    <OnLn_Py_Txn_Ordr_ID>订单编号</OnLn_Py_Txn_Ordr_ID>  \n" +
            "    <Clrg_Stm_Dt_Tm>交易日期</Clrg_Stm_Dt_Tm>  \n" +
            "    <Acq_Fnds_Clrg_Dt>记账日期</Acq_Fnds_Clrg_Dt>  \n" +
            "    <Ordr_Tm>订单时间</Ordr_Tm>  \n" +
            "    <Ahn_TxnAmt>交易金额</Ahn_TxnAmt>  \n" +
            "    <Ordr_PyRfd_Amt>退款总额</Ordr_PyRfd_Amt>  \n" +
            "    <MrchCmsn_Amt>手续费金额</MrchCmsn_Amt>  \n" +
            "    <RetGds_Orig_TxnAmt>原支付金额</RetGds_Orig_TxnAmt>  \n" +
            "    <Cst_AccNo>支付卡号</Cst_AccNo>  \n" +
            "    <CcyCd>币种</CcyCd>  \n" +
            "    <Txn_Status>交易状态</Txn_Status>  \n" +
            "    <MsgRp_Jrnl_No>退款时商户流水号</MsgRp_Jrnl_No>  \n" +
            "    <Scn_Idr>场景标识</Scn_Idr>  \n" +
            "    <Clrg_Txn_CD>清算交易码</Clrg_Txn_CD>  \n" +
            "    <Cntrprt_ID>商户柜台代码</Cntrprt_ID>  \n" +
            "    <BsnItm_Dsc>支付备注1</BsnItm_Dsc>  \n" +
            "    <Txn_Itm_Dsc>支付备注2</Txn_Itm_Dsc>  \n" +
            "    <Fcs_Itm_Dsc>关注事项描述</Fcs_Itm_Dsc>  \n" +
            "    <Crd_Attr_Bmp_Def_ID>卡属性位图定义编号</Crd_Attr_Bmp_Def_ID>  \n" +
            "    <OriOvrlsttnEV_Trck_No>流水跟踪号</OriOvrlsttnEV_Trck_No>  \n" +
            "    <Rvrs_Ind>冲正标志</Rvrs_Ind>  \n" +
            "    <Udo_Ind>撤销标志</Udo_Ind>  \n" +
            "    <POS_ID>POS终端编号</POS_ID>  \n" +
            "    <CrCrd_Instm_Prd_Num>信用卡分期期数</CrCrd_Instm_Prd_Num>  \n" +
            "    <Rtrvl_Ref_No>POSPH系统参考号</Rtrvl_Ref_No>  \n" +
            "    <Crd_Ahn_CD>卡授权码</Crd_Ahn_CD>  \n" +
            "    <ATM_Txn_SN>#ATM交易序号</ATM_Txn_SN>  \n" +
            "    <DstCrd_IssuBnk_InsNo>内卡发卡行机构号</DstCrd_IssuBnk_InsNo>  \n" +
            "    <Acq_Txn_Vchr_No>交易凭证号</Acq_Txn_Vchr_No>  \n" +
            "    <BigAmt_Instm_HdCg>分期手续费</BigAmt_Instm_HdCg>  \n" +
            "    <Orig_Amt>折扣前原交易金额</Orig_Amt>  \n" +
            "    <Pcs_Avy_ID>促销活动编号</Pcs_Avy_ID>  \n" +
            "    <Tmnl_BtNo>批次号</Tmnl_BtNo>  \n" +
            "    <TX_SPECIAL_EC>流水类型</TX_SPECIAL_EC>  \n" +
            "    <Txn_ClrgAmt>结算金额</Txn_ClrgAmt>  \n" +
            "    <CardNo_Inpt_MtdCd>卡片受理方式</CardNo_Inpt_MtdCd>  \n" +
            "    <Sub_Mrch_No>二级商户编号</Sub_Mrch_No>  \n" +
            "    <Sub_Mrch_Nm>二级商户名称</Sub_Mrch_Nm>  \n" +
            "    <Txn_Tp_Nm>交易类型</Txn_Tp_Nm>  \n" +
            "    <Cntrprt_Acc_Nm>付款方户名</Cntrprt_Acc_Nm>  \n" +
            "    <EBNK_VCHR_NO>网银凭证号</EBNK_VCHR_NO>  \n" +
            "    <Txn_Rmrk>交易备注</Txn_Rmrk>  \n" +
            "   </LIST>  \n" +
            "   <NOTICE>提示信息</NOTICE>  \n" +
            "  </TX_INFO>  \n" +
            "  </TX> \n";

    @Test
    void fromXml() {
        final CcbWlpt5W101BResponse response = JacksonXmlUtils
                .fromXml(xml, CcbWlpt5W101BResponse.class);
        Assertions.assertEquals(
                JacksonXmlUtils.fromXml(xml, HashMap.class),
                JacksonXmlUtils.fromXml(JacksonXmlUtils.toXml(response), HashMap.class));
    }
}