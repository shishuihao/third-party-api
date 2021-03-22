package cn.shishuihao.thirdparty.api.pay.api;

import cn.shishuihao.thirdparty.api.pay.PayApi;
import cn.shishuihao.thirdparty.api.pay.request.H5PayApiRequest;
import cn.shishuihao.thirdparty.api.pay.response.H5PayApiResponse;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public interface H5PayApi extends PayApi<
        H5PayApi,
        H5PayApiRequest,
        H5PayApiResponse> {
    /**
     * get api type.
     * immutable
     *
     * @return api type
     */
    @Override
    default Class<H5PayApi> apiType() {
        return H5PayApi.class;
    }
}
