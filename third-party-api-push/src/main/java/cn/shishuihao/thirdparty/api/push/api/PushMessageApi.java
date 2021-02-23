package cn.shishuihao.thirdparty.api.push.api;

import cn.shishuihao.thirdparty.api.push.PushApi;
import cn.shishuihao.thirdparty.api.push.request.PushMessageRequest;
import cn.shishuihao.thirdparty.api.push.response.PushMessageResponse;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public interface PushMessageApi extends PushApi<PushMessageApi, PushMessageRequest, PushMessageResponse> {
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
