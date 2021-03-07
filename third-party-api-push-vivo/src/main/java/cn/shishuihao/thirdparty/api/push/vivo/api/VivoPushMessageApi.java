package cn.shishuihao.thirdparty.api.push.vivo.api;

import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.core.exception.ApiException;
import cn.shishuihao.thirdparty.api.push.api.PushMessageApi;
import cn.shishuihao.thirdparty.api.push.request.PushMessageApiRequest;
import cn.shishuihao.thirdparty.api.push.response.PushMessageApiResponse;
import cn.shishuihao.thirdparty.api.push.util.ArrayUtils;
import cn.shishuihao.thirdparty.api.push.vivo.VivoPushApiProperties;
import cn.shishuihao.thirdparty.api.push.vivo.VivoPushClient;
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
     * execute PushMessageApiRequest by vivo.
     *
     * @param request request
     * @return PushMessageApiResponse
     */
    @Override
    public PushMessageApiResponse execute(final PushMessageApiRequest request) {
        VivoPushApiProperties properties = (VivoPushApiProperties)
                ApiRegistry.INSTANCE.getApiPropertiesOrThrow(request);
        try {
            Sender sender = vivoPushClient.getSender(properties);
            String requestId = UUID.randomUUID().toString();
            Message.Builder builder = getBuilder(request, requestId);
            Result result;
            String[] registrationIds = request.getRegistrationIds();
            if (ArrayUtils.isEmpty(registrationIds)) {
                result = sender.sendToAll(builder.build());
            } else if (ArrayUtils.getLength(registrationIds) == 1) {
                result = sender.sendSingle(builder.build());
            } else {
                result = batchPush(request, sender, builder);
            }
            return getApiResponse(requestId, result);
        } catch (Exception e) {
            throw new ApiException(e);
        }
    }

    private Message.Builder getBuilder(final PushMessageApiRequest request,
                                       final String requestId) {
        return new Message.Builder()
                .requestId(requestId)
                // 必填项，设置通知类型，value类型支持以下值：
                // 1：无 2：响铃 3：振动 4：响铃和振动
                .notifyType(1)
                // 必填项，设置点击跳转类型，value类型支持以下值：
                // 1：打开APP首页 2：打开链接 3：自定义 4：打开app内指定页面
                .skipType(1)
                .title(request.getTitle())
                .content(request.getPayload());
    }

    private Result batchPush(final PushMessageApiRequest request,
                             final Sender sender,
                             final Message.Builder builder) throws Exception {
        Result result = sender.saveListPayLoad(builder.build());
        if (ResultChecker.success(result)) {
            TargetMessage targetMessage = new TargetMessage.Builder()
                    .requestId(UUID.randomUUID().toString())
                    .taskId(result.getTaskId())
                    .regIds(new HashSet<>(Arrays
                            .asList(request.getRegistrationIds())))
                    .build();
            result = sender.sendToList(targetMessage);
        }
        return result;
    }

    private PushMessageApiResponse getApiResponse(
            final String requestId,
            final Result result) {
        return PushMessageApiResponse.builder()
                .success(result.getResult() == 0)
                .code(String.valueOf(result.getResult()))
                .message(result.getDesc())
                .requestId(requestId)
                .build();
    }
}
