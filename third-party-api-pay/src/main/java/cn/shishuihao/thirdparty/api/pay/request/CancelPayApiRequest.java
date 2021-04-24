package cn.shishuihao.thirdparty.api.pay.request;

import cn.shishuihao.thirdparty.api.core.request.AbstractRequest;
import cn.shishuihao.thirdparty.api.pay.PayApiRequest;
import cn.shishuihao.thirdparty.api.pay.api.CancelPayApi;
import cn.shishuihao.thirdparty.api.pay.response.CancelPayApiResponse;
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
public class CancelPayApiRequest extends AbstractRequest<
        CancelPayApi,
        CancelPayApiRequest,
        CancelPayApiResponse> implements PayApiRequest<
        CancelPayApi,
        CancelPayApiRequest,
        CancelPayApiResponse> {
    /**
     * channel transaction id.
     */
    private final String channelTransactionId;
    /**
     * out trade no.
     */
    private final String outTradeNo;
    /**
     * auth code.
     * such as qrcode.
     */
    private final String authCode;

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
    public Class<CancelPayApiResponse> responseType() {
        return CancelPayApiResponse.class;
    }
}
