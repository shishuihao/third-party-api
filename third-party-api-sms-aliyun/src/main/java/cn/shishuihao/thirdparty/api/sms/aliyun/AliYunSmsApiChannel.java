package cn.shishuihao.thirdparty.api.sms.aliyun;

import cn.shishuihao.thirdparty.api.core.channel.AbstractMemoryChannel;
import cn.shishuihao.thirdparty.api.sms.SmsApiChannel;
import cn.shishuihao.thirdparty.api.sms.aliyun.api.AliYunSendBatchSmsApi;
import cn.shishuihao.thirdparty.api.sms.aliyun.api.AliYunSendSmsApi;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class AliYunSmsApiChannel
        extends AbstractMemoryChannel<AliYunSmsApiProperties>
        implements SmsApiChannel<AliYunSmsApiProperties> {
    /**
     * gateway.
     */
    public static final String ENDPOINT = "dysmsapi.aliyuncs.com";
    /**
     * channel id.
     */
    public static final String CHANNEL_ID = "sms.aliyun";
    /**
     * channel properties.
     */
    private final AliYunSmsApiChannelProperties channelProperties;

    /**
     * new AliYunSmsApiChannel.
     *
     * @param properties channelProperties
     * @param client     aliyun sms http client
     */
    public AliYunSmsApiChannel(final AliYunSmsApiChannelProperties properties,
                               final AliYunSmsClient client) {
        this.channelProperties = properties;
        this.add(new AliYunSendBatchSmsApi(client));
        this.add(new AliYunSendSmsApi(client));
    }

    /**
     * new AliYunSmsApiChannel.
     *
     * @param properties channelProperties
     */
    public AliYunSmsApiChannel(final AliYunSmsApiChannelProperties properties) {
        this(properties, new AliYunSmsClient());
    }

    /**
     * new AliYunSmsApiChannel.
     */
    public AliYunSmsApiChannel() {
        this(new AliYunSmsApiChannelProperties());
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
    public Class<AliYunSmsApiProperties> propertiesType() {
        return AliYunSmsApiProperties.class;
    }
}
