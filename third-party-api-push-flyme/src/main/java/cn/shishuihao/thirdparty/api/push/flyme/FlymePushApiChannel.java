package cn.shishuihao.thirdparty.api.push.flyme;

import cn.shishuihao.thirdparty.api.core.channel.AbstractMemoryChannel;
import cn.shishuihao.thirdparty.api.push.PushApiChannel;
import cn.shishuihao.thirdparty.api.push.flyme.api.FlymePushMessageApi;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class FlymePushApiChannel
        extends AbstractMemoryChannel<FlymePushApiProperties>
        implements PushApiChannel<FlymePushApiProperties> {
    /**
     * channel id.
     */
    public static final String CHANNEL_ID = "push.flyme";
    /**
     * channel properties.
     */
    private final FlymePushApiChannelProperties channelProperties;

    /**
     * new FlymePushApiChannel.
     *
     * @param properties channelProperties
     * @param client     oppo push http client
     */
    public FlymePushApiChannel(final FlymePushApiChannelProperties properties,
                               final FlymePushClient client) {
        this.channelProperties = properties;
        this.save(new FlymePushMessageApi(client));
    }

    /**
     * new FlymePushApiChannel.
     *
     * @param properties channelProperties
     */
    public FlymePushApiChannel(final FlymePushApiChannelProperties properties) {
        this(properties, new FlymePushClient());
    }

    /**
     * new FlymePushApiChannel.
     */
    public FlymePushApiChannel() {
        this(new FlymePushApiChannelProperties());
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
    public Class<FlymePushApiProperties> propertiesType() {
        return FlymePushApiProperties.class;
    }
}
