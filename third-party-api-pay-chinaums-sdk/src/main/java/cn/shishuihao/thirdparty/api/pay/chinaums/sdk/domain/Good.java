package cn.shishuihao.thirdparty.api.pay.chinaums.sdk.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.jackson.Jacksonized;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Jacksonized
@ToString
@Builder
@Getter
public class Good {
    /**
     * 商品ID 字符串 ⇐64 否.
     */
    @JsonProperty("goodsId")
    private final String goodsId;
    /**
     * 商品名称 字符串 ⇐256 否.
     */
    @JsonProperty("goodsName")
    private final String goodsName;
    /**
     * 商品数量 字符串 否.
     */
    @JsonProperty("quantity")
    private final String quantity;
    /**
     * 商品单价 （分） 字符串 否.
     */
    @JsonProperty("price")
    private final String price;
    /**
     * 商品分类 字符串 ⇐64 否.
     */
    @JsonProperty("goodsCategory")
    private final String goodsCategory;
    /**
     * 商品说明 字符串 ⇐1024 否.
     */
    @JsonProperty("body")
    private final String body;
    /**
     * 商品单位 数字型 否.
     */
    @JsonProperty("unit")
    private final String unit;
    /**
     * 商品折扣 数字型 否.
     */
    @JsonProperty("discount")
    private final String discount;
    /**
     * 子商户号 字符串 15 否.
     */
    @JsonProperty("subMerchantId")
    private final String subMerchantId;
    /**
     * 商户子订 单号 字符串 6..32 否.
     */
    @JsonProperty("merOrderId")
    private final String merOrderId;
    /**
     * 子商户商 品总额 数字型 0..100000000 否.
     */
    @JsonProperty("subOrderAmount")
    private final String subOrderAmount;
}
