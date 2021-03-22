package cn.shishuihao.thirdparty.api.pay.request;

import cn.shishuihao.thirdparty.api.core.request.AbstractRequest;
import cn.shishuihao.thirdparty.api.pay.PayApiRequest;
import cn.shishuihao.thirdparty.api.pay.api.QueryPayApi;
import cn.shishuihao.thirdparty.api.pay.response.QueryApiResponse;
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
public class QueryApiRequest extends AbstractRequest<
        QueryPayApi,
        QueryApiRequest,
        QueryApiResponse> implements PayApiRequest<
        QueryPayApi,
        QueryApiRequest,
        QueryApiResponse> {
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
    public Class<QueryPayApi> apiType() {
        return QueryPayApi.class;
    }

    /**
     * get response type.
     * immutable
     *
     * @return response type
     */
    @Override
    public Class<QueryApiResponse> responseType() {
        return QueryApiResponse.class;
    }
}
