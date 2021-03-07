package cn.shishuihao.thirdparty.api.pay.weixin.sdk.util;

import org.apache.commons.codec.digest.HmacAlgorithms;
import org.apache.commons.codec.digest.HmacUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public final class HmacDigestUtils {
    /**
     * UTILS_MAP.
     */
    private static final Map<String, HmacUtils> UTILS_MAP
            = new ConcurrentHashMap<>();

    private HmacDigestUtils() {
    }

    private static HmacUtils getHmacUtils(final HmacAlgorithms algorithm,
                                          final String key) {
        return UTILS_MAP.computeIfAbsent(algorithm.getName() + key, k ->
                new HmacUtils(HmacAlgorithms.HMAC_SHA_256, key));
    }

    /**
     * hmac 256.
     *
     * @param data data
     * @param key  key
     * @return hmac 256
     */
    public static String hmacSha256(final byte[] data, final String key) {
        return getHmacUtils(HmacAlgorithms.HMAC_SHA_256, key).hmacHex(data);
    }

    /**
     * hmac 512.
     *
     * @param data data
     * @param key  key
     * @return hmac 512
     */
    public static String hmacSha512(final byte[] data, final String key) {
        return getHmacUtils(HmacAlgorithms.HMAC_SHA_512, key).hmacHex(data);
    }
}
