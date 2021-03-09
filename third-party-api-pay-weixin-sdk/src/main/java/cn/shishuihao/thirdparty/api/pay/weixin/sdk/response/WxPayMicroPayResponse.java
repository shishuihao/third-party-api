package cn.shishuihao.thirdparty.api.pay.weixin.sdk.response;

import cn.shishuihao.thirdparty.api.pay.weixin.sdk.annotation.WxParameter;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Getter;
import lombok.Setter;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Getter
@Setter
@XStreamAlias("xml")
public class WxPayMicroPayResponse extends AbstractWxPayXmlResponse {
    /**
     * 用户标识.
     */
    @WxParameter(
            name = "用户标识",
            required = true, type = "String(128)",
            example = "oUpF8uMuAJO_M2pxb1Q9zNjWeS6o",
            desc = "用户在商户appid下的唯一标识")
    @XStreamAlias("openid")
    private String openid;
    /**
     * 是否关注公众账号.
     */
    @WxParameter(
            name = "是否关注公众账号",
            required = true, type = "String(1)",
            example = "Y",
            desc = "用户是否关注公众账号，仅在公众账号类型支付有效，取值范围：Y或N;Y-关注;N-未关注")
    @XStreamAlias("is_subscribe")
    private String isSubscribe;
    /**
     * 用户子标识.
     */
    @WxParameter(
            name = "用户子标识",
            required = false, type = "String(128)",
            example = "wxd930ea5d5a258f4f",
            desc = "子商户appid下用户唯一标识，如需返回则请求时需要传sub_appid")
    @XStreamAlias("sub_openid")
    private String subOpenid;
    /**
     * 是否关注子公众账号.
     */
    @WxParameter(
            name = "是否关注子公众账号",
            required = false, type = "String(1)",
            example = "Y",
            desc = "用户是否关注子公众账号，仅在公众账号类型支付有效，取值范围：Y或N;Y-关注;N-未关注")
    @XStreamAlias("sub_is_subscribe")
    private String subIsSubscribe;
    /**
     * 交易类型.
     */
    @WxParameter(
            name = "交易类型",
            required = true, type = "String(16)",
            example = "MICROPAY",
            desc = "支付类型为MICROPAY(即扫码支付)")
    @XStreamAlias("trade_type")
    private String tradeType;
    /**
     * 付款银行.
     */
    @WxParameter(
            name = "付款银行",
            required = true, type = "String(16)",
            example = "CMC",
            desc = "银行类型，采用字符串类型的银行标识")
    @XStreamAlias("bank_type")
    private String bankType;
    /**
     * 标价币种.
     */
    @WxParameter(
            name = "标价币种",
            required = false, type = "String(8)",
            example = "CNY",
            desc = "符合ISO 4217标准的三位字母代码，默认人民币：CNY，其他值列表详见货币类型")
    @XStreamAlias("fee_type")
    private String feeType;
    /**
     * 标价金额.
     */
    @WxParameter(
            name = "标价金额",
            required = true, type = "Int",
            example = "888",
            desc = "订单总金额，单位为分，只能为整数，详见支付金额")
    @XStreamAlias("total_fee")
    private Integer totalFee;
    /**
     * 现金支付货币类型.
     */
    @WxParameter(
            name = "现金支付货币类型",
            required = false, type = "String(16)",
            example = "CNY",
            desc = "符合ISO 4217标准的三位字母代码，默认人民币：CNY，其他值列表详见货币类型")
    @XStreamAlias("cash_fee_type")
    private String cashFeeType;
    /**
     * 现金支付金额.
     */
    @WxParameter(
            name = "现金支付金额",
            required = true, type = "Int",
            example = "100",
            desc = "订单现金支付金额，详见支付金额")
    @XStreamAlias("cash_fee")
    private Integer cashFee;
    /**
     * 应结订单金额.
     */
    @WxParameter(
            name = "应结订单金额",
            required = false, type = "Int",
            example = "100",
            desc = "当订单使用了免充值型优惠券后返回该参数，应结订单金额=订单金额-免充值优惠券金额。")
    @XStreamAlias("settlement_total_fee")
    private Integer settlementTotalFee;
    /**
     * 代金券金额.
     */
    @WxParameter(
            name = "代金券金额",
            required = false, type = "Int",
            example = "100",
            desc = "“代金券”金额<=订单金额，订单金额-“代金券”金额=现金支付金额，详见支付金额")
    @XStreamAlias("coupon_fee")
    private Integer couponFee;
    /**
     * 代金券使用数量.
     */
    @WxParameter(
            name = "代金券使用数量",
            required = false, type = "Int",
            example = "1",
            desc = "“代金券或立减优惠使用数量")
    @XStreamAlias("coupon_count")
    private Integer couponCount;
    /**
     * 微信支付订单号.
     */
    @WxParameter(
            name = "微信支付订单号",
            required = true, type = "String(32)",
            example = "1217752501201407033233368018",
            desc = "“微信支付订单号")
    @XStreamAlias("transaction_id")
    private String transactionId;
    /**
     * 商户订单号.
     */
    @WxParameter(
            name = "商户订单号",
            required = true, type = "String(32)",
            example = "1217752501201407033233368018",
            desc = "“商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*且在同一个商户号下唯一。")
    @XStreamAlias("out_trade_no")
    private String outTradeNo;
    /**
     * 商家数据包.
     */
    @WxParameter(
            name = "商家数据包",
            required = false, type = "String(128)",
            example = "123456",
            desc = "“商家数据包，原样返回")
    @XStreamAlias("attach")
    private String attach;
    /**
     * 支付完成时间.
     */
    @WxParameter(
            name = "支付完成时间",
            required = true, type = "String(14)",
            example = "123456",
            desc = "订单生成时间，格式为yyyyMMddHHmmss，"
                    + "如2009年12月25日9点10分10秒表示为20091225091010。详见时间规则")
    @XStreamAlias("time_end")
    private String timeEnd;
}
