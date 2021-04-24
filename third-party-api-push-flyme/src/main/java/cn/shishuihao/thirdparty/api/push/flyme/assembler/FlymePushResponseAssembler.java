package cn.shishuihao.thirdparty.api.push.flyme.assembler;

import cn.shishuihao.thirdparty.api.push.response.PushMessageApiResponse;
import com.meizu.push.sdk.server.constant.ErrorCode;
import com.meizu.push.sdk.server.constant.ResultPack;

import java.util.Optional;

/**
 * 响应装配器.
 *
 * @author shishuihao
 * @version 1.0.0
 */

public class FlymePushResponseAssembler {
    /**
     * 实例.
     */
    public static final FlymePushResponseAssembler INSTANCE
            = new FlymePushResponseAssembler();

    /**
     * 装配.
     *
     * @param result 响应
     * @return {@link PushMessageApiResponse}
     */
    public PushMessageApiResponse assemble(final ResultPack<?> result) {
        return PushMessageApiResponse.builder()
                .success(ErrorCode.SUCCESS == result.getErrorCode())
                .code(Optional.ofNullable(result.getErrorCode())
                        .map(it -> it.getValue()
                                + ","
                                + it.getDescription())
                        .orElse(null))
                .message(result.comment())
                .build();
    }
}
