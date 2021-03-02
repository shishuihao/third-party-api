package cn.shishuihao.thirdparty.api.pay.weixin;

import cn.shishuihao.thirdparty.api.core.properties.AbstractApiProperties;
import cn.shishuihao.thirdparty.api.pay.PayApiProperties;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class WeixinPayApiProperties extends AbstractApiProperties implements PayApiProperties {
    public WeixinPayApiProperties() {
        this.setChannelId(WeixinPayApiChannel.CHANNEL_ID);
    }

    @Override
    public String id() {
        return null;
    }
}
