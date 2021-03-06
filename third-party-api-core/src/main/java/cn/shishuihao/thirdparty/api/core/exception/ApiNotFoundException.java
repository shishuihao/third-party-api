package cn.shishuihao.thirdparty.api.core.exception;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class ApiNotFoundException extends ApiException {
    /**
     * Constructs a new api not found exception.
     *
     * @param message the detail message.
     */
    public ApiNotFoundException(final String message) {
        super(message);
    }

    /**
     * Constructs a new api not found exception.
     *
     * @param message the detail message.
     * @param cause   the cause.
     */
    public ApiNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new api not found exception.
     *
     * @param cause the cause.
     */
    public ApiNotFoundException(final Throwable cause) {
        super(cause);
    }
}
