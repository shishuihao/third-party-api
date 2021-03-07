package cn.shishuihao.thirdparty.api.pay.weixin.sdk.response;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Getter
@Setter
@XStreamAlias("xml")
public class WxPayRefundQueryResponse extends AbstractWxPayXmlResponse {
    /**
     * 订单总退款次数.
     * 否
     * Int
     * 35
     * 订单总共已发生的部分退款次数，当请求参数传入offset后有返回
     */
    @XStreamAlias("total_refund_count")
    private Integer totalRefundCount;
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
     * 订单金额.
     * 是
     * Int
     * 100
     * 订单总金额，单位为分，只能为整数，详见支付金额
     */
    @XStreamAlias("total_fee")
    private String totalFee;
    /**
     * 应结订单金额.
     * 否
     * Int
     * 100
     * 当订单使用了免充值型优惠券后返回该参数，应结订单金额=订单金额-免充值优惠券金额。
     */
    @XStreamAlias("settlement_total_fee")
    private String settlementTotalFee;
    /**
     * 标价币种.
     * 是
     * String(8)
     * CNY
     * 货币类型，符合ISO 4217标准的三位字母代码，
     * 默认人民币：CNY，其他值列表详见货币类型
     */
    @XStreamAlias("fee_type")
    private String feeType;
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
     * 退款笔数.
     * 是
     * Int
     * 1
     * 当前返回退款笔数
     */
    @XStreamAlias("refund_count")
    private Integer refundCount;
    /**
     * 商户退款单号.
     * 是
     * String(64)
     * 1217752501201407033233368018
     * 商户系统内部的退款单号，商户系统内部唯一，
     * 只能是数字、大小写字母_-|*@ ，同一退款单号多次请求只退一笔。
     */
    @XStreamAlias("out_refund_no_$n")
    private Map<Integer, String> outRefundNos = new HashMap<>();
    /**
     * 微信退款单号.
     * 是
     * String(32)
     * 1217752501201407033233368018
     * 微信退款单号
     */
    @XStreamAlias("refund_id_$n")
    private Map<Integer, String> refundIds = new HashMap<>();
    /**
     * 退款渠道.
     * 否
     * String(16)
     * ORIGINAL
     * ORIGINAL—原路退款
     * BALANCE—退回到余额
     * OTHER_BALANCE—原账户异常退到其他余额账户
     * OTHER_BANKCARD—原银行卡异常退到其他银行卡
     */
    @XStreamAlias("refund_channel_$n")
    private Map<Integer, String> refundChannels = new HashMap<>();
    /**
     * 申请退款金额.
     * 是
     * Int
     * 100
     * 退款总金额,单位为分,可以做部分退款
     */
    @XStreamAlias("refund_fee_$n")
    private Map<Integer, Integer> refundFees = new HashMap<>();
    /**
     * 退款金额.
     * 否
     * Int
     * 100
     * 退款金额=申请退款金额-非充值代金券退款金额，退款金额<=申请退款金额
     */
    @XStreamAlias("settlement_refund_fee_$n")
    private Map<Integer, Integer> settlementRefundFees = new HashMap<>();

    /**
     * 代金券类型.
     * 否
     * String(8)
     * CASH
     * CASH--充值代金券
     * NO_CASH---非充值优惠券
     * 开通免充值券功能，并且订单使用了优惠券后有返回（取值：CASH、NO_CASH）。
     * $n为下标,$m为下标,从0开始编号，举例：coupon_type_$0_$1
     */
    @XStreamAlias("coupon_type_$n_$m")
    private Map<Integer, Map<Integer, String>> couponTypes = new HashMap<>();
    /**
     * 总代金券退款金额.
     * 否
     * Int
     * 100
     * 代金券退款金额<=退款金额，退款金额-代金券或立减优惠退款金额为现金，
     * 说明详见代金券或立减优惠
     */
    @XStreamAlias("coupon_refund_fee_$n")
    private Map<Integer, Integer> couponRefundFees = new HashMap<>();
    /**
     * 退款代金券使用数量.
     * 否
     * Int
     * 1
     * 退款代金券使用数量 ,$n为下标,从0开始编号
     */
    @XStreamAlias("coupon_refund_count_$n")
    private Map<Integer, Integer> couponRefundCounts = new HashMap<>();
    /**
     * 退款代金券ID.
     * 否
     * String(20)
     * 10000
     * 退款代金券ID, $n为下标，$m为下标，从0开始编号
     */
    @XStreamAlias("coupon_refund_id_$n_$m")
    private Map<Integer, Map<Integer, Integer>> couponRefundsIds
            = new HashMap<>();
    /**
     * 单个代金券退款金额.
     * 否
     * Int
     * 100
     * 单个退款代金券支付金额, $n为下标，$m为下标，从0开始编号。
     */
    @XStreamAlias("coupon_refund_fee_$n_$m")
    private Map<Integer, Map<Integer, Integer>> couponRefundsFees
            = new HashMap<>();
    /**
     * 退款状态.
     * 是
     * String(16)
     * SUCCESS
     * 退款状态：
     * SUCCESS—退款成功
     * REFUNDCLOSE—退款关闭。
     * PROCESSING—退款处理中
     * CHANGE—退款异常，退款到银行发现用户的卡作废或者冻结了，导致原路退款银行卡失败，
     * 可前往商户平台（pay.weixin.qq.com）-交易中心，手动处理此笔退款。
     * $n为下标，从0开始编号。
     */
    @XStreamAlias("refund_status_$n")
    private Map<Integer, String> refundStatuses = new HashMap<>();
    /**
     * 退款资金来源.
     * 否
     * String(30)
     * REFUND_SOURCE_RECHARGE_FUNDS
     * REFUND_SOURCE_RECHARGE_FUNDS---可用余额退款/基本账户
     * REFUND_SOURCE_UNSETTLED_FUNDS---未结算资金退款
     * $n为下标，从0开始编号。
     */
    @XStreamAlias("refund_account_$n")
    private Map<Integer, String> refundAccounts = new HashMap<>();
    /**
     * 退款入账账户.
     * 是
     * String(64)
     * 招商银行信用卡0403
     * 取当前退款单的退款入账方
     * 1）退回银行卡：
     * {银行名称}{卡类型}{卡尾号}
     * 2）退回支付用户零钱:
     * 支付用户零钱
     * 3）退还商户:
     * 商户基本账户
     * 商户结算银行账户
     * 4）退回支付用户零钱通:
     * 支付用户零钱通
     */
    @XStreamAlias("refund_recv_accout_$n")
    private Map<Integer, String> refundRecvAccounts = new HashMap<>();
    /**
     * 退款成功时间.
     * 否
     * String(20)
     * 2016-07-25 15:26:26
     * 退款成功时间，当退款状态为退款成功时有返回。
     * $n为下标，从0开始编号。
     */
    @XStreamAlias("refund_success_time_$n")
    private Map<Integer, String> refundSuccessTimes = new HashMap<>();
}
