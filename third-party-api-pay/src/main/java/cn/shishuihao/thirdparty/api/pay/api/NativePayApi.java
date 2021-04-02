package cn.shishuihao.thirdparty.api.pay.api;

import cn.shishuihao.thirdparty.api.pay.PayApi;
import cn.shishuihao.thirdparty.api.pay.request.NativePayApiRequest;
import cn.shishuihao.thirdparty.api.pay.response.NativePayApiResponse;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public interface NativePayApi extends PayApi<
        NativePayApi,
        NativePayApiRequest,
        NativePayApiResponse> {
    /**
     * get api type.
     * immutable
     *
     * @return api type
     */
    @Override
    default Class<NativePayApi> apiType() {
        return NativePayApi.class;
    }
}
