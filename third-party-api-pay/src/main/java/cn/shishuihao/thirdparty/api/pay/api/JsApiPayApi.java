package cn.shishuihao.thirdparty.api.pay.api;

import cn.shishuihao.thirdparty.api.pay.PayApi;
import cn.shishuihao.thirdparty.api.pay.request.JsApiPayApiRequest;
import cn.shishuihao.thirdparty.api.pay.response.JsApiPayApiResponse;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public interface JsApiPayApi extends PayApi<
        JsApiPayApi,
        JsApiPayApiRequest,
        JsApiPayApiResponse> {
    /**
     * get api type.
     * immutable
     *
     * @return api type
     */
    @Override
    default Class<JsApiPayApi> apiType() {
        return JsApiPayApi.class;
    }
}
