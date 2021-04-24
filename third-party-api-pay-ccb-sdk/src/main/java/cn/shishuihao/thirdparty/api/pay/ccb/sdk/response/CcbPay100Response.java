package cn.shishuihao.thirdparty.api.pay.ccb.sdk.response;

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
public class CcbPay100Response extends AbstractCcbResponse {
    /**
     * 订单结果 1 Y.
     * Y：成功
     * N：失败
     * U：不确定（交易超时，建议通过订单查询确认扣款结果）
     * Q：待轮询（需按照[3.2.3.支付及轮询流程说明]继续调用轮询接口查询订单结果）
     * 其他无法明确订单结果的情况，均继续调用轮询接口查询
     * Y
     */
    @JsonProperty("RESULT")
    private String result;
    /**
     * 订单号 30 N.
     * 从请求参数中获得
     * 20180906101102
     */
    @JsonProperty("ORDERID")
    private String orderId;
    /**
     * 订单金额 16 N.
     * 从请求参数中获得
     * 5
     */
    @JsonProperty("AMOUNT")
    private String amount;
    /**
     * 二维码类型 1 N.
     * 1：龙支付
     * 2：微信
     * 3：支付宝
     * 4：银联
     * 2
     */
    @JsonProperty("QRCODETYPE")
    private String qrCodeType;
    /**
     * 等待时间 2 N.
     * RESULT为Q-待查询时返回，单位:秒.
     * 5
     */
    @JsonProperty("WAITTIME")
    private String waitTime;
    /**
     * 客户识别号 128 N.
     * 客户识别码。
     * 当RETURN_FIELD 字段第一位上送1时返回。
     * 银联渠道不返回。
     * RESULT为Q，该字段不返回，需发轮询接口（PAY101）获取。
     * 此字段不参与验签.
     * 99915236154128
     */
    @JsonProperty("OPENID")
    private String openId;
    /**
     * 用户子标识 128 N.
     * 微信支付专有字段。
     * 当RETURN_FIELD字段第一位上送1时返回。
     * 子商户appid下用户唯一标识，如需返回则请求时需要传sub_appid。
     * RESULT为Q，该字段不返回，需发轮询接口（PAY101）获取。
     * 此字段不参与验签
     */
    @JsonProperty("SUB_OPENID")
    private String subOpenId;
    /**
     * 客户实付金额 16,2 N.
     * 客户实付金额。
     * 当RETURN_FIELD字段第二位上送1时返回。
     * 当客户使用龙支付且享受优惠时，该参数有值。
     * RESULT为Q，该字段不返回，需发轮询接口（PAY101）获取。
     * 此字段不参与验签.
     * 2.00
     */
    @JsonProperty("PAID_AMOUNT")
    private String paidAmount;
    /**
     * 商户实收金额 16,2 N.
     * 商户实收金额。
     * 当RETURN_FIELD字段第二位上送1时返回。
     * 当客户使用银联支付且享受优惠时，该参数有值。
     * RESULT为Q，该字段不返回，需发轮询接口（PAY101）获取。
     * 此字段不参与验签.
     * 3.00
     */
    @JsonProperty("RECEIPT_AMOUNT")
    private String receiptAmount;
    /**
     * 优惠活动数组 JSON N.
     * 优惠活动名。
     * 当RETURN_FIELD字段第二位上送1时返回。
     * RESULT为Q，该字段不返回，需发轮询接口（PAY101）获取。
     * 此字段不参与验签.
     */
    @JsonProperty("COUPONARRAY")
    private Coupon[] couponArray;
    /**
     * 支付详细信息 JSON N.
     * 支付详细信息。
     * 当RETURN_FIELD字段第四位上送1时返回。
     * RESULT为Q，该字段不返回，需发轮询接口（PAY101）获取。
     * 此字段不参与验签.
     */
    @JsonProperty("PAYMENT_DETAILS")
    private PaymentDetails paymentDetails;
    /**
     * 微信优惠金额 JSON N.
     * 微信优惠金额。
     * 当RETURN_FIELD第5位为1时返回。
     * RESULT为Q，该字段不返回，需发轮询接口（PAY101）获取。
     * 此字段不参与验签.
     */
    @JsonProperty("COUPONAMOUNT_WX")
    private CouponAmountWx couponAmountWx;
    /**
     * 微信优惠详情 JSON N.
     * 微信优惠详情。
     * 当RETURN_FIELD第5位为1时返回。
     * RESULT为Q，该字段不返回，需发轮询接口（PAY101）获取。
     * 此字段不参与验签.
     */
    @JsonProperty("promotion_detail")
    private PromotionDetail promotionDetail;

    @ToString
    @Getter
    @Setter
    public static class Coupon {
        /**
         * 优惠活动名称 600 N.
         * 优惠活动名称
         * 随机立减
         */
        @JsonProperty("COUPONNAME")
        private String couponName;
        /**
         * 优惠抵消交易金额 12 N.
         * 优惠抵消交易金额
         * 0.01
         */
        @JsonProperty("COUPONTxnAmt")
        private String couponTxnAmt;
    }

    @ToString
    @Getter
    @Setter
    public static class PaymentDetails {
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

    @ToString
    @Getter
    @Setter
    public static class CouponAmountWx {
        /**
         * 现金支付金额 12 N.
         * 订单现金支付金额，即客户实际支付的金额
         * 100.00
         */
        @JsonProperty("CASH_FEE")
        private String cashFee;
        /**
         * 应结订单金额 12 N.
         * 商户实际收到的金额。
         * 应结订单金额=订单金额-免充值优惠券金额。
         * 120.00
         */
        @JsonProperty("SETTLEMENT_TOTAL_FEE")
        private String settlementTotalFee;
        /**
         * 代金券金额 12 N.
         * 用户享受的所有优惠金额。
         * 代金券金额<=订单金额，订单金额-代金券金额=现金支付金额
         * 50.00
         */
        @JsonProperty("COUPON_FEE")
        private String couponFee;
    }

    @ToString
    @Getter
    @Setter
    public static class PromotionDetail {
        /**
         * 券 ID String(32) Y.
         * 券或者立减优惠id。
         * 109519
         */
        @JsonProperty("promotion_id")
        private String promotionId;
        /**
         * 优惠名称 String(64) N.
         * 优惠名称
         * 单品惠-6 优
         */
        @JsonProperty("name")
        private String name;
        /**
         * 优惠范围 String(32) N.
         * GLOBAL-全场代金券。
         * SINGLE-单品优惠。
         * SINGLE
         */
        @JsonProperty("scope")
        private String scope;
        /**
         * 优惠类型 String(32) N.
         * COUPON-代金券，需要走结算资金的充值型代金券,（境外商户券币种与支付币种一致）。
         * DISCOUNT-优惠券，不走结算资金的免充值型优惠券，（境外商户券币种与标价币种一致。
         * DISCOUNT
         */
        @JsonProperty("type")
        private String type;
        /**
         * 优惠券面额 Int N.
         * 用户享受优惠的金额（优惠券面额=微信出资金额+商家出资金额+其他出资方金额）。
         * 5
         */
        @JsonProperty("amount")
        private String amount;
        /**
         * 活动 ID String(32) Y.
         * 在微信商户后台配置的批次ID。
         * 931386
         */
        @JsonProperty("activity_id")
        private String activityId;
        /**
         * 微信出资 String(32) N.
         * 特指由微信支付商户平台创建的优惠，出资金额等于本项优惠总金额，单位为分。
         * 0
         */
        @JsonProperty("wxpay_contribute")
        private String wxPayContribute;
        /**
         * 商户出资 String(32) N.
         * 其他出资方出资金额，单位为分。
         * 5
         */
        @JsonProperty("merchant_contribute")
        private String merchantContribute;
        /**
         * 单品列表 String Y.
         * 单品信息，使用 Json 数组格式。
         * 示例见下文
         */
        @JsonProperty("goods_detail")
        private GoodsDetail goodsDetail;
    }

    @ToString
    @Getter
    @Setter
    public static class GoodsDetail {
        /**
         * 商品编码 String(32) Y.
         * 由半角的大小写字母、数字、中划线、下划线中的一种或几种组成。
         * a_goods1
         */
        @JsonProperty("goods_id")
        private String goodsId;
        /**
         * 商品备注 String(128) N.
         * goods_remark为备注字段，按照配置原样返回，
         * 字段内容在微信后台配置券时进行设置。
         * 商品备注
         */
        @JsonProperty("goods_remark")
        private String goodsRemark;
        /**
         * discount_amount 商品优惠金额 Int Y.
         * 单品的总优惠金额，单位为分。
         * 4
         */
        @JsonProperty("promotion_id")
        private String promotionId;
        /**
         * 商品数量 Int Y.
         * 用户购买的数量。
         * 1
         */
        @JsonProperty("quantity")
        private String quantity;
        /**
         * 商品价格 Int Y.
         * 单位为分。如果商户有优惠，需传输商户优惠后的单价
         * (例如：用户对一笔100 元的订单使用了商场发的优惠券 100-50，则活动商品的单价应为原单价-50)。
         * 2
         */
        @JsonProperty("price")
        private String price;
    }
}
