package cn.shishuihao.thirdparty.api.push.oppo;

import cn.shishuihao.thirdparty.api.push.properties.AbstractPushApiProperties;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@EqualsAndHashCode(of = {"appKey"}, callSuper = true)
@Getter
@Setter
public class OppoPushApiProperties extends AbstractPushApiProperties {
    /**
     * 应用key.
     */
    private String appKey;
    /**
     * 密钥.
     */
    private String masterSecret;

    /**
     * new OppoPushApiProperties.
     */
    public OppoPushApiProperties() {
        this.setChannelId(OppoPushApiChannel.CHANNEL_ID);
    }

    /**
     * get entity id.
     *
     * @return entity id
     */
    @Override
    public String id() {
        return String.valueOf(appKey);
    }
}
