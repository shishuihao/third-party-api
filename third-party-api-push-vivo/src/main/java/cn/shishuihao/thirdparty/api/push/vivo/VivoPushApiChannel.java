package cn.shishuihao.thirdparty.api.push.vivo;

import cn.shishuihao.thirdparty.api.core.channel.AbstractMemoryChannel;
import cn.shishuihao.thirdparty.api.push.PushApiChannel;
import cn.shishuihao.thirdparty.api.push.vivo.api.VivoPushMessageApi;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class VivoPushApiChannel extends AbstractMemoryChannel<VivoPushApiProperties> implements PushApiChannel<VivoPushApiProperties> {
    public static final String CHANNEL_ID = "push.vivo";

    private final VivoPushProperties channelProperties;

    public VivoPushApiChannel(VivoPushProperties channelProperties, VivoPushClient vivoPushClient) {
        this.channelProperties = channelProperties;
        this.add(new VivoPushMessageApi(vivoPushClient));
    }

    public VivoPushApiChannel(VivoPushProperties channelProperties) {
        this(channelProperties, new VivoPushClient());
    }

    public VivoPushApiChannel() {
        this(new VivoPushProperties());
    }

    @Override
    public String id() {
        return channelProperties.getChannelId();
    }

    @Override
    public Class<VivoPushApiProperties> propertiesType() {
        return VivoPushApiProperties.class;
    }
}
