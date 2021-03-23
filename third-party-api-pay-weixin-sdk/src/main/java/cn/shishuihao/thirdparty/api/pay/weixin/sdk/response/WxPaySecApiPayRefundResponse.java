package cn.shishuihao.thirdparty.api.pay.weixin.sdk.response;

import cn.shishuihao.thirdparty.api.pay.weixin.sdk.annotation.WxParameter;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Getter
@Setter
@XStreamAlias("xml")
public class WxPaySecApiPayRefundResponse extends AbstractWxPayXmlResponse {
    /**
     * 微信支付订单号.
     */
    @WxParameter(
            name = "微信支付订单号",
            required = true,
            type = "String(32)",
            example = "1217752501201407033233368018",
            desc = "微信支付订单号")
    @XStreamAlias("transaction_id")
    private String transactionId;
    /**
     * 商户订单号.
     */
    @WxParameter(
            name = "商户订单号",
            required = true, type = "String(32)",
            example = "1217752501201407033233368018",
            desc = "商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*@ ，且在同一个商户号下唯一。")
    @XStreamAlias("out_trade_no")
    private String outTradeNo;
    /**
     * 商户退款单号.
     */
    @WxParameter(
            name = "商户退款单号",
            required = true, type = "String(64)",
            example = "1217752501201407033233368018",
            desc = "商户系统内部的退款单号，商户系统内部唯一，只能是数字、大小写字母_-|*@ ，同一退款单号多次请求只退一笔。")
    @XStreamAlias("out_refund_no")
    private String outRefundNo;
    /**
     * 微信退款单号.
     */
    @WxParameter(
            name = "微信退款单号",
            required = true, type = "String(32)",
            example = "1217752501201407033233368018",
            desc = "微信退款单号。")
    @XStreamAlias("refund_id")
    private String refundId;
    /**
     * 退款金额.
     */
    @WxParameter(
            name = "退款金额",
            required = true, type = "Int",
            example = "100",
            desc = "退款总金额,单位为分,可以做部分退款")
    @XStreamAlias("refund_fee")
    private Integer refundFee;
    /**
     * 应结退款金额.
     */
    @WxParameter(
            name = "应结退款金额",
            required = false, type = "Int",
            example = "100",
            desc = "去掉非充值代金券退款金额后的退款金额，退款金额=申请退款金额-非充值代金券退款金额，退款金额<=申请退款金额")
    @XStreamAlias("settlement_refund_fee")
    private String settlementRefundFee;
    /**
     * 标价金额.
     */
    @WxParameter(
            name = "标价金额",
            required = true, type = "Int",
            example = "100",
            desc = "订单总金额，单位为分")
    @XStreamAlias("total_fee")
    private String totalFee;
    /**
     * 应结订单金额.
     */
    @WxParameter(
            name = "应结订单金额",
            required = false, type = "Int",
            example = "100",
            desc = "去掉非充值代金券金额后的订单总金额，应结订单金额=订单金额-非充值代金券金额，应结订单金额<=订单金额。")
    @XStreamAlias("settlement_total_fee")
    private String settlementTotalFee;
    /**
     * 标价币种.
     */
    @WxParameter(
            name = "标价币种",
            required = false, type = "String(8)",
            example = "CNY",
            desc = "货币类型，符合ISO 4217标准的三位字母代码，默认人民币：CNY，其他值列表详见货币类型")
    @XStreamAlias("fee_type")
    private String feeType;
    /**
     * 现金支付金额.
     */
    @WxParameter(
            name = "现金支付金额",
            required = true, type = "Int",
            example = "100",
            desc = "现金支付金额订单现金支付金额，详见支付金额")
    @XStreamAlias("cash_fee")
    private Integer cashFee;
    /**
     * 现金支付币种.
     */
    @WxParameter(
            name = "现金支付币种",
            required = false, type = "String(16)",
            example = "CNY",
            desc = "货币类型，符合ISO 4217标准的三位字母代码，默认人民币：CNY，其他值列表详见货币类型")
    @XStreamAlias("cash_fee_type")
    private String cashFeeType;
    /**
     * 现金退款金额.
     */
    @WxParameter(
            name = "现金退款金额",
            required = false, type = "Int",
            example = "100",
            desc = "现金退款金额，单位为分，只能为整数，详见支付金额")
    @XStreamAlias("cash_refund_fee")
    private Integer cashRefundFee;
    /**
     * 代金券类型.
     */
    @WxParameter(
            name = "代金券类型",
            required = false, type = "String(8)",
            example = "CASH",
            desc = "CASH--充值代金券\n"
                    + "NO_CASH---非充值代金券\n"
                    + "订单使用代金券时有返回（取值：CASH、NO_CASH）。"
                    + "$n为下标,从0开始编号，举例：coupon_type_0")
    @XStreamAlias("coupon_type_$n")
    private List<String> couponTypes = new ArrayList<>();
    /**
     * 代金券退款总金额.
     */
    @WxParameter(
            name = "代金券退款总金额",
            required = false, type = "Int",
            example = "100",
            desc = "代金券退款金额<=退款金额，退款金额-代金券或立减优惠退款金额为现金，说明详见代金券或立减优惠")
    @XStreamAlias("coupon_refund_fee")
    private Integer couponRefundFee;
    /**
     * 单个代金券退款金额.
     */
    @WxParameter(
            name = "单个代金券退款金额",
            required = false, type = "Int",
            example = "100",
            desc = "代金券退款金额<=退款金额，退款金额-代金券或立减优惠退款金额为现金，说明详见代金券或立减优惠")
    @XStreamAlias("coupon_refund_fee_$n")
    private List<Integer> couponRefundFees = new ArrayList<>();
    /**
     * 退款代金券使用数量.
     */
    @WxParameter(
            name = "退款代金券使用数量",
            required = false, type = "Int",
            example = "1",
            desc = "退款代金券使用数量")
    @XStreamAlias("coupon_refund_count")
    private Integer couponRefundCount;
    /**
     * 退款代金券ID.
     */
    @WxParameter(
            name = "退款代金券ID",
            required = false, type = "String(20)",
            example = "10000",
            desc = "退款代金券ID, $n为下标，从0开始编号")
    @XStreamAlias("coupon_refund_id_$n_$m")
    private List<String> couponRefundsIds = new ArrayList<>();
}
