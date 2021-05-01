package cn.shishuihao.thirdparty.api.pay.sdk.request;

import cn.shishuihao.thirdparty.api.pay.sdk.domain.RefundAmount;
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
public class PayV1RefundsRequest
        extends AbstractPayV1Request {
    /**
     * 交易id.
     */
    private final String transactionId;
    /**
     * 商户订单号.
     */
    private final String outTradeNo;
    /**
     * 商户退款单号.
     */
    private final String outRefundNo;
    /**
     * 退款原因.
     */
    private final String reason;
    /**
     * 通知地址.
     */
    private final String notifyUrl;
    /**
     * 金额信息.
     */
    private final RefundAmount amount;
}
