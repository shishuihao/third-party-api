package cn.shishuihao.thirdparty.api.push.xiaomi.assembler;

import cn.shishuihao.thirdparty.api.push.response.PushMessageApiResponse;
import com.xiaomi.push.sdk.ErrorCode;
import com.xiaomi.xmpush.server.Result;

import java.util.Optional;

/**
 * 响应装配器.
 *
 * @author shishuihao
 * @version 1.0.0
 */

public class XiaomiPushResponseAssembler {
    /**
     * 实例.
     */
    public static final XiaomiPushResponseAssembler INSTANCE
            = new XiaomiPushResponseAssembler();

    /**
     * 装配.
     *
     * @param result 响应
     * @return {@link PushMessageApiResponse}
     */
    public PushMessageApiResponse assemble(
            final Result result) {
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
    }
}
