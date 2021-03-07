package cn.shishuihao.thirdparty.api.push.huawei.api;

import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.core.exception.ApiException;
import cn.shishuihao.thirdparty.api.push.api.PushMessageApi;
import cn.shishuihao.thirdparty.api.push.huawei.HuaweiPushApiProperties;
import cn.shishuihao.thirdparty.api.push.huawei.sdk.HuaweiFactory;
import cn.shishuihao.thirdparty.api.push.huawei.sdk.api.HuaweiPushApi;
import cn.shishuihao.thirdparty.api.push.huawei.sdk.domain.Message;
import cn.shishuihao.thirdparty.api.push.huawei.sdk.domain.Notification;
import cn.shishuihao.thirdparty.api.push.huawei.sdk.request.HuaweiSendMessageRequest;
import cn.shishuihao.thirdparty.api.push.huawei.sdk.response.HuaweiSendMessageResponse;
import cn.shishuihao.thirdparty.api.push.huawei.sdk.util.ResponseChecker;
import cn.shishuihao.thirdparty.api.push.request.PushMessageApiRequest;
import cn.shishuihao.thirdparty.api.push.response.PushMessageApiResponse;
import lombok.AllArgsConstructor;

import java.util.Arrays;

/**
 * push message.
 *
 * @author shishuihao
 * @version 1.0.0
 */
@AllArgsConstructor
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
            HuaweiSendMessageRequest hwRequest = getHwRequest(request);
            HuaweiSendMessageResponse hwResponse = huaweiPushApi
                    .sendMessage(properties.getAppId(), hwRequest);
            return getApiResponse(hwResponse);
        } catch (Exception e) {
            throw new ApiException(e);
        }
    }

    private HuaweiSendMessageRequest getHwRequest(
            final PushMessageApiRequest request) {
        return HuaweiSendMessageRequest
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
    }

    private PushMessageApiResponse getApiResponse(
            final HuaweiSendMessageResponse hwResponse) {
        return PushMessageApiResponse.builder()
                .success(ResponseChecker.success(hwResponse))
                .code(hwResponse.getCode())
                .message(hwResponse.getMsg())
                .requestId(hwResponse.getRequestId())
                .build();
    }
}
