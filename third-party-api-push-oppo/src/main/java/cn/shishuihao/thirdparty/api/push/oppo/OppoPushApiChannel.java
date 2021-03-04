package cn.shishuihao.thirdparty.api.push.oppo;

import cn.shishuihao.thirdparty.api.core.channel.AbstractMemoryChannel;
import cn.shishuihao.thirdparty.api.push.PushApiChannel;
import cn.shishuihao.thirdparty.api.push.oppo.api.OppoPushMessageApi;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class OppoPushApiChannel extends AbstractMemoryChannel<OppoPushApiProperties> implements PushApiChannel<OppoPushApiProperties> {
    public static final String CHANNEL_ID = "push.oppo";

    private final OppoPushProperties channelProperties;

    public OppoPushApiChannel(OppoPushProperties channelProperties, OppoPushClient oppoPushClient) {
        this.channelProperties = channelProperties;
        this.add(new OppoPushMessageApi(oppoPushClient));
    }

    public OppoPushApiChannel(OppoPushProperties channelProperties) {
        this(channelProperties, new OppoPushClient());
    }

    public OppoPushApiChannel() {
        this(new OppoPushProperties());
    }

    @Override
    public String id() {
        return channelProperties.getChannelId();
    }

    @Override
    public Class<OppoPushApiProperties> propertiesType() {
        return OppoPushApiProperties.class;
    }
}
