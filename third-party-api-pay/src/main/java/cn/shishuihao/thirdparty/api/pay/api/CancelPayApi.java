package cn.shishuihao.thirdparty.api.pay.api;

import cn.shishuihao.thirdparty.api.pay.PayApi;
import cn.shishuihao.thirdparty.api.pay.request.CancelApiRequest;
import cn.shishuihao.thirdparty.api.pay.response.CancelApiResponse;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public interface CancelPayApi extends PayApi<
        CancelPayApi,
        CancelApiRequest,
        CancelApiResponse> {
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
