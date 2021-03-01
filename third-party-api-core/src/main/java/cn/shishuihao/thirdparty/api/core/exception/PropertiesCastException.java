package cn.shishuihao.thirdparty.api.core.exception;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class PropertiesCastException extends ApiException {
    public PropertiesCastException(String message) {
        super(message);
    }

    public PropertiesCastException(String message, Throwable cause) {
        super(message, cause);
    }

    public PropertiesCastException(Throwable cause) {
        super(cause);
    }
}
