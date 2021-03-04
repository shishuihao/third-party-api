package cn.shishuihao.thirdparty.api.push.oppo.api;

import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.core.exception.ApiException;
import cn.shishuihao.thirdparty.api.push.api.PushMessageApi;
import cn.shishuihao.thirdparty.api.push.oppo.OppoPushApiProperties;
import cn.shishuihao.thirdparty.api.push.oppo.OppoPushClient;
import cn.shishuihao.thirdparty.api.push.request.PushMessageApiRequest;
import cn.shishuihao.thirdparty.api.push.response.PushMessageApiResponse;
import com.oppo.push.server.Notification;
import com.oppo.push.server.Result;
import com.oppo.push.server.Target;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class OppoPushMessageApi implements PushMessageApi {
    private final OppoPushClient oppoPushClient;

    public OppoPushMessageApi(OppoPushClient oppoPushClient) {
        this.oppoPushClient = oppoPushClient;
    }

    @Override
    public PushMessageApiResponse execute(PushMessageApiRequest request) {
        OppoPushApiProperties properties = (OppoPushApiProperties) ApiRegistry.INSTANCE.getApiPropertiesOrThrow(request);
        try {
            Notification notification = new Notification();
            notification.setTitle(request.getTitle());
            notification.setContent(request.getPayload());
            Result result;
            if (request.getRegistrationIds() == null || request.getRegistrationIds().length <= 0) {
                result = oppoPushClient.getSender(properties).saveNotification(notification);
                if (result.getReturnCode().getCode() == 0) {
                    result = oppoPushClient.getSender(properties)
                            .broadcastNotification(result.getMessageId(), Target.build(""));
                }
            } else {
                result = oppoPushClient.getSender(properties)
                        .unicastBatchNotification(Arrays.stream(request.getRegistrationIds())
                                .collect(Collectors.toMap(Target::build, it -> notification)));
            }
            return PushMessageApiResponse.Builder.builder()
                    .success(result.getReturnCode().getCode() == 0)
                    .code(Optional.ofNullable(result.getReturnCode())
                            .map(it -> it.getCode() + "," + it.getMessage())
                            .orElse(null))
                    .message(result.getReason())
                    .build();
        } catch (Exception e) {
            throw new ApiException(e);
        }
    }
}
