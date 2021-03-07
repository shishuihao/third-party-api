package cn.shishuihao.thirdparty.api.push.huawei.sdk.api;

import cn.shishuihao.thirdparty.api.push.huawei.sdk.request.HuaweiSendMessageRequest;
import cn.shishuihao.thirdparty.api.push.huawei.sdk.response.HuaweiSendMessageResponse;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public interface HuaweiPushApi {
    /**
     * 构建发送消息请求.
     * {@link "https://developer.huawei.com/consumer/cn/doc/development
     * /HMSCore-Guides/android-server-dev-0000001050040110"}
     *
     * @param appId   app id
     * @param request request
     * @return response.
     */
    @Headers("Content-Type: application/json; charset=UTF-8")
    @RequestLine("POST /v1/{appId}/messages:send")
    HuaweiSendMessageResponse sendMessage(@Param("appId") String appId,
                                          HuaweiSendMessageRequest request);
}
