package cn.shishuihao.thirdparty.api.push.oppo.util;

import java.lang.reflect.Array;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class ArrayUtils {
    private ArrayUtils() {
    }

    public static int getLength(final Object array) {
        if (array == null) {
            return 0;
        }
        return Array.getLength(array);
    }

    public static boolean isEmpty(final Object[] array) {
        return getLength(array) == 0;
    }

    public static boolean isNotEmpty(final Object[] array) {
        return getLength(array) != 0;
    }
}
