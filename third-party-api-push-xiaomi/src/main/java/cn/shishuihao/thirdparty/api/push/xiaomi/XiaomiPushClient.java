package cn.shishuihao.thirdparty.api.push.xiaomi;

import cn.shishuihao.thirdparty.api.core.properties.AbstractApiProperties;
import com.xiaomi.xmpush.server.Sender;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class XiaomiPushClient {
    /**
     * map.
     */
    private final Map<AbstractApiProperties, Sender> map
            = new ConcurrentHashMap<>();

    /**
     * get xiaomi push client.
     *
     * @param properties properties
     * @return Sender
     */
    public Sender getSender(final XiaomiPushApiProperties properties) {
        return map.computeIfAbsent(properties, k ->
                new Sender(properties.getAppSecretKey()));
    }
}
