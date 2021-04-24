package cn.shishuihao.thirdparty.api.pay.response;

import cn.shishuihao.thirdparty.api.core.response.BaseApiResponse;
import cn.shishuihao.thirdparty.api.pay.PayApiResponse;
import cn.shishuihao.thirdparty.api.pay.domain.transaction.RefundStatus;
import cn.shishuihao.thirdparty.api.pay.domain.transaction.TradeStatus;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Getter
@SuperBuilder
public class RefundQueryPayApiResponse
        extends BaseApiResponse
        implements PayApiResponse {
    /**
     * 支付渠道生成的订单号.
     */
    private final String channelTransactionId;
    /**
     * 交易状态.
     */
    private final TradeStatus tradeStatus;
    /**
     * out trade no.
     */
    private final String[] outRefundNos;
    /**
     * 支付渠道生成的退款号.
     */
    private final String[] channelRefundIds;
    /**
     * 退款状态.
     */
    private final RefundStatus[] refundStatuses;
}
