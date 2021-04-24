package cn.shishuihao.thirdparty.api.pay.wechat.domain;

import cn.shishuihao.thirdparty.api.pay.domain.transaction.TradeStatus;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author admin
 * @version 1.0.0
 */

public enum WechatTradeStatus {
    /**
     * 支付成功.
     */
    SUCCESS,
    /**
     * 转入退款.
     */
    REFUND,
    /**
     * 未支付.
     */
    NOTPAY,
    /**
     * 已关闭.
     */
    CLOSED,
    /**
     * 已撤销（刷卡支付）.
     */
    REVOKED,
    /**
     * 用户支付中.
     */
    USERPAYING,
    /**
     * 支付失败(其他原因，如银行返回失败).
     */
    PAYERROR,
    /**
     * ACCEPT--已接收，等待扣款.
     */
    ACCEPT;
    /**
     * lookup.
     */
    private static final Map<String, WechatTradeStatus> LOOKUP
            = Arrays.stream(values())
            .collect(Collectors.toMap(Enum::name, it -> it));

    /**
     * value of.
     *
     * @param status status
     * @return WechatTradeStatus
     */
    public static WechatTradeStatus of(final String status) {
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
    public static TradeStatus tradeStatusOf(final WechatTradeStatus status) {
        if (status == null) {
            return null;
        }
        switch (status) {
            case NOTPAY:
                return TradeStatus.NEW;
            case USERPAYING:
            case ACCEPT:
                return TradeStatus.WAIT_BUYER_PAY;
            case SUCCESS:
                return TradeStatus.TRADE_SUCCESS;
            case PAYERROR:
                return TradeStatus.TRADE_FAIL;
            case CLOSED:
                return TradeStatus.TRADE_CLOSED;
            case REVOKED:
                return TradeStatus.TRADE_REVOKED;
            case REFUND:
                return TradeStatus.TRADE_REFUND;
            default:
                return null;
        }
    }
}
