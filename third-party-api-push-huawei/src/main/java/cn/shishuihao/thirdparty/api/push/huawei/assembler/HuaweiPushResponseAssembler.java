package cn.shishuihao.thirdparty.api.push.huawei.assembler;

import cn.shishuihao.thirdparty.api.push.huawei.sdk.response.HuaweiSendMessageResponse;
import cn.shishuihao.thirdparty.api.push.huawei.sdk.util.ResponseChecker;
import cn.shishuihao.thirdparty.api.push.response.PushMessageApiResponse;

/**
 * 响应装配器.
 *
 * @author shishuihao
 * @version 1.0.0
 */

public class HuaweiPushResponseAssembler {
    /**
     * 实例.
     */
    public static final HuaweiPushResponseAssembler INSTANCE
            = new HuaweiPushResponseAssembler();

    /**
     * 装配.
     *
     * @param response 响应
     * @return {@link PushMessageApiResponse}
     */
    public PushMessageApiResponse assemble(
            final HuaweiSendMessageResponse response) {
        return PushMessageApiResponse.builder()
                .success(ResponseChecker.success(response))
                .code(response.getCode())
                .message(response.getMsg())
                .requestId(response.getRequestId())
                .build();
    }
}
