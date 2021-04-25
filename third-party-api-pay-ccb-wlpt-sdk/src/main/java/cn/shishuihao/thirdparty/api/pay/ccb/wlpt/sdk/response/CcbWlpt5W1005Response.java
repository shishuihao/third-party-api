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

public class CcbWlpt5W1005Response
        extends CcbWlptResponse<CcbWlpt5W1005Response.TxInfo> {
    @Getter
    @Setter
    @JacksonXmlRootElement(localName = "TX_INFO")
    public static class TxInfo implements CcbWlptTxInfo {
        /**
         * 文件名 varChar(60) T 通过6W0111交易进行文件下载.
         */
        @JacksonXmlProperty(localName = "FILE_NAME")
        private String fileName;
        /**
         * 提示信息 varChar(200) T.
         */
        @JacksonXmlProperty(localName = "NOTICE")
        private String notice;
    }
}
