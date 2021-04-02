package cn.shishuihao.thirdparty.api.pay.response;

import cn.shishuihao.thirdparty.api.core.response.BaseApiResponse;
import cn.shishuihao.thirdparty.api.pay.PayApiResponse;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Getter
@SuperBuilder
public class CancelPayApiResponse
        extends BaseApiResponse
        implements PayApiResponse {
    /**
     * 支付渠道生成的订单号.
     */
    private final String channelTransactionId;
    /**
     * retry.
     */
    private final boolean retry;
}
