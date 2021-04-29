package cn.shishuihao.thirdparty.api.pay.chinaums.sdk.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Jacksonized
@ToString
@SuperBuilder
@Getter
public class ChinaumsV1NetPayRefundResponse
        extends AbstractChinaumsResponse {
    /**
     * 商户订单号 字符串 否.
     */
    @JsonProperty("merOrderId")
    private final String merOrderId;
    /**
     * 商户名称 字符串 否.
     */
    @JsonProperty("merName")
    private final String merName;
    /**
     * 交易状态 字符串 否.
     */
    @JsonProperty("status")
    private final String status;
    /**
     * 支付渠道商户号 字符串 否.
     * 各渠道情况不同，酌情转换
     */
    @JsonProperty("targetMid")
    private final String targetMid;
    /**
     * 目标平台单号 字符串 否.
     */
    @JsonProperty("targetOrderId")
    private final String targetOrderId;
    /**
     * 目标平台状态 字符串 否.
     */
    @JsonProperty("targetStatus")
    private final String targetStatus;
    /**
     * 目标平台代码 字符串 否.
     */
    @JsonProperty("targetSys")
    private final String targetSys;
    /**
     * 支付总金额 数字型 否.
     */
    @JsonProperty("totalAmount")
    private final Integer totalAmount;
    /**
     * 总退款金额 数字型 否.
     */
    @JsonProperty("refundAmount")
    private final Integer refundAmount;
    /**
     * 退款渠道列表 字符串 否.
     */
    @JsonProperty("refundFunds")
    private final String refundFunds;
    /**
     * 退款渠道描述 字符串 否.
     */
    @JsonProperty("refundFundsDesc")
    private final String refundFundsDesc;
    /**
     * 实付部分退款 金额 数字型 否.
     */
    @JsonProperty("refundInvoiceAmount")
    private final Integer refundInvoiceAmount;
    /**
     * 退货订单号 字符串 否.
     */
    @JsonProperty("refundOrderId")
    private final String refundOrderId;
    /**
     * 目标系统退货订单号 字符串 否.
     */
    @JsonProperty("refundTargetOrderId")
    private final String refundTargetOrderId;
    /**
     * 营销联盟优惠金额 字符串 否.
     */
    @JsonProperty("yxlmAmount")
    private final String yxlmAmount;
    /**
     * 退款状态 字符串 否.
     */
    @JsonProperty("refundStatus")
    private final String refundStatus;
}
