package cn.shishuihao.thirdparty.api.pay.weixin.sdk.request;

import cn.shishuihao.thirdparty.api.pay.weixin.sdk.annotation.WxParameter;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Getter
@SuperBuilder
@XStreamAlias("xml")
public class WxPayOrderQueryRequest extends AbstractWxPayXmlRequest {
    /**
     * 微信订单号.
     * 微信订单号和商户订单号二选一
     */
    @WxParameter(
            name = "微信订单号",
            required = false, type = "String(32)",
            example = "013467007045764",
            desc = "微信的订单号，优先使用")
    @XStreamAlias("transaction_id")
    private final String transactionId;
    /**
     * 商户订单号.
     * 微信订单号和商户订单号二选一
     */
    @WxParameter(
            name = "商户订单号",
            required = false, type = "String(32)",
            example = "1217752501201407033233368018",
            desc = "商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*@ ，且在同一个商户号下唯一。 详见商户订单号")
    @XStreamAlias("out_trade_no")
    private final String outTradeNo;
}
