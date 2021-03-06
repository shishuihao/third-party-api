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
    private final Map<AbstractApiProperties, IFlymePush> map = new ConcurrentHashMap<>();

    public IFlymePush getClient(FlymePushApiProperties properties) {
        return map.computeIfAbsent(properties, k -> new IFlymePush(properties.getAppSecret(), properties.isUseSsl()));
    }
}
