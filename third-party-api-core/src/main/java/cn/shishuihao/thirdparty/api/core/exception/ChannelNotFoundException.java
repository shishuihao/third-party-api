package cn.shishuihao.thirdparty.api.core.exception;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class ChannelNotFoundException extends ApiException {
    /**
     * Constructs a new channel not found exception.
     *
     * @param message the detail message.
     */
    public ChannelNotFoundException(final String message) {
        super(message);
    }

    /**
     * Constructs a new channel not found exception.
     *
     * @param message the detail message.
     * @param cause   the cause.
     */
    public ChannelNotFoundException(final String message,
                                    final Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new channel not found exception.
     *
     * @param cause the cause.
     */
    public ChannelNotFoundException(final Throwable cause) {
        super(cause);
    }
}
