package cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.request;

import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.domain.CcbWlptTxInfo;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Builder;
import lombok.Getter;

/**
 * NO.3 文件上传.
 * 交易名称 文件上传 请求交易码 5W3000 内部交易码 5W3000
 * 后端系统 IBS 交易类型 连接类 XML示例 Sample 请看示例报文
 * 交易说明 注意：1、外联平台文件上传,注意这里上传的文件目录分割符号必须为："/"，比如：D:/TEST/UPLOAD.TXT
 * 2、上传文件大小不能大于10M
 *
 * @author shishuihao
 * @version 1.0.0
 */
@Getter
@Builder
@JacksonXmlRootElement(localName = "TX_INFO")
public class CcbWlpt5W3000RequestTxInfo implements CcbWlptTxInfo {
    /**
     * 要上传的文件名称 varChar(128) F 要上传的文件名，如：CBB1172476199728.
     */
    @JacksonXmlProperty(localName = "SEND_FILE")
    private final String sendFile;
    /**
     * 文件上传至服务器路径 varChar(100) F 固定填写：circle.
     */
    @JacksonXmlProperty(localName = "UPFILEPATH")
    private final String upFilePath;
    /**
     * 下载路径标志 varChar(1) F 固定填写1.
     */
    @JacksonXmlProperty(localName = "LOCAL_REMOTE")
    private final int localRemote;
    /**
     * 是否保持原文件名 varChar(1) T 暂定填1 .
     */
    @JacksonXmlProperty(localName = "KEEP_FILENAME")
    private final Integer keepFilename;
}
