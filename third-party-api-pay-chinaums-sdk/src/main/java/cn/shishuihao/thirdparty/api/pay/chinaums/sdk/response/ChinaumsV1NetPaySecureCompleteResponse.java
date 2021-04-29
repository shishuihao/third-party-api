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
public class ChinaumsV1NetPaySecureCompleteResponse
        extends AbstractChinaumsResponse {
    /**
     * 商户订单号 字符串 否.
     */
    @JsonProperty("merOrderId")
    private final String merOrderId;
    /**
     * 担保交易状态 字符串 否.
     */
    @JsonProperty("secureStatus")
    private final String secureStatus;
    /**
     * 担保完成金额 字符串 否.
     */
    @JsonProperty("completedAmount")
    private final Integer completedAmount;
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
     * cardAttr.
     */
    @JsonProperty("cardAttr")
    private final String cardAttr;
    /**
     * 目标平台单号 字符串 否.
     */
    @JsonProperty("targetOrderId")
    private final String targetOrderId;
    /**
     * 交易状态 字符串 否.
     */
    @JsonProperty("status")
    private final String status;
    /**
     * 目标平台代码 字符串 否.
     */
    @JsonProperty("targetSys")
    private final String targetSys;
}
