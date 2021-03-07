package cn.shishuihao.thirdparty.api.commons.json;

import com.google.gson.Gson;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public final class GsonUtils {
    /**
     * This is the main class for using Gson.
     */
    private static final Gson GSON;

    private GsonUtils() {
    }

    static {
        // Gson
        GSON = new Gson();
    }

    /**
     * object to json.
     *
     * @param value object
     * @return json
     */
    public static String toJson(final Object value) {
        if (value == null) {
            return null;
        }
        return GSON.toJson(value);
    }

    /**
     * json to object.
     *
     * @param content   json
     * @param valueType object type
     * @param <T>       object type
     * @return object
     */
    public static <T> T fromJson(final String content,
                                 final Class<T> valueType) {
        if (content == null) {
            return null;
        }
        return GSON.fromJson(content, valueType);
    }
}
