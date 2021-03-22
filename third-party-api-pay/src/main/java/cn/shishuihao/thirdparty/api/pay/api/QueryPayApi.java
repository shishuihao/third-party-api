package cn.shishuihao.thirdparty.api.pay.api;

import cn.shishuihao.thirdparty.api.pay.PayApi;
import cn.shishuihao.thirdparty.api.pay.request.QueryApiRequest;
import cn.shishuihao.thirdparty.api.pay.response.QueryApiResponse;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public interface QueryPayApi extends PayApi<
        QueryPayApi,
        QueryApiRequest,
        QueryApiResponse> {
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
