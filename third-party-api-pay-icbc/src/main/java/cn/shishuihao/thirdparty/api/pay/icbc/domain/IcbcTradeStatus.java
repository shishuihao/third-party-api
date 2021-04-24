package cn.shishuihao.thirdparty.api.pay.icbc.domain;

import cn.shishuihao.thirdparty.api.pay.domain.transaction.TradeStatus;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author admin
 * @version 1.0.0
 */

public enum IcbcTradeStatus {
    /**
     * 0：支付中.
     */
    WAIT_BUYER_PAY,
    /**
     * 1：支付成功.
     */
    TRADE_SUCCESS,
    /**
     * 2：支付失败.
     */
    TRADE_FAIL;
    /**
     * lookup.
     */
    private static final Map<Integer, IcbcTradeStatus> LOOKUP
            = Arrays.stream(values())
            .collect(Collectors.toMap(Enum::ordinal, it -> it));

    /**
     * value of.
     *
     * @param status status
     * @return IcbcTradeStatus
     */
    public static IcbcTradeStatus of(final String status) {
        return LOOKUP.get(Integer.valueOf(status));
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
    public static TradeStatus tradeStatusOf(final IcbcTradeStatus status) {
        if (status == null) {
            return null;
        }
        switch (status) {
            case WAIT_BUYER_PAY:
                return TradeStatus.WAIT_BUYER_PAY;
            case TRADE_SUCCESS:
                return TradeStatus.TRADE_SUCCESS;
            case TRADE_FAIL:
                return TradeStatus.TRADE_FAIL;
            default:
                return null;
        }
    }
}
