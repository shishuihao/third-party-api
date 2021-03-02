package cn.shishuihao.thirdparty.api.pay.weixin;

import cn.shishuihao.thirdparty.api.core.channel.AbstractMemoryChannel;
import cn.shishuihao.thirdparty.api.pay.PayApiChannel;
import cn.shishuihao.thirdparty.api.pay.weixin.api.WxCodePayApi;
import cn.shishuihao.thirdparty.api.pay.weixin.sdk.WxPayClient;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class WxPayApiChannel extends AbstractMemoryChannel<WxPayApiProperties> implements PayApiChannel<WxPayApiProperties> {
    public static final String CHANNEL_ID = "pay.weixin";

    private final WxPayProperties channelProperties;

    public WxPayApiChannel(WxPayProperties channelProperties, WxPayClient wxPayClient) {
        this.channelProperties = channelProperties;
        this.add(new WxCodePayApi(wxPayClient));
    }

    public WxPayApiChannel(WxPayProperties channelProperties) {
        this(channelProperties, new WxPayClient());
    }

    public WxPayApiChannel() {
        this(new WxPayProperties());
    }

    @Override
    public String id() {
        return channelProperties.getChannelId();
    }

    @Override
    public Class<WxPayApiProperties> propertiesType() {
        return WxPayApiProperties.class;
    }
}
