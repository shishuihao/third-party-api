package cn.shishuihao.thirdparty.api.pay.icbc.domain;

import cn.shishuihao.thirdparty.api.pay.domain.transaction.RefundStatus;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author admin
 * @version 1.0.0
 */

public enum IcbcRefundStatus {
    /**
     * 0：退款可疑.
     */
    REFUND_UNKNOWN,
    /**
     * 1：退款成功.
     */
    REFUND_SUCCESS,
    /**
     * 2：退款失败.
     */
    REFUND_FAIL;
    /**
     * lookup.
     */
    private static final Map<Integer, IcbcRefundStatus> LOOKUP
            = Arrays.stream(values())
            .collect(Collectors.toMap(Enum::ordinal, it -> it));

    /**
     * value of.
     *
     * @param value value
     * @return IcbcRefundStatus
     */
    public static IcbcRefundStatus of(final String value) {
        return LOOKUP.get(Integer.valueOf(value));
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
    public static RefundStatus refundStatusOf(final IcbcRefundStatus status) {
        if (status == null) {
            return null;
        }
        switch (status) {
            case REFUND_UNKNOWN:
                return RefundStatus.REFUND_UNKNOWN;
            case REFUND_SUCCESS:
                return RefundStatus.REFUND_SUCCESS;
            case REFUND_FAIL:
                return RefundStatus.REFUND_FAIL;
            default:
                return null;
        }
    }

    /**
     * refund status of.
     *
     * @param refundList refundList
     * @return RefundStatus
     */
    public static RefundStatus refundStatusOf(
            final List<IcbcRefund> refundList) {
        if (refundList == null || refundList.isEmpty()) {
            return null;
        }
        final List<IcbcRefundStatus> statusList = refundList.stream()
                .map(it -> of(it.getRejectStatus()))
                .collect(Collectors.toList());
        // 全额退款 all REFUND_SUCCESS
        if (statusList.stream()
                .allMatch(it -> it == REFUND_SUCCESS)) {
            return RefundStatus.REFUND_SUCCESS;
        }
        // 退款状态未知 any REFUND_UNKNOWN
        if (statusList.stream()
                .anyMatch(it -> it == REFUND_UNKNOWN)) {
            return RefundStatus.REFUND_UNKNOWN;
        }
        // 部分退款 any REFUND_SUCCESS
        if (statusList.stream()
                .anyMatch(it -> it == REFUND_SUCCESS)) {
            return RefundStatus.REFUND_PARTIAL;
        }
        // all REFUND_FAIL
        return RefundStatus.REFUND_FAIL;
    }
}
