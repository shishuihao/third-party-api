package cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.response;

import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.domain.CcbWlptTxInfo;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;
import lombok.Setter;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class CcbWlpt5W101BResponse
        extends CcbWlptResponse<CcbWlpt5W101BResponse.TxInfo> {
    @Getter
    @Setter
    @JacksonXmlRootElement(localName = "TX_INFO")
    public static class TxInfo implements CcbWlptTxInfo {
        /**
         * 当前页次 Int T.
         */
        @JacksonXmlProperty(localName = "CUR_PAGE")
        private Integer curPage;
        /**
         * 总页次 Int T.
         */
        @JacksonXmlProperty(localName = "PAGE_COUNT")
        private Integer pageCount;
        /**
         * 商户号 varChar(15) T.
         */
        @JacksonXmlProperty(localName = "Ed_Crd_Prty_Idr_CD")
        private String edCrdPartyIdrCd;
        /**
         * 支付金额 Decimal(16,2) T.
         */
        @JacksonXmlProperty(localName = "Py_Amt")
        private String paymentAmount;
        /**
         * 商户退款金额 Decimal(16,2) T.
         */
        @JacksonXmlProperty(localName = "Mrch_Rfnd_Amt")
        private String merchantRefundAmount;
        /**
         * 提示 varChar(200) T 提示信息.
         */
        @JacksonXmlProperty(localName = "NOTICE")
        private String notice;
        /**
         * 多条信息.
         */
        @JacksonXmlElementWrapper(useWrapping = false)
        @JacksonXmlProperty(localName = "LIST")
        private Flow[] list;
    }

    @Getter
    @Setter
    public static class Flow {
        /**
         * 订单编号 varChar(120) T.
         **/
        @JacksonXmlProperty(localName = "OnLn_Py_Txn_Ordr_ID")
        private String orderId;
        /**
         * 交易日期 varChar(14) T.
         * 格式[yyyymmddhhffss]
         **/
        @JacksonXmlProperty(localName = "Clrg_Stm_Dt_Tm")
        private String clearingStmDateTime;
        /**
         * 记账日期 varChar(8) T.
         * 格式[yyyymmdd]
         **/
        @JacksonXmlProperty(localName = "Acq_Fnds_Clrg_Dt")
        private String acqFndsClearingDate;
        /**
         * 订单时间 varChar(42) T.
         * 格式[yyyymmddhhffss]
         **/
        @JacksonXmlProperty(localName = "Ordr_Tm")
        private String orderTime;
        /**
         * 交易金额 Decimal(16,2) T.
         **/
        @JacksonXmlProperty(localName = "Ahn_TxnAmt")
        private String ahnTransactionAmount;
        /**
         * 退款总额 Decimal(16,2) T.
         **/
        @JacksonXmlProperty(localName = "Ordr_PyRfd_Amt")
        private String orderPayRefundAmount;
        /**
         * 手续费金额 Decimal(16,2) T.
         **/
        @JacksonXmlProperty(localName = "MrchCmsn_Amt")
        private String merchantCommissionAmount;
        /**
         * 原支付金额 Decimal(16,2) T.
         **/
        @JacksonXmlProperty(localName = "RetGds_Orig_TxnAmt")
        private String retGdsOriginTransactionAmount;
        /**
         * 支付卡号 varChar(32) T.
         **/
        @JacksonXmlProperty(localName = "Cst_AccNo")
        private String cstAccNo;
        /**
         * 币种 varChar(3) T. 00-交易成功标志 01-交易失败 02-不确定 04-不确定 TO-交易超时
         **/
        @JacksonXmlProperty(localName = "CcyCd")
        private String currencyCode;
        /**
         * 交易状态 varChar(2) T.
         **/
        @JacksonXmlProperty(localName = "Txn_Status")
        private String transactionStatus;
        /**
         * 退款时商户流水号 varChar(240) T.
         **/
        @JacksonXmlProperty(localName = "MsgRp_Jrnl_No")
        private String msgRpJournalNo;
        /**
         * 场景标识 varChar(3) T.
         * L01 - 龙支付
         * Y01 - 被扫
         * Y02 - 主扫
         * ZFB - 聚合支付支付宝
         * CFT - 聚合支付微信
         * Q01 - 客户回馈的券处理商户账
         **/
        @JacksonXmlProperty(localName = "Scn_Idr")
        private String sceneId;
        /**
         * 清算交易码 varChar(9) T.
         **/
        @JacksonXmlProperty(localName = "Clrg_Txn_CD")
        private String clearingTransactionCode;
        /**
         * 商户柜台代码 varChar(240) T.
         **/
        @JacksonXmlProperty(localName = "Cntrprt_ID")
        private String cntrprtId;
        /**
         * 支付备注1 varChar(600) T.
         **/
        @JacksonXmlProperty(localName = "BsnItm_Dsc")
        private String bsnItemDescription;
        /**
         * 支付备注2 varChar(600) T.
         **/
        @JacksonXmlProperty(localName = "Txn_Itm_Dsc")
        private String transactionItemDescription;
        /**
         * 关注事项描述 varChar(600) T. 数据格式：操作员号|本异地标志|项目编号|基本户|客户IP|实名制ID|
         **/
        @JacksonXmlProperty(localName = "Fcs_Itm_Dsc")
        private String focusItemDescription;
        /**
         * 卡属性位图定义编号 varChar(10) T.
         * 00060 - 本行对私借记
         * 00061 - 本行对公借记
         * 1006- - 本行贷记卡
         * 20060 - 本行准贷记卡
         * 0106- - 境内他行借记卡
         * 1106- - 境内他行贷记卡
         * 2106- - 境内他行准贷记卡
         * -110- - 国际VISA
         * -111- - 国际JCB
         * -112- - 国际MASTER
         * -113- - 国际大莱
         * -114- - 国际运通
         * 30060 - 建行钱包
         **/
        @JacksonXmlProperty(localName = "Crd_Attr_Bmp_Def_ID")
        private String cardAttributeBitmapDefId;
        /**
         * 流水跟踪号 varChar(25) T.
         **/
        @JacksonXmlProperty(localName = "OriOvrlsttnEV_Trck_No")
        private String trackNo;
        /**
         * 冲正标志 varChar(1) T.
         * 1-已冲正
         **/
        @JacksonXmlProperty(localName = "Rvrs_Ind")
        private String reversalInd;
        /**
         * 撤销标志 varChar(1) T. 撤销标志，1-已撤销
         **/
        @JacksonXmlProperty(localName = "Udo_Ind")
        private String udoInd;
        /**
         * POS终端编号 varChar(19) T.
         **/
        @JacksonXmlProperty(localName = "POS_ID")
        private String posId;
        /**
         * 信用卡分期期数 varChar(7) T.
         **/
        @JacksonXmlProperty(localName = "CrCrd_Instm_Prd_Num")
        private String creditCardInstallmentPeriodNum;
        /**
         * 系统参考号 varChar(12) T.
         **/
        @JacksonXmlProperty(localName = "Rtrvl_Ref_No")
        private String refNo;
        /**
         * 卡授权码 varChar(6) T.
         **/
        @JacksonXmlProperty(localName = "Crd_Ahn_CD")
        private String cardAhnCode;
        /**
         * #ATM交易序号 varChar(9) T.
         **/
        @JacksonXmlProperty(localName = "ATM_Txn_SN")
        private String atmTransactionSn;
        /**
         * 内卡发卡行机构号 varChar(9) T.
         **/
        @JacksonXmlProperty(localName = "DstCrd_IssuBnk_InsNo")
        private String dstCardIssuingBankInsNo;
        /**
         * 交易凭证号 varChar(6) T.
         **/
        @JacksonXmlProperty(localName = "Acq_Txn_Vchr_No")
        private String acqTransactionVoucherNo;
        /**
         * 分期手续费 varChar(13) T.
         **/
        @JacksonXmlProperty(localName = "BigAmt_Instm_HdCg")
        private String bigAmountInstallmentHandlingCharge;
        /**
         * 折扣前原交易金额 varChar(16) T.
         **/
        @JacksonXmlProperty(localName = "Orig_Amt")
        private String originAmount;
        /**
         * 促销活动编号 varChar(50) T.
         **/
        @JacksonXmlProperty(localName = "Pcs_Avy_ID")
        private String pcsActivityId;
        /**
         * 批次号 varChar(6) T.
         **/
        @JacksonXmlProperty(localName = "Tmnl_BtNo")
        private String tmnlBatchNo;
        /**
         * 流水类型 varChar(1) T. 0-支付交易 1-退款交易 9其它
         **/
        @JacksonXmlProperty(localName = "TX_SPECIAL_EC")
        private String transactionSpecialEc;
        /**
         * 结算金额 varChar(16) T.
         **/
        @JacksonXmlProperty(localName = "Txn_ClrgAmt")
        private String transactionClearingAmount;
        /**
         * 卡片受理方式 varChar(2) T.
         **/
        @JacksonXmlProperty(localName = "CardNo_Inpt_MtdCd")
        private String cardNoInptMethodCode;
        /**
         * 二级商户编号 varChar(15) T.
         **/
        @JacksonXmlProperty(localName = "Sub_Mrch_No")
        private String subMerchantNo;
        /**
         * 二级商户名称 varChar(600) T.
         **/
        @JacksonXmlProperty(localName = "Sub_Mrch_Nm")
        private String subMerchantNm;
        /**
         * 交易类型 varChar(120) T.
         * P1交易类型
         * 01：客户支付及退款(包含除跨行和企业之外的全部退款)
         * 02：账号支付
         * 03：悦生活客户支付
         * 04：悦生活账号支付
         * 05：贷款账户支付
         * 06：快捷付
         * 07：个人跨行支付及退款
         * 08：IC卡支付
         * 09：外卡支付
         * 10：分期支付
         * 11：分期支付不验密
         * 12:龙支付
         * 50：企业支付及退款
         * 51：招投标个人支付及退款
         * 52：招投标企业支付及退款
         * 53：企业跨行支付及退款
         * 54:企业跨行招投标支付及退款
         * 55：个人跨行招投标支付及退款注：
         * 交易类型为支付时，07或者53类型为跨行支付。
         * 50和53类型，客户类型为企业，其它为个人。
         **/
        @JacksonXmlProperty(localName = "Txn_Tp_Nm")
        private String transactionTypeNm;
        /**
         * 付款方户名 varChar(180) T.
         **/
        @JacksonXmlProperty(localName = "Cntrprt_Acc_Nm")
        private String cntrprtAccNm;
        /**
         * 网银凭证号 varChar(12) T.
         **/
        @JacksonXmlProperty(localName = "EBNK_VCHR_NO")
        private String ebankVoucherNo;
        /**
         * 交易备注 varChar(240) T.
         **/
        @JacksonXmlProperty(localName = "Txn_Rmrk")
        private String transactionRemark;
    }
}
