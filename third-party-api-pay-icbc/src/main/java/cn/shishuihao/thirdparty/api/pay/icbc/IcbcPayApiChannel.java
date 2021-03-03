package cn.shishuihao.thirdparty.api.pay.icbc;

import cn.shishuihao.thirdparty.api.core.channel.AbstractMemoryChannel;
import cn.shishuihao.thirdparty.api.pay.PayApiChannel;
import cn.shishuihao.thirdparty.api.pay.icbc.api.IcbcCodePayApi;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class IcbcPayApiChannel extends AbstractMemoryChannel<IcbcPayApiProperties> implements PayApiChannel<IcbcPayApiProperties> {
    public static final String CHANNEL_ID = "pay.icbc";

    private final IcbcPayProperties channelProperties;

    public IcbcPayApiChannel(IcbcPayProperties channelProperties, IcbcPayClient icbcPayClient) {
        this.channelProperties = channelProperties;
        this.add(new IcbcCodePayApi(icbcPayClient));
    }

    public IcbcPayApiChannel(IcbcPayProperties channelProperties) {
        this(channelProperties, new IcbcPayClient());
    }

    public IcbcPayApiChannel() {
        this(new IcbcPayProperties());
    }

    @Override
    public String id() {
        return channelProperties.getChannelId();
    }

    @Override
    public Class<IcbcPayApiProperties> propertiesType() {
        return IcbcPayApiProperties.class;
    }
}
