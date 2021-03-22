package cn.shishuihao.thirdparty.api.pay.request;

import cn.shishuihao.thirdparty.api.core.request.AbstractRequest;
import cn.shishuihao.thirdparty.api.pay.PayApiRequest;
import cn.shishuihao.thirdparty.api.pay.api.AppPayApi;
import cn.shishuihao.thirdparty.api.pay.response.AppPayApiResponse;
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
public class AppPayApiRequest extends AbstractRequest<
        AppPayApi,
        AppPayApiRequest,
        AppPayApiResponse> implements PayApiRequest<
        AppPayApi,
        AppPayApiRequest,
        AppPayApiResponse> {
    /**
     * out trade no.
     */
    @NotBlank
    private final String outTradeNo;
    /**
     * pay total amount.
     */
    @Min(1)
    private final int totalAmount;
    /**
     * subject.
     */
    private final String subject;

    /**
     * get api type.
     * immutable
     *
     * @return api type
     */
    @Override
    public Class<AppPayApi> apiType() {
        return AppPayApi.class;
    }

    /**
     * get response type.
     * immutable
     *
     * @return response type
     */
    @Override
    public Class<AppPayApiResponse> responseType() {
        return AppPayApiResponse.class;
    }
}