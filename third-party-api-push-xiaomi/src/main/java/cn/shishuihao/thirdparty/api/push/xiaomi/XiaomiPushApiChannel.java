package cn.shishuihao.thirdparty.api.push.xiaomi;

import cn.shishuihao.thirdparty.api.core.channel.AbstractMemoryChannel;
import cn.shishuihao.thirdparty.api.push.PushApiChannel;
import cn.shishuihao.thirdparty.api.push.xiaomi.api.XiaomiPushMessageApi;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class XiaomiPushApiChannel
        extends AbstractMemoryChannel<XiaomiPushApiProperties>
        implements PushApiChannel<XiaomiPushApiProperties> {
    /**
     * channel id.
     */
    public static final String CHANNEL_ID = "push.xiaomi";
    /**
     * channel properties.
     */
    private final XiaomiPushApiChannelProperties channelProperties;

    /**
     * new XiaomiPushApiChannel.
     *
     * @param properties channelProperties
     * @param client     xiaomi push http client
     */
    public XiaomiPushApiChannel(final XiaomiPushApiChannelProperties properties,
                                final XiaomiPushClient client) {
        this.channelProperties = properties;
        this.add(new XiaomiPushMessageApi(client));
    }

    /**
     * new XiaomiPushApiChannel.
     *
     * @param prop channelProperties
     */
    public XiaomiPushApiChannel(final XiaomiPushApiChannelProperties prop) {
        this(prop, new XiaomiPushClient());
    }

    /**
     * new XiaomiPushApiChannel.
     */
    public XiaomiPushApiChannel() {
        this(new XiaomiPushApiChannelProperties());
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
    public Class<XiaomiPushApiProperties> propertiesType() {
        return XiaomiPushApiProperties.class;
    }
}
