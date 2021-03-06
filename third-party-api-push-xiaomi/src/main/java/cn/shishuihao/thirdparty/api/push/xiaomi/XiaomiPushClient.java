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
    private final Map<AbstractApiProperties, Sender> map = new ConcurrentHashMap<>();

    public Sender getSender(XiaomiPushApiProperties properties) {
        return map.computeIfAbsent(properties, k -> new Sender(properties.getAppSecretKey()));
    }
}
