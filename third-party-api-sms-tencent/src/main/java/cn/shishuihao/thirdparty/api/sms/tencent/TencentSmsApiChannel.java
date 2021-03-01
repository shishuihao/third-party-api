package cn.shishuihao.thirdparty.api.sms.tencent;

import cn.shishuihao.thirdparty.api.core.channel.AbstractMemoryChannel;
import cn.shishuihao.thirdparty.api.sms.SmsApiChannel;
import cn.shishuihao.thirdparty.api.sms.tencent.api.TencentSendBatchSmsApi;
import cn.shishuihao.thirdparty.api.sms.tencent.api.TencentSendSmsApi;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class TencentSmsApiChannel extends AbstractMemoryChannel<TencentSmsApiProperties> implements SmsApiChannel<TencentSmsApiProperties> {
    public static final String CHANNEL_ID = "sms.tencent";

    private final TencentSmsProperties channelProperties;

    public TencentSmsApiChannel(TencentSmsProperties channelProperties) {
        this.channelProperties = channelProperties;
        TencentSendBatchSmsApi batchSmsApi = new TencentSendBatchSmsApi();
        this.add(batchSmsApi);
        this.add(new TencentSendSmsApi(batchSmsApi));
    }

    public TencentSmsApiChannel() {
        this(new TencentSmsProperties());
    }

    @Override
    public String id() {
        return channelProperties.getChannelId();
    }

    @Override
    public Class<TencentSmsApiProperties> propertiesType() {
        return TencentSmsApiProperties.class;
    }
}
