package cn.shishuihao.thirdparty.api.push.xiaomi.assembler;

import cn.shishuihao.thirdparty.api.push.request.PushMessageApiRequest;
import cn.shishuihao.thirdparty.api.push.xiaomi.XiaomiPushApiProperties;
import com.xiaomi.xmpush.server.Message;

/**
 * 请求装配器.
 *
 * @author shishuihao
 * @version 1.0.0
 */

public class XiaomiPushRequestAssembler {
    /**
     * 实例.
     */
    public static final XiaomiPushRequestAssembler INSTANCE
            = new XiaomiPushRequestAssembler();

    /**
     * 装配 请求.
     *
     * @param request    请求
     * @param properties 配置属性
     * @return {@link Message}
     */
    public Message assemble(final PushMessageApiRequest request,
                            final XiaomiPushApiProperties properties) {
        return new Message.Builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .payload(request.getPayload())
                .restrictedPackageName(request.getRestrictedPackageName())
                // 使用默认提示音提示
                .notifyType(1)
                .build();
    }
}
