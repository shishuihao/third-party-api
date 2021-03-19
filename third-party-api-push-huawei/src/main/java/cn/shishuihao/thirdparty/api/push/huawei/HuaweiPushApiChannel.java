package cn.shishuihao.thirdparty.api.push.huawei;

import cn.shishuihao.thirdparty.api.core.channel.AbstractMemoryChannel;
import cn.shishuihao.thirdparty.api.push.PushApiChannel;
import cn.shishuihao.thirdparty.api.push.huawei.api.HuaweiPushMessageApi;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class HuaweiPushApiChannel
        extends AbstractMemoryChannel<HuaweiPushApiProperties>
        implements PushApiChannel<HuaweiPushApiProperties> {
    /**
     * channel id.
     */
    public static final String CHANNEL_ID = "push.huawei";
    /**
     * channel properties.
     */
    private final HuaweiPushApiChannelProperties channelProperties;

    /**
     * new HuaweiPushApiChannel.
     *
     * @param properties channelProperties
     */
    public HuaweiPushApiChannel(
            final HuaweiPushApiChannelProperties properties) {
        this.channelProperties = properties;
        this.add(new HuaweiPushMessageApi());
    }

    /**
     * new HuaweiPushApiChannel.
     */
    public HuaweiPushApiChannel() {
        this(new HuaweiPushApiChannelProperties());
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
    public Class<HuaweiPushApiProperties> propertiesType() {
        return HuaweiPushApiProperties.class;
    }
}
