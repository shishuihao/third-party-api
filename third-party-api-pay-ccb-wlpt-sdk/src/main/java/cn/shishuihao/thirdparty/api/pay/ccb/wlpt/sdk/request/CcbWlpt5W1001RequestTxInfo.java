package cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.request;

import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.domain.CcbWlptTxInfo;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Builder;
import lombok.Getter;

/**
 * NO.1 （5W1001）B2C外联启动连接交易.
 * 交易名称 B2C外联平台启动连接交易 请求交易码 5W1001 内部交易码 5W1001
 * 后端系统 IBS 交易类型 查询类 XML示例 Sample
 * 交易说明 B2C外联平台启动连接交易
 *
 * @author shishuihao
 * @version 1.0.0
 */
@Getter
@Builder
@JacksonXmlRootElement(localName = "TX_INFO")
public class CcbWlpt5W1001RequestTxInfo implements CcbWlptTxInfo {
    /**
     * 备注1 varChar(32) T.
     */
    @JacksonXmlProperty(localName = "REM1")
    private final String remark1;
    /**
     * 备注2 varChar(32) T.
     */
    @JacksonXmlProperty(localName = "REM2")
    private final String remark2;
}
