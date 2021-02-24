package cn.shishuihao.thirdparty.api.sms.tencent;

import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.core.ApiPropertiesRepository;
import cn.shishuihao.thirdparty.api.core.impl.memory.AbstractChannelMemoryImpl;
import cn.shishuihao.thirdparty.api.sms.SmsApiChannel;
import cn.shishuihao.thirdparty.api.sms.tencent.api.TencentSendBatchSmsApi;
import cn.shishuihao.thirdparty.api.sms.tencent.api.TencentSendSmsApi;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class TencentSmsApiChannel extends AbstractChannelMemoryImpl implements SmsApiChannel {
    private final TencentSmsProperties channelProperties;

    public TencentSmsApiChannel(TencentSmsProperties channelProperties,
                                ApiPropertiesRepository propertiesRepository) {
        this.channelProperties = channelProperties;
        TencentSendBatchSmsApi batchSmsApi = new TencentSendBatchSmsApi(propertiesRepository);
        this.add(batchSmsApi);
        this.add(new TencentSendSmsApi(batchSmsApi));
    }

    public TencentSmsApiChannel() {
        this(new TencentSmsProperties(), ApiRegistry.PROPERTIES_REPOSITORY);
    }

    @Override
    public String id() {
        return channelProperties.getChannelId();
    }
}
