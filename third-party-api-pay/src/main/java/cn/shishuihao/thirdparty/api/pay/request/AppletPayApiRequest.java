package cn.shishuihao.thirdparty.api.pay.request;

import cn.shishuihao.thirdparty.api.core.request.AbstractRequest;
import cn.shishuihao.thirdparty.api.pay.PayApiRequest;
import cn.shishuihao.thirdparty.api.pay.api.AppletPayApi;
import cn.shishuihao.thirdparty.api.pay.response.AppletPayApiResponse;
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
public class AppletPayApiRequest extends AbstractRequest<
        AppletPayApi,
        AppletPayApiRequest,
        AppletPayApiResponse> implements PayApiRequest<
        AppletPayApi,
        AppletPayApiRequest,
        AppletPayApiResponse> {
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
     * payer id.
     * such as openid.
     */
    private final String payerId;

    /**
     * get api type.
     * immutable
     *
     * @return api type
     */
    @Override
    public Class<AppletPayApi> apiType() {
        return AppletPayApi.class;
    }

    /**
     * get response type.
     * immutable
     *
     * @return response type
     */
    @Override
    public Class<AppletPayApiResponse> responseType() {
        return AppletPayApiResponse.class;
    }
}
