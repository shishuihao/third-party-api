package cn.shishuihao.thirdparty.api.push.xiaomi;

import cn.shishuihao.thirdparty.api.core.channel.AbstractMemoryChannel;
import cn.shishuihao.thirdparty.api.push.PushApiChannel;
import cn.shishuihao.thirdparty.api.push.xiaomi.api.XiaomiPushMessageApi;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class XiaomiPushApiChannel extends AbstractMemoryChannel<XiaomiPushApiProperties> implements PushApiChannel<XiaomiPushApiProperties> {
    public static final String CHANNEL_ID = "push.xiaomi";

    private final XiaomiPushProperties channelProperties;

    public XiaomiPushApiChannel(XiaomiPushProperties channelProperties) {
        this.channelProperties = channelProperties;
        this.add(new XiaomiPushMessageApi());
    }

    public XiaomiPushApiChannel() {
        this(new XiaomiPushProperties());
    }

    @Override
    public String id() {
        return channelProperties.getChannelId();
    }

    @Override
    public Class<XiaomiPushApiProperties> propertiesType() {
        return XiaomiPushApiProperties.class;
    }
}
