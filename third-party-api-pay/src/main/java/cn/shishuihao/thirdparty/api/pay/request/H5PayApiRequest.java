package cn.shishuihao.thirdparty.api.pay.request;

import cn.shishuihao.thirdparty.api.core.request.AbstractRequest;
import cn.shishuihao.thirdparty.api.pay.PayApiRequest;
import cn.shishuihao.thirdparty.api.pay.api.H5PayApi;
import cn.shishuihao.thirdparty.api.pay.response.H5PayApiResponse;
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
public class H5PayApiRequest extends AbstractRequest<
        H5PayApi,
        H5PayApiRequest,
        H5PayApiResponse> implements PayApiRequest<
        H5PayApi,
        H5PayApiRequest,
        H5PayApiResponse> {
    /**
     * out trade no.
     */
    @NotBlank
    private final String outTradeNo;
    /**
     * subject.
     */
    @NotBlank
    private final String subject;
    /**
     * currency.
     */
    @NotBlank
    private final String currency;
    /**
     * pay total amount.
     */
    @Min(1)
    private final int totalAmount;
    /**
     * quitUrl.
     */
    private final String quitUrl;
    /**
     * returnUrl.
     */
    private final String returnUrl;

    /**
     * get api type.
     * immutable
     *
     * @return api type
     */
    @Override
    public Class<H5PayApi> apiType() {
        return H5PayApi.class;
    }

    /**
     * get response type.
     * immutable
     *
     * @return response type
     */
    @Override
    public Class<H5PayApiResponse> responseType() {
        return H5PayApiResponse.class;
    }
}
