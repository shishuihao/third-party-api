package cn.shishuihao.thirdparty.api.push.util;

import java.lang.reflect.Array;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public final class ArrayUtils {
    private ArrayUtils() {
    }

    /**
     * get length.
     *
     * @param array array
     * @return array length
     */
    public static int getLength(final Object array) {
        if (array == null) {
            return 0;
        }
        return Array.getLength(array);
    }

    /**
     * is empty.
     *
     * @param array array
     * @return boolean
     */
    public static boolean isEmpty(final Object[] array) {
        return getLength(array) == 0;
    }

    /**
     * is not empty.
     *
     * @param array array
     * @return boolean
     */
    public static boolean isNotEmpty(final Object[] array) {
        return getLength(array) != 0;
    }
}
