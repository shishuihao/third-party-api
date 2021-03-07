package cn.shishuihao.thirdparty.api.push.oppo.api;

import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.core.exception.ApiException;
import cn.shishuihao.thirdparty.api.push.api.PushMessageApi;
import cn.shishuihao.thirdparty.api.push.oppo.OppoPushApiProperties;
import cn.shishuihao.thirdparty.api.push.oppo.OppoPushClient;
import cn.shishuihao.thirdparty.api.push.oppo.util.ResultChecker;
import cn.shishuihao.thirdparty.api.push.request.PushMessageApiRequest;
import cn.shishuihao.thirdparty.api.push.response.PushMessageApiResponse;
import cn.shishuihao.thirdparty.api.push.util.ArrayUtils;
import com.oppo.push.server.Notification;
import com.oppo.push.server.Result;
import com.oppo.push.server.Sender;
import com.oppo.push.server.Target;
import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * push message.
 * {@link "https://open.oppomobile.com/wiki/doc#id=10203"}
 *
 * @author shishuihao
 * @version 1.0.0
 */
@AllArgsConstructor
public class OppoPushMessageApi implements PushMessageApi {
    /**
     * oppoPushClient.
     */
    private final OppoPushClient oppoPushClient;

    /**
     * execute PushMessageApiRequest by oppo.
     *
     * @param request request
     * @return PushMessageApiResponse
     */
    @Override
    public PushMessageApiResponse execute(final PushMessageApiRequest request) {
        OppoPushApiProperties properties = (OppoPushApiProperties)
                ApiRegistry.INSTANCE.getApiPropertiesOrThrow(request);
        try {
            Sender sender = oppoPushClient.getSender(properties);
            Notification notification = new Notification();
            notification.setTitle(request.getTitle());
            notification.setContent(request.getPayload());
            Result result = ArrayUtils.isNotEmpty(request.getRegistrationIds())
                    ? batchPush(request, sender, notification)
                    : broadcastPush(sender, notification);
            return getResponse(result);
        } catch (Exception e) {
            throw new ApiException(e);
        }
    }

    private Result batchPush(final PushMessageApiRequest request,
                             final Sender sender,
                             final Notification notification)
            throws Exception {
        Map<Target, Notification> notificationMessages = Arrays
                .stream(request.getRegistrationIds())
                .collect(Collectors.toMap(Target::build, it -> notification));
        return sender.unicastBatchNotification(notificationMessages);
    }

    private Result broadcastPush(final Sender sender,
                                 final Notification notification)
            throws Exception {
        Result result = sender.saveNotification(notification);
        if (ResultChecker.success(result)) {
            result = sender.broadcastNotification(
                    result.getMessageId(),
                    Target.build(""));
        }
        return result;
    }

    private PushMessageApiResponse getResponse(final Result result) {
        return PushMessageApiResponse.builder()
                .success(ResultChecker.success(result))
                .code(Optional.ofNullable(result.getReturnCode())
                        .map(it -> it.getCode() + "," + it.getMessage())
                        .orElse(null))
                .message(result.getReason())
                .build();
    }
}
