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

public class CcbWlpt5W1001Response
        extends CcbWlptResponse<CcbWlpt5W1001Response.TxInfo> {
    @Getter
    @Setter
    @JacksonXmlRootElement(localName = "TX_INFO")
    public static class TxInfo implements TransactionInfo {
        /**
         * 备注1 varChar(32) T.
         */
        @JacksonXmlProperty(localName = "REM1")
        private String rem1;
        /**
         * 备注2 varChar(32) T.
         */
        @JacksonXmlProperty(localName = "REM2")
        private String rem2;
    }
}
