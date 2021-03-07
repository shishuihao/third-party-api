package cn.shishuihao.thirdparty.api.pay.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public final class AmountUtils {
    /**
     * Handy constants for conversion methods.
     */
    static final int C0 = 100;

    private AmountUtils() {
    }

    /**
     * yuan => cent.
     *
     * @param yuan yuan
     * @return cent
     */
    public static Double toCentDouble(final String yuan) {
        return Double.parseDouble(new DecimalFormat("#.00")
                .format(Double.parseDouble(yuan))) * C0;
    }

    /**
     * yuan => cent.
     *
     * @param yuan yuan
     * @return cent
     */
    public static int toCent(final String yuan) {
        return toCentDouble(yuan).intValue();
    }

    /**
     * yuan => cent.
     *
     * @param yuan yuan
     * @return cent
     */
    public static int toCent(final double yuan) {
        return toCent(String.valueOf(yuan));
    }

    /**
     * cent => yuan.
     *
     * @param cent cent
     * @return yuan
     */
    public static BigDecimal toYuanBigDecimal(final int cent) {
        return BigDecimal.valueOf(cent)
                .divide(new BigDecimal(C0), 2, RoundingMode.HALF_UP);
    }

    /**
     * cent => yuan.
     *
     * @param cent cent
     * @return yuan
     */
    public static String toYuanString(final int cent) {
        return toYuanBigDecimal(cent).toString();
    }
}
