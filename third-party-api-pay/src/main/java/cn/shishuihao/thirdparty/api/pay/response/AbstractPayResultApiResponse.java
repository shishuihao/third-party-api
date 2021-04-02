package cn.shishuihao.thirdparty.api.pay.response;

import cn.shishuihao.thirdparty.api.core.response.BaseApiResponse;
import cn.shishuihao.thirdparty.api.pay.PayApiResponse;
import cn.shishuihao.thirdparty.api.pay.domain.transaction.TradeStatus;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Getter
@SuperBuilder
public abstract class AbstractPayResultApiResponse
        extends BaseApiResponse
        implements PayApiResponse {
    /**
     * 支付渠道生成的订单号.
     */
    private final String channelTransactionId;
    /**
     * 付款银行.
     */
    private final String bankType;
    /**
     * 支付币种.
     */
    private final String payCurrency;
    /**
     * 支付总金额.
     */
    private final Integer payTotalAmount;
    /**
     * 结算币种.
     */
    private final String settleCurrency;
    /**
     * 结算总金额.
     */
    private final Integer settleTotalAmount;
    /**
     * 交易状态.
     */
    private final TradeStatus tradeStatus;
}
