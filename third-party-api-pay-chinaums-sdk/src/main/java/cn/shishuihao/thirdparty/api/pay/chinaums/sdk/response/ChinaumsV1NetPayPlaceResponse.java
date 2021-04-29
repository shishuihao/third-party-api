package cn.shishuihao.thirdparty.api.pay.chinaums.sdk.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

import java.util.Map;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Jacksonized
@ToString
@SuperBuilder
@Getter
public class ChinaumsV1NetPayPlaceResponse
        extends AbstractChinaumsResponse {
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
     * 清分ID 字符串 否.
     * 如果来源方传了bankRefId就等于bankRefId，否则等于seqId
     */
    @JsonProperty("settleRefId")
    private final String settleRefId;
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
     * JSAPI支付用的 请求报文，带有签名信息 Map 否.
     */
    @JsonProperty("jsPayRequest")
    private final Map<String, Object> jsPayRequest;
    /**
     * appPayRequest APP支付用的请 求报文，带有签名信息 Map 否.
     */
    @JsonProperty("appPayRequest")
    private final Map<String, Object> appPayRequest;
    /**
     * 支付ID，用于APP支付和公众号支付 字符串 ⇐64 否.
     */
    @JsonProperty("prepayId")
    private final String prepayId;
    /**
     * 支付二维码，内容为URL，由终端转换成二维码显示 字符串 ⇐64 否.
     */
    @JsonProperty("qrCode")
    private final String qrCode;
    /**
     * 支付渠道商户号 字符串 否.
     * 各渠道情况不同，酌情转换
     */
    @JsonProperty("targetMid")
    private final String targetMid;
    /**
     * 营销联盟优惠金额 字符串 否.
     */
    @JsonProperty("yxlmAmount")
    private final String yxlmAmount;
}
