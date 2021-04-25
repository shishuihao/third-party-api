package cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.response;

import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.domain.CcbWlptTxInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.Optional;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class CcbWlpt5W1003Response
        extends CcbWlptResponse<CcbWlpt5W1003Response.TxInfo> {
    @Getter
    @Setter
    @JacksonXmlRootElement(localName = "TX_INFO")
    public static class TxInfo implements CcbWlptTxInfo {
        /**
         * 总页次 Int T.
         */
        @JacksonXmlProperty(localName = "TPAGE")
        private Integer pageCount;
        /**
         * 当前页次 Int T.
         */
        @JacksonXmlProperty(localName = "CUR_PAGE")
        private Integer curPage;
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
        private Refund[] list;

        /**
         * refundCodes.
         *
         * @return String[]
         */
        @JsonIgnore
        public String[] refundCodes() {
            return Optional.ofNullable(list)
                    .map(it -> Arrays.stream(it)
                            .map(Refund::getRefundCode)
                            .toArray(String[]::new))
                    .orElse(null);
        }

        /**
         * orderStatuses.
         *
         * @return Integer[]
         */
        @JsonIgnore
        public Integer[] orderStatuses() {
            return Optional.ofNullable(list)
                    .map(it -> Arrays.stream(it)
                            .map(Refund::getOrderStatus)
                            .toArray(Integer[]::new))
                    .orElse(null);
        }
    }

    @Getter
    @Setter
    public static class Refund {
        /**
         * 交易日期 varChar(32) T.
         */
        @JacksonXmlProperty(localName = "TRAN_DATE")
        private String transactionDate;
        /**
         * 退款日期 varChar(32) T.
         */
        @JacksonXmlProperty(localName = "REFUND_DATE")
        private String refundDate;
        /**
         * 订单号 varChar(30) T.
         */
        @JacksonXmlProperty(localName = "ORDER_NUMBER")
        private String orderId;
        /**
         * 退款账号 varChar(30) T.
         */
        @JacksonXmlProperty(localName = "REFUND_ACCOUNT")
        private String refundAccount;
        /**
         * 支付金额 Decimal(16,2) T.
         */
        @JacksonXmlProperty(localName = "PAY_AMOUNT")
        private String paymentAmount;
        /**
         * 退款金额 Decimal(16,2) T.
         */
        @JacksonXmlProperty(localName = "REFUNDEMENT_AMOUNT")
        private String refundAmount;
        /**
         * 柜台号 varChar(9) T.
         */
        @JacksonXmlProperty(localName = "POS_CODE")
        private String posId;
        /**
         * 操作员 varChar(21) T.
         */
        @JacksonXmlProperty(localName = "USERID")
        private String userId;
        /**
         * 订单状态 Char(1) T.
         * 0:失败
         * 1:成功
         * 2:待银行确认
         * 5:待银行确认
         */
        @JacksonXmlProperty(localName = "STATUS")
        private Integer orderStatus;
        /**
         * 退款流水号 varChar(15) T.
         * 商户退款时上送的退款流水号，无上送则不展示 .
         */
        @JacksonXmlProperty(localName = "REFUND_CODE")
        private String refundCode;
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
         * 退款结算金额 Decimal(16,2) T.
         */
        @JacksonXmlProperty(localName = "Txn_ClrgAmt")
        private String transactionClearingAmount;
        /**
         * 退款手续费金额 Decimal(16,2) T.
         */
        @JacksonXmlProperty(localName = "MrchCmsn_Amt")
        private String merchantCommissionAmount;
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
         * 卡属性位图 varChar(10) F.
         */
        @JacksonXmlProperty(localName = "Crd_Attr_Bmp_Def_ID")
        private String cardAttributeBitmapDefId;
        /**
         * 发卡行机构号 varChar(9) F.
         */
        @JacksonXmlProperty(localName = "DstCrd_IssuBnk_InsNo")
        private String dstCardIssuingBankInsNo;
    }
}
