package cn.shishuihao.thirdparty.api.pay.wechat;

import cn.shishuihao.thirdparty.api.core.channel.AbstractMemoryChannel;
import cn.shishuihao.thirdparty.api.pay.PayApiChannel;
import cn.shishuihao.thirdparty.api.pay.wechat.api.WechatCodePayApi;
import cn.shishuihao.thirdparty.api.pay.wechat.api.WechatQueryPayApi;
import cn.shishuihao.thirdparty.api.pay.wechat.sdk.WechatFactory;
import cn.shishuihao.thirdparty.api.pay.wechat.sdk.api.WechatPayCodeApi;

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
     * @param codeApi    codeApi
     */
    public WechatPayApiChannel(
            final WechatPayApiChannelProperties properties,
            final WechatPayCodeApi codeApi) {
        this.channelProperties = properties;
        this.save(new WechatCodePayApi(codeApi));
        this.save(new WechatQueryPayApi(codeApi));
    }

    /**
     * new WechatPayApiChannel.
     *
     * @param properties channel properties
     */
    public WechatPayApiChannel(final WechatPayApiChannelProperties properties) {
        this(properties, WechatFactory.Payment.codeApi());
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
