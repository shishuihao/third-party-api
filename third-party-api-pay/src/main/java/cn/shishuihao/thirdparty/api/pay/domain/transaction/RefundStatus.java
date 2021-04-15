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
     * REFUND_SUCCESS.
     */
    REFUND_SUCCESS,
    /**
     * REFUND_PARTIAL.
     */
    REFUND_PARTIAL,
    /**
     * TRADE_FAIL.
     */
    REFUND_FAIL,
    /**
     * TRADE_CLOSED.
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
