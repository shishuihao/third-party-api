package cn.shishuihao.thirdparty.api.push;

import cn.shishuihao.thirdparty.api.core.channel.ApiChannel;

/**
 * @param <P> push api properties
 * @author shishuihao
 * @version 1.0.0
 */
public interface PushApiChannel<
        P extends PushApiProperties>
        extends ApiChannel<P> {
}
