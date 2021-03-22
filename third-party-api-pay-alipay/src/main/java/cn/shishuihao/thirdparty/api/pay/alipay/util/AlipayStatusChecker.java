package cn.shishuihao.thirdparty.api.pay.alipay.util;

import cn.shishuihao.thirdparty.api.pay.domain.order.OrderStatus;

/**
 * @author shishuihao
 * @version 1.0.0
 */
public final class AlipayStatusChecker {
    private AlipayStatusChecker() {
    }

    public static OrderStatus status(String tradeStatus) {
        if (tradeStatus == null) {
            return null;
        }
        switch (tradeStatus) {
            case "WAIT_BUYER_PAY":
                return OrderStatus.PAY_PROCESSED;
            case "TRADE_CLOSED":
                return OrderStatus.CANCEL_SUCCEEDED;
            case "TRADE_SUCCESS":
                return OrderStatus.PAY_SUCCEEDED;
            case "TRADE_FINISHED":
                return OrderStatus.FINISHED;
            default:
                return null;
        }
    }
}
