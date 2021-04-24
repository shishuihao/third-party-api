package cn.shishuihao.thirdparty.api.pay.ccb;

import cn.shishuihao.thirdparty.api.core.channel.AbstractMemoryChannel;
import cn.shishuihao.thirdparty.api.pay.PayApiChannel;
import cn.shishuihao.thirdparty.api.pay.ccb.api.CcbCancelPayApi;
import cn.shishuihao.thirdparty.api.pay.ccb.api.CcbCodePayApi;
import cn.shishuihao.thirdparty.api.pay.ccb.sdk.CcbPayClient;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.api.CcbWlptQueryPayApi;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.api.CcbWlptRefundPayApi;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.api.CcbWlptRefundQueryPayApi;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class CcbPayApiChannel
        extends AbstractMemoryChannel<CcbPayApiProperties>
        implements PayApiChannel<CcbPayApiProperties> {
    /**
     * channel id.
     */
    public static final String CHANNEL_ID = "pay.ccb";
    /**
     * channel properties.
     */
    private final CcbPayApiChannelProperties channelProperties;

    /**
     * new CcbPayApiChannel.
     *
     * @param properties channel properties
     * @param client     client
     */
    public CcbPayApiChannel(
            final CcbPayApiChannelProperties properties,
            final CcbPayClient client) {
        this.channelProperties = properties;
        this.save(new CcbCancelPayApi(client));
        this.save(new CcbCodePayApi(client));
        // 外联平台
        this.save(new CcbWlptQueryPayApi(client));
        this.save(new CcbWlptRefundPayApi(client));
        this.save(new CcbWlptRefundQueryPayApi(client));
    }

    /**
     * new CcbPayApiChannel.
     *
     * @param properties channel properties
     */
    public CcbPayApiChannel(
            final CcbPayApiChannelProperties properties) {
        this(properties, new CcbPayClient());
    }

    /**
     * new CcbPayApiChannel.
     */
    public CcbPayApiChannel() {
        this(new CcbPayApiChannelProperties());
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
    public Class<CcbPayApiProperties> propertiesType() {
        return CcbPayApiProperties.class;
    }
}
