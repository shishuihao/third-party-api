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
    private final Map<AbstractApiProperties, Sender> map = new ConcurrentHashMap<>();

    public Sender getSender(OppoPushApiProperties properties) {
        return map.computeIfAbsent(properties, k -> {
            try {
                return new Sender(properties.getAppKey(), properties.getMasterSecret());
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e) {
                throw new IllegalArgumentException(e);
            }
        });
    }
}
