package cn.shishuihao.thirdparty.api.pay.request;

import cn.shishuihao.thirdparty.api.core.request.AbstractRequest;
import cn.shishuihao.thirdparty.api.pay.PayApiRequest;
import cn.shishuihao.thirdparty.api.pay.api.RefundQueryPayApi;
import cn.shishuihao.thirdparty.api.pay.response.RefundQueryApiResponse;
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
public class RefundQueryApiRequest extends AbstractRequest<
        RefundQueryPayApi,
        RefundQueryApiRequest,
        RefundQueryApiResponse> implements PayApiRequest<
        RefundQueryPayApi,
        RefundQueryApiRequest,
        RefundQueryApiResponse> {
    /**
     * out trade no.
     */
    private final String outTradeNo;
    /**
     * out trade no.
     */
    @NotBlank
    private final String outRefundNo;

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
    public Class<RefundQueryApiResponse> responseType() {
        return RefundQueryApiResponse.class;
    }
}
