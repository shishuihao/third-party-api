package cn.shishuihao.thirdparty.api.sms.aliyun;

import cn.shishuihao.thirdparty.api.core.impl.memory.AbstractMemoryChannel;
import cn.shishuihao.thirdparty.api.sms.SmsApiChannel;
import cn.shishuihao.thirdparty.api.sms.aliyun.api.AliYunSendBatchSmsApi;
import cn.shishuihao.thirdparty.api.sms.aliyun.api.AliYunSendSmsApi;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class AliYunSmsApiChannel extends AbstractMemoryChannel<AliYunSmsApiProperties> implements SmsApiChannel<AliYunSmsApiProperties> {
    public static final String CHANNEL_ID = "sms.aliyun";

    private final AliYunSmsProperties channelProperties;

    public AliYunSmsApiChannel(AliYunSmsProperties channelProperties) {
        this.channelProperties = channelProperties;
        this.add(new AliYunSendBatchSmsApi());
        this.add(new AliYunSendSmsApi());
    }

    public AliYunSmsApiChannel() {
        this(new AliYunSmsProperties());
    }

    @Override
    public String id() {
        return channelProperties.getChannelId();
    }

    @Override
    public Class<AliYunSmsApiProperties> propertiesType() {
        return AliYunSmsApiProperties.class;
    }
}
