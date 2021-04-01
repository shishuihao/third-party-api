package cn.shishuihao.thirdparty.api.pay.alipay.domain;

import cn.shishuihao.thirdparty.api.pay.domain.transaction.TradeStatus;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author admin
 * @version 1.0.0
 */

public enum AlipayTradeStatus {
    /**
     * 交易创建，等待买家付款.
     */
    WAIT_BUYER_PAY,
    /**
     * 未付款交易超时关闭，或支付完成后全额退款.
     */
    TRADE_CLOSED,
    /**
     * 交易支付成功.
     */
    TRADE_SUCCESS,
    /**
     * 交易结束，不可退款.
     */
    TRADE_FINISHED;
    /**
     * lookup.
     */
    private static final Map<String, AlipayTradeStatus> LOOKUP
            = Arrays.stream(values())
            .collect(Collectors.toMap(Enum::toString, it -> it));

    /**
     * value of.
     *
     * @param status status
     * @return AlipayTradeStatus
     */
    public static AlipayTradeStatus of(final String status) {
        return LOOKUP.get(status);
    }

    /**
     * trade status of.
     *
     * @param status status
     * @return TradeStatus
     */
    public static TradeStatus tradeStatusOf(final String status) {
        return tradeStatusOf(of(status));
    }

    /**
     * trade status of.
     *
     * @param status status
     * @return TradeStatus
     */
    public static TradeStatus tradeStatusOf(final AlipayTradeStatus status) {
        if (status == null) {
            return null;
        }
        switch (status) {
            case WAIT_BUYER_PAY:
                return TradeStatus.WAIT_BUYER_PAY;
            case TRADE_CLOSED:
                return TradeStatus.TRADE_CLOSED;
            case TRADE_SUCCESS:
                return TradeStatus.TRADE_SUCCESS;
            case TRADE_FINISHED:
                return TradeStatus.TRADE_FINISHED;
            default:
                return null;
        }
    }
}
