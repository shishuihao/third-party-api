package cn.shishuihao.thirdparty.api.push.huawei;

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
public class HuaweiPushApiProperties extends AbstractPushApiProperties {
    /**
     * application id.
     */
    private String appId;

    /**
     * new HuaweiPushApiProperties.
     */
    public HuaweiPushApiProperties() {
        this.setChannelId(HuaweiPushApiChannel.CHANNEL_ID);
    }

    /**
     * get entity id.
     *
     * @return entity id
     */
    @Override
    public String id() {
        return appId;
    }
}
