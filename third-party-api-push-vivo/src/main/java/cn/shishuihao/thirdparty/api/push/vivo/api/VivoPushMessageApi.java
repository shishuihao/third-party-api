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

import java.util.Arrays;
import java.util.HashSet;
import java.util.UUID;

/**
 * {@link = "https://dev.vivo.com.cn/documentCenter/doc/363"}
 *
 * @author shishuihao
 * @version 1.0.0
 */

public class VivoPushMessageApi implements PushMessageApi {
    private final VivoPushClient vivoPushClient;

    public VivoPushMessageApi(VivoPushClient vivoPushClient) {
        this.vivoPushClient = vivoPushClient;
    }

    @Override
    public PushMessageApiResponse execute(PushMessageApiRequest request) {
        VivoPushApiProperties properties = (VivoPushApiProperties) ApiRegistry.INSTANCE.getApiPropertiesOrThrow(request);
        try {
            Sender sender = vivoPushClient.getSender(properties);
            String requestId = UUID.randomUUID().toString();
            Message.Builder builder = new Message.Builder()
                    .requestId(requestId)
                    // 必填项，设置通知类型，value类型支持以下值：
                    // 1：无 2：响铃 3：振动 4：响铃和振动
                    .notifyType(1)
                    // 必填项，设置点击跳转类型，value类型支持以下值：
                    // 1：打开APP首页 2：打开链接 3：自定义 4：打开app内指定页面
                    .skipType(1)
                    .title(request.getTitle())
                    .content(request.getPayload());
            Result result;
            if (ArrayUtils.isEmpty(request.getRegistrationIds())) {
                result = sender.sendToAll(builder.build());
            } else if (ArrayUtils.getLength(request.getRegistrationIds()) == 1) {
                result = sender.sendSingle(builder.build());
            } else {
                result = batchPush(request, sender, builder);
            }
            return getPushMessageApiResponse(requestId, result);
        } catch (Exception e) {
            throw new ApiException(e);
        }
    }

    private Result batchPush(PushMessageApiRequest request, Sender sender, Message.Builder builder) throws Exception {
        Result result = sender.saveListPayLoad(builder.build());
        if (ResultChecker.success(result)) {
            TargetMessage targetMessage = new TargetMessage.Builder()
                    .requestId(UUID.randomUUID().toString())
                    .taskId(result.getTaskId())
                    .regIds(new HashSet<>(Arrays.asList(request.getRegistrationIds())))
                    .build();
            result = sender.sendToList(targetMessage);
        }
        return result;
    }

    private PushMessageApiResponse getPushMessageApiResponse(String requestId, Result result) {
        return PushMessageApiResponse.Builder.builder()
                .success(result.getResult() == 0)
                .code(String.valueOf(result.getResult()))
                .message(result.getDesc())
                .requestId(requestId)
                .build();
    }
}
