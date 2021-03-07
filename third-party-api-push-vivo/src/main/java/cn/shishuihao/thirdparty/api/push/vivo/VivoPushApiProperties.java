package cn.shishuihao.thirdparty.api.push.vivo;

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
public class VivoPushApiProperties extends AbstractPushApiProperties {
    /**
     * 应用key.
     */
    private String appKey;
    /**
     * 密钥.
     */
    private String secret;

    /**
     * new VivoPushApiProperties.
     */
    public VivoPushApiProperties() {
        this.setChannelId(VivoPushApiChannel.CHANNEL_ID);
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
