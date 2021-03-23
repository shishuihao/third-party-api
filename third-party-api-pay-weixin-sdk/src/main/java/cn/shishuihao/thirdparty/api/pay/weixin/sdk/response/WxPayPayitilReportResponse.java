package cn.shishuihao.thirdparty.api.pay.weixin.sdk.response;

import cn.shishuihao.thirdparty.api.pay.weixin.sdk.annotation.WxParameter;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Getter;
import lombok.Setter;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Getter
@Setter
@JacksonXmlRootElement(localName = "xml")
public class WxPayPayitilReportResponse {
    // region 返回信息.
    /**
     * 返回状态码.
     */
    @WxParameter(
            name = "返回状态码",
            required = true, type = "String(16)",
            example = "SUCCESS",
            desc = "SUCCESS/FAIL\n此字段是通信标识，表示接口层的请求结果，并非退款状态。")
    @XStreamAlias("return_code")
    private String returnCode;
    /**
     * 返回信息.
     */
    @WxParameter(
            name = "返回信息",
            required = false, type = "String(128)",
            example = "签名失败",
            desc = "返回信息，如非空，为错误原因\n签名失败\n参数格式校验错误")
    @XStreamAlias("return_msg")
    private String returnMsg;
    // endregion
    // region 当return_code为SUCCESS的时候，还会包括以下字段

    /**
     * 业务结果.
     */
    @WxParameter(
            name = "业务结果",
            required = true, type = "String(16)",
            example = "SUCCESS",
            desc = "SUCCESS/FAIL")
    @XStreamAlias("result_code")
    private String resultCode;
}
