package cn.shishuihao.thirdparty.api.push.flyme;

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
public class FlymePushApiProperties extends AbstractPushApiProperties {
    /**
     * default retries.
     */
    public static final int DEFAULT_RETRIES = 3;
    /**
     * 应用id.
     */
    private Long appId;
    /**
     * 应用密钥.
     */
    private String appSecret;
    /**
     * 是否使用https接口调用.
     * true 使用https连接
     * false使用http连接
     */
    private boolean useSsl;
    /**
     * 尝试次数. >=1
     */
    private int retries = DEFAULT_RETRIES;

    /**
     * new FlymePushApiProperties.
     */
    public FlymePushApiProperties() {
        this.setChannelId(FlymePushApiChannel.CHANNEL_ID);
    }

    /**
     * get entity id.
     *
     * @return entity id
     */
    @Override
    public String id() {
        return String.valueOf(appId);
    }
}
