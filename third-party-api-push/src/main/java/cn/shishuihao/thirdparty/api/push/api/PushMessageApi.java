package cn.shishuihao.thirdparty.api.push.api;

import cn.shishuihao.thirdparty.api.push.PushApi;
import cn.shishuihao.thirdparty.api.push.request.PushMessageApiRequest;
import cn.shishuihao.thirdparty.api.push.response.PushMessageApiResponse;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public interface PushMessageApi extends PushApi<PushMessageApi, PushMessageApiRequest, PushMessageApiResponse> {
    /**
     * get api type
     * immutable
     *
     * @return api type
     */
    @Override
    default Class<PushMessageApi> apiType() {
        return PushMessageApi.class;
    }
}
