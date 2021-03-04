package cn.shishuihao.thirdparty.api.push.flyme;

import cn.shishuihao.thirdparty.api.core.channel.AbstractMemoryChannel;
import cn.shishuihao.thirdparty.api.push.PushApiChannel;
import cn.shishuihao.thirdparty.api.push.flyme.api.FlymePushMessageApi;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class FlymePushApiChannel extends AbstractMemoryChannel<FlymePushApiProperties> implements PushApiChannel<FlymePushApiProperties> {
    public static final String CHANNEL_ID = "push.flyme";

    private final FlymePushProperties channelProperties;

    public FlymePushApiChannel(FlymePushProperties channelProperties, FlymePushClient flymePushClient) {
        this.channelProperties = channelProperties;
        this.add(new FlymePushMessageApi(flymePushClient));
    }

    public FlymePushApiChannel(FlymePushProperties channelProperties) {
        this(channelProperties, new FlymePushClient());
    }

    public FlymePushApiChannel() {
        this(new FlymePushProperties());
    }

    @Override
    public String id() {
        return channelProperties.getChannelId();
    }

    @Override
    public Class<FlymePushApiProperties> propertiesType() {
        return FlymePushApiProperties.class;
    }
}
