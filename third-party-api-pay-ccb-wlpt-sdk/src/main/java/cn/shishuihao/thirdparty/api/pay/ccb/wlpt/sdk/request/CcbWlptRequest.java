package cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.request;

import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.domain.CcbWlptTxInfo;
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
public class CcbWlptRequest<T extends CcbWlptTxInfo> {
    /**
     * 请求序列号 varChar(16) F 只可以使用数字.
     */
    @JacksonXmlProperty(localName = "REQUEST_SN")
    private final String requestSn;
    /**
     * 商户代码 varChar(15) .
     */
    @JacksonXmlProperty(localName = "MERCHANTID")
    private final String merchantId;
    /**
     * 客户号 varChar(21) F 字符型char，网银客户号.
     */
    @JacksonXmlProperty(localName = "CUST_ID")
    private final String customerId;
    /**
     * 操作员号 varChar(6) F.
     */
    @JacksonXmlProperty(localName = "USER_ID")
    private final String userId;
    /**
     * 密码 varChar(32) F 操作员密码.
     */
    @JacksonXmlProperty(localName = "PASSWORD")
    private final String password;
    /**
     * 交易码 varChar(6) F 交易请求码.
     */
    @JacksonXmlProperty(localName = "TX_CODE")
    private final String txCode;
    /**
     * 语言 varChar(2) F CN.
     */
    @JacksonXmlProperty(localName = "LANGUAGE")
    private final String language;
    /**
     * 交易信息.
     */
    @JacksonXmlProperty(localName = "TX_INFO")
    private final T txInfo;
    /**
     * 签名信息 varChar(254) T .
     */
    @JacksonXmlProperty(localName = "SIGN_INFO")
    private final String signInfo;
    /**
     * 签名CA信息 varChar(254) T 客户采用socket连接时，建行客户端自动添加 .
     */
    @JacksonXmlProperty(localName = "SIGNCERT")
    private final String signCert;
}
