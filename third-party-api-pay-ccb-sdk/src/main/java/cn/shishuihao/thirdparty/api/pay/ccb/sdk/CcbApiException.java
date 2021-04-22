package cn.shishuihao.thirdparty.api.pay.ccb.sdk;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class CcbApiException extends RuntimeException {
    /**
     * Constructs a new api exception.
     *
     * @param message the detail message.
     */
    public CcbApiException(final String message) {
        super(message);
    }

    /**
     * Constructs a new api exception.
     *
     * @param message the detail message.
     * @param cause   the cause.
     */
    public CcbApiException(final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new api exception.
     *
     * @param cause the cause.
     */
    public CcbApiException(final Throwable cause) {
        super(cause);
    }
}
