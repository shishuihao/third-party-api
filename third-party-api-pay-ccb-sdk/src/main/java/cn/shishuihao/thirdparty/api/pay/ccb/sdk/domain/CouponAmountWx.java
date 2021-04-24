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
public class CouponAmountWx {
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
