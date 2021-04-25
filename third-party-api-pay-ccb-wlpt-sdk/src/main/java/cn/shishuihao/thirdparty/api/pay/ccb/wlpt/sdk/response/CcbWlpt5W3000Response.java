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

public class CcbWlpt5W3000Response
        extends CcbWlptResponse<CcbWlpt5W3000Response.TxInfo> {
    @Getter
    @Setter
    @JacksonXmlRootElement(localName = "TX_INFO")
    public static class TxInfo implements CcbWlptTxInfo {
        /**
         * 原文件名 varChar(128) F.
         */
        @JacksonXmlProperty(localName = "ORI_FILE")
        private String oriFile;
        /**
         * 上传后后端存储文件名称 varChar(128) F.
         */
        @JacksonXmlProperty(localName = "SEND_FILE")
        private String sendFile;
        /**
         * 上传后后端存储文件名称 varChar(128) F.
         */
        @JacksonXmlProperty(localName = "UP_FILE_PATH")
        private String upFilePath;
    }
}
