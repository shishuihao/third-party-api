package cn.shishuihao.thirdparty.api.commons.http.util;

import org.apache.commons.lang3.exception.ExceptionUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public final class QueryStringUtils {
    private QueryStringUtils() {
    }

    /**
     * params to queryString.
     *
     * @param params      params
     * @param valueMapper function to apply to value
     * @return queryString
     */
    public static String toQueryString(
            final Map<String, ?> params,
            final Function<Object, String> valueMapper) {
        return params.entrySet().stream()
                .filter(it -> it.getKey() != null)
                .map(it -> it.getKey()
                        + "="
                        + valueMapper.apply(it.getValue()))
                .collect(Collectors.joining("&"));
    }

    /**
     * params to queryString.
     *
     * @param params params
     * @return queryString
     */
    public static String toQueryString(
            final Map<String, ?> params) {
        return toQueryString(params, value -> Optional.ofNullable(value)
                .map(Object::toString)
                .orElse(""));
    }

    /**
     * Translates a string into {@code application/x-www-form-urlencoded}
     * format using a specific encoding scheme. This method uses the
     * supplied encoding scheme to obtain the bytes for unsafe
     * characters.
     *
     * @param s       {@code String} to be translated.
     * @param charset charset
     * @return queryString
     */
    public static String encode(final String s, final Charset charset) {
        try {
            return URLEncoder.encode(s, charset.toString());
        } catch (UnsupportedEncodingException e) {
            throw ExceptionUtils.<RuntimeException>rethrow(e);
        }
    }

    /**
     * params to queryString.
     *
     * @param params  params
     * @param charset charset
     * @return queryString
     */
    public static String toQueryString(
            final Map<String, Object> params,
            final Charset charset) {
        return toQueryString(params, value -> Optional.ofNullable(value)
                .map(it -> encode(it.toString(), charset))
                .orElse(""));
    }
}
