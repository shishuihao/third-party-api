package cn.shishuihao.thirdparty.api.core.exception;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class PropertiesNotFoundException extends ApiException {
    /**
     * Constructs a new properties not found exception.
     *
     * @param message the detail message.
     */
    public PropertiesNotFoundException(final String message) {
        super(message);
    }

    /**
     * Constructs a new properties not found exception.
     *
     * @param message the detail message.
     * @param cause   the cause.
     */
    public PropertiesNotFoundException(final String message,
                                       final Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new properties not found exception.
     *
     * @param cause the cause.
     */
    public PropertiesNotFoundException(final Throwable cause) {
        super(cause);
    }
}
