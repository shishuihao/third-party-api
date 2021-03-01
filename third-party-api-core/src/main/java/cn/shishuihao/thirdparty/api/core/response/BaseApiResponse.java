package cn.shishuihao.thirdparty.api.core.response;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class BaseApiResponse implements ApiResponse {
    private final boolean success;
    private final String code;
    private final String message;
    private final String requestId;

    protected BaseApiResponse(boolean success, String code, String message, String requestId) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.requestId = requestId;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getRequestId() {
        return requestId;
    }
}
