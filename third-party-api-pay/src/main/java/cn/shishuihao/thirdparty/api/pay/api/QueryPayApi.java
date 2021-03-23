package cn.shishuihao.thirdparty.api.pay.api;

import cn.shishuihao.thirdparty.api.pay.PayApi;
import cn.shishuihao.thirdparty.api.pay.request.QueryPayApiRequest;
import cn.shishuihao.thirdparty.api.pay.response.QueryPayApiResponse;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public interface QueryPayApi extends PayApi<
        QueryPayApi,
        QueryPayApiRequest,
        QueryPayApiResponse> {
    /**
     * get api type.
     * immutable
     *
     * @return api type
     */
    @Override
    default Class<QueryPayApi> apiType() {
        return QueryPayApi.class;
    }
}
