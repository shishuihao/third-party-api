package cn.shishuihao.thirdparty.api.pay.ccb.hsb.sdk.util;

import cn.shishuihao.thirdparty.api.commons.json.JacksonUtils;
import com.ccb.mktpay.sign.RSASignUtil;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@SuppressWarnings({"rawtypes", "unchecked"})
public final class SignUtils {
    private SignUtils() {
    }

    /**
     * sign.
     *
     * @param privateKey privateKey
     * @param json       json
     * @return sign
     */
    public static String sign(final String privateKey, final String json) {
        return RSASignUtil.sign(privateKey, createSign(json));
    }

    /**
     * create sign.
     *
     * @param json json
     * @return String
     */
    public static String createSign(final String json) {
        return createSign(JacksonUtils.fromJson(json, TreeMap.class));
    }

    /**
     * create sign.
     *
     * @param map map
     * @return String
     */
    public static String createSign(final Map<String, Object> map) {
        String jsonStr = splicingSign(map);
        jsonStr = jsonStr.substring(0, jsonStr.length() - 1);
        return jsonStr;
    }

    private static String splicingSign(final Map<String, Object> map) {
        SortedMap<String, Object> sortedMap = new TreeMap<>();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof List) {
                sortedMap.put(key, ((List) value).stream()
                        .map(SignUtils::splicingSign)
                        .collect(Collectors.toList()));
            } else {
                if (StringUtils.isNotBlank(value.toString())) {
                    sortedMap.put(key, value.toString());
                }
            }
        }
        return toString(sortedMap);
    }

    private static String toString(final SortedMap<String, Object> sortedMap) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Object> entry : sortedMap.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (isValid(key)) {
                if (value instanceof ArrayList) {
                    for (Object v : (ArrayList) value) {
                        sb.append(v);
                    }
                } else {
                    sb.append(key).append("=").append(value).append("&");
                }
            }
        }
        return sb.toString();
    }

    private static boolean isValid(final String key) {
        return !StringUtils.equalsIgnoreCase("SIGN_INF", key)
                && !StringUtils.equalsIgnoreCase("Svc_Rsp_St", key)
                && !StringUtils.equalsIgnoreCase("Svc_Rsp_Cd", key)
                && !StringUtils.equalsIgnoreCase("Rsp_Inf", key);
    }

    private static String splicingSign(final Object object) {
        if (object instanceof Map) {
            return splicingSign((Map<String, Object>) object);
        }
        return object.toString();
    }
}
