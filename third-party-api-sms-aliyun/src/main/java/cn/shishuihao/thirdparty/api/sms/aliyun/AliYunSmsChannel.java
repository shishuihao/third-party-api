package cn.shishuihao.thirdparty.api.sms.aliyun;

import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.core.PropertiesRepository;
import cn.shishuihao.thirdparty.api.core.impl.memory.AbstractChannelMemoryImpl;
import cn.shishuihao.thirdparty.api.sms.SmsChannel;
import cn.shishuihao.thirdparty.api.sms.aliyun.api.AliYunSendBatchSmsApi;
import cn.shishuihao.thirdparty.api.sms.aliyun.api.AliYunSendSmsApi;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class AliYunSmsChannel extends AbstractChannelMemoryImpl implements SmsChannel {
    private final AliYunSmsChannelProperties channelProperties;

    public AliYunSmsChannel(AliYunSmsChannelProperties channelProperties,
                            PropertiesRepository propertiesRepository) {
        this.channelProperties = channelProperties;
        this.add(new AliYunSendBatchSmsApi(propertiesRepository));
        this.add(new AliYunSendSmsApi(propertiesRepository));
    }

    public AliYunSmsChannel() {
        this(new AliYunSmsChannelProperties(), ApiRegistry.PROPERTIES_REPOSITORY);
    }

    @Override
    public String id() {
        return channelProperties.getChannelId();
    }
}
