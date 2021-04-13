package cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.request;

import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.TransactionInfo;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Builder;
import lombok.Getter;

/**
 * NO.1 （5W1006）E付通授权信息查询.
 * 交易名称 E付通授权信息查询 请求交易码 5W1006 内部交易码 5W1006
 * 后端系统 IBS 交易类型 查询类 XML示例 Sample
 * 交易说明 增加E付通授权信息的实时查询接口
 *
 * @author shishuihao
 * @version 1.0.0
 */
@Getter
@Builder
@JacksonXmlRootElement(localName = "TX_INFO")
public class CcbWlpt5W1006RequestTxInfo implements TransactionInfo {
    /**
     * 授权号 varChar(20) F.
     */
    @JacksonXmlProperty(localName = "GRANTNUM")
    private final String grantNumber;
    /**
     * 分行号 varChar(9) F 商户所属分行号.
     */
    @JacksonXmlProperty(localName = "BRANCHID")
    private final String branchId;
}
