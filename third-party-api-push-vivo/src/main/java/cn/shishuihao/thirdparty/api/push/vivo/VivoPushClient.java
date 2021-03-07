package cn.shishuihao.thirdparty.api.push.vivo;

import cn.shishuihao.thirdparty.api.core.properties.AbstractApiProperties;
import com.vivo.push.sdk.server.Sender;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class VivoPushClient {
    /**
     * map.
     */
    private final Map<AbstractApiProperties, Sender>
            map = new ConcurrentHashMap<>();

    /**
     * get vivo push client.
     *
     * @param properties properties
     * @return Sender
     */
    public Sender getSender(final VivoPushApiProperties properties) {
        return map.computeIfAbsent(properties, k -> {
            try {
                return new Sender(properties.getSecret());
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e) {
                throw new IllegalArgumentException(e);
            }
        });
    }
}
