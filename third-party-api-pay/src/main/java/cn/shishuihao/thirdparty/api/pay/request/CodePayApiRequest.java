package cn.shishuihao.thirdparty.api.pay.request;

import cn.shishuihao.thirdparty.api.core.request.AbstractRequest;
import cn.shishuihao.thirdparty.api.pay.PayApiRequest;
import cn.shishuihao.thirdparty.api.pay.api.CodePayApi;
import cn.shishuihao.thirdparty.api.pay.response.CodePayApiResponse;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Getter
@Jacksonized
@SuperBuilder
public class CodePayApiRequest extends AbstractRequest<
        CodePayApi,
        CodePayApiRequest,
        CodePayApiResponse> implements PayApiRequest<
        CodePayApi,
        CodePayApiRequest,
        CodePayApiResponse> {
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
    @NotBlank
    private final String subject;
    /**
     * currency.
     */
    @NotBlank
    private final String currency;
    /**
     * auth code.
     * such as qrcode.
     */
    @NotEmpty
    private final String authCode;

    /**
     * get api type.
     * immutable
     *
     * @return api type
     */
    @Override
    public Class<CodePayApi> apiType() {
        return CodePayApi.class;
    }

    /**
     * get response type.
     * immutable
     *
     * @return response type
     */
    @Override
    public Class<CodePayApiResponse> responseType() {
        return CodePayApiResponse.class;
    }
}
