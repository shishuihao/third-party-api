package cn.shishuihao.thirdparty.api.push.vivo;

import cn.shishuihao.thirdparty.api.core.channel.AbstractMemoryChannel;
import cn.shishuihao.thirdparty.api.push.PushApiChannel;
import cn.shishuihao.thirdparty.api.push.vivo.api.VivoPushMessageApi;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class VivoPushApiChannel
        extends AbstractMemoryChannel<VivoPushApiProperties>
        implements PushApiChannel<VivoPushApiProperties> {
    /**
     * channel id.
     */
    public static final String CHANNEL_ID = "push.vivo";
    /**
     * channel properties.
     */
    private final VivoPushApiChannelProperties channelProperties;

    /**
     * new VivoPushApiChannel.
     *
     * @param properties channelProperties
     * @param client     vivo push http client
     */
    public VivoPushApiChannel(final VivoPushApiChannelProperties properties,
                              final VivoPushClient client) {
        this.channelProperties = properties;
        this.add(new VivoPushMessageApi(client));
    }

    /**
     * new VivoPushApiChannel.
     *
     * @param properties channelProperties
     */
    public VivoPushApiChannel(final VivoPushApiChannelProperties properties) {
        this(properties, new VivoPushClient());
    }

    /**
     * new VivoPushApiChannel.
     */
    public VivoPushApiChannel() {
        this(new VivoPushApiChannelProperties());
    }

    /**
     * get id.
     *
     * @return id
     */
    @Override
    public String id() {
        return channelProperties.getChannelId();
    }

    /**
     * get properties type.
     * immutable
     *
     * @return properties type
     */
    @Override
    public Class<VivoPushApiProperties> propertiesType() {
        return VivoPushApiProperties.class;
    }
}
