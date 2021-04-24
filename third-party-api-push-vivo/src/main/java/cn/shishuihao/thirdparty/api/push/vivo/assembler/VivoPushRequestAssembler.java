package cn.shishuihao.thirdparty.api.push.vivo.assembler;

import cn.shishuihao.thirdparty.api.push.request.PushMessageApiRequest;
import cn.shishuihao.thirdparty.api.push.vivo.VivoPushApiProperties;
import com.vivo.push.sdk.notofication.Message;

import java.util.UUID;

/**
 * 请求装配器.
 *
 * @author shishuihao
 * @version 1.0.0
 */

public class VivoPushRequestAssembler {
    /**
     * 实例.
     */
    public static final VivoPushRequestAssembler INSTANCE
            = new VivoPushRequestAssembler();

    /**
     * 装配 请求.
     *
     * @param request    请求
     * @param properties 配置属性
     * @return {@link Message}
     */
    public Message assemble(final PushMessageApiRequest request,
                            final VivoPushApiProperties properties) {
        return new Message.Builder()
                .requestId(UUID.randomUUID().toString())
                // 必填项，设置通知类型，value类型支持以下值：
                // 1：无 2：响铃 3：振动 4：响铃和振动
                .notifyType(1)
                // 必填项，设置点击跳转类型，value类型支持以下值：
                // 1：打开APP首页 2：打开链接 3：自定义 4：打开app内指定页面
                .skipType(1)
                .title(request.getTitle())
                .content(request.getPayload())
                .build();
    }
}
