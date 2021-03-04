package cn.shishuihao.thirdparty.api.push.flyme;

import com.meizu.push.sdk.server.IFlymePush;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class FlymePushClient {
    private final Map<FlymePushApiProperties, IFlymePush> map = new ConcurrentHashMap<>();

    public IFlymePush getClient(FlymePushApiProperties properties) {
        return map.computeIfAbsent(properties, k -> new IFlymePush(k.getAppSecret(), k.isUseSSL()));
    }
}
