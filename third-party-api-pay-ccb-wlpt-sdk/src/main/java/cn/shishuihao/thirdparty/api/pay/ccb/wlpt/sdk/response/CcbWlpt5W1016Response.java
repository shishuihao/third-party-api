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

public class CcbWlpt5W1016Response
        extends CcbWlptResponse<CcbWlpt5W1016Response.TxInfo> {
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
         * 多条信息.
         */
        @JacksonXmlElementWrapper(useWrapping = false)
        @JacksonXmlProperty(localName = "LIST")
        private Refund[] list;
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
         * 退款金额 Decimal T.
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
         */
        @JacksonXmlProperty(localName = "STATUS")
        private Integer orderStatus;
        /**
         * 订单退款失败错误码 varChar(256) T.
         */
        @JacksonXmlProperty(localName = "ERRCODE")
        private String errCode;
        /**
         * 失败原因 varChar(256) T.
         */
        @JacksonXmlProperty(localName = "ERRMSG")
        private String errMsg;
    }
}
