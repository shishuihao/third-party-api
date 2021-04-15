package cn.shishuihao.thirdparty.api.pay.ccb.wlpt;

import cn.shishuihao.thirdparty.api.core.channel.AbstractMemoryChannel;
import cn.shishuihao.thirdparty.api.pay.PayApiChannel;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.api.CcbWlptQueryPayApi;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.api.CcbWlptRefundPayApi;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.api.CcbWlptRefundQueryPayApi;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.CcbWlptPayClient;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class CcbWlptPayApiChannel
        extends AbstractMemoryChannel<CcbWlptPayApiProperties>
        implements PayApiChannel<CcbWlptPayApiProperties> {
    /**
     * channel id.
     */
    public static final String CHANNEL_ID = "pay.ccb.wlpt";
    /**
     * channel properties.
     */
    private final CcbWlptPayApiChannelProperties channelProperties;

    /**
     * new CcbWlptPayApiChannel.
     *
     * @param properties channel properties
     * @param client     client
     */
    public CcbWlptPayApiChannel(
            final CcbWlptPayApiChannelProperties properties,
            final CcbWlptPayClient client) {
        this.channelProperties = properties;
        this.save(new CcbWlptQueryPayApi(client));
        this.save(new CcbWlptRefundPayApi(client));
        this.save(new CcbWlptRefundQueryPayApi(client));
    }

    /**
     * new CcbWlptPayApiChannel.
     *
     * @param properties channel properties
     */
    public CcbWlptPayApiChannel(
            final CcbWlptPayApiChannelProperties properties) {
        this(properties, new CcbWlptPayClient());
    }

    /**
     * new CcbWlptPayApiChannel.
     */
    public CcbWlptPayApiChannel() {
        this(new CcbWlptPayApiChannelProperties());
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
    public Class<CcbWlptPayApiProperties> propertiesType() {
        return CcbWlptPayApiProperties.class;
    }
}
