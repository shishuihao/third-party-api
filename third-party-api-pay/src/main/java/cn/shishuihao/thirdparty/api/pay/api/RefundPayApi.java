package cn.shishuihao.thirdparty.api.pay.api;

import cn.shishuihao.thirdparty.api.pay.PayApi;
import cn.shishuihao.thirdparty.api.pay.request.RefundPayApiRequest;
import cn.shishuihao.thirdparty.api.pay.response.RefundPayApiResponse;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public interface RefundPayApi extends PayApi<
        RefundPayApi,
        RefundPayApiRequest,
        RefundPayApiResponse> {
    /**
     * get api type.
     * immutable
     *
     * @return api type
     */
    @Override
    default Class<RefundPayApi> apiType() {
        return RefundPayApi.class;
    }
}
