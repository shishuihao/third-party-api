package cn.shishuihao.thirdparty.api.core.exception;

import cn.shishuihao.thirdparty.api.core.ApiException;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class ApiNotFoundException extends ApiException {
    public ApiNotFoundException(String message) {
        super(message);
    }

    public ApiNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ApiNotFoundException(Throwable cause) {
        super(cause);
    }
}
