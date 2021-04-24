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
public class PromotionDetail {
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
