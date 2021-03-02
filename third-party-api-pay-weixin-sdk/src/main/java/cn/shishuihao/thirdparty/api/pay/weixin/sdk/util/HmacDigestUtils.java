package cn.shishuihao.thirdparty.api.pay.weixin.sdk.util;

import org.apache.commons.codec.digest.HmacAlgorithms;
import org.apache.commons.codec.digest.HmacUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class HmacDigestUtils {
    private static final Map<String, HmacUtils> UTILS_MAP = new ConcurrentHashMap<>();

    private static HmacUtils getHmacUtils(final HmacAlgorithms algorithm, final String key) {
        return UTILS_MAP.computeIfAbsent(algorithm.getName() + key, (k) ->
                new HmacUtils(HmacAlgorithms.HMAC_SHA_256, key));
    }

    public static String hmacSha256(final byte[] data, final String key) {
        return getHmacUtils(HmacAlgorithms.HMAC_SHA_256, key).hmacHex(data);
    }
}
