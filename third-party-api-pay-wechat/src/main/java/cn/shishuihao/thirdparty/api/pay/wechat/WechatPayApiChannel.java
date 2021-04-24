package cn.shishuihao.thirdparty.api.pay.wechat;

import cn.shishuihao.thirdparty.api.core.channel.AbstractMemoryChannel;
import cn.shishuihao.thirdparty.api.pay.PayApiChannel;
import cn.shishuihao.thirdparty.api.pay.wechat.api.WechatCodePayApi;
import cn.shishuihao.thirdparty.api.pay.wechat.api.WechatQueryPayApi;
import cn.shishuihao.thirdparty.api.pay.wechat.sdk.WechatPayClient;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class WechatPayApiChannel
        extends AbstractMemoryChannel<WechatPayApiProperties>
        implements PayApiChannel<WechatPayApiProperties> {
    /**
     * channel id.
     */
    public static final String CHANNEL_ID = "pay.wechat";
    /**
     * channel properties.
     */
    private final WechatPayApiChannelProperties channelProperties;

    /**
     * new WechatPayApiChannel.
     *
     * @param properties channel properties
     * @param client     client
     */
    public WechatPayApiChannel(
            final WechatPayApiChannelProperties properties,
            final WechatPayClient client) {
        this.channelProperties = properties;
        this.save(new WechatCodePayApi(client));
        this.save(new WechatQueryPayApi(client));
    }

    /**
     * new WechatPayApiChannel.
     *
     * @param properties channel properties
     */
    public WechatPayApiChannel(final WechatPayApiChannelProperties properties) {
        this(properties, new WechatPayClient());
    }

    /**
     * new WechatPayApiChannel.
     */
    public WechatPayApiChannel() {
        this(new WechatPayApiChannelProperties());
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
    public Class<WechatPayApiProperties> propertiesType() {
        return WechatPayApiProperties.class;
    }
}
