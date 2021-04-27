package cn.shishuihao.thirdparty.api.pay.fuioupay.sdk.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@ToString
@SuperBuilder
@Getter
public class FuiouPaySmpGateRequest
        extends AbstractFuiouPayRequest {
    /**
     * 商户订单号  MAX(30).
     * 客户支付后商户网站产生的一个唯一的定单号，该订单号应该在相当 长的时间内不重复。
     * 富友通过订单号来唯一确认一笔订单的重复性。
     * 必填
     * 11032302065863805732
     */
    @JsonProperty("order_id")
    private final String orderId;
    /**
     * 交易金额  MAX(12).
     * 客户支付订单的总金额，一笔订单一个，以分为单位。
     * 不可以为零，必需符合金额标准。
     * 必填
     * 2000
     */
    @JsonProperty("order_amt")
    private final Integer orderAmount;
    /**
     * 支付类型  3.
     * ‘B2C’  – B2C 支付
     * ‘B2B’  – B2B 支付
     * ‘FYCD’ – 预付卡
     * ‘SXF’  – 随心富
     * 必填
     * B2C
     */
    @JsonProperty("order_pay_type")
    private final String orderPayType;
    /**
     * 页面跳转URL  MAX(200).
     * 商户接收支付结果通知地址
     * 必填
     * http://192.168.9.7:8080/paytest/result.jsp
     */
    @JsonProperty("page_notify_url")
    private final String pageNotifyUrl;
    /**
     * 后台通知URL  MAX(200).
     * 商户接收支付结果后台通知地址
     * 非必填
     * http://192.168.9.7:8080/paytest/result.jsp
     */
    @JsonProperty("back_notify_url")
    private final String backNotifyUrl;
    /**
     * 超时时间  2.
     * 1m-15 天，m：分钟、h：小时、d 天、 1c 当天有效，
     * 非必填
     * 10m
     */
    @JsonProperty("order_valid_time")
    private final String orderValidTime;
    /**
     * 银行代码  10.
     * '0801020000' - 中国工商银行
     * '0801030000' - 中国农业银行
     * '0801040000' – 中国银行
     * '0801050000' - 中国建设银行
     * '0803010000' - 交通银行
     * '0801000000' - 邮政储蓄
     * '0803080000' - 招商银行
     * '0803100000' - 上海浦东发展银行
     * '0803030000' - 中国光大银行
     * '0803050000' - 中国民生银行
     * '0803020000' - 中信银行
     * '0803060000' - 广发银行
     * '0803040000' - 华夏银行
     * '0803090000' - 兴业银行
     * '0000000000' – 其他银行
     * 必填
     * 0803010000
     */
    @JsonProperty("iss_ins_cd")
    private final String issuingInstitutionCode;
    /**
     * 商品名称  MAX(60).
     * 非必填
     * SonyW5500 液晶 电视(test)
     */
    @JsonProperty("goods_name")
    private final String goodsName;
    /**
     * 商品展示网址  MAX(200) .
     * 非必填
     * http://192.168.9.7:8080/paytest/goods_display.jsp
     */
    @JsonProperty("goods_display_url")
    private final String goodsDisplayUrl;
    /**
     * 备注  MAX(60) 非必填.
     * 备注
     */
    @JsonProperty("rem")
    private final String rem;
    /**
     * 版本号 ver MAX(10).
     * 目前填 1.0.1
     * 必填
     * 1.0.1
     */
    @JsonProperty("ver")
    private final String version;
}
