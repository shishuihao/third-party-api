package cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.response;

import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.domain.CcbWlptTxInfo;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * @author shishuihao
 * @version 1.0.0
 */
public class CcbWlpt6W0111Response
        extends CcbWlptResponse<CcbWlpt6W0111Response.TxInfo> {
    @JacksonXmlRootElement(localName = "TX_INFO")
    public static class TxInfo implements CcbWlptTxInfo {
    }
}
