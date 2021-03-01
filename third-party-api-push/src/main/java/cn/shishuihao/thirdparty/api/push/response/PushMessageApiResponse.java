package cn.shishuihao.thirdparty.api.push.response;

import cn.shishuihao.thirdparty.api.core.response.BaseApiResponse;
import cn.shishuihao.thirdparty.api.push.PushApiResponse;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class PushMessageApiResponse extends BaseApiResponse implements PushApiResponse {
    protected PushMessageApiResponse(boolean success, String code, String message, String requestId) {
        super(success, code, message, requestId);
    }

    public static final class Builder {
        private boolean success;
        private String code;
        private String message;
        private String requestId;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder success(boolean success) {
            this.success = success;
            return this;
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
            return new PushMessageApiResponse(success, code, message, requestId);
        }
    }
}
