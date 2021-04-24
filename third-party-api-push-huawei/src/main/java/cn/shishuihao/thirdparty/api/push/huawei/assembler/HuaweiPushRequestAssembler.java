package cn.shishuihao.thirdparty.api.push.huawei.assembler;

import cn.shishuihao.thirdparty.api.push.huawei.HuaweiPushApiProperties;
import cn.shishuihao.thirdparty.api.push.huawei.sdk.domain.Message;
import cn.shishuihao.thirdparty.api.push.huawei.sdk.domain.Notification;
import cn.shishuihao.thirdparty.api.push.huawei.sdk.request.HuaweiSendMessageRequest;
import cn.shishuihao.thirdparty.api.push.request.PushMessageApiRequest;

import java.util.Arrays;

/**
 * 请求装配器.
 *
 * @author shishuihao
 * @version 1.0.0
 */

public class HuaweiPushRequestAssembler {
    /**
     * 实例.
     */
    public static final HuaweiPushRequestAssembler INSTANCE
            = new HuaweiPushRequestAssembler();

    /**
     * 装配 请求.
     *
     * @param request    请求
     * @param properties 配置属性
     * @return {@link HuaweiSendMessageRequest}
     */
    public HuaweiSendMessageRequest assemble(
            final PushMessageApiRequest request,
            final HuaweiPushApiProperties properties) {
        return HuaweiSendMessageRequest
                .builder()
                .validateOnly(false)
                .message(Message.builder()
                        .notification(Notification.builder()
                                .title(request.getTitle())
                                .body(request.getPayload())
                                .build())
                        .token(Arrays.asList(request.getRegistrationIds()))
                        .build())
                .build();
    }
}
