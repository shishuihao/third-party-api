package cn.shishuihao.thirdparty.api.pay.chinaums.sdk.domain;

/**
 * @author shishuihao
 * @version 1.0.0
 */
public enum ChinaumsStatus {
    /**
     * NEW_ORDER 新订单.
     */
    NEW_ORDER,
    /**
     * UNKNOWN 不明确的交易状态.
     */
    UNKNOWN,
    /**
     * TRADE_CLOSED 在指定时间段内未支付时关闭的交易； 在交易完成全额退款成功时关闭的交易；支付失败的交易.
     * TRADE_CLOSED的交易不允许进行任何操作。
     */
    TRADE_CLOSED,
    /**
     * WAIT_BUYER_PAY 交易创建，等待买家付款.
     */
    WAIT_BUYER_PAY,
    /**
     * TRADE_SUCCESS 支付成功.
     */
    TRADE_SUCCESS,
    /**
     * TRADE_REFUND 订单转入退货流程 退货可能是部分也可能是全部.
     */
    TRADE_REFUND;

    /**
     * value of.
     *
     * @param status status
     * @return ChinaumsStatus
     */
    public static ChinaumsStatus of(final String status) {
        return status == null ? null : ChinaumsStatus.valueOf(status);
    }
}
