package cn.shishuihao.thirdparty.api.push.oppo.api;

import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.core.exception.ApiException;
import cn.shishuihao.thirdparty.api.push.api.PushMessageApi;
import cn.shishuihao.thirdparty.api.push.oppo.OppoPushApiProperties;
import cn.shishuihao.thirdparty.api.push.oppo.OppoPushClient;
import cn.shishuihao.thirdparty.api.push.oppo.assembler.OppoPushRequestAssembler;
import cn.shishuihao.thirdparty.api.push.oppo.assembler.OppoPushResponseAssembler;
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
     * execute request.
     *
     * @param request request
     * @return response
     */
    @Override
    public PushMessageApiResponse execute(final PushMessageApiRequest request) {
        final OppoPushApiProperties properties = (OppoPushApiProperties)
                ApiRegistry.INSTANCE.getApiPropertiesOrThrow(request);
        try {
            final Sender sender = oppoPushClient.getSender(properties);
            final Notification notification = OppoPushRequestAssembler.INSTANCE
                    .assemble(request, properties);
            final Result result = ArrayUtils
                    .isNotEmpty(request.getRegistrationIds())
                    ? batchPush(request, sender, notification)
                    : broadcastPush(sender, notification);
            return OppoPushResponseAssembler.INSTANCE
                    .assemble(result);
        } catch (Exception e) {
            throw new ApiException(e);
        }
    }

    private Result batchPush(final PushMessageApiRequest request,
                             final Sender sender,
                             final Notification notification)
            throws Exception {
        final Map<Target, Notification> notificationMessages = Arrays
                .stream(request.getRegistrationIds())
                .collect(Collectors.toMap(Target::build, it -> notification));
        return sender.unicastBatchNotification(notificationMessages);
    }

    private Result broadcastPush(final Sender sender,
                                 final Notification notification)
            throws Exception {
        final Result result = sender.saveNotification(notification);
        if (ResultChecker.success(result)) {
            return sender.broadcastNotification(
                    result.getMessageId(),
                    Target.build(""));
        }
        return result;
    }
}
