package cn.shishuihao.thirdparty.api.pay.wechat.domain;

import cn.shishuihao.thirdparty.api.pay.domain.transaction.RefundStatus;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author admin
 * @version 1.0.0
 */

public enum WechatRefundStatus {
    /**
     * 退款成功.
     */
    SUCCESS,
    /**
     * 退款关闭.
     */
    REFUNDCLOSE,
    /**
     * 退款处理中.
     */
    PROCESSING,
    /**
     * 退款异常.
     */
    CHANGE;
    /**
     * lookup.
     */
    private static final Map<String, WechatRefundStatus> LOOKUP
            = Arrays.stream(values())
            .collect(Collectors.toMap(Enum::name, it -> it));

    /**
     * value of.
     *
     * @param value value
     * @return WechatRefundStatus
     */
    public static WechatRefundStatus of(final String value) {
        return LOOKUP.get(value);
    }

    /**
     * refund status of.
     *
     * @param status status
     * @return RefundStatus
     */
    public static RefundStatus refundStatusOf(final String status) {
        return refundStatusOf(of(status));
    }

    /**
     * refund status of.
     *
     * @param status status
     * @return RefundStatus
     */
    public static RefundStatus refundStatusOf(final WechatRefundStatus status) {
        if (status == null) {
            return null;
        }
        switch (status) {
            case PROCESSING:
                return RefundStatus.REFUND_PROCESSING;
            case SUCCESS:
                return RefundStatus.REFUND_SUCCESS;
            case CHANGE:
                return RefundStatus.REFUND_FAIL;
            case REFUNDCLOSE:
                return RefundStatus.REFUND_CLOSED;
            default:
                return null;
        }
    }

    /**
     * refund statuses of.
     *
     * @param refundStatuses refundStatuses
     * @return RefundStatus[]
     */
    public static RefundStatus[] refundStatusesOf(
            final List<String> refundStatuses) {
        if (refundStatuses == null) {
            return new RefundStatus[0];
        }
        return refundStatuses.stream()
                .map(WechatRefundStatus::refundStatusOf)
                .toArray(RefundStatus[]::new);
    }
}
