package cn.shishuihao.thirdparty.api.pay.wechat;

import cn.shishuihao.thirdparty.api.pay.PayApiProperties;
import cn.shishuihao.thirdparty.api.pay.wechat.sdk.WechatProperties;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
public class WechatPayApiProperties
        extends WechatProperties
        implements PayApiProperties {
    /**
     * channel id.
     */
    private String channelId;

    /**
     * new WechatPayApiProperties.
     */
    public WechatPayApiProperties() {
        this.setChannelId(WechatPayApiChannel.CHANNEL_ID);
    }

    /**
     * get channel id.
     *
     * @return channel id
     */
    @Override
    public String channelId() {
        return channelId;
    }

    /**
     * get id.
     *
     * @return id
     */
    @Override
    public String id() {
        return String.join(":",
                String.valueOf(getAppId()),
                String.valueOf(getMchId()),
                String.valueOf(getSubAppId()),
                String.valueOf(getSubMchId()));
    }
}
