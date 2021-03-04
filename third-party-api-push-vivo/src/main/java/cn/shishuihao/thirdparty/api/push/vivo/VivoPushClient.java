package cn.shishuihao.thirdparty.api.push.vivo;

import com.vivo.push.sdk.server.Sender;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class VivoPushClient {
    private final Map<VivoPushApiProperties, Sender> map = new ConcurrentHashMap<>();

    public Sender getSender(VivoPushApiProperties properties) {
        return map.computeIfAbsent(properties, k -> {
            try {
                return new Sender(k.getSecret());
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e) {
                throw new IllegalArgumentException(e);
            }
        });
    }
}
