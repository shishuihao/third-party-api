package cn.shishuihao.thirdparty.api.pay.ccb.wlpt.domain;

import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.domain.CcbWlptOrderStatus;
import cn.shishuihao.thirdparty.api.pay.domain.transaction.RefundStatus;

/**
 * @author admin
 * @version 1.0.0
 */

public final class CcbWlptRefundStatus {
    private CcbWlptRefundStatus() {
    }

    /**
     * refund status of.
     *
     * @param status status
     * @return RefundStatus
     */
    public static RefundStatus refundStatusOf(final Integer status) {
        return refundStatusOf(CcbWlptOrderStatus.of(status));
    }

    /**
     * refund status of.
     *
     * @param status status
     * @return RefundStatus
     */
    public static RefundStatus refundStatusOf(final CcbWlptOrderStatus status) {
        if (status == null) {
            return null;
        }
        switch (status) {
            case REFUND_UNKNOWN:
                return RefundStatus.REFUND_UNKNOWN;
            case REFUND_FULL:
                return RefundStatus.REFUND_SUCCESS;
            case REFUND_PARTIAL:
                return RefundStatus.REFUND_PARTIAL;
            default:
                return null;
        }
    }
}
