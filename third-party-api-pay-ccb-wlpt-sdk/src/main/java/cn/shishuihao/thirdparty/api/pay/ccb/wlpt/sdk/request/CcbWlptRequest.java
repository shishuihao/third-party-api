package cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.request;

import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.TransactionInfo;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Builder;
import lombok.Getter;

/**
 * @param <T> 交易信息
 * @author shishuihao
 * @version 1.0.0
 */
@Getter
@Builder
@JacksonXmlRootElement(localName = "TX")
public class CcbWlptRequest<T extends TransactionInfo> {
    /**
     * REQUEST_SN 请求序列号 varChar(16) F 只可以使用数字.
     */
    @JacksonXmlProperty(localName = "REQUEST_SN")
    private final String requestSn;
    /**
     * CUST_ID 客户号 varChar(21) F 字符型char，网银客户号.
     */
    @JacksonXmlProperty(localName = "CUST_ID")
    private final String customerId;
    /**
     * USER_ID 操作员号 varChar(6) F.
     */
    @JacksonXmlProperty(localName = "USER_ID")
    private final String userId;
    /**
     * PASSWORD 密码 varChar(32) F 操作员密码.
     */
    @JacksonXmlProperty(localName = "PASSWORD")
    private final String password;
    /**
     * TX_CODE 交易码 varChar(6) F 交易请求码.
     */
    @JacksonXmlProperty(localName = "TX_CODE")
    private final String txCode;
    /**
     * LANGUAGE 语言 varChar(2) F CN.
     */
    @JacksonXmlProperty(localName = "LANGUAGE")
    private final String language;
    /**
     * 交易信息.
     */
    @JacksonXmlProperty(localName = "TX_INFO")
    private final T txInfo;
}
