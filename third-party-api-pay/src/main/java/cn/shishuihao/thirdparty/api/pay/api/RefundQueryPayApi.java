package cn.shishuihao.thirdparty.api.pay.api;

import cn.shishuihao.thirdparty.api.pay.PayApi;
import cn.shishuihao.thirdparty.api.pay.request.RefundQueryApiRequest;
import cn.shishuihao.thirdparty.api.pay.response.RefundQueryApiResponse;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public interface RefundQueryPayApi extends PayApi<
        RefundQueryPayApi,
        RefundQueryApiRequest,
        RefundQueryApiResponse> {
    /**
     * get api type.
     * immutable
     *
     * @return api type
     */
    @Override
    default Class<RefundQueryPayApi> apiType() {
        return RefundQueryPayApi.class;
    }
}
