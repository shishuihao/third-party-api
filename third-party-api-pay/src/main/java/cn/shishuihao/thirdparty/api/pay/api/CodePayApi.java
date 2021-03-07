package cn.shishuihao.thirdparty.api.pay.api;

import cn.shishuihao.thirdparty.api.pay.PayApi;
import cn.shishuihao.thirdparty.api.pay.request.CodePayApiRequest;
import cn.shishuihao.thirdparty.api.pay.response.CodePayApiResponse;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public interface CodePayApi extends PayApi<
        CodePayApi, CodePayApiRequest, CodePayApiResponse> {
    /**
     * get api type.
     * immutable
     *
     * @return api type
     */
    @Override
    default Class<CodePayApi> apiType() {
        return CodePayApi.class;
    }
}
