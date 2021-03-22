package cn.shishuihao.thirdparty.api.pay.api;

import cn.shishuihao.thirdparty.api.pay.PayApi;
import cn.shishuihao.thirdparty.api.pay.request.RefundApiRequest;
import cn.shishuihao.thirdparty.api.pay.response.RefundApiResponse;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public interface RefundPayApi extends PayApi<
        RefundPayApi,
        RefundApiRequest,
        RefundApiResponse> {
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
