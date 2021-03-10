package cn.shishuihao.thirdparty.api.pay.weixin.sdk.request;

import cn.shishuihao.thirdparty.api.pay.weixin.sdk.annotation.WxParameter;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Getter
@SuperBuilder
@JacksonXmlRootElement(localName = "xml")
public class WxPayCloseOrderRequest extends AbstractWxPayXmlRequest {
    /**
     * 商户订单号.
     */
    @WxParameter(
            name = "商户订单号",
            required = false,
            type = "String(32)",
            example = "1217752501201407033233368018",
            desc = "商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*@ ，且在同一个商户号下唯一。 详见商户订单号")
    @JacksonXmlProperty(localName = "out_trade_no")
    private final String outTradeNo;
}
