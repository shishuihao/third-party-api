package cn.shishuihao.thirdparty.api.push.vivo.api;

import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.core.exception.ApiException;
import cn.shishuihao.thirdparty.api.push.api.PushMessageApi;
import cn.shishuihao.thirdparty.api.push.request.PushMessageApiRequest;
import cn.shishuihao.thirdparty.api.push.response.PushMessageApiResponse;
import cn.shishuihao.thirdparty.api.push.util.ArrayUtils;
import cn.shishuihao.thirdparty.api.push.vivo.VivoPushApiProperties;
import cn.shishuihao.thirdparty.api.push.vivo.VivoPushClient;
import cn.shishuihao.thirdparty.api.push.vivo.assembler.VivoPushRequestAssembler;
import cn.shishuihao.thirdparty.api.push.vivo.assembler.VivoPushResponseAssembler;
import cn.shishuihao.thirdparty.api.push.vivo.util.ResultChecker;
import com.vivo.push.sdk.notofication.Message;
import com.vivo.push.sdk.notofication.Result;
import com.vivo.push.sdk.notofication.TargetMessage;
import com.vivo.push.sdk.server.Sender;
import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.HashSet;
import java.util.UUID;

/**
 * push message.
 * {@link = "https://dev.vivo.com.cn/documentCenter/doc/363"}
 *
 * @author shishuihao
 * @version 1.0.0
 */
@AllArgsConstructor
public class VivoPushMessageApi implements PushMessageApi {
    /**
     * vivoPushClient.
     */
    private final VivoPushClient vivoPushClient;

    /**
     * execute request.
     *
     * @param request request
     * @return response
     */
    @Override
    public PushMessageApiResponse execute(final PushMessageApiRequest request) {
        final VivoPushApiProperties properties = (VivoPushApiProperties)
                ApiRegistry.INSTANCE.getApiPropertiesOrThrow(request);
        try {
            final Sender sender = vivoPushClient.getSender(properties);
            final Message message = VivoPushRequestAssembler.INSTANCE
                    .assemble(request, properties);
            final Result result;
            final String[] registrationIds = request.getRegistrationIds();
            if (ArrayUtils.isEmpty(registrationIds)) {
                result = sender.sendToAll(message);
            } else if (ArrayUtils.getLength(registrationIds) == 1) {
                result = sender.sendSingle(message);
            } else {
                result = batchPush(request, sender, message);
            }
            return VivoPushResponseAssembler.INSTANCE
                    .assemble(message.getRequestId(), result);
        } catch (Exception e) {
            throw new ApiException(e);
        }
    }

    private Result batchPush(final PushMessageApiRequest request,
                             final Sender sender,
                             final Message message) throws Exception {
        final Result result = sender.saveListPayLoad(message);
        if (ResultChecker.success(result)) {
            final TargetMessage targetMessage = new TargetMessage.Builder()
                    .requestId(UUID.randomUUID().toString())
                    .taskId(result.getTaskId())
                    .regIds(new HashSet<>(Arrays
                            .asList(request.getRegistrationIds())))
                    .build();
            return sender.sendToList(targetMessage);
        }
        return result;
    }
}
