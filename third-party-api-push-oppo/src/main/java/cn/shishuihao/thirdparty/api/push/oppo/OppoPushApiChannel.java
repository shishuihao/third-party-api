package cn.shishuihao.thirdparty.api.push.oppo;

import cn.shishuihao.thirdparty.api.core.channel.AbstractMemoryChannel;
import cn.shishuihao.thirdparty.api.push.PushApiChannel;
import cn.shishuihao.thirdparty.api.push.oppo.api.OppoPushMessageApi;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class OppoPushApiChannel
        extends AbstractMemoryChannel<OppoPushApiProperties>
        implements PushApiChannel<OppoPushApiProperties> {
    /**
     * channel id.
     */
    public static final String CHANNEL_ID = "push.oppo";
    /**
     * channel properties.
     */
    private final OppoPushApiChannelProperties channelProperties;

    /**
     * new OppoPushApiChannel.
     *
     * @param properties channelProperties
     * @param client     oppo push http client
     */
    public OppoPushApiChannel(final OppoPushApiChannelProperties properties,
                              final OppoPushClient client) {
        this.channelProperties = properties;
        this.save(new OppoPushMessageApi(client));
    }

    /**
     * new OppoPushApiChannel.
     *
     * @param properties channelProperties
     */
    public OppoPushApiChannel(final OppoPushApiChannelProperties properties) {
        this(properties, new OppoPushClient());
    }

    /**
     * new OppoPushApiChannel.
     */
    public OppoPushApiChannel() {
        this(new OppoPushApiChannelProperties());
    }

    /**
     * get entity id.
     *
     * @return entity id
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
    public Class<OppoPushApiProperties> propertiesType() {
        return OppoPushApiProperties.class;
    }
}
