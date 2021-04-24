package cn.shishuihao.thirdparty.api.push.flyme.assembler;

import cn.shishuihao.thirdparty.api.push.flyme.FlymePushApiProperties;
import cn.shishuihao.thirdparty.api.push.request.PushMessageApiRequest;
import com.meizu.push.sdk.server.model.push.VarnishedMessage;

/**
 * 请求装配器.
 *
 * @author shishuihao
 * @version 1.0.0
 */

public class FlymePushRequestAssembler {
    /**
     * 实例.
     */
    public static final FlymePushRequestAssembler INSTANCE
            = new FlymePushRequestAssembler();

    /**
     * 装配 请求.
     *
     * @param request    请求
     * @param properties 配置属性
     * @return {@link VarnishedMessage}
     */
    public VarnishedMessage assemble(
            final PushMessageApiRequest request,
            final FlymePushApiProperties properties) {
        return new VarnishedMessage.Builder()
                .appId(properties.getAppId())
                .title(request.getTitle())
                .content(request.getPayload())
                .build();
    }
}
