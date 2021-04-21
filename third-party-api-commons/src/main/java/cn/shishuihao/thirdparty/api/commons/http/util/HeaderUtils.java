package cn.shishuihao.thirdparty.api.commons.http.util;

import feign.Response;
import org.apache.commons.lang3.StringUtils;

import java.util.Optional;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public final class HeaderUtils {
    /**
     * UTF_8.
     */
    public static final String UTF_8 = "UTF-8";
    /**
     * CONTENT_TYPE.
     */
    private static final String CONTENT_TYPE = "content-type";
    /**
     * CHARSET.
     */
    private static final String CHARSET = "charset";

    private HeaderUtils() {
    }

    /**
     * get content type charset.
     *
     * @param response       response
     * @param defaultCharset default charset
     * @return charset
     */
    public static String getContentTypeCharset(
            final Response response,
            final String defaultCharset) {
        return Optional.ofNullable(response.headers())
                .map(it -> it.get(CONTENT_TYPE))
                .flatMap(it -> it.stream()
                        .findFirst())
                .map(it -> getContentTypeCharset(it, defaultCharset))
                .orElse(defaultCharset);
    }

    private static String getContentTypeCharset(
            final String contentType,
            final String defaultCharset) {
        if (!StringUtils.isEmpty(contentType)) {
            String[] params = contentType.split(";");
            for (String param : params) {
                param = param.trim();
                if (param.startsWith(CHARSET)) {
                    String[] pair = param.split("=", 2);
                    if (pair.length == 2) {
                        String value = pair[1];
                        if (!StringUtils.isEmpty(value)) {
                            return value.trim();
                        }
                    }
                    break;
                }
            }
        }
        return defaultCharset;
    }
}
