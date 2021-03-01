package cn.shishuihao.thirdparty.api.sms.response;

import cn.shishuihao.thirdparty.api.core.response.BaseApiResponse;
import cn.shishuihao.thirdparty.api.sms.SmsApiResponse;
import cn.shishuihao.thirdparty.api.sms.domain.SendStatus;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class SendBatchSmsApiResponse extends BaseApiResponse implements SmsApiResponse {
    private final SendStatus[] sendStatuses;

    protected SendBatchSmsApiResponse(boolean success, String code, String message, String requestId, SendStatus[] sendStatuses) {
        super(success, code, message, requestId);
        this.sendStatuses = sendStatuses;
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
