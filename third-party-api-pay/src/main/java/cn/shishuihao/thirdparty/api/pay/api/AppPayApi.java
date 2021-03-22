package cn.shishuihao.thirdparty.api.pay.api;

import cn.shishuihao.thirdparty.api.pay.PayApi;
import cn.shishuihao.thirdparty.api.pay.request.AppPayApiRequest;
import cn.shishuihao.thirdparty.api.pay.response.AppPayApiResponse;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public interface AppPayApi extends PayApi<
        AppPayApi,
        AppPayApiRequest,
        AppPayApiResponse> {
    /**
     * get api type.
     * immutable
     *
     * @return api type
     */
    @Override
    default Class<AppPayApi> apiType() {
        return AppPayApi.class;
    }
}
