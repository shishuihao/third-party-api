package cn.shishuihao.thirdparty.api.push.oppo;

import cn.shishuihao.thirdparty.api.core.properties.AbstractApiProperties;
import com.oppo.push.server.Sender;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class OppoPushClient {
    /**
     * map.
     */
    private final Map<AbstractApiProperties, Sender> map
            = new ConcurrentHashMap<>();

    /**
     * get oppo push client.
     *
     * @param properties properties
     * @return Sender
     */
    public Sender getSender(final OppoPushApiProperties properties) {
        return map.computeIfAbsent(properties, k -> {
            try {
                return new Sender(
                        properties.getAppKey(),
                        properties.getMasterSecret());
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e) {
                throw new IllegalArgumentException(e);
            }
        });
    }
}
