package cn.shishuihao.thirdparty.api.pay.chinaums.sdk.domain;

/**
 * @author shishuihao
 * @version 1.0.0
 */
public enum ChinaumsRefundStatus {
    /**
     * UNKNOWN 不明确的交易状态 需要调退款查询接口确认退款结果.
     */
    UNKNOWN,
    /**
     * 退款成功.
     */
    SUCCESS,
    /**
     * 退款失败.
     */
    FAIL,
    /**
     * 需要调退款查询接口确认退款结果.
     */
    PROCESSING;

    /**
     * value of.
     *
     * @param status status
     * @return ChinaumsRefundStatus
     */
    public static ChinaumsRefundStatus of(final String status) {
        return status == null ? null : ChinaumsRefundStatus.valueOf(status);
    }
}
