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
 * @author shishuihao
 * @version 1.0.0
 */

public enum SignType {
    /**
     * 签名算法
     */
    // MD5
    MD5 {
        @Override
        public String sign(String signKey, Map<String, Object> params) throws UnsupportedEncodingException {
            return DigestUtils.md5Hex(getSignString(params, signKey).getBytes(getCharset(params))).toUpperCase();
        }
    },
    // HMAC-SHA256
    HMAC_SHA256 {
        @Override
        public String sign(String signKey, Map<String, Object> params) throws UnsupportedEncodingException {
            return HmacDigestUtils.hmacSha256(getSignString(params, signKey).getBytes(getCharset(params)), signKey).toUpperCase();
        }

        @Override
        public String toString() {
            return "HMAC-SHA256";
        }
    };

    private static String getSignString(Map<String, Object> params, String signKey) {
        // 字典序排序 key=value格式
        if (params == null || params.isEmpty()) {
            return "";
        }
        Map<String, String> stringStringMap = new LinkedHashMap<>(params.size());
        params.forEach((k, v) -> stringStringMap.put(k, v == null ? null : v.toString()));
        String paramsString = stringStringMap.entrySet().stream()
                // 过滤
                .filter(it -> it.getKey() != null && StringUtils.isNotBlank(it.getValue()))
                // 排序
                .sorted(Map.Entry.comparingByKey())
                // 拼接
                .map(it -> it.getKey() + "=" + it.getValue())
                .collect(Collectors.joining("&"));
        // 拼接密钥
        return paramsString + "&key=" + signKey;
    }

    private static String getCharset(Map<String, Object> params) {
        return Optional.ofNullable(params.get("charset"))
                .map(Object::toString)
                .orElse("UTF-8");
    }

    public abstract String sign(String signKey, Map<String, Object> params) throws UnsupportedEncodingException;
}
