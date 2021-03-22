package cn.shishuihao.thirdparty.api.pay.api;

import cn.shishuihao.thirdparty.api.pay.PayApi;
import cn.shishuihao.thirdparty.api.pay.request.AppletPayApiRequest;
import cn.shishuihao.thirdparty.api.pay.response.AppletPayApiResponse;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public interface AppletPayApi extends PayApi<
        AppletPayApi,
        AppletPayApiRequest,
        AppletPayApiResponse> {
    /**
     * get api type.
     * immutable
     *
     * @return api type
     */
    @Override
    default Class<AppletPayApi> apiType() {
        return AppletPayApi.class;
    }
}
