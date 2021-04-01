package cn.shishuihao.thirdparty.api.pay.alipay.domain;

import cn.shishuihao.thirdparty.api.pay.domain.transaction.RefundStatus;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author admin
 * @version 1.0.0
 */

public enum AlipayRefundStatus {
    /**
     * 退款处理成功.
     */
    REFUND_SUCCESS,
    /**
     * 退款失败.
     */
    REFUND_FAIL;
    /**
     * lookup.
     */
    private static final Map<String, AlipayRefundStatus> LOOKUP
            = Arrays.stream(values())
            .collect(Collectors.toMap(Enum::toString, it -> it));

    /**
     * value of.
     *
     * @param value value
     * @return AlipayRefundStatus
     */
    public static AlipayRefundStatus of(final String value) {
        return LOOKUP.get(value);
    }

    /**
     * refund status of.
     *
     * @param status status
     * @return TradeStatus
     */
    public static RefundStatus refundStatusOf(final String status) {
        return refundStatusOf(of(status));
    }

    /**
     * refund status of.
     *
     * @param status status
     * @return TradeStatus
     */
    public static RefundStatus refundStatusOf(final AlipayRefundStatus status) {
        if (status == null) {
            return null;
        }
        switch (status) {
            case REFUND_SUCCESS:
                return RefundStatus.REFUND_SUCCESS;
            case REFUND_FAIL:
                return RefundStatus.REFUND_FAIL;
            default:
                return null;
        }
    }
}
