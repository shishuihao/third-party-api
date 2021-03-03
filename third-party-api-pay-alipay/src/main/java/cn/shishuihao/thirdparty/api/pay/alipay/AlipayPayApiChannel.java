package cn.shishuihao.thirdparty.api.pay.alipay;

import cn.shishuihao.thirdparty.api.core.channel.AbstractMemoryChannel;
import cn.shishuihao.thirdparty.api.pay.PayApiChannel;
import cn.shishuihao.thirdparty.api.pay.alipay.api.AlipayCodePayApi;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class AlipayPayApiChannel extends AbstractMemoryChannel<AlipayPayApiProperties> implements PayApiChannel<AlipayPayApiProperties> {
    public static final String CHANNEL_ID = "pay.alipay";

    private final AlipayPayProperties channelProperties;

    public AlipayPayApiChannel(AlipayPayProperties channelProperties, AlipayPayClient alipayPayClient) {
        this.channelProperties = channelProperties;
        this.add(new AlipayCodePayApi(alipayPayClient));
    }

    public AlipayPayApiChannel(AlipayPayProperties channelProperties) {
        this(channelProperties, new AlipayPayClient());
    }

    public AlipayPayApiChannel() {
        this(new AlipayPayProperties());
    }

    @Override
    public String id() {
        return channelProperties.getChannelId();
    }

    @Override
    public Class<AlipayPayApiProperties> propertiesType() {
        return AlipayPayApiProperties.class;
    }
}
