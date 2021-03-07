package cn.shishuihao.thirdparty.api.pay.weixin.sdk.domain;

import cn.shishuihao.thirdparty.api.pay.weixin.sdk.util.HmacDigestUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.UnsupportedEncodingException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * 签名算法.
 * {@link "https://pay.weixin.qq.com/wiki/doc/api/micropay.php?chapter=4_3"}
 *
 * @author shishuihao
 * @version 1.0.0
 */

public enum SignType {
    /**
     * MD5.
     */
    MD5 {
        @Override
        public String sign(final String signKey,
                           final Map<String, Object> params)
                throws UnsupportedEncodingException {
            return DigestUtils.md5Hex(getSignString(params, signKey)
                    .getBytes(getCharset(params)))
                    .toUpperCase();
        }
    },
    /**
     * HMAC_SHA256.
     */
    HMAC_SHA256 {
        @Override
        public String sign(final String signKey,
                           final Map<String, Object> params)
                throws UnsupportedEncodingException {
            return HmacDigestUtils.hmacSha256(getSignString(params, signKey)
                    .getBytes(getCharset(params)), signKey)
                    .toUpperCase();
        }

        @Override
        public String toString() {
            return "HMAC-SHA256";
        }
    };

    private static String getSignString(final Map<String, Object> params,
                                        final String signKey) {
        // 字典序排序 key=value格式
        if (params == null || params.isEmpty()) {
            return "";
        }
        Map<String, String> stringStringMap
                = new LinkedHashMap<>(params.size());
        params.forEach((k, v) -> stringStringMap
                .put(k, v == null ? null : v.toString()));
        String paramsString = stringStringMap.entrySet().stream()
                // 过滤
                .filter(it -> it.getKey() != null
                        && StringUtils.isNotBlank(it.getValue()))
                // 排序
                .sorted(Map.Entry.comparingByKey())
                // 拼接
                .map(it -> it.getKey() + "=" + it.getValue())
                .collect(Collectors.joining("&"));
        // 拼接密钥
        return paramsString + "&key=" + signKey;
    }

    private static String getCharset(final Map<String, Object> params) {
        return Optional.ofNullable(params.get("charset"))
                .map(Object::toString)
                .orElse("UTF-8");
    }

    /**
     * sign params.
     *
     * @param signKey sign key
     * @param params  params
     * @return sign
     * @throws UnsupportedEncodingException UnsupportedEncodingException
     */
    public abstract String sign(String signKey, Map<String, Object> params)
            throws UnsupportedEncodingException;
}
