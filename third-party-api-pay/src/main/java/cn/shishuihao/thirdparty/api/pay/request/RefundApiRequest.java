package cn.shishuihao.thirdparty.api.pay.request;

import cn.shishuihao.thirdparty.api.core.request.AbstractRequest;
import cn.shishuihao.thirdparty.api.pay.PayApiRequest;
import cn.shishuihao.thirdparty.api.pay.api.RefundPayApi;
import cn.shishuihao.thirdparty.api.pay.response.RefundApiResponse;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Getter
@Jacksonized
@SuperBuilder
public class RefundApiRequest extends AbstractRequest<
        RefundPayApi,
        RefundApiRequest,
        RefundApiResponse> implements PayApiRequest<
        RefundPayApi,
        RefundApiRequest,
        RefundApiResponse> {
    /**
     * out trade no.
     */
    @NotBlank
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
    public Class<RefundApiResponse> responseType() {
        return RefundApiResponse.class;
    }
}
