package cn.shishuihao.thirdparty.api.pay.api;

import cn.shishuihao.thirdparty.api.pay.PayApi;
import cn.shishuihao.thirdparty.api.pay.request.QueryOrderApiRequest;
import cn.shishuihao.thirdparty.api.pay.response.QueryOrderApiResponse;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public interface QueryOrderPayApi extends PayApi<
        QueryOrderPayApi,
        QueryOrderApiRequest,
        QueryOrderApiResponse> {
    /**
     * get api type.
     * immutable
     *
     * @return api type
     */
    @Override
    default Class<QueryOrderPayApi> apiType() {
        return QueryOrderPayApi.class;
    }
}
