package cn.shishuihao.thirdparty.api.pay.ccb.sdk.response;

import cn.shishuihao.thirdparty.api.pay.ccb.sdk.domain.Coupon;
import cn.shishuihao.thirdparty.api.pay.ccb.sdk.domain.CouponAmountWx;
import cn.shishuihao.thirdparty.api.pay.ccb.sdk.domain.PaymentDetails;
import cn.shishuihao.thirdparty.api.pay.ccb.sdk.domain.PromotionDetail;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class CcbPay101Response extends AbstractCcbResponse {
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
     * 该笔订单的资金总额
     * 0.01
     */
    @JsonProperty("AMOUNT")
    private String amount;
    /**
     * 等待时间 2 N.
     * RESULT为Q-待查询时返回，单位:秒.
     * 建议商户按返回等待相应时间后再发起轮询
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

    /**
     * 是否成功.
     *
     * @return boolean
     */
    @JsonIgnore
    @Override
    public boolean isSuccess() {
        return "Y".equalsIgnoreCase(result);
    }
}
