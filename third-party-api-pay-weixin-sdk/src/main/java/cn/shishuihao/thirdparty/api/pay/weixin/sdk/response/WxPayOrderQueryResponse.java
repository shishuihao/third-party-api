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
public class WxPayOrderQueryResponse extends AbstractWxPayXmlResponse {
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
            desc = "用户是否关注公众账号，Y-关注，N-未关注（机构商户不返回）")
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
            desc = "用户是否关注子公众账号，Y-关注，N-未关注（机构商户不返回）")
    @XStreamAlias("sub_is_subscribe")
    private String subIsSubscribe;
    /**
     * 交易类型.
     */
    @WxParameter(
            name = "交易类型",
            required = true, type = "String(16)",
            example = "JSAPI",
            desc = "调用接口提交的交易类型，取值如下：JSAPI，NATIVE，APP，MICROPAY，详细说明见参数规定")
    @XStreamAlias("trade_type")
    private String tradeType;
    /**
     * 交易状态.
     */
    @WxParameter(
            name = "交易状态",
            required = true, type = "String(32)",
            example = "SUCCESS",
            desc = "SUCCESS--支付成功\n"
                    + "REFUND--转入退款\n"
                    + "NOTPAY--未支付\n"
                    + "CLOSED--已关闭\n"
                    + "REVOKED--已撤销(刷卡支付)\n"
                    + "USERPAYING--用户支付中\n"
                    + "PAYERROR--支付失败(其他原因，如银行返回失败)\n"
                    + "ACCEPT--已接收，等待扣款")
    @XStreamAlias("trade_state")
    private String tradeState;
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
     * 商品详情.
     */
    @WxParameter(
            name = "商品详情",
            required = false, type = "String(8192)",
            example = "{\n"
                    + "\"discount_detail\":[\n"
                    + "{\n"
                    + "\"goods_id\":\"iphone6s_16G\",\n"
                    + "\"goods_name\":\"iPhone6s 16G\",\n"
                    + "\"coupon_batch_id\":888,\n"
                    + "\"coupon_id\":666888,\n"
                    + "\"coupon_fee\":1000\n"
                    + "},\n"
                    + "{\n"
                    + "\"goods_id\":\"iphone6s_32G\",\n"
                    + "\"goods_name\":\"iPhone6s 32G\",\n"
                    + "\"coupon_batch_id\":999,\n"
                    + "\"coupon_id\":666999,\n"
                    + "\"coupon_fee\":1500\n"
                    + "}\n"
                    + "]\n"
                    + "}",
            desc = "商品详细列表，使用Json格式，传输签名前请务必使用CDATA标签将JSON文本串保护起来。"
                    + "如果使用了单品优惠，会有单品优惠信息返回\n"
                    + "\n"
                    + "discount_detail []：\n"
                    + "└ goods_id String 必填 32 商品的编号\n"
                    + "└ goods_name String 必填 256 商品名称\n"
                    + "└ coupon_batch_id String 必填 代金券批次ID\n"
                    + "└ coupon_id String 必填 代金卷ID\n"
                    + "└ coupon_fee Int 必填 代金券支付金额，单位为分")
    @XStreamAlias("detail")
    private String detail;
    /**
     * 标价金额.
     */
    @WxParameter(
            name = "标价金额",
            required = true, type = "Int",
            example = "100",
            desc = "订单总金额，单位为分")
    @XStreamAlias("total_fee")
    private Integer totalFee;
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
     * 现金支付货币类型.
     */
    @WxParameter(
            name = "现金支付货币类型",
            required = false, type = "String(16) ",
            example = "CNY",
            desc = "货币类型，符合ISO 4217标准的三位字母代码，默认人民币：CNY，其他值列表详见货币类型")
    @XStreamAlias("cash_fee_type")
    private String cashFeeType;
    /**
     * 代金券金额.
     */
    @WxParameter(
            name = "代金券金额",
            required = false, type = "Int",
            example = "100",
            desc = "“代金券或立减优惠”金额<=订单总金额，订单总金额-“代金券或立减优惠”金额=现金支付金额，详见支付金额")
    @XStreamAlias("coupon_fee")
    private Integer couponFee;
    /**
     * 代金券使用数量.
     */
    @WxParameter(
            name = "代金券使用数量",
            required = false, type = "Int",
            example = "1",
            desc = "代金券或立减优惠使用数量")
    @XStreamAlias("coupon_count")
    private Integer couponCount;
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
     * 商家数据包.
     */
    @WxParameter(
            name = "商家数据包",
            required = false, type = "String(128)",
            example = "123456",
            desc = "商家数据包，原样返回")
    @XStreamAlias("attach")
    private String attach;
    /**
     * 支付完成时间.
     */
    @WxParameter(
            name = "支付完成时间",
            required = true, type = "String(14)",
            example = "20141030133525",
            desc = "订单支付时间，格式为yyyyMMddHHmmss，"
                    + "如2009年12月25日9点10分10秒表示为20091225091010。其他详见时间规则")
    @XStreamAlias("time_end")
    private String timeEnd;
    /**
     * 交易状态描述.
     */
    @WxParameter(
            name = "交易状态描述",
            required = true, type = "String(256)",
            example = "支付失败，请重新下单支付",
            desc = "对当前查询订单状态的描述和下一步操作的指引")
    @XStreamAlias("trade_state_desc")
    private String tradeStateDesc;
}
