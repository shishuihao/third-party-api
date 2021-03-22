package cn.shishuihao.thirdparty.api.pay.request;

import cn.shishuihao.thirdparty.api.core.request.AbstractRequest;
import cn.shishuihao.thirdparty.api.pay.PayApiRequest;
import cn.shishuihao.thirdparty.api.pay.api.CancelPayApi;
import cn.shishuihao.thirdparty.api.pay.response.CancelApiResponse;
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
public class CancelApiRequest extends AbstractRequest<
        CancelPayApi,
        CancelApiRequest,
        CancelApiResponse> implements PayApiRequest<
        CancelPayApi,
        CancelApiRequest,
        CancelApiResponse> {
    /**
     * out trade no.
     */
    @NotBlank
    private final String outTradeNo;

    /**
     * get api type.
     * immutable
     *
     * @return api type
     */
    @Override
    public Class<CancelPayApi> apiType() {
        return CancelPayApi.class;
    }

    /**
     * get response type.
     * immutable
     *
     * @return response type
     */
    @Override
    public Class<CancelApiResponse> responseType() {
        return CancelApiResponse.class;
    }
}
