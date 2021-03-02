package cn.shishuihao.thirdparty.api.pay.weixin;

import cn.shishuihao.thirdparty.api.core.channel.AbstractMemoryChannel;
import cn.shishuihao.thirdparty.api.pay.PayApiChannel;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class WeixinPayApiChannel extends AbstractMemoryChannel<WeixinPayApiProperties> implements PayApiChannel<WeixinPayApiProperties> {
    public static final String CHANNEL_ID = "pay.weixin";

    private final WeixinPayProperties channelProperties;

    public WeixinPayApiChannel(WeixinPayProperties channelProperties) {
       this.channelProperties = channelProperties;
    }

    public WeixinPayApiChannel() {
        this(new WeixinPayProperties());
    }

    @Override
    public String id() {
        return channelProperties.getChannelId();
    }

    @Override
    public Class<WeixinPayApiProperties> propertiesType() {
        return WeixinPayApiProperties.class;
    }
}
