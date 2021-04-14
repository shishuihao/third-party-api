package cn.shishuihao.thirdparty.api.pay.ccb.wlpt;

import cn.shishuihao.thirdparty.api.pay.PayApiProperties;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.CcbWlptProperties;
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
public class CcbWlptPayApiProperties
        extends CcbWlptProperties
        implements PayApiProperties {
    /**
     * channel id.
     */
    private String channelId;

    /**
     * new CcbWlptPayApiProperties.
     */
    public CcbWlptPayApiProperties() {
        this.setChannelId(CcbWlptPayApiChannel.CHANNEL_ID);
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
        return this.getMerchantId();
    }
}
