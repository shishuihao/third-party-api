package cn.shishuihao.thirdparty.api.pay.wechat.sdk.request;

import cn.shishuihao.thirdparty.api.pay.wechat.sdk.annotation.WechatParameter;
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
public class WechatPaySecApiPayReverseRequest
        extends AbstractWechatPayXmlRequest {
    /**
     * 微信订单号.
     */
    @WechatParameter(
            name = "微信订单号",
            required = false, requiredIn = {"微信订单号", "商户订单号"},
            type = "String(32)",
            example = "013467007045764",
            desc = "微信的订单号，优先使用")
    @JacksonXmlProperty(localName = "transaction_id")
    private final String transactionId;
    /**
     * 商户订单号.
     */
    @WechatParameter(
            name = "商户订单号",
            required = false, requiredIn = {"微信订单号", "商户订单号"},
            type = "String(32)",
            example = "1217752501201407033233368018",
            desc = "商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*@ ，且在同一个商户号下唯一。 详见商户订单号")
    @JacksonXmlProperty(localName = "out_trade_no")
    private final String outTradeNo;
}
