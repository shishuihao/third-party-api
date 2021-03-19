package cn.shishuihao.thirdparty.api.push.xiaomi;

import cn.shishuihao.thirdparty.api.push.properties.AbstractPushApiProperties;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@EqualsAndHashCode(of = {"appId"}, callSuper = true)
@Getter
@Setter
public class XiaomiPushApiProperties extends AbstractPushApiProperties {
    /**
     * default retries.
     */
    public static final int DEFAULT_RETRIES = 3;

    /**
     * application id.
     */
    private String appId;
    /**
     * application secret key.
     */
    private String appSecretKey;
    /**
     * 尝试次数. >=1
     */
    private int retries = DEFAULT_RETRIES;

    /**
     * new XiaomiPushApiProperties.
     */
    public XiaomiPushApiProperties() {
        this.setChannelId(XiaomiPushApiChannel.CHANNEL_ID);
    }

    /**
     * get id.
     *
     * @return id
     */
    @Override
    public String id() {
        return appId;
    }
}
