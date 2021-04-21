package cn.shishuihao.thirdparty.api.pay.weixin.v3.sdk.domain;

import cn.shishuihao.thirdparty.api.commons.http.response.HttpResponse;
import cn.shishuihao.thirdparty.api.pay.weixin.v3.sdk.annotation.WxParameter;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Getter
@Setter
public class WxPayV3PayTransaction
        implements HttpResponse {
    /**
     * 应用ID.
     */
    @WxParameter(
            name = "应用ID",
            required = true, type = "string[1,32]",
            example = "wxd678efh567hg6787",
            desc = "直连商户申请的公众号或移动应用appid。")
    @JsonProperty("appid")
    private String appId;
    /**
     * 直连商户号.
     */
    @WxParameter(
            name = "直连商户号",
            required = true, type = "string[1,32]",
            example = "1230000109",
            desc = "直连商户的商户号，由微信支付生成并下发。")
    @JsonProperty("mchid")
    private String mchId;
    /**
     * 商户订单号.
     */
    @WxParameter(
            name = "商户订单号",
            required = true, type = "string[6,32]",
            example = "1217752501201407033233368018",
            desc = "商户系统内部订单号，只能是数字、大小写字母_-*且在同一个商户号下唯一，详见【商户订单号】。")
    @JsonProperty("out_trade_no")
    private String outTradeNo;
    /**
     * 微信支付订单号.
     */
    @WxParameter(
            name = "微信支付订单号",
            required = false, type = "string[1,32]",
            example = "1217752501201407033233368018",
            desc = "微信支付系统生成的订单号。")
    @JsonProperty("transaction_id")
    private String transactionId;
    /**
     * 交易类型.
     */
    @WxParameter(
            name = "交易类型",
            required = false, type = "string[1,16]",
            example = "MICROPAY",
            desc = "交易类型，枚举值：\n"
                    + "JSAPI：公众号支付\n"
                    + "NATIVE：扫码支付\n"
                    + "APP：APP支付\n"
                    + "MICROPAY：付款码支付\n"
                    + "MWEB：H5支付\n"
                    + "FACEPAY：刷脸支付")
    @JsonProperty("trade_type")
    private String tradeType;
    /**
     * 交易状态.
     */
    @WxParameter(
            name = "交易状态",
            required = true, type = "string[1,32]",
            example = "SUCCESS",
            desc = "SUCCESS：支付成功\n"
                    + "REFUND：转入退款\n"
                    + "NOTPAY：未支付\n"
                    + "CLOSED：已关闭\n"
                    + "REVOKED：已撤销（付款码支付）\n"
                    + "USERPAYING：用户支付中（付款码支付）\n"
                    + "PAYERROR：支付失败(其他原因，如银行返回失败)\n"
                    + "ACCEPT：已接收，等待扣款")
    @JsonProperty("trade_state")
    private String tradeState;
    /**
     * 交易状态描述.
     */
    @WxParameter(
            name = "交易状态描述",
            required = true, type = "string[1,256]",
            example = "支付成功",
            desc = "交易状态描述")
    @JsonProperty("trade_state_desc")
    private String tradeStateDesc;
    /**
     * 付款银行.
     */
    @WxParameter(
            name = "付款银行",
            required = false, type = "string[1,16]",
            example = "CMC",
            desc = "银行类型，采用字符串类型的银行标识。银行标识请参考《银行类型对照表》")
    @JsonProperty("bank_type")
    private String bankType;
    /**
     * 附加数据.
     */
    @WxParameter(
            name = "附加数据",
            required = false, type = "string[1,128]",
            example = "自定义数据",
            desc = "附加数据，在查询API和支付通知中原样返回，可作为自定义参数使用")
    @JsonProperty("attach")
    private String attach;
    /**
     * 支付完成时间.
     */
    @WxParameter(
            name = "支付完成时间",
            required = false, type = "string[1,64]",
            example = "2018-06-08T10:34:56+08:00",
            desc = "支付完成时间，遵循rfc3339标准格式，格式为YYYY-MM-DDTHH:mm:ss+TIMEZONE，"
                    + "YYYY-MM-DD表示年月日，T出现在字符串中，表示time元素的开头，HH:mm:ss表示时分秒，"
                    + "TIMEZONE表示时区（+08:00表示东八区时间，领先UTC 8小时，即北京时间）。"
                    + "例如：2015-05-20T13:29:35+08:00表示，北京时间2015年5月20日 13点29分35秒。"
    )
    @JsonProperty("success_time")
    private String successTime;
    /**
     * 支付者.
     */
    @WxParameter(
            name = "支付者",
            required = true, type = "object",
            example = "",
            desc = "支付者信息")
    @JsonProperty("payer")
    private Payer payer;
    /**
     * 订单金额.
     */
    @WxParameter(
            name = "订单金额",
            required = false, type = "object",
            example = "",
            desc = "订单金额信息，当支付成功时返回该字段。")
    @JsonProperty("amount")
    private Amount amount;
    /**
     * 场景信息.
     */
    @WxParameter(
            name = "场景信息",
            required = false, type = "object",
            example = "",
            desc = "支付场景描述")
    @JsonProperty("scene_info")
    private SceneInfo sceneInfo;
    /**
     * 优惠功能.
     */
    @WxParameter(
            name = "优惠功能",
            required = false, type = "object",
            example = "",
            desc = "优惠功能，享受优惠时返回该字段。")
    @JsonProperty("promotion_detail")
    private PromotionDetail[] promotionDetail;

    @Getter
    @Setter
    public static class Payer {
        /**
         * 用户标识.
         */
        @WxParameter(
                name = "用户标识",
                required = true, type = "string[1,128]",
                example = "oUpF8uMuAJO_M2pxb1Q9zNjWeS6o",
                desc = "用户在直连商户appid下的唯一标识。")
        @JsonProperty("openid")
        private String openid;
    }

    @Getter
    @Setter
    public static class Amount {
        /**
         * 用户支付金额.
         */
        @WxParameter(
                name = "用户支付金额",
                required = false, type = "int",
                example = "100",
                desc = "用户支付金额，单位为分。")
        @JsonProperty("payer_total")
        private Integer payerTotal;
        /**
         * 总金额.
         */
        @WxParameter(
                name = "总金额",
                required = false, type = "int",
                example = "100",
                desc = "订单总金额，单位为分。")
        @JsonProperty("total")
        private Integer total;
        /**
         * 货币类型.
         */
        @WxParameter(
                name = "货币类型",
                required = false, type = "string[1,16]",
                example = "CNY",
                desc = "CNY：人民币，境内商户号仅支持人民币。")
        @JsonProperty("currency")
        private String currency;
        /**
         * 用户支付币种.
         */
        @WxParameter(
                name = "用户支付币种",
                required = false, type = "string[1,16]",
                example = "CNY",
                desc = "用户支付币种")
        @JsonProperty("payer_currency")
        private String payerCurrency;
    }

    @Getter
    @Setter
    public static class SceneInfo {
        /**
         * 商户端设备号.
         */
        @WxParameter(
                name = "商户端设备号",
                required = false, type = "string[1,32]",
                example = "013467007045764",
                desc = "商户端设备号（发起扣款请求的商户服务器设备号）。")
        @JsonProperty("device_id")
        private String deviceId;
    }

    @Getter
    @Setter
    public static class PromotionDetail {
        /**
         * 优惠券面额.
         */
        @WxParameter(
                name = "优惠券面额",
                required = true, type = "int",
                example = "100",
                desc = "优惠券面额")
        @JsonProperty("amount")
        private Integer amount;
        /**
         * 微信出资.
         */
        @WxParameter(
                name = "微信出资",
                required = false, type = "int",
                example = "0",
                desc = "微信出资，单位为分")
        @JsonProperty("wechatpay_contribute")
        private String wechatPayContribute;
        /**
         * 券ID.
         */
        @WxParameter(
                name = "券ID",
                required = true, type = "string[1,32]",
                example = "109519",
                desc = "券ID")
        @JsonProperty("coupon_id")
        private String couponId;
        /**
         * 优惠范围.
         */
        @WxParameter(
                name = "优惠范围",
                required = false, type = "string[1,32]",
                example = "GLOBAL",
                desc = "GLOBAL：全场代金券\n"
                        + "SINGLE：单品优惠")
        @JsonProperty("scope")
        private String scope;
        /**
         * 商户出资.
         */
        @WxParameter(
                name = "商户出资",
                required = false, type = "int",
                example = "0",
                desc = "商户出资，单位为分")
        @JsonProperty("merchant_contribute")
        private String merchantContribute;
        /**
         * 优惠名称.
         */
        @WxParameter(
                name = "优惠名称",
                required = false, type = "string[1,64]",
                example = "单品惠-6",
                desc = "优惠名称")
        @JsonProperty("name")
        private String name;
        /**
         * 其他出资.
         */
        @WxParameter(
                name = "其他出资",
                required = false, type = "int",
                example = "0",
                desc = "其他出资，单位为分")
        @JsonProperty("other_contribute")
        private String otherContribute;
        /**
         * 优惠币种.
         */
        @WxParameter(
                name = "优惠币种",
                required = false, type = "string[1,16]",
                example = "CNY",
                desc = "CNY：人民币，境内商户号仅支持人民币。")
        @JsonProperty("currency")
        private String currency;
        /**
         * 活动ID.
         */
        @WxParameter(
                name = "活动ID",
                required = false, type = "string[1,32]",
                example = "931386",
                desc = "活动ID")
        @JsonProperty("stock_id")
        private String stockId;
        /**
         * 单品列表.
         */
        @WxParameter(
                name = "单品列表",
                required = false, type = "array",
                example = "",
                desc = "单品列表信息")
        @JsonProperty("goods_detail")
        private GoodsDetail[] goodsDetail;
        /**
         * 优惠类型.
         */
        @WxParameter(
                name = "优惠类型",
                required = false, type = "string[1,32]",
                example = "CASH",
                desc = "CASH：充值\n"
                        + "NOCASH：预充值")
        @JsonProperty("type")
        private String type;
    }

    @Getter
    @Setter
    public static class GoodsDetail {
        /**
         * 商品备注.
         */
        @WxParameter(
                name = "商品备注",
                required = false, type = "string[1,128]",
                example = "商品备注信息",
                desc = "商品备注信息")
        @JsonProperty("goods_remark")
        private String goodsRemark;
        /**
         * 商品数量.
         */
        @WxParameter(
                name = "商品数量",
                required = true, type = "int",
                example = "1",
                desc = "用户购买的数量")
        @JsonProperty("quantity")
        private Integer quantity;
        /**
         * 商品优惠金额.
         */
        @WxParameter(
                name = "商品优惠金额",
                required = true, type = "int",
                example = "0 ",
                desc = "商品优惠金额")
        @JsonProperty("discount_amount")
        private Integer discountAmount;
        /**
         * 商品编码.
         */
        @WxParameter(
                name = "商品编码",
                required = true, type = "string[1,32]",
                example = "M1006",
                desc = "商品编码")
        @JsonProperty("goods_id")
        private String goodsId;
        /**
         * 商品单价.
         */
        @WxParameter(
                name = "商品单价",
                required = true, type = "int",
                example = "100",
                desc = "商品单价，单位为分")
        @JsonProperty("unit_price")
        private Integer unitPrice;
    }
}
