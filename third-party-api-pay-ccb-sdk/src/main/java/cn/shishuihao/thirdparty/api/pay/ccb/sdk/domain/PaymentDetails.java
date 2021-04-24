package cn.shishuihao.thirdparty.api.pay.ccb.sdk.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@ToString
@Getter
@Setter
public class PaymentDetails {
    /**
     * 支付方式 10 N.
     * 枚举值
     * 支付宝：ALIPAY
     * 微信：WEIXIN
     * 建行：CCB
     * 银联：UNIONPAY
     * ALIPAY
     */
    @JsonProperty("TYPE")
    private String type;
    /**
     * 支付渠道 30 N.
     * 1.当支付方式为微信时，
     * 详见https://pay.weixin.qq.com/wiki/doc/api/jsapi_sl.php?chapter=4_2的8、
     * 银行类型，商户可根据该字段获取支付账户的发卡机构
     * 2.当支付方式为支付宝时
     * 支付渠道代码 支付渠道说明
     * COUPON 支付宝红包
     * ALIPAYACCOUNT 支付宝余额
     * POINT 集分宝
     * DISCOUNT 折扣券
     * PCARD 预付卡
     * MCARD 商家储值卡
     * MDISCOUNT 商户优惠券
     * MCOUPON 商户红包
     * PCREDIT 蚂蚁花呗
     * BANKCARD 银行卡渠道
     * 3.当支付方式为建行时，
     * 支付渠道代码 支付渠道说明
     * LONG_WALLET 龙支付钱包
     * CCB_BANKCARD 建行卡
     * OTHER_BANKCARD 他行卡
     * 4.当支付方式为银联时，该字段返回为空
     * BANKCARD
     */
    @JsonProperty("PAY_CHANNEL")
    private String payChannel;
    /**
     * 借贷记标识 10 N.
     * 借记：DEBIT
     * 贷记：CREDIT
     * 当支付方式为银联时，该字段返回为空
     * CREDIT
     */
    @JsonProperty("DEBIT_CREDIT_TYPE")
    private String debitCreditType;
    /**
     * 第三方订单号 100 N.
     * 返回支付宝/微信订单号
     * 当支付方式为龙支付或银联时，该字段返回为空
     * 2018010521001004890523646975
     */
    @JsonProperty("THIRD_TRADE_NO")
    private String thirdTradeNo;
}
