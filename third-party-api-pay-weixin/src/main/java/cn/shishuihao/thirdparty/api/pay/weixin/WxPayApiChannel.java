package cn.shishuihao.thirdparty.api.pay.weixin;

import cn.shishuihao.thirdparty.api.core.channel.AbstractMemoryChannel;
import cn.shishuihao.thirdparty.api.pay.PayApiChannel;
import cn.shishuihao.thirdparty.api.pay.weixin.api.WxCodePayApi;
import cn.shishuihao.thirdparty.api.pay.weixin.api.WxQueryPayApi;
import cn.shishuihao.thirdparty.api.pay.weixin.sdk.WxFactory;
import cn.shishuihao.thirdparty.api.pay.weixin.sdk.api.WxPayCodeApi;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class WxPayApiChannel
        extends AbstractMemoryChannel<WxPayApiProperties>
        implements PayApiChannel<WxPayApiProperties> {
    /**
     * channel id.
     */
    public static final String CHANNEL_ID = "pay.weixin";
    /**
     * channel properties.
     */
    private final WxPayApiChannelProperties channelProperties;

    /**
     * new WxPayApiChannel.
     *
     * @param properties channel properties
     * @param codeApi    codeApi
     */
    public WxPayApiChannel(
            final WxPayApiChannelProperties properties,
            final WxPayCodeApi codeApi) {
        this.channelProperties = properties;
        this.save(new WxCodePayApi(codeApi));
        this.save(new WxQueryPayApi(codeApi));
    }

    /**
     * new WxPayApiChannel.
     *
     * @param properties channel properties
     */
    public WxPayApiChannel(final WxPayApiChannelProperties properties) {
        this(properties, WxFactory.Payment.codeApi());
    }

    /**
     * new WxPayApiChannel.
     */
    public WxPayApiChannel() {
        this(new WxPayApiChannelProperties());
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
    public Class<WxPayApiProperties> propertiesType() {
        return WxPayApiProperties.class;
    }
}
