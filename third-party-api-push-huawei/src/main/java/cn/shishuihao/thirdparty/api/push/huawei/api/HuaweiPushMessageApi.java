package cn.shishuihao.thirdparty.api.push.huawei.api;

import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.core.exception.ApiException;
import cn.shishuihao.thirdparty.api.push.api.PushMessageApi;
import cn.shishuihao.thirdparty.api.push.huawei.HuaweiPushApiProperties;
import cn.shishuihao.thirdparty.api.push.huawei.sdk.HuaweiFactory;
import cn.shishuihao.thirdparty.api.push.huawei.sdk.api.HuaweiPushApi;
import cn.shishuihao.thirdparty.api.push.huawei.sdk.domain.Message;
import cn.shishuihao.thirdparty.api.push.huawei.sdk.domain.Notification;
import cn.shishuihao.thirdparty.api.push.huawei.sdk.request.HuaweiPushMessageRequest;
import cn.shishuihao.thirdparty.api.push.huawei.sdk.response.HuaweiPushMessageResponse;
import cn.shishuihao.thirdparty.api.push.huawei.sdk.util.ResponseChecker;
import cn.shishuihao.thirdparty.api.push.request.PushMessageApiRequest;
import cn.shishuihao.thirdparty.api.push.response.PushMessageApiResponse;

import java.util.Arrays;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class HuaweiPushMessageApi implements PushMessageApi {
    /**
     * huaweiPushApi.
     */
    private final HuaweiPushApi huaweiPushApi = HuaweiFactory.Push.pushApi();

    /**
     * execute PushMessageApiRequest by huawei.
     *
     * @param request request
     * @return PushMessageApiResponse
     */
    @Override
    public PushMessageApiResponse execute(final PushMessageApiRequest request) {
        HuaweiPushApiProperties properties = (HuaweiPushApiProperties)
                ApiRegistry.INSTANCE.getApiPropertiesOrThrow(request);
        try {
            HuaweiPushMessageRequest pmRequest = HuaweiPushMessageRequest
                    .builder()
                    .validateOnly(false)
                    .message(Message.builder()
                            .notification(Notification.builder()
                                    .title(request.getTitle())
                                    .body(request.getPayload())
                                    .build())
                            .token(Arrays.asList(request.getRegistrationIds()))
                            .build())
                    .build();
            HuaweiPushMessageResponse response = huaweiPushApi.sendMessage(
                    properties.getAppId(),
                    pmRequest);
            return PushMessageApiResponse.Builder.builder()
                    .success(ResponseChecker.success(response))
                    .code(response.getCode())
                    .message(response.getMsg())
                    .requestId(response.getRequestId())
                    .build();
        } catch (Exception e) {
            throw new ApiException(e);
        }
    }
}
