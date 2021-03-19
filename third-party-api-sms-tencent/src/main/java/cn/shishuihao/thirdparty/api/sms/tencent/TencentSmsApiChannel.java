package cn.shishuihao.thirdparty.api.sms.tencent;

import cn.shishuihao.thirdparty.api.core.channel.AbstractMemoryChannel;
import cn.shishuihao.thirdparty.api.sms.SmsApiChannel;
import cn.shishuihao.thirdparty.api.sms.tencent.api.TencentSendBatchSmsApi;
import cn.shishuihao.thirdparty.api.sms.tencent.api.TencentSendSmsApi;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class TencentSmsApiChannel
        extends AbstractMemoryChannel<TencentSmsApiProperties>
        implements SmsApiChannel<TencentSmsApiProperties> {
    /**
     * channel id.
     */
    public static final String CHANNEL_ID = "sms.tencent";
    /**
     * channel properties.
     */
    private final TencentSmsApiChannelProperties channelProperties;

    /**
     * new TencentSmsApiChannel.
     *
     * @param properties channelProperties
     * @param client     tencent sms http client
     */
    public TencentSmsApiChannel(final TencentSmsApiChannelProperties properties,
                                final TencentSmsClient client) {
        this.channelProperties = properties;
        TencentSendBatchSmsApi batchSmsApi = new TencentSendBatchSmsApi(client);
        this.add(batchSmsApi);
        this.add(new TencentSendSmsApi(batchSmsApi));
    }

    /**
     * new TencentSmsApiChannel.
     *
     * @param prop channelProperties
     */
    public TencentSmsApiChannel(final TencentSmsApiChannelProperties prop) {
        this(prop, new TencentSmsClient(prop));
    }

    /**
     * new TencentSmsApiChannel.
     */
    public TencentSmsApiChannel() {
        this(new TencentSmsApiChannelProperties());
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
    public Class<TencentSmsApiProperties> propertiesType() {
        return TencentSmsApiProperties.class;
    }
}
