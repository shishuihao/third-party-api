package cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.response;

import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.domain.CcbWlptTxInfo;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;
import lombok.Setter;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class CcbWlpt5W1006Response
        extends CcbWlptResponse<CcbWlpt5W1006Response.TxInfo> {
    @Getter
    @Setter
    @JacksonXmlRootElement(localName = "TX_INFO")
    public static class TxInfo implements CcbWlptTxInfo {
        /**
         * 商户代码 varChar(21) T.
         */
        @JacksonXmlProperty(localName = "MER_CODE")
        private String merchantCode;
        /**
         * 授权日期 varChar(10) T.
         */
        @JacksonXmlProperty(localName = "AUTH_DATE")
        private String authDate;
        /**
         * 授权号 varChar(20) T.
         */
        @JacksonXmlProperty(localName = "GRANT_NUM")
        private String grantNum;
        /**
         * 客户姓名 varChar(40) T.
         */
        @JacksonXmlProperty(localName = "CUSTOMER_NAME")
        private String customerName;
        /**
         * 单笔交易限额 Decimal(16,2) T.
         */
        @JacksonXmlProperty(localName = "SINGLE_TRAN_LIMIT")
        private String singleTransactionLimit;
        /**
         * 日累计交易限额 Decimal(16,2) T.
         */
        @JacksonXmlProperty(localName = "DAY_TRAN_LIMIT")
        private String dayTransactionLimit;
        /**
         * 预留字段 　 T.
         * 预留字段，暂返回为空
         */
        @JacksonXmlProperty(localName = "GRANT_FLAG")
        private String grantFlag;
    }
}
