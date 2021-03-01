package cn.shishuihao.thirdparty.api.core.properties;

import cn.shishuihao.thirdparty.api.core.repository.Entity;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public interface ApiProperties extends Entity<String> {
    /**
     * get channel id
     *
     * @return channel id
     */
    String channelId();
}
