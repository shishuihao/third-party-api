package cn.shishuihao.thirdparty.api.push.xiaomi;

import cn.shishuihao.thirdparty.api.core.PropertiesRepository;
import cn.shishuihao.thirdparty.api.core.impl.AbstractChannel;
import cn.shishuihao.thirdparty.api.push.PushChannel;
import cn.shishuihao.thirdparty.api.push.xiaomi.api.XiaomiPushMessageApi;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class XiaomiPushChannel extends AbstractChannel implements PushChannel {
    private final XiaomiPushChannelProperties channelProperties;

    public XiaomiPushChannel(XiaomiPushChannelProperties channelProperties,
                             PropertiesRepository propertiesRepository) {
        this.channelProperties = channelProperties;
        this.add(new XiaomiPushMessageApi(propertiesRepository));
    }

    @Override
    public String id() {
        return channelProperties.getChannelId();
    }
}
