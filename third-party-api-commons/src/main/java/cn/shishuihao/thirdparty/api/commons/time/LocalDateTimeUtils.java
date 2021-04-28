package cn.shishuihao.thirdparty.api.commons.time;

import java.time.format.DateTimeFormatter;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public final class LocalDateTimeUtils {
    /**
     * yyyyMMddHHmmss.
     */
    public static final DateTimeFormatter COMPACT_DATE_TIME_FORMATTER
            = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

    /**
     * DATE_TIME_FORMATTER.
     */
    public static final DateTimeFormatter DATE_TIME_FORMATTER
            = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private LocalDateTimeUtils() {
    }
}
