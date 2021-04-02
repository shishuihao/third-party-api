package cn.shishuihao.thirdparty.api.pay.icbc;

import cn.shishuihao.thirdparty.api.core.channel.AbstractMemoryChannel;
import cn.shishuihao.thirdparty.api.pay.PayApiChannel;
import cn.shishuihao.thirdparty.api.pay.icbc.api.IcbcCodePayApi;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class IcbcPayApiChannel
        extends AbstractMemoryChannel<IcbcPayApiProperties>
        implements PayApiChannel<IcbcPayApiProperties> {
    /**
     * gateway.
     */
    public static final String GATEWAY = "https://gw.open.icbc.com.cn";
    /**
     * channel id.
     */
    public static final String CHANNEL_ID = "pay.icbc";
    /**
     * channel properties.
     */
    private final IcbcPayApiChannelProperties channelProperties;

    /**
     * new IcbcPayApiChannel.
     *
     * @param properties channel properties
     * @param client     icbc pay http client
     */
    public IcbcPayApiChannel(final IcbcPayApiChannelProperties properties,
                             final IcbcPayClient client) {
        this.channelProperties = properties;
        this.save(new IcbcCodePayApi(client));
    }

    /**
     * new IcbcPayApiChannel.
     *
     * @param properties channel properties
     */
    public IcbcPayApiChannel(final IcbcPayApiChannelProperties properties) {
        this(properties, new IcbcPayClient());
    }

    /**
     * new IcbcPayApiChannel.
     */
    public IcbcPayApiChannel() {
        this(new IcbcPayApiChannelProperties());
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
    public Class<IcbcPayApiProperties> propertiesType() {
        return IcbcPayApiProperties.class;
    }
}
