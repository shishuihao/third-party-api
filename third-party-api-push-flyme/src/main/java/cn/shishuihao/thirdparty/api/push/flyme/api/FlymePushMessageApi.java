package cn.shishuihao.thirdparty.api.push.flyme.api;

import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.core.exception.ApiException;
import cn.shishuihao.thirdparty.api.push.api.PushMessageApi;
import cn.shishuihao.thirdparty.api.push.flyme.FlymePushApiProperties;
import cn.shishuihao.thirdparty.api.push.flyme.FlymePushClient;
import cn.shishuihao.thirdparty.api.push.request.PushMessageApiRequest;
import cn.shishuihao.thirdparty.api.push.response.PushMessageApiResponse;
import com.meizu.push.sdk.constant.PushType;
import com.meizu.push.sdk.server.IFlymePush;
import com.meizu.push.sdk.server.constant.ErrorCode;
import com.meizu.push.sdk.server.constant.ResultPack;
import com.meizu.push.sdk.server.model.push.VarnishedMessage;

import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class FlymePushMessageApi implements PushMessageApi {
    private final FlymePushClient flymePushClient;

    public FlymePushMessageApi(FlymePushClient flymePushClient) {
        this.flymePushClient = flymePushClient;
    }

    @Override
    public PushMessageApiResponse execute(PushMessageApiRequest request) {
        FlymePushApiProperties properties = (FlymePushApiProperties) ApiRegistry.INSTANCE.getApiPropertiesOrThrow(request);
        try {
            IFlymePush push = flymePushClient.getClient(properties);
            VarnishedMessage message = new VarnishedMessage.Builder()
                    .appId(properties.getAppId())
                    .title(request.getTitle())
                    .content(request.getPayload())
                    .build();
            ResultPack<?> result;
            if (request.getRegistrationIds() == null || request.getRegistrationIds().length <= 0) {
                result = push.pushToApp(PushType.STATUSBAR, message);
            } else {
                result = push.pushMessage(message, Arrays.asList(request.getRegistrationIds()), Math.max(1, properties.getRetries()));
            }
            return PushMessageApiResponse.Builder.builder()
                    .success(ErrorCode.SUCCESS == result.getErrorCode())
                    .code(Optional.ofNullable(result.getErrorCode())
                            .map(it -> it.getValue() + "," + it.getDescription())
                            .orElse(null))
                    .message(result.comment())
                    .build();
        } catch (IOException e) {
            throw new ApiException(e);
        }
    }
}
