package cn.shishuihao.thirdparty.api.push.oppo.assembler;

import cn.shishuihao.thirdparty.api.push.oppo.OppoPushApiProperties;
import cn.shishuihao.thirdparty.api.push.request.PushMessageApiRequest;
import com.oppo.push.server.Notification;

/**
 * 请求装配器.
 *
 * @author shishuihao
 * @version 1.0.0
 */

public class OppoPushRequestAssembler {
    /**
     * 实例.
     */
    public static final OppoPushRequestAssembler INSTANCE
            = new OppoPushRequestAssembler();

    /**
     * 装配 请求.
     *
     * @param request    请求
     * @param properties 配置属性
     * @return {@link Notification}
     */
    public Notification assemble(
            final PushMessageApiRequest request,
            final OppoPushApiProperties properties) {
        Notification notification = new Notification();
        notification.setTitle(request.getTitle());
        notification.setContent(request.getPayload());
        return notification;
    }
}
