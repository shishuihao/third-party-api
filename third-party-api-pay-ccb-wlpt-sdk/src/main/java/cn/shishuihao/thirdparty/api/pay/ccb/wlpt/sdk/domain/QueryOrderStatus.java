package cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.domain;

/**
 * 订单状态.
 */
public enum QueryOrderStatus {
    /**
     * 0:交易失败.
     */
    TRADE_FAIL,
    /**
     * 1:交易成功.
     */
    TRADE_SUCCESS,
    /**
     * 2:待银行确认.
     */
    TRADE_UNKNOWN,
    /**
     * 3:全部.
     */
    ALL
}
