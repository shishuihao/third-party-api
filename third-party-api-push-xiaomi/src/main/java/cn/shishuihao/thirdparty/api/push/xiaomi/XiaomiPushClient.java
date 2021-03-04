package cn.shishuihao.thirdparty.api.push.xiaomi;

import com.xiaomi.xmpush.server.Sender;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class XiaomiPushClient {
    private final Map<XiaomiPushApiProperties, Sender> map = new ConcurrentHashMap<>();

    public Sender getClient(XiaomiPushApiProperties properties) {
        return map.computeIfAbsent(properties, k -> new Sender(k.getAppSecretKey()));
    }
}
