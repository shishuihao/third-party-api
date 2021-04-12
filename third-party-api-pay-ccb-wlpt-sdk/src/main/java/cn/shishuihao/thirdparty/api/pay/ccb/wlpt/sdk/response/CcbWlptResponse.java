package cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.response;

import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.TransactionInfo;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;
import lombok.Setter;

/**
 * @param <T> 交易信息
 * @author shishuihao
 * @version 1.0.0
 */
@Getter
@Setter
@JacksonXmlRootElement(localName = "TX")
public class CcbWlptResponse<T extends TransactionInfo> {
    /**
     * REQUEST_SN 请求序列号 varChar(16) F 只可以使用数字.
     */
    @JacksonXmlProperty(localName = "REQUEST_SN")
    private String requestSn;
    /**
     * CUST_ID 客户号 varChar(21) F 字符型char，网银客户号.
     */
    @JacksonXmlProperty(localName = "CUST_ID")
    private String customerId;
    /**
     * TX_CODE 交易码 varChar(6) F 交易请求码.
     */
    @JacksonXmlProperty(localName = "TX_CODE")
    private String txCode;
    /**
     * RETURN_CODE 响应码 varChar(12) F 交易响应码 .
     */
    @JacksonXmlProperty(localName = "RETURN_CODE")
    private String returnCode;
    /**
     * RETURN_CODE 响应码 varChar(12) F 交易响应码.
     */
    @JacksonXmlProperty(localName = "RETURN_MSG")
    private String returnMsg;
    /**
     * LANGUAGE 语言 varChar(2) F CN.
     */
    @JacksonXmlProperty(localName = "LANGUAGE")
    private String language;
    /**
     * 交易信息.
     */
    @JacksonXmlProperty(localName = "TX_INFO")
    private T txInfo;
}
