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
public class ChinaumsV1NetPayCloseResponse
        extends AbstractChinaumsResponse {
    /**
     * 结算日期 字符串 否 格式yyyy-MM-dd.
     */
    @JsonProperty("settleDate")
    private final String settleDate;
    /**
     * 清分ID 字符串 否.
     * 如果来源方传了bankRefId就等于bankRefId，否则等于seqId
     */
    @JsonProperty("settleRefId")
    private final String settleRefId;
    /**
     * 支付渠道商户号 字符串 否.
     * 各渠道情况不同，酌情转换
     */
    @JsonProperty("targetMid")
    private final String targetMid;
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
}
