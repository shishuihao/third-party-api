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
     * 交易状态.
     */
    private final TradeStatus tradeStatus;
    /**
     * 退款状态.
     */
    private final RefundStatus refundStatus;
}
