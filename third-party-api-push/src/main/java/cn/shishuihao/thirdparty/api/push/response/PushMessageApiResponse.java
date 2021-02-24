package cn.shishuihao.thirdparty.api.push.response;

import cn.shishuihao.thirdparty.api.push.PushApiResponse;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class PushMessageApiResponse implements PushApiResponse {
    private final String code;
    private final String message;
    private final String requestId;

    protected PushMessageApiResponse(String code, String message, String requestId) {
        this.code = code;
        this.message = message;
        this.requestId = requestId;
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

    public static final class Builder {
        private String code;
        private String message;
        private String requestId;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder code(String code) {
            this.code = code;
            return this;
        }

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public Builder requestId(String requestId) {
            this.requestId = requestId;
            return this;
        }

        public PushMessageApiResponse build() {
            return new PushMessageApiResponse(code, message, requestId);
        }
    }
}
