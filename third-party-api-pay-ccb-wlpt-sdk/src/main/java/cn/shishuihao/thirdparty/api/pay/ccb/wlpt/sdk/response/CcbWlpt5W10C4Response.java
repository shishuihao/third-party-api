package cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.response;

import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.TransactionInfo;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;
import lombok.Setter;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class CcbWlpt5W10C4Response
        extends CcbWlptResponse<CcbWlpt5W10C4Response.TxInfo> {
    @Getter
    @Setter
    @JacksonXmlRootElement(localName = "TX_INFO")
    public static class TxInfo implements TransactionInfo {
        /**
         * 订单号 varChar(30) F 交易响应码.
         */
        @JacksonXmlProperty(localName = "Ordr_ID")
        private String orderId;
        /**
         * 支付金额 varChar(100) F 交易响应码.
         */
        @JacksonXmlProperty(localName = "PAY_AMOUNT")
        private String payAmount;
        /**
         * 退款金额 varChar(101) F 交易响应码.
         */
        @JacksonXmlProperty(localName = "AMOUNT")
        private String amount;
        /**
         * 系统参考号 varChar(15) F 交易响应码.
         */
        @JacksonXmlProperty(localName = "rXtNo")
        private String rxtNo;
        /**
         * 备注1.
         */
        @JacksonXmlProperty(localName = "REM1")
        private String remark1;
        /**
         * 备注2.
         */
        @JacksonXmlProperty(localName = "REM2")
        private String remark2;
    }
}