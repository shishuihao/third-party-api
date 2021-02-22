package cn.shishuihao.thirdparty.api.sms.tencent;

import cn.shishuihao.thirdparty.api.core.PropertiesRepository;
import cn.shishuihao.thirdparty.api.core.impl.AbstractChannel;
import cn.shishuihao.thirdparty.api.sms.SmsChannel;
import cn.shishuihao.thirdparty.api.sms.tencent.api.TencentSendBatchSmsApi;
import cn.shishuihao.thirdparty.api.sms.tencent.api.TencentSendSmsApi;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class TencentSmsChannel extends AbstractChannel implements SmsChannel {
    private final TencentSmsChannelProperties channelProperties;

    public TencentSmsChannel(TencentSmsChannelProperties channelProperties,
                             PropertiesRepository propertiesRepository) {
        this.channelProperties = channelProperties;
        TencentSendBatchSmsApi batchSmsApi = new TencentSendBatchSmsApi(propertiesRepository);
        this.add(batchSmsApi);
        this.add(new TencentSendSmsApi(batchSmsApi));
    }

    @Override
    public String id() {
        return channelProperties.getChannelId();
    }
}
