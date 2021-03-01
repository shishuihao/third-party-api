package cn.shishuihao.thirdparty.api.pay.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class AmountUtils {
    private AmountUtils() {
    }

    public static Double toCentDouble(String amount) {
        return Double.parseDouble(new DecimalFormat("#.00").format(Double.parseDouble(amount))) * 100;
    }

    public static int toCent(String yuan) {
        return toCentDouble(yuan).intValue();
    }

    public static int toCent(double yuan) {
        return toCent(String.valueOf(yuan));
    }

    public static BigDecimal toYuanBigDecimal(int price) {
        return BigDecimal.valueOf(price).divide(new BigDecimal(100), 2, RoundingMode.HALF_UP);
    }

    public static String toYuanString(int price) {
        return toYuanBigDecimal(price).toString();
    }
}
