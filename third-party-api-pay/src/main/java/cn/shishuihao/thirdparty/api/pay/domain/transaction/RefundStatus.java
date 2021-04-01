package cn.shishuihao.thirdparty.api.pay.domain.transaction;

/**
 * trade status.
 *
 * @author shishuihao
 * @version 1.0.0
 */

public enum RefundStatus {
    /**
     * REFUND_PROCESSING.
     */
    REFUND_PROCESSING,
    /**
     * TRADE_UNKNOWN.
     */
    REFUND_UNKNOWN,
    /**
     * 支付成功 => 交易支付成功，可退款.
     */
    REFUND_SUCCESS,
    /**
     * TRADE_FAIL.
     */
    REFUND_FAIL,
    /**
     * 交易关闭 => TRADE_CLOSED.
     */
    REFUND_CLOSED;

    /**
     * able to refund.
     *
     * @return boolean
     */
    public boolean isRefundable() {
        return false;
    }
}
