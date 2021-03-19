package cn.shishuihao.thirdparty.api.pay.alipay;

import cn.shishuihao.thirdparty.api.core.channel.AbstractMemoryChannel;
import cn.shishuihao.thirdparty.api.pay.PayApiChannel;
import cn.shishuihao.thirdparty.api.pay.alipay.api.AlipayCodePayApi;

/**
 * @author shishuihao
 * @version 1.0.0
 */
public class AlipayPayApiChannel
        extends AbstractMemoryChannel<AlipayPayApiProperties>
        implements PayApiChannel<AlipayPayApiProperties> {
    /**
     * channel id.
     */
    public static final String CHANNEL_ID = "pay.alipay";
    /**
     * channel properties.
     */
    private final AlipayPayApiChannelProperties channelProperties;

    /**
     * new AlipayPayApiChannel.
     *
     * @param properties channel properties
     * @param client     alipay pay http client
     */
    public AlipayPayApiChannel(final AlipayPayApiChannelProperties properties,
                               final AlipayPayClient client) {
        this.channelProperties = properties;
        this.add(new AlipayCodePayApi(client));
    }

    /**
     * new AlipayPayApiChannel.
     *
     * @param properties channel properties
     */
    public AlipayPayApiChannel(final AlipayPayApiChannelProperties properties) {
        this(properties, new AlipayPayClient());
    }

    /**
     * new AlipayPayApiChannel.
     */
    public AlipayPayApiChannel() {
        this(new AlipayPayApiChannelProperties());
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
    public Class<AlipayPayApiProperties> propertiesType() {
        return AlipayPayApiProperties.class;
    }
}
