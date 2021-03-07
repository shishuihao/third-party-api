package cn.shishuihao.thirdparty.api.push.xiaomi.api;

import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.core.exception.ApiException;
import cn.shishuihao.thirdparty.api.push.api.PushMessageApi;
import cn.shishuihao.thirdparty.api.push.request.PushMessageApiRequest;
import cn.shishuihao.thirdparty.api.push.response.PushMessageApiResponse;
import cn.shishuihao.thirdparty.api.push.xiaomi.XiaomiPushApiProperties;
import cn.shishuihao.thirdparty.api.push.xiaomi.XiaomiPushClient;
import com.xiaomi.push.sdk.ErrorCode;
import com.xiaomi.xmpush.server.Constants;
import com.xiaomi.xmpush.server.Message;
import com.xiaomi.xmpush.server.Result;
import com.xiaomi.xmpush.server.Sender;
import lombok.AllArgsConstructor;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

/**
 * push message.
 * @author shishuihao
 * @version 1.0.0
 */
@AllArgsConstructor
public class XiaomiPushMessageApi implements PushMessageApi {
    /**
     * xiaomiPushClient.
     */
    private final XiaomiPushClient xiaomiPushClient;

    /**
     * execute PushMessageApiRequest by xiaomi.
     *
     * @param request request
     * @return PushMessageApiResponse
     */
    @Override
    public PushMessageApiResponse execute(final PushMessageApiRequest request) {
        XiaomiPushApiProperties properties = (XiaomiPushApiProperties)
                ApiRegistry.INSTANCE.getApiPropertiesOrThrow(request);
        try {
            Constants.useOfficial();
            Sender sender = xiaomiPushClient.getSender(properties);
            Message message = new Message.Builder()
                    .title(request.getTitle())
                    .description(request.getDescription())
                    .payload(request.getPayload())
                    .restrictedPackageName(request.getRestrictedPackageName())
                    // 使用默认提示音提示
                    .notifyType(1)
                    .build();
            Result result = sender.send(message,
                    Arrays.asList(request.getRegistrationIds()),
                    Math.max(1, properties.getRetries()));
            return PushMessageApiResponse.builder()
                    .success(ErrorCode.Success == result.getErrorCode())
                    .code(Optional.ofNullable(result.getErrorCode())
                            .map(it -> it.getValue()
                                    + ","
                                    + it.getDescription())
                            .orElse(null))
                    .message(result.getReason())
                    .requestId(result.getMessageId())
                    .build();
        } catch (IOException | ParseException e) {
            throw new ApiException(e);
        }
    }
}
