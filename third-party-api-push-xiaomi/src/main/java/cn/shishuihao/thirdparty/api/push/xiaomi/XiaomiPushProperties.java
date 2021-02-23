package cn.shishuihao.thirdparty.api.push.xiaomi;

import cn.shishuihao.thirdparty.api.push.PushProperties;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class XiaomiPushProperties implements PushProperties {
    /**
     * application id
     */
    private String appId;
    /**
     * application key
     */
    private String appKey;
    /**
     * application secret key
     */
    private String appSecretKey;

    public String getAppSecretKey() {
        return appSecretKey;
    }

    @Override
    public String id() {
        return null;
    }
}
