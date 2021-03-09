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
public class WxPayRefundQueryRequest extends AbstractWxPayXmlRequest {
    /**
     * 微信订单号.
     */
    @WxParameter(
            name = "微信订单号",
            required = false,
            requiredIn = {"微信订单号", "商户订单号", "商户退款单号", "微信退款单号"},
            type = "String(32)",
            example = "013467007045764",
            desc = "微信的订单号，优先使用")
    @XStreamAlias("transaction_id")
    private final String transactionId;
    /**
     * 商户订单号.
     */
    @WxParameter(
            name = "商户订单号",
            required = false,
            requiredIn = {"微信订单号", "商户订单号", "商户退款单号", "微信退款单号"},
            type = "String(32)",
            example = "1217752501201407033233368018",
            desc = "商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*@ ，且在同一个商户号下唯一。 详见商户订单号")
    @XStreamAlias("out_trade_no")
    private final String outTradeNo;
    /**
     * 商户退款单号.
     */
    @WxParameter(
            name = "商户退款单号",
            required = false,
            requiredIn = {"微信订单号", "商户订单号", "商户退款单号", "微信退款单号"},
            type = "String(64)",
            example = "1217752501201407033233368018",
            desc = "商户系统内部的退款单号，商户系统内部唯一，只能是数字、大小写字母_-|*@ ，同一退款单号多次请求只退一笔。")
    @XStreamAlias("out_refund_no")
    private final String outRefundNo;
    /**
     * 微信退款单号.
     */
    @WxParameter(
            name = "微信退款单号",
            required = false,
            requiredIn = {"微信订单号", "商户订单号", "商户退款单号", "微信退款单号"},
            type = "String(32)",
            example = "1217752501201407033233368018",
            desc = "微信退款单号\n"
                    + "refund_id、out_refund_no、out_trade_no、transaction_id"
                    + "四个参数必填一个，如果同时存在优先级为：\n"
                    + "refund_id>out_refund_no>transaction_id>out_trade_no")
    @XStreamAlias("refund_id")
    private final String refundId;
    /**
     * 偏移量.
     */
    @WxParameter(
            name = "偏移量",
            required = false, type = "Int",
            example = "15",
            desc = "偏移量，当部分退款次数超过10次时可使用，表示返回的查询结果从这个偏移量开始取记录")
    @XStreamAlias("offset")
    private final Integer offset;
}
