package cn.shishuihao.thirdparty.api.pay.chinaums.sdk.request;

import cn.shishuihao.thirdparty.api.pay.chinaums.sdk.domain.RefundSubOrder;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

/**
 * 退款.
 * 当成功交易之后一段时间内，由于买家或商户的原因需要退款时，
 * 商户可以通过本接口将支付款退还给买家，退款请求验证成功之后，银商将通知支付渠道方按照退款规则把支付款按原路退回到买家帐号上。
 * 退款订单号refundOrderId也需遵循商户订单号生成规范，即以银商分配的4位来源编号作为账单号的前4位，且在商户系统中 此账单号保证唯一。
 * 总长度需大于6位，小于28位。
 * 银商的推荐规则为（无特殊情况下，建议遵守此规则）：{来源编号(4位)}{时间(yyyyMMddmmHHssSSS)(17位)}{7位随机数}
 *
 * @author shishuihao
 * @version 1.0.0
 */
@Jacksonized
@ToString
@SuperBuilder
@Getter
public class ChinaumsV1NetPayRefundRequest
        extends AbstractChinaumsRequest {
    /**
     * 商户订单号 字符串 6..64 是 原交易订单号.
     */
    @JsonProperty("merOrderId")
    private final String merOrderId;
    /**
     * 支付订单号 字符串 6..64 否.
     */
    @JsonProperty("targetOrderId")
    private final String targetOrderId;
    /**
     * 要退货的金额 数字型 1..100000000 是.
     * 若下单接口中上送了分账标记字 段divisionFlag，
     * 则该字段 refundAmount=subOrders 中totalAmount之和 +platformAmount.
     */
    @JsonProperty("refundAmount")
    private final Integer refundAmount;
    /**
     * 退款订单号 字符串 6..32 否.
     * 多次退款必传，每次退款上送的 refundOrderId值需不同，
     * 若多次退货，且后续退货上送的 merOrderId和refundOrderId字段与之前退货上送的值一致，将不会走退货逻辑，
     * 而是返回已有退货订单的退货信息，遵循商户订单号生成规范.
     */
    @JsonProperty("refundOrderId")
    private final String refundOrderId;
    /**
     * 平台商户退款分账金额 数字型 0..100000000 否.
     * 若原交易是分账交易，则分账金额必传，且退款接口 platformAmount小于下单接口中上送的platformAmount.
     */
    @JsonProperty("platformAmount")
    private final Integer platformAmount;
    /**
     * 子订单信息 数组→JSON 否.
     * 若原交易有分账，退款时必填。
     * 且退款接口totalAmount小于下单接口中上送的subOrders中对 应mid下的totalAmount。
     * （一 次只能对一个子商户进行退款 ）.
     */
    @JsonProperty("subOrders")
    private final RefundSubOrder[] subOrders;
    /**
     * 退货说明 字符串 ⇐255 否.
     */
    @JsonProperty("refundDesc")
    private final String refundDesc;
}
