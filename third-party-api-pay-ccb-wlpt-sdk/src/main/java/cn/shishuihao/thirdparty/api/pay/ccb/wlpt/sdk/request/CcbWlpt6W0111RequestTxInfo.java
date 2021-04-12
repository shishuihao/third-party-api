package cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.request;

import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.TransactionInfo;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Builder;
import lombok.Getter;

/**
 * NO.4 大文件下载.
 * 交易名称 大文件下载 请求交易码 6W0111 内部交易码 6W0111
 * 后端系统 IBS 交易类型 连接类 XML示例 Sample 请看示例报文
 * 交易说明 外联平台返回文件下载,注意这里下载后的文件保存在外联平台目录wlpt_app\download下
 *
 * @author shishuihao
 * @version 1.0.0
 */
@Getter
@Builder
@JacksonXmlRootElement(localName = "TX_INFO")
public class CcbWlpt6W0111RequestTxInfo implements TransactionInfo {
    /**
     * 要下载的文件名称 varChar(128) F 要下载的文件名，如：CBB1172476199728.
     */
    @JacksonXmlProperty(localName = "SOURCE")
    private final String source;
    /**
     * 文件路径 varChar(30) F 要下载文件的路径:merchant/shls,必须填该值.
     */
    @JacksonXmlProperty(localName = "FILEPATH")
    private final String filePath;
    /**
     * 下载路径标志 varChar(1) F 一般0.
     */
    @JacksonXmlProperty(localName = "LOCAL_REMOTE")
    private final Integer localRemote;
}
