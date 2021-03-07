package cn.shishuihao.thirdparty.api.pay.weixin.sdk.response;

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
     * 是
     * String(128)
     * oUpF8uMuAJO_M2pxb1Q9zNjWeS6o
     * 用户在商户appid下的唯一标识
     */
    @XStreamAlias("openid")
    private String openid;
    /**
     * 是否关注公众账号.
     * 是
     * String(1)
     * Y
     * 用户是否关注公众账号，Y-关注，N-未关注
     */
    @XStreamAlias("is_subscribe")
    private String isSubscribe;
    /**
     * 用户子标识.
     * 否
     * String(128)
     * wxd930ea5d5a258f4f
     * 用户在子商户appid下的唯一标识
     */
    @XStreamAlias("sub_openid")
    private String subOpenid;
    /**
     * 是否关注子公众账号.
     * 否
     * String(1)
     * Y
     * 用户是否关注子公众账号，Y-关注，N-未关注
     */
    @XStreamAlias("sub_is_subscribe")
    private String subIsSubscribe;
    /**
     * 交易类型.
     * 是
     * String(16)
     * JSAPI
     * 调用接口提交的交易类型，取值如下：
     * JSAPI，NATIVE，APP，MICROPAY，详细说明见参数规定
     */
    @XStreamAlias("trade_type")
    private String tradeType;
    /**
     * 交易状态.
     * 是
     * String(32)
     * SUCCESS
     */
    @XStreamAlias("trade_state")
    private String tradeState;
    /**
     * 交易状态描述.
     * 是
     * String(256)
     * 支付失败，请重新下单支付 对当前查询订单状态的描述和下一步操作的指引
     */
    @XStreamAlias("trade_state_desc")
    private String tradeStateDesc;
    /**
     * 付款银行.
     * 是
     * String(16)
     * CMC
     * 银行类型，采用字符串类型的银行标识
     */
    @XStreamAlias("bank_type")
    private String bankType;
    /**
     * 订单金额.
     * 是
     * Int
     * 100
     * 订单总金额，单位为分
     */
    @XStreamAlias("total_fee")
    private Integer totalFee;
    /**
     * 标价币种.
     * 否
     * String(8)
     * CNY
     * 货币类型，符合ISO 4217标准的三位字母代码，
     * 默认人民币：CNY，其他值列表详见货币类型
     */
    @XStreamAlias("fee_type")
    private String feeType;
    /**
     * 应结订单金额.
     * 否
     * Int
     * 100
     * 当订单使用了免充值型优惠券后返回该参数，应结订单金额=订单金额-免充值优惠券金额。
     */
    @XStreamAlias("settlement_total_fee")
    private Integer settlementTotalFee;
    /**
     * 现金支付金额.
     * 是
     * Int
     * 100
     * 现金支付金额订单现金支付金额，详见支付金额
     */
    @XStreamAlias("cash_fee")
    private Integer cashFee;
    /**
     * 现金支付货币类型.
     * 否
     * String(16)  CNY
     * 货币类型，符合ISO 4217标准的三位字母代码，
     * 默认人民币：CNY，其他值列表详见货币类型
     */
    @XStreamAlias("cash_fee_type")
    private String cashFeeType;
    /**
     * 代金券金额.
     * 否
     * Int
     * 100
     * “代金券或立减优惠”金额<=订单总金额，
     * 订单总金额-“代金券或立减优惠”金额=现金支付金额，详见支付金额
     */
    @XStreamAlias("coupon_fee")
    private Integer couponFee;
    /**
     * 代金券使用数量.
     * 否
     * Int
     * 1  代金券或立减优惠使用数量
     */
    @XStreamAlias("coupon_count")
    private Integer couponCount;
    /**
     * 微信支付订单号.
     * 是
     * String(32)
     * 1217752501201407033233368018
     * 微信支付订单号
     */
    @XStreamAlias("transaction_id")
    private String transactionId;
    /**
     * 商户订单号.
     * 是
     * String(32)
     * 1217752501201407033233368018
     * 商户系统内部订单号，要求32个字符内，
     * 只能是数字、大小写字母_-|*@ ，且在同一个商户号下唯一。
     */
    @XStreamAlias("out_trade_no")
    private String outTradeNo;
    /**
     * 商家数据包.
     * 否
     * String(128)
     * 123456  商家数据包，原样返回
     */
    @XStreamAlias("attach")
    private String attach;
    /**
     * 支付完成时间.
     * 是
     * String(14)
     * 20141030133525
     * 订单支付时间，格式为yyyyMMddHHmmss，
     * 如2009年12月25日9点10分10秒表示为20091225091010。其他详见时间规则
     */
    @XStreamAlias("time_end")
    private String timeEnd;
}
