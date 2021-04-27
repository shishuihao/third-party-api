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
public class FuiouPaySmpQueryGateRequest
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
}
