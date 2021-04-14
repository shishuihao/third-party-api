package cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.domain;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author admin
 * @version 1.0.0
 */

public enum CcbWlptOrderStatus {
    /**
     * 0:失败.
     */
    TRADE_FAIL,
    /**
     * 1:成功.
     */
    TRADE_SUCCESS,
    /**
     * 2:待银行确认.
     */
    TRADE_UNKNOWN,
    /**
     * 3:已部分退款.
     */
    REFUND_PARTIAL,
    /**
     * 4:已全额退款.
     */
    REFUND_FULL,
    /**
     * 5:待银行确认.
     */
    REFUND_UNKNOWN;
    /**
     * lookup.
     */
    private static final Map<Integer, CcbWlptOrderStatus> LOOKUP
            = Arrays.stream(values())
            .collect(Collectors.toMap(Enum::ordinal, it -> it));

    /**
     * value of.
     *
     * @param status status
     * @return CcbWlptOrderStatus
     */
    public static CcbWlptOrderStatus of(final Integer status) {
        return LOOKUP.get(status);
    }
}
