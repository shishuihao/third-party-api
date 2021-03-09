package cn.shishuihao.thirdparty.api.pay.weixin.sdk.request;

import cn.shishuihao.thirdparty.api.pay.weixin.sdk.annotation.WxParameter;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Getter
@SuperBuilder
@XStreamAlias("xml")
public class WxPayUnifiedOrderRequest extends AbstractWxPayXmlRequest {
    /**
     * 商品描述.
     */
    @WxParameter(
            name = "商品描述",
            required = true, type = "String(128)",
            example = "image形象店-深圳腾大- QQ公仔",
            desc = "商品简单描述，该字段须严格按照规范传递，具体请见参数规定")
    @XStreamAlias("body")
    private final String body;
    /**
     * 商品详情.
     */
    @WxParameter(
            name = "商品详情",
            required = false, type = "String(6000)",
            example = "",
            desc = "单品优惠功能字段，需要接入详见单品优惠详细说明")
    @XStreamAlias("detail")
    private final String detail;
    /**
     * 附加数据.
     */
    @WxParameter(
            name = "附加数据",
            required = false, type = "String(127)",
            example = "说明",
            desc = "附加数据，在查询API和支付通知中原样返回，该字段主要用于商户携带订单的自定义数据")
    @XStreamAlias("attach")
    private final String attach;
    /**
     * 商户订单号.
     */
    @WxParameter(
            name = "商户订单号",
            required = true, type = "String(32)",
            example = "1217752501201407033233368018",
            desc = "商户系统内部订单号，要求32个字符内，只能是数字、大小写字母_-|*且在同一个商户号下唯一。详见商户订单号")
    @XStreamAlias("out_trade_no")
    private final String outTradeNo;
    /**
     * 货币类型.
     */
    @WxParameter(
            name = "货币类型",
            required = false, type = "String(16)",
            example = "CNY",
            desc = "符合ISO 4217标准的三位字母代码，默认人民币：CNY，其他值列表详见货币类型")
    @XStreamAlias("fee_type")
    private final String feeType;
    /**
     * 总金额.
     */
    @WxParameter(
            name = "总金额",
            required = true, type = "Int",
            example = "888",
            desc = "订单总金额，单位为分，只能为整数，详见支付金额")
    @XStreamAlias("total_fee")
    private final Integer totalFee;
    /**
     * 终端IP.
     */
    @WxParameter(
            name = "终端IP",
            required = true, type = "String(64)",
            example = "8.8.8.8",
            desc = "支持IPV4和IPV6两种格式的IP地址。调用微信支付API的机器IP")
    @XStreamAlias("spbill_create_ip")
    private final String spBillCreateIp;
    /**
     * 交易起始时间.
     */
    @WxParameter(
            name = "交易起始时间",
            required = false, type = "String(14)",
            example = "20091225091010",
            desc = "订单生成时间，格式为yyyyMMddHHmmss，"
                    + "如2009年12月25日9点10分10秒表示为20091225091010。其他详见时间规则")
    @XStreamAlias("time_start")
    private final String timeStart;
    /**
     * 交易结束时间.
     */
    @WxParameter(
            name = "交易结束时间",
            required = false, type = "String(14)",
            example = "20091227091010",
            desc = "订单失效时间，格式为yyyyMMddHHmmss，"
                    + "如2009年12月27日9点10分10秒表示为20091227091010。注意：最短失效时间间隔需大于1分钟")
    @XStreamAlias("time_expire")
    private final String timeExpire;
    /**
     * 订单优惠标记.
     */
    @WxParameter(
            name = "订单优惠标记",
            required = false, type = "String(32)",
            example = "",
            desc = "订单优惠标记，代金券或立减优惠功能的参数，说明详见代金券或立减优惠")
    @XStreamAlias("goods_tag")
    private final String goodsTag;
    /**
     * 通知地址.
     */
    @WxParameter(
            name = "通知地址",
            required = true, type = "String(256)",
            example = "http://www.weixin.qq.com/wxpay/pay.php",
            desc = "接收微信支付异步通知回调地址，通知url必须为直接可访问的url，不能携带参数。")
    @XStreamAlias("notify_url")
    private final String notifyUrl;
    /**
     * 交易类型.
     */
    @WxParameter(
            name = "交易类型",
            required = true, type = "String(16)",
            example = "JSAPI",
            desc = "JSAPI -JSAPI支付\n"
                    + "NATIVE -Native支付\n"
                    + "APP -APP支付\n"
                    + "说明详见参数规定")
    @XStreamAlias("trade_type")
    private final String tradeType;
    /**
     * 商品ID.
     */
    @WxParameter(
            name = "商品ID",
            required = false, type = "String(32)",
            example = "12235413214070356458058",
            desc = "trade_type=NATIVE时，此参数必传。此id为二维码中包含的商品ID，商户自行定义。")
    @XStreamAlias("product_id")
    private final String productId;
    /**
     * 指定支付方式.
     */
    @WxParameter(
            name = "指定支付方式",
            required = false, type = "String(32)",
            example = "no_credit",
            desc = "no_credit--指定不能使用信用卡支付")
    @XStreamAlias("limit_pay")
    private final String limitPay;
    /**
     * 用户标识.
     */
    @WxParameter(
            name = "用户标识",
            required = false, type = "String(128)",
            example = "oUpF8uMuAJO_M2pxb1Q9zNjWeS6o",
            desc = "trade_type=JSAPI，此参数必传，用户在主商户appid下的唯一标识。"
                    + "openid和sub_openid可以选传其中之一，如果选择传sub_openid,则必须传sub_appid。"
                    + "下单前需要调用【网页授权获取用户信息】接口获取到用户的Openid。")
    @XStreamAlias("openid")
    private final String openid;
    /**
     * 用户标识.
     */
    @WxParameter(
            name = "用户子标识",
            required = false, type = "String(128)",
            example = "oUpF8uMuAJO_M2pxb1Q9zNjWeS6o",
            desc = "trade_type=JSAPI，此参数必传，用户在子商户appid下的唯一标识。"
                    + "openid和sub_openid可以选传其中之一，如果选择传sub_openid,则必须传sub_appid。"
                    + "下单前需要调用【网页授权获取用户信息】接口获取到用户的Openid。")
    @XStreamAlias("sub_openid")
    private final String subOpenid;
    /**
     * 电子发票入口开放标识.
     */
    @WxParameter(
            name = "电子发票入口开放标识",
            required = false, type = "String(8)",
            example = "Y",
            desc = "Y，传入Y时，支付成功消息和支付详情页将出现开票入口。"
                    + "需要在微信支付商户平台或微信公众平台开通电子发票功能，传此字段才可生效")
    @XStreamAlias("receipt")
    private final String receipt;
    /**
     * 是否需要分账.
     */
    @WxParameter(
            name = "是否需要分账",
            required = false, type = "String(16)",
            example = "Y",
            desc = "Y-是，需要分账\n"
                    + "N-否，不分账\n"
                    + "字母要求大写，不传默认不分账")
    @XStreamAlias("profit_sharing")
    private final String profitSharing;
    /**
     * 场景信息.
     */
    @WxParameter(
            name = "场景信息",
            required = false, type = "String(256)",
            example = "{\"store_info\" : {\n"
                    + "\"id\": \"SZTX001\",\n"
                    + "\"name\": \"腾大餐厅\",\n"
                    + "\"area_code\": \"440305\",\n"
                    + "\"address\": \"科技园中一路腾讯大厦\" }}",
            desc = "该字段用于上报场景信息，目前支持上报实际门店信息。"
                    + "该字段为JSON对象数据，对象格式为"
                    + "{\"store_info\":{\"id\": \"门店ID\",\"name\": \"名称\","
                    + "\"area_code\": \"编码\",\"address\": \"地址\" }}，"
                    + "字段详细说明请点击行前的+展开")
    @XStreamAlias("scene_info")
    private final String sceneInfo;
}
