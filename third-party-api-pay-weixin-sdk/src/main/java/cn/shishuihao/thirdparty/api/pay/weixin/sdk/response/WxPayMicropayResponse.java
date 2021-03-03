package cn.shishuihao.thirdparty.api.pay.weixin.sdk.response;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@XStreamAlias("xml")
public class WxPayMicropayResponse extends AbstractWxPayXmlResponse {
    /**
     * 用户标识  openid  是  String(128)  oUpF8uMuAJO_M2pxb1Q9zNjWeS6o  用户在商户appid下的唯一标识
     */
    @XStreamAlias("openid")
    private String openid;
    /**
     * 是否关注公众账号  is_subscribe  是 String(1)  Y  用户是否关注公众账号，Y-关注，N-未关注
     */
    @XStreamAlias("is_subscribe")
    private String isSubscribe;
    /**
     * 用户子标识  sub_openid 否 String(128)  wxd930ea5d5a258f4f  用户在子商户appid下的唯一标识
     */
    @XStreamAlias("sub_openid")
    private String subOpenid;
    /**
     * 是否关注子公众账号  sub_is_subscribe 否 String(1)  Y  用户是否关注子公众账号，Y-关注，N-未关注
     */
    @XStreamAlias("sub_is_subscribe")
    private String subIsSubscribe;
    /**
     * 交易类型  trade_type  是  String(16)  JSAPI  调用接口提交的交易类型，取值如下：JSAPI，NATIVE，APP，MICROPAY，详细说明见参数规定
     */
    @XStreamAlias("trade_type")
    private String tradeType;
    /**
     * 付款银行  bank_type  是  String(16)  CMC  银行类型，采用字符串类型的银行标识
     */
    @XStreamAlias("bank_type")
    private String bankType;
    /**
     * 订单金额 total_fee  是  Int  100  订单总金额，单位为分
     */
    @XStreamAlias("total_fee")
    private Integer totalFee;
    /**
     * 标价币种  fee_type  否  String(8)  CNY
     * 货币类型，符合ISO 4217标准的三位字母代码，默认人民币：CNY，其他值列表详见货币类型
     */
    @XStreamAlias("fee_type")
    private String feeType;
    /**
     * 应结订单金额 settlement_total_fee  否  Int  100
     * 当订单使用了免充值型优惠券后返回该参数，应结订单金额=订单金额-免充值优惠券金额。
     */
    @XStreamAlias("settlement_total_fee")
    private Integer settlementTotalFee;
    /**
     * 现金支付金额  cash_fee  是  Int  100
     * 现金支付金额订单现金支付金额，详见支付金额
     */
    @XStreamAlias("cash_fee")
    private Integer cashFee;
    /**
     * 现金支付货币类型  cash_fee_type  否  String(16)  CNY
     * 货币类型，符合ISO 4217标准的三位字母代码，默认人民币：CNY，其他值列表详见货币类型
     */
    @XStreamAlias("cash_fee_type")
    private String cashFeeType;
    /**
     * 代金券金额  coupon_fee  否  Int  100
     * “代金券或立减优惠”金额<=订单总金额，订单总金额-“代金券或立减优惠”金额=现金支付金额，详见支付金额
     */
    @XStreamAlias("coupon_fee")
    private Integer couponFee;
    /**
     * 代金券使用数量  coupon_count  否  Int  1  代金券或立减优惠使用数量
     */
    @XStreamAlias("coupon_count")
    private Integer couponCount;
    /**
     * 微信支付订单号  transaction_id  是  String(32)  1217752501201407033233368018  微信支付订单号
     */
    @XStreamAlias("transaction_id")
    private String transactionId;
    /**
     * 商户订单号  out_trade_no  是  String(32)  1217752501201407033233368018
     * 商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*@ ，且在同一个商户号下唯一。
     */
    @XStreamAlias("out_trade_no")
    private String outTradeNo;
    /**
     * 商家数据包  attach  否  String(128)  123456  商家数据包，原样返回
     */
    @XStreamAlias("attach")
    private String attach;
    /**
     * 支付完成时间  time_end  是  String(14)  20141030133525
     * 订单支付时间，格式为yyyyMMddHHmmss，如2009年12月25日9点10分10秒表示为20091225091010。其他详见时间规则
     */
    @XStreamAlias("time_end")
    private String timeEnd;

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getIsSubscribe() {
        return isSubscribe;
    }

    public void setIsSubscribe(String isSubscribe) {
        this.isSubscribe = isSubscribe;
    }

    public String getSubOpenid() {
        return subOpenid;
    }

    public void setSubOpenid(String subOpenid) {
        this.subOpenid = subOpenid;
    }

    public String getSubIsSubscribe() {
        return subIsSubscribe;
    }

    public void setSubIsSubscribe(String subIsSubscribe) {
        this.subIsSubscribe = subIsSubscribe;
    }

    public String getTradeType() {
        return tradeType;
    }

    public void setTradeType(String tradeType) {
        this.tradeType = tradeType;
    }

    public String getBankType() {
        return bankType;
    }

    public void setBankType(String bankType) {
        this.bankType = bankType;
    }

    public Integer getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(Integer totalFee) {
        this.totalFee = totalFee;
    }

    public String getFeeType() {
        return feeType;
    }

    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }

    public Integer getSettlementTotalFee() {
        return settlementTotalFee;
    }

    public void setSettlementTotalFee(Integer settlementTotalFee) {
        this.settlementTotalFee = settlementTotalFee;
    }

    public Integer getCashFee() {
        return cashFee;
    }

    public void setCashFee(Integer cashFee) {
        this.cashFee = cashFee;
    }

    public String getCashFeeType() {
        return cashFeeType;
    }

    public void setCashFeeType(String cashFeeType) {
        this.cashFeeType = cashFeeType;
    }

    public Integer getCouponFee() {
        return couponFee;
    }

    public void setCouponFee(Integer couponFee) {
        this.couponFee = couponFee;
    }

    public Integer getCouponCount() {
        return couponCount;
    }

    public void setCouponCount(Integer couponCount) {
        this.couponCount = couponCount;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getOutTradeNo() {
        return outTradeNo;
    }

    public void setOutTradeNo(String outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    public String getAttach() {
        return attach;
    }

    public void setAttach(String attach) {
        this.attach = attach;
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
    }
}
