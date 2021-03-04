package cn.shishuihao.thirdparty.api.push.vivo.api;

import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.core.exception.ApiException;
import cn.shishuihao.thirdparty.api.push.api.PushMessageApi;
import cn.shishuihao.thirdparty.api.push.request.PushMessageApiRequest;
import cn.shishuihao.thirdparty.api.push.response.PushMessageApiResponse;
import cn.shishuihao.thirdparty.api.push.vivo.VivoPushApiProperties;
import cn.shishuihao.thirdparty.api.push.vivo.VivoPushClient;
import com.vivo.push.sdk.notofication.Message;
import com.vivo.push.sdk.notofication.Result;
import com.vivo.push.sdk.notofication.TargetMessage;
import com.vivo.push.sdk.server.Sender;

import java.util.Arrays;
import java.util.HashSet;
import java.util.UUID;

/**
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
                    // 必填项，用户请求唯一标识 最大64字符
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
            if (request.getRegistrationIds() == null || request.getRegistrationIds().length <= 0) {
                result = sender.sendToAll(builder.build());
            } else if (request.getRegistrationIds().length == 1) {
                result = sender.sendSingle(builder.build());
            } else {
                result = sender.saveListPayLoad(builder.build());
                if (result.getResult() == 0) {
                    TargetMessage targetMessage = new TargetMessage.Builder()
                            .requestId(UUID.randomUUID().toString())
                            .taskId(result.getTaskId())
                            .regIds(new HashSet<>(Arrays.asList(request.getRegistrationIds())))
                            .build();
                    result = sender.sendToList(targetMessage);
                }
            }
            return PushMessageApiResponse.Builder.builder()
                    .success(result.getResult() == 0)
                    .code(String.valueOf(result.getResult()))
                    .message(result.getDesc())
                    .requestId(requestId)
                    .build();
        } catch (Exception e) {
            throw new ApiException(e);
        }
    }
}
