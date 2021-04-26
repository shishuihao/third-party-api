package cn.shishuihao.thirdparty.api.commons.time;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public final class LocalDateUtils {
    /**
     * yyyyMMdd.
     */
    public static final DateTimeFormatter COMPACT_DATE_FORMATTER
            = DateTimeFormatter.ofPattern("yyyyMMdd");
    /**
     * yyyy-MM-dd.
     */
    public static final DateTimeFormatter DATE_FORMATTER
            = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    /**
     * yyyyMMdd.
     */
    public static final int DATE_LENGTH = 8;
    /**
     * yyyyMM.
     */
    public static final int MONTH_LENGTH = 6;
    /**
     * yyyy.
     */
    public static final int YEAR_LENGTH = 4;


    private LocalDateUtils() {
    }

    /**
     * 解析日期.
     *
     * @param text 日期字符串 允许格式:yyyy、yyyyMM、yyyy-MM、yyyyMMdd、yyyy-MM-dd、yyyy-MM-dd
     * @return LocalDateTime
     */
    public static LocalDate parse(final String text) {
        String reduced = text.replaceAll("[ \\-:]", "");
        switch (reduced.length()) {
            case YEAR_LENGTH:
                return LocalDate.parse(reduced + "0101",
                        COMPACT_DATE_FORMATTER);
            case MONTH_LENGTH:
                return LocalDate.parse(reduced + "01",
                        COMPACT_DATE_FORMATTER);
            case DATE_LENGTH:
                return LocalDate.parse(reduced,
                        COMPACT_DATE_FORMATTER);
            default:
                return LocalDate.parse(text);
        }
    }
}
