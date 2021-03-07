package cn.shishuihao.thirdparty.api.push.flyme;

import cn.shishuihao.thirdparty.api.core.properties.AbstractApiProperties;
import com.meizu.push.sdk.server.IFlymePush;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class FlymePushClient {
    /**
     * map.
     */
    private final Map<AbstractApiProperties, IFlymePush> map
            = new ConcurrentHashMap<>();

    /**
     * get flyme push client.
     *
     * @param properties properties
     * @return Sender
     */
    public IFlymePush getClient(final FlymePushApiProperties properties) {
        return map.computeIfAbsent(properties, k ->
                new IFlymePush(
                        properties.getAppSecret(),
                        properties.isUseSsl()));
    }
}
