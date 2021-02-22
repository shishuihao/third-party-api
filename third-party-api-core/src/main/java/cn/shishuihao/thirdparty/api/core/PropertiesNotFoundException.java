package cn.shishuihao.thirdparty.api.core;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class PropertiesNotFoundException extends ApiException {
    public PropertiesNotFoundException(String message) {
        super(message);
    }

    public PropertiesNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public PropertiesNotFoundException(Throwable cause) {
        super(cause);
    }
}
