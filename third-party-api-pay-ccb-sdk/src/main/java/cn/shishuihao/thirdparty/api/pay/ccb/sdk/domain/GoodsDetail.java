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
public class GoodsDetail {
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
