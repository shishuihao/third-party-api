package cn.shishuihao.thirdparty.api.sms.aliyun;

import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.core.ApiPropertiesRepository;
import cn.shishuihao.thirdparty.api.core.impl.memory.AbstractMemoryChannel;
import cn.shishuihao.thirdparty.api.sms.SmsApiChannel;
import cn.shishuihao.thirdparty.api.sms.aliyun.api.AliYunSendBatchSmsApi;
import cn.shishuihao.thirdparty.api.sms.aliyun.api.AliYunSendSmsApi;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class AliYunSmsApiChannel extends AbstractMemoryChannel implements SmsApiChannel {
    private final AliYunSmsProperties channelProperties;

    public AliYunSmsApiChannel(AliYunSmsProperties channelProperties,
                               ApiPropertiesRepository propertiesRepository) {
        this.channelProperties = channelProperties;
        this.add(new AliYunSendBatchSmsApi(propertiesRepository));
        this.add(new AliYunSendSmsApi(propertiesRepository));
    }

    public AliYunSmsApiChannel() {
        this(new AliYunSmsProperties(), ApiRegistry.PROPERTIES_REPOSITORY);
    }

    @Override
    public String id() {
        return channelProperties.getChannelId();
    }
}
