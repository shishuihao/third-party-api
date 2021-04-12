package cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.request;

import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.TransactionInfo;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Builder;
import lombok.Getter;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Getter
@Builder
@JacksonXmlRootElement(localName = "TX_INFO")
public class CcbWlpt6W0111RequestTxInfo implements TransactionInfo {
    /**
     * SOURCE 要下载的文件名称 varChar(128) F 要下载的文件名，如：CBB1172476199728 .
     */
    @JacksonXmlProperty(localName = "SOURCE")
    private final String source;
    /**
     * FILEPATH 文件路径 varChar(30) F 要下载文件的路径:merchant/shls,必须填该值 .
     */
    @JacksonXmlProperty(localName = "FILEPATH")
    private final String filePath;
    /**
     * LOCAL_REMOTE 下载路径标志 varChar(1) F 一般0 .
     */
    @JacksonXmlProperty(localName = "LOCAL_REMOTE")
    private final Integer localRemote;
}
