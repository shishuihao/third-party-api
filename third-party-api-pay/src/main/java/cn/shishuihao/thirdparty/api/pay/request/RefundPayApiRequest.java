package cn.shishuihao.thirdparty.api.pay.request;

import cn.shishuihao.thirdparty.api.core.request.AbstractRequest;
import cn.shishuihao.thirdparty.api.pay.PayApiRequest;
import cn.shishuihao.thirdparty.api.pay.api.RefundPayApi;
import cn.shishuihao.thirdparty.api.pay.response.RefundPayApiResponse;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

import javax.validation.constraints.Min;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Getter
@Jacksonized
@SuperBuilder
public class RefundPayApiRequest extends AbstractRequest<
        RefundPayApi,
        RefundPayApiRequest,
        RefundPayApiResponse> implements PayApiRequest<
        RefundPayApi,
        RefundPayApiRequest,
        RefundPayApiResponse> {
    /**
     * channel transaction id.
     */
    private final String channelTransactionId;
    /**
     * out trade no.
     */
    private final String outTradeNo;
    /**
     * refund total amount.
     */
    @Min(1)
    private final int refundAmount;

    /**
     * get api type.
     * immutable
     *
     * @return api type
     */
    @Override
    public Class<RefundPayApi> apiType() {
        return RefundPayApi.class;
    }

    /**
     * get response type.
     * immutable
     *
     * @return response type
     */
    @Override
    public Class<RefundPayApiResponse> responseType() {
        return RefundPayApiResponse.class;
    }
}
