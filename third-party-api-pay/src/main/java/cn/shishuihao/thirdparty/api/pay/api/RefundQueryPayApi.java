package cn.shishuihao.thirdparty.api.pay.api;

import cn.shishuihao.thirdparty.api.pay.PayApi;
import cn.shishuihao.thirdparty.api.pay.request.RefundQueryPayApiRequest;
import cn.shishuihao.thirdparty.api.pay.response.RefundQueryPayApiResponse;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public interface RefundQueryPayApi extends PayApi<
        RefundQueryPayApi,
        RefundQueryPayApiRequest,
        RefundQueryPayApiResponse> {
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
