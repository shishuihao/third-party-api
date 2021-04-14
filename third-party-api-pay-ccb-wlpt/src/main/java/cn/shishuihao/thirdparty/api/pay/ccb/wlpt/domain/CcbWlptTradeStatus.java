package cn.shishuihao.thirdparty.api.pay.ccb.wlpt.domain;

import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.domain.CcbWlptOrderStatus;
import cn.shishuihao.thirdparty.api.pay.domain.transaction.TradeStatus;

/**
 * @author admin
 * @version 1.0.0
 */

public final class CcbWlptTradeStatus {
    private CcbWlptTradeStatus() {
    }

    /**
     * trade status of.
     *
     * @param status status
     * @return TradeStatus
     */
    public static TradeStatus tradeStatusOf(final Integer status) {
        return tradeStatusOf(CcbWlptOrderStatus.of(status));
    }

    /**
     * trade status of.
     *
     * @param status status
     * @return TradeStatus
     */
    public static TradeStatus tradeStatusOf(final CcbWlptOrderStatus status) {
        if (status == null) {
            return null;
        }
        switch (status) {
            case TRADE_UNKNOWN:
                return TradeStatus.TRADE_UNKNOWN;
            case TRADE_SUCCESS:
                return TradeStatus.TRADE_SUCCESS;
            case TRADE_FAIL:
                return TradeStatus.TRADE_FAIL;
            default:
                return null;
        }
    }
}
