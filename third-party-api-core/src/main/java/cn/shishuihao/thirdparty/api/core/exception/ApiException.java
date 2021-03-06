package cn.shishuihao.thirdparty.api.core.exception;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class ApiException extends RuntimeException {
    /**
     * Constructs a new api exception.
     *
     * @param message the detail message.
     */
    public ApiException(final String message) {
        super(message);
    }

    /**
     * Constructs a new api exception.
     *
     * @param message the detail message.
     * @param cause   the cause.
     */
    public ApiException(final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new api exception.
     *
     * @param cause the cause.
     */
    public ApiException(final Throwable cause) {
        super(cause);
    }
}
