package cn.shishuihao.thirdparty.api.pay.chinaums.sdk.domain;

/**
 * @author shishuihao
 * @version 1.0.0
 */
public enum ChinaumsSecureStatus {
    /**
     * 担保未完成 担保未完成的交易不允许直接做反交易.
     */
    UNCOMPLETED,
    /**
     * 担保已完成，部分完成 .
     */
    PARTLY_COMPLETED,
    /**
     * 担保已完成，全部完成 .
     */
    ALL_COMPLETED,
    /**
     * 担保已撤销.
     */
    CANCELED;

    /**
     * value of.
     *
     * @param status status
     * @return ChinaumsRefundStatus
     */
    public static ChinaumsSecureStatus of(final String status) {
        return status == null ? null : ChinaumsSecureStatus.valueOf(status);
    }
}
