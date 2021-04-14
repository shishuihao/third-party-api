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

public class CcbWlpt5W1007Response
        extends CcbWlptResponse<CcbWlpt5W1007Response.TxInfo> {
    @Getter
    @Setter
    @JacksonXmlRootElement(localName = "TX_INFO")
    public static class TxInfo implements TransactionInfo {
        /**
         * 授权码 varChar(6) F.
         */
        @JacksonXmlProperty(localName = "AUTH_ID")
        private String authId;
        /**
         * 附加响应码 varChar(1) T.
         * 0发卡行代授权
         * 1国际组织代授权
         * 2系统内部拒绝
         */
        @JacksonXmlProperty(localName = "REASONCODE")
        private String reasonCode;
    }
}
