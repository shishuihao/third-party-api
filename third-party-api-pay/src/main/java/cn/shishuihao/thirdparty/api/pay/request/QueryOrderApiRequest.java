package cn.shishuihao.thirdparty.api.pay.request;

import cn.shishuihao.thirdparty.api.core.request.AbstractRequest;
import cn.shishuihao.thirdparty.api.pay.PayApiRequest;
import cn.shishuihao.thirdparty.api.pay.api.QueryOrderPayApi;
import cn.shishuihao.thirdparty.api.pay.response.QueryOrderApiResponse;
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
public class QueryOrderApiRequest extends AbstractRequest<
        QueryOrderPayApi,
        QueryOrderApiRequest,
        QueryOrderApiResponse> implements PayApiRequest<
        QueryOrderPayApi,
        QueryOrderApiRequest,
        QueryOrderApiResponse> {
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
    public Class<QueryOrderPayApi> apiType() {
        return QueryOrderPayApi.class;
    }

    /**
     * get response type.
     * immutable
     *
     * @return response type
     */
    @Override
    public Class<QueryOrderApiResponse> responseType() {
        return QueryOrderApiResponse.class;
    }
}
