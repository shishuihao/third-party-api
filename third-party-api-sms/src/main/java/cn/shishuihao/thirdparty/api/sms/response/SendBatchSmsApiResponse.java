package cn.shishuihao.thirdparty.api.sms.response;

import cn.shishuihao.thirdparty.api.sms.SmsApiResponse;
import cn.shishuihao.thirdparty.api.sms.domain.SendStatus;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class SendBatchSmsApiResponse implements SmsApiResponse {
    private final boolean success;
    private final String code;
    private final String message;
    private final String requestId;
    private final SendStatus[] sendStatuses;

    protected SendBatchSmsApiResponse(boolean success, String code, String message, String requestId, SendStatus[] sendStatuses) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.requestId = requestId;
        this.sendStatuses = sendStatuses;
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

    public SendStatus[] getSendStatuses() {
        return sendStatuses;
    }


    public static final class Builder {
        private boolean success;
        private String code;
        private String message;
        private String requestId;
        private SendStatus[] sendStatuses;

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

        public Builder sendStatuses(SendStatus[] sendStatuses) {
            this.sendStatuses = sendStatuses;
            return this;
        }

        public SendBatchSmsApiResponse build() {
            return new SendBatchSmsApiResponse(success, code, message, requestId, sendStatuses);
        }
    }
}
