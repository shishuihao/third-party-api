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
public class ChinaumsV1NetPayQueryResponse
        extends AbstractChinaumsResponse {
    /**
     * 平台流水号 字符串 否.
     */
    @JsonProperty("seqId")
    private final String seqId;
    /**
     * 清分ID 字符串 否.
     * 如果来源方传了bankRefId就等于bankRefId，否则等于seqId
     */
    @JsonProperty("settleRefId")
    private final String settleRefId;
    /**
     * 检索参考号 字符串 否 .
     * 用在银联体系交易中
     */
    @JsonProperty("refId")
    private final String refId;
    /**
     * 交易状态 字符串 否.
     */
    @JsonProperty("status")
    private final String status;
    /**
     * 支付总金额 数字型 否.
     */
    @JsonProperty("totalAmount")
    private final Integer totalAmount;
    /**
     * 商户名称 字符串 否.
     */
    @JsonProperty("merName")
    private final String merName;
    /**
     * 商户订单号 字符串 否.
     */
    @JsonProperty("merOrderId")
    private final String merOrderId;
    /**
     * 目标平台单号 字符串 否.
     */
    @JsonProperty("targetOrderId")
    private final String targetOrderId;
    /**
     * 目标平台代码 字符串 否.
     */
    @JsonProperty("targetSys")
    private final String targetSys;
    /**
     * 目标平台状态 字符串 否.
     */
    @JsonProperty("targetStatus")
    private final String targetStatus;
    /**
     * 买家ID 字符串 否.
     */
    @JsonProperty("buyerId")
    private final String buyerId;
    /**
     * 支付渠道商户号 字符串 否.
     * 各渠道情况不同，酌情转换
     */
    @JsonProperty("targetMid")
    private final String targetMid;
    /**
     * 银行卡号 字符串 否.
     */
    @JsonProperty("bankCardNo")
    private final String bankCardNo;
    /**
     * 银行信息 字符串 否.
     */
    @JsonProperty("bankInfo")
    private final String bankInfo;
    /**
     * 支付渠道列表 字符串 是 格式为：
     * 方式:金 额（单位：分）| 方式:金额|…….
     */
    @JsonProperty("billFunds")
    private final String billFunds;
    /**
     * 支付渠道描述 字符串 是.
     */
    @JsonProperty("billFundsDesc")
    private final String billFundsDesc;
    /**
     * 买家付款的金额 数字型 否.
     * 支付宝会有.
     */
    @JsonProperty("buyerPayAmount")
    private final Integer buyerPayAmount;
    /**
     * 账单支付信息 JSON 否.
     * 若涉及营销联盟优惠，则账单流水总金额为优惠后的总金额.
     */
    @JsonProperty("billPayment")
    private final String billPayment;
    /**
     * 买家用户名 字符串 否.
     */
    @JsonProperty("buyerUsername")
    private final String buyerUsername;
    /**
     * 网付计算的优惠 金额 数字型 否.
     */
    @JsonProperty("couponAmount")
    private final Integer couponAmount;
    /**
     * 交易中可给用户开具发票的金额 数字型 否.
     */
    @JsonProperty("invoiceAmount")
    private final Integer invoiceAmount;
    /**
     * 支付时间 字符串 是 格式yyyy-MM-dd HH:mm:ss.
     */
    @JsonProperty("payTime")
    private final String payTime;
    /**
     * 商户实收金额 数字型 否 支付宝会有.
     */
    @JsonProperty("receiptAmount")
    private final Integer receiptAmount;
    /**
     * 结算日期 字符串 否 格式yyyy-MM-dd.
     */
    @JsonProperty("settleDate")
    private final String settleDate;
    /**
     * 子买家ID 字符串 否 如微信的subOpenId.
     */
    @JsonProperty("subBuyerId")
    private final String subBuyerId;
    /**
     * 营销联盟优惠金额 字符串 否.
     */
    @JsonProperty("yxlmAmount")
    private final String yxlmAmount;
    /**
     * 微信活动ID 字符串 否.
     */
    @JsonProperty("activityIds")
    private final String activityIds;
}
