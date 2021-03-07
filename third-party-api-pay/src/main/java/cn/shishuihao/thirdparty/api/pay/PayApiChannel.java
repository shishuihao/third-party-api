package cn.shishuihao.thirdparty.api.pay;

import cn.shishuihao.thirdparty.api.core.channel.ApiChannel;

/**
 * @param <P> pay api properties
 * @author shishuihao
 * @version 1.0.0
 */
public interface PayApiChannel<
        P extends PayApiProperties> extends ApiChannel<P> {
}
