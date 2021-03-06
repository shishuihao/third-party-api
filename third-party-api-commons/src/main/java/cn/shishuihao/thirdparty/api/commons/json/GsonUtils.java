package cn.shishuihao.thirdparty.api.commons.json;

import com.google.gson.Gson;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class GsonUtils {
    private static final Gson GSON;

    private GsonUtils() {
    }

    static {
        // Gson
        GSON = new Gson();
    }

    public static String toJson(Object value) {
        return value == null ? null : GSON.toJson(value);
    }

    public static <T> T fromJson(String content, Class<T> valueType) {
        return content == null ? null : GSON.fromJson(content, valueType);
    }
}
