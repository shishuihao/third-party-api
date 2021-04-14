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

public class CcbWlpt520200Response
        extends CcbWlptResponse<CcbWlpt520200Response.TxInfo> {
    @Getter
    @Setter
    @JacksonXmlRootElement(localName = "TX_INFO")
    public static class TxInfo implements TransactionInfo {
        /**
         * 商户代码 varChar(15) F.
         */
        @JacksonXmlProperty(localName = "MERCHANTID")
        private String merchantId;
        /**
         * 操作员号 varChar(26) F.
         */
        @JacksonXmlProperty(localName = "USER_ID")
        private String userId;
        /**
         * 交易金额 Decimal(16,2) F.
         */
        @JacksonXmlProperty(localName = "PAYMENT")
        private String payment;
        /**
         * 网银柜台编号 varChar(9) F 　.
         */
        @JacksonXmlProperty(localName = "POSID")
        private String posId;
    }
}
