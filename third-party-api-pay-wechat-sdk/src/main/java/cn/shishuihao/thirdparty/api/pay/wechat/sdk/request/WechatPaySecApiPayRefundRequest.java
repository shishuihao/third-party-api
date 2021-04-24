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
public class WechatPaySecApiPayRefundRequest
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
    /**
     * 商户退款单号.
     */
    @WechatParameter(
            name = "商户退款单号",
            required = true, type = "String(64)",
            example = "1217752501201407033233368018",
            desc = "商户系统内部的退款单号，商户系统内部唯一，只能是数字、大小写字母_-|*@ ，同一退款单号多次请求只退一笔。")
    @JacksonXmlProperty(localName = "out_refund_no")
    private final String outRefundNo;
    /**
     * 订单金额.
     */
    @WechatParameter(
            name = "订单金额",
            required = true, type = "Int",
            example = "888",
            desc = "订单总金额，单位为分，只能为整数，详见支付金额")
    @JacksonXmlProperty(localName = "total_fee")
    private final Integer totalFee;
    /**
     * 退款金额.
     */
    @WechatParameter(
            name = "退款金额",
            required = true, type = "Int",
            example = "100",
            desc = "退款总金额，订单总金额，单位为分，只能为整数，详见支付金额")
    @JacksonXmlProperty(localName = "refund_fee")
    private final Integer refundFee;
    /**
     * 退款货币种类.
     */
    @WechatParameter(
            name = "退款货币种类",
            required = false, type = "String(8)",
            example = "CNY",
            desc = "退款货币类型，需与支付一致，或者不填。"
                    + "符合ISO 4217标准的三位字母代码，默认人民币：CNY，其他值列表详见货币类型")
    @JacksonXmlProperty(localName = "refund_fee_type")
    private final String refundFeeType;
    /**
     * 退款原因.
     */
    @WechatParameter(
            name = "退款原因",
            required = false, type = "String(80)",
            example = "商品已售完",
            desc = "若商户传入，会在下发给用户的退款消息中体现退款原因\n"
                    + "注意：若订单退款金额≤1元，且属于部分退款，则不会在退款消息中体现退款原因")
    @JacksonXmlProperty(localName = "refund_desc")
    private final String refundDesc;
    /**
     * 退款资金来源.
     */
    @WechatParameter(
            name = "退款资金来源",
            required = false, type = "String(30)",
            example = "REFUND_SOURCE_RECHARGE_FUNDS",
            desc = "仅针对老资金流商户使用\n"
                    + "REFUND_SOURCE_UNSETTLED_FUNDS---未结算资金退款（默认使用未结算资金退款）\n"
                    + "REFUND_SOURCE_RECHARGE_FUNDS---可用余额退款")
    @JacksonXmlProperty(localName = "refund_account")
    private final String refundAccount;
    /**
     * 退款结果通知url.
     */
    @WechatParameter(
            name = "退款结果通知url",
            required = false, type = "String(256)",
            example = "https://weixin.qq.com/notify/",
            desc = "异步接收微信支付退款结果通知的回调地址，通知URL必须为外网可访问的url，不允许带参数\n"
                    + "如果参数中传了notify_url，则商户平台上配置的回调地址将不会生效。")
    @JacksonXmlProperty(localName = "notify_url")
    private final String notifyUrl;
}
