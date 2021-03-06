package cn.shishuihao.thirdparty.api.core.exception;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class PropertiesCastException extends ApiException {
    /**
     * Constructs a new properties cast exception.
     *
     * @param message the detail message.
     */
    public PropertiesCastException(final String message) {
        super(message);
    }

    /**
     * Constructs a new properties cast exception.
     *
     * @param message the detail message.
     * @param cause   the cause.
     */
    public PropertiesCastException(final String message,
                                   final Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new properties cast exception.
     *
     * @param cause the cause.
     */
    public PropertiesCastException(final Throwable cause) {
        super(cause);
    }
}
