package cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.response;

import cn.shishuihao.thirdparty.api.commons.http.response.HttpResponse;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.domain.CcbWlptTxInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class CcbWlptResponse<T extends CcbWlptTxInfo>
        implements HttpResponse {
    /**
     * 请求序列号 varChar(16) F 只可以使用数字.
     */
    @JacksonXmlProperty(localName = "REQUEST_SN")
    private String requestSn;
    /**
     * 客户号 varChar(21) F 字符型char，网银客户号.
     */
    @JacksonXmlProperty(localName = "CUST_ID")
    private String customerId;
    /**
     * 交易码 varChar(6) F 交易请求码.
     */
    @JacksonXmlProperty(localName = "TX_CODE")
    private String txCode;
    /**
     * 响应码 varChar(12) F 交易响应码 .
     */
    @JacksonXmlProperty(localName = "RETURN_CODE")
    private String returnCode;
    /**
     * 响应码 varChar(12) F 交易响应码.
     */
    @JacksonXmlProperty(localName = "RETURN_MSG")
    private String returnMsg;
    /**
     * 语言 varChar(2) F CN.
     */
    @JacksonXmlProperty(localName = "LANGUAGE")
    private String language;
    /**
     * 交易信息.
     */
    @JacksonXmlProperty(localName = "TX_INFO")
    private T txInfo;

    /**
     * 是否响应成功.
     *
     * @return boolean
     */
    @JsonIgnore
    public boolean isReturnSuccess() {
        return "000000".equals(this.returnCode);
    }
}
