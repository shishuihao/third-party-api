package cn.shishuihao.thirdparty.api.pay.request;

import cn.shishuihao.thirdparty.api.core.request.AbstractRequest;
import cn.shishuihao.thirdparty.api.pay.PayApiRequest;
import cn.shishuihao.thirdparty.api.pay.api.CodePayApi;
import cn.shishuihao.thirdparty.api.pay.response.CodePayApiResponse;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

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
     * subject.
     */
    private final String subject;
    /**
     * out trade no.
     */
    private final String outTradeNo;
    /**
     * pay total amount.
     */
    private final int totalAmount;
    /**
     * auth code.such as qrcode.
     */
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
