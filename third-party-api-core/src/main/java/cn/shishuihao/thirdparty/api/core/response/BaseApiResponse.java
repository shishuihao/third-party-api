package cn.shishuihao.thirdparty.api.core.response;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class BaseApiResponse implements ApiResponse {
    /**
     * success.
     */
    private final boolean success;
    /**
     * error code.
     */
    private final String code;
    /**
     * error message.
     */
    private final String message;
    /**
     * request id.
     */
    private final String requestId;

    /**
     * new BaseApiResponse.
     *
     * @param pSuccess   is success
     * @param pCode      error code
     * @param pMessage   error message
     * @param pRequestId request id
     */
    protected BaseApiResponse(final boolean pSuccess,
                              final String pCode,
                              final String pMessage,
                              final String pRequestId) {
        this.success = pSuccess;
        this.code = pCode;
        this.message = pMessage;
        this.requestId = pRequestId;
    }

    /**
     * is success.
     *
     * @return boolean
     */
    public boolean isSuccess() {
        return success;
    }

    /**
     * get error code.
     *
     * @return String
     */
    public String getCode() {
        return code;
    }

    /**
     * get error message.
     *
     * @return String
     */
    public String getMessage() {
        return message;
    }

    /**
     * get request id.
     *
     * @return String
     */
    public String getRequestId() {
        return requestId;
    }
}
