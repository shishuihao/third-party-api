package cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.response;

import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.TransactionInfo;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;
import lombok.Setter;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class CcbWlpt5W1002Response
        extends CcbWlptResponse<CcbWlpt5W1002Response.TxInfo> {
    @Getter
    @Setter
    @JacksonXmlRootElement(localName = "TX_INFO")
    public static class TxInfo implements TransactionInfo {
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
         * 提示 varChar(200) T 提示信息.
         */
        @JacksonXmlProperty(localName = "NOTICE")
        private String notice;
        /**
         * 多条信息.
         */
        @JacksonXmlElementWrapper(useWrapping = false)
        @JacksonXmlProperty(localName = "LIST")
        private Transaction[] list;
    }

    @Getter
    @Setter
    public static class Transaction {
        /**
         * 交易日期 varChar(32) T.
         */
        @JacksonXmlProperty(localName = "TRAN_DATE")
        private String transactionDate;
        /**
         * 记账日期 varChar(32) T.
         */
        @JacksonXmlProperty(localName = "ACC_DATE")
        private String accountingDate;
        /**
         * 订单号 varChar(30) T.
         */
        @JacksonXmlProperty(localName = "ORDER")
        private String orderId;
        /**
         * 付款方账号 varChar(30) T.
         */
        @JacksonXmlProperty(localName = "ACCOUNT")
        private String account;
        /**
         * 支付金额 Decimal(16,2) T.
         */
        @JacksonXmlProperty(localName = "PAYMENT_MONEY")
        private String paymentAmount;
        /**
         * 退款金额 Decimal(16,2) T.
         */
        @JacksonXmlProperty(localName = "REFUND_MONEY")
        private String refundAmount;
        /**
         * 柜台号 varChar(9) T.
         */
        @JacksonXmlProperty(localName = "POS_ID")
        private String posId;
        /**
         * 备注1 varChar(32) T.
         */
        @JacksonXmlProperty(localName = "REM1")
        private String remark1;
        /**
         * 备注2 varChar(32) T.
         */
        @JacksonXmlProperty(localName = "REM2")
        private String remark2;
        /**
         * 订单状态 Char(1) T.
         * 0:失败
         * 1:成功
         * 2:待银行确认
         * 3:已部分退款
         * 4:已全额退款
         * 5:待银行确认
         */
        @JacksonXmlProperty(localName = "ORDER_STATUS")
        private Integer orderStatus;
        /**
         * 支付方式 Char(3) T.
         * BHK:建行
         * THK:他行
         * ZFB:支付宝
         * CFT:微信
         */
        @JacksonXmlProperty(localName = "PAY_MODE")
        private String payMode;
        /**
         * 订单金额 Decimal(16,2) T.
         * 优惠前订单金额（订单金额-支付金额=优惠金额
         */
        @JacksonXmlProperty(localName = "Orig_Amt")
        private String originAmount;
        /**
         * 结算金额 Decimal(16,2) T.
         */
        @JacksonXmlProperty(localName = "Txn_ClrgAmt")
        private String transactionClearingAmount;
        /**
         * 手续费金额 Decimal(16,2) T.
         */
        @JacksonXmlProperty(localName = "MrchCmsn_Amt")
        private String merchantCommissionAmount;
        /**
         * 优惠金额 Decimal(16,2) T.
         */
        @JacksonXmlProperty(localName = "Discount_Amt")
        private String discountAmount;
        /**
         * 银行流水号 varChar(25) T.
         */
        @JacksonXmlProperty(localName = "OriOvrlsttnEV_Trck_No")
        private String trackNo;
        /**
         * 商户流水号 varChar(30) F.
         */
        @JacksonXmlProperty(localName = "MsgRp_Jrnl_No")
        private String msgRpJournalNo;
        /**
         * 信用卡分期期数 varChar(7) F.
         */
        @JacksonXmlProperty(localName = "CrCrd_Instm_Prd_Num")
        private String creditCardInstallmentPeriodNum;
        /**
         * 卡属性位图 varChar(10) F.
         */
        @JacksonXmlProperty(localName = "Crd_Attr_Bmp_Def_ID")
        private String cardAttributeBitmapDefId;
        /**
         * 发卡行机构号 varChar(9) F.
         */
        @JacksonXmlProperty(localName = "DstCrd_IssuBnk_InsNo")
        private String dstCardIssuingBankInsNo;
        /**
         * 交易标志位图 varChar(120) F.
         * 第1位：建行综合积分
         * 第2位：客户回馈优惠券
         * 第3位：客户回馈优惠活动
         * 第4位：ELP优惠活动
         * 第5位：预付卡
         * 第6位：商户优惠券
         * 第7位：银联系统二维码优惠
         * 第8位：微信系统优惠
         * 第9位：支付宝系统优惠
         * 第10位：激励金
         */
        @JacksonXmlProperty(localName = "OnlnPcsgInd_1_Bmp_ECD")
        private String onlinePcsgInd1BitmapEcd;
        /**
         * 交易金额  F.
         * 与OnlnPcsgInd_1_Bmp_ECD一起使用，为真实扣卡金额.
         */
        @JacksonXmlProperty(localName = "TxnAmt")
        private String transactionAmount;
        /**
         * 客户类型优惠描述 varChar(3000) F.
         * 最多三组，每组中各要素分别用“^”分隔符分开，组间用“|$|”分隔符分开，最后以“|$|”结束。
         * 每组格式：优惠项目类型^优惠出资方^优惠抵消交易金额^优惠项目编号^优惠项目简称 .
         */
        @JacksonXmlProperty(localName = "Cst_Tp_Prft_Dsc")
        private String customerTypePreferentialDescription;
    }
}
