package cn.shishuihao.thirdparty.api.push.vivo.assembler;

import cn.shishuihao.thirdparty.api.push.response.PushMessageApiResponse;
import com.vivo.push.sdk.notofication.Result;

/**
 * 响应装配器.
 *
 * @author shishuihao
 * @version 1.0.0
 */

public class VivoPushResponseAssembler {
    /**
     * 实例.
     */
    public static final VivoPushResponseAssembler INSTANCE
            = new VivoPushResponseAssembler();

    /**
     * 装配.
     *
     * @param requestId 请求id
     * @param result    响应
     * @return {@link PushMessageApiResponse}
     */
    public PushMessageApiResponse assemble(
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
