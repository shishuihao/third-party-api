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
public class Coupon {
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
