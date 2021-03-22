package cn.shishuihao.thirdparty.api.pay.request;

import cn.shishuihao.thirdparty.api.core.request.AbstractRequest;
import cn.shishuihao.thirdparty.api.pay.PayApiRequest;
import cn.shishuihao.thirdparty.api.pay.api.JsApiPayApi;
import cn.shishuihao.thirdparty.api.pay.response.JsApiPayApiResponse;
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
public class JsApiPayApiRequest extends AbstractRequest<
        JsApiPayApi,
        JsApiPayApiRequest,
        JsApiPayApiResponse> implements PayApiRequest<
        JsApiPayApi,
        JsApiPayApiRequest,
        JsApiPayApiResponse> {
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
     * get api type.
     * immutable
     *
     * @return api type
     */
    @Override
    public Class<JsApiPayApi> apiType() {
        return JsApiPayApi.class;
    }

    /**
     * get response type.
     * immutable
     *
     * @return response type
     */
    @Override
    public Class<JsApiPayApiResponse> responseType() {
        return JsApiPayApiResponse.class;
    }
}