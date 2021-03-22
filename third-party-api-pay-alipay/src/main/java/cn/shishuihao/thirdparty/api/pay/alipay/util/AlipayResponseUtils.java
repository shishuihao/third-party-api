package cn.shishuihao.thirdparty.api.pay.alipay.util;

import com.aliyun.tea.TeaModel;
import com.google.common.base.Strings;
import org.apache.commons.lang3.reflect.FieldUtils;

import java.util.Optional;

import static com.alipay.easysdk.kernel.util.ResponseChecker.SUB_CODE_FIELD_NAME;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public final class AlipayResponseUtils {
    /**
     * CODE_FIELD_NAME.
     */
    public static final String CODE_FIELD_NAME = "code";
    /**
     * SUB_MSG_FIELD_NAME.
     */
    public static final String SUB_MSG_FIELD_NAME = "subMsg";
    /**
     * MSG_FIELD_NAME.
     */
    public static final String MSG_FIELD_NAME = "msg";

    private AlipayResponseUtils() {
    }

    /**
     * code.
     *
     * @param response response
     * @return subCode or code
     */
    public static String code(final TeaModel response) {
        return Optional.ofNullable(getValue(response, SUB_CODE_FIELD_NAME))
                .filter(it -> !Strings.isNullOrEmpty(it))
                .orElse(getValue(response, CODE_FIELD_NAME));
    }

    /**
     * message.
     *
     * @param response response
     * @return subMsg or msg
     */
    public static String message(final TeaModel response) {
        return Optional.ofNullable(getValue(response, SUB_MSG_FIELD_NAME))
                .filter(it -> !Strings.isNullOrEmpty(it))
                .orElse(getValue(response, MSG_FIELD_NAME));
    }

    private static String getValue(final TeaModel response,
                                   final String fieldName) {
        try {
            return (String) FieldUtils.readField(response, fieldName, true);
        } catch (IllegalAccessException e) {
            return null;
        }
    }
}
