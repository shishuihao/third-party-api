package cn.shishuihao.thirdparty.api.pay.api;

import cn.shishuihao.thirdparty.api.pay.PayApi;
import cn.shishuihao.thirdparty.api.pay.request.CancelPayApiRequest;
import cn.shishuihao.thirdparty.api.pay.response.CancelPayApiResponse;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public interface CancelPayApi extends PayApi<
        CancelPayApi,
        CancelPayApiRequest,
        CancelPayApiResponse> {
    /**
     * get api type.
     * immutable
     *
     * @return api type
     */
    @Override
    default Class<CancelPayApi> apiType() {
        return CancelPayApi.class;
    }
}
