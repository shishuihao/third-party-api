package cn.shishuihao.thirdparty.api.core.exception;

import cn.shishuihao.thirdparty.api.core.ApiException;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class ChannelNotFoundException extends ApiException {
    public ChannelNotFoundException(String message) {
        super(message);
    }

    public ChannelNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ChannelNotFoundException(Throwable cause) {
        super(cause);
    }
}
