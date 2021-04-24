package cn.shishuihao.thirdparty.api.pay.request;

import cn.shishuihao.thirdparty.api.core.request.AbstractRequest;
import cn.shishuihao.thirdparty.api.pay.PayApiRequest;
import cn.shishuihao.thirdparty.api.pay.api.RefundQueryPayApi;
import cn.shishuihao.thirdparty.api.pay.response.RefundQueryPayApiResponse;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

import javax.validation.constraints.NotBlank;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Getter
@Jacksonized
@SuperBuilder
public class RefundQueryPayApiRequest extends AbstractRequest<
        RefundQueryPayApi,
        RefundQueryPayApiRequest,
        RefundQueryPayApiResponse> implements PayApiRequest<
        RefundQueryPayApi,
        RefundQueryPayApiRequest,
        RefundQueryPayApiResponse> {
    /**
     * out trade no.
     */
    private final String outTradeNo;
    /**
     * channel transaction id.
     */
    private final String channelTransactionId;
    /**
     * out trade no.
     */
    @NotBlank
    private final String outRefundNo;
    /**
     * channel refund id.
     */
    private final String channelRefundId;
    /**
     * get api type.
     * immutable
     *
     * @return api type
     */
    @Override
    public Class<RefundQueryPayApi> apiType() {
        return RefundQueryPayApi.class;
    }

    /**
     * get response type.
     * immutable
     *
     * @return response type
     */
    @Override
    public Class<RefundQueryPayApiResponse> responseType() {
        return RefundQueryPayApiResponse.class;
    }
}
