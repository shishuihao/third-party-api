package cn.shishuihao.thirdparty.api.sms.response;

import cn.shishuihao.thirdparty.api.sms.SmsApiResponse;
import cn.shishuihao.thirdparty.api.sms.domain.SendStatus;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class SendBatchSmsApiResponse implements SmsApiResponse {
    private final SendStatus[] sendStatuses;
    private final String requestId;

    protected SendBatchSmsApiResponse(SendStatus[] sendStatuses, String requestId) {
        this.sendStatuses = sendStatuses;
        this.requestId = requestId;
    }

    public SendStatus[] getSendStatuses() {
        return sendStatuses;
    }

    public String getRequestId() {
        return requestId;
    }

    public static final class Builder {
        private SendStatus[] sendStatuses;
        private String requestId;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder sendStatuses(SendStatus[] sendStatuses) {
            this.sendStatuses = sendStatuses;
            return this;
        }

        public Builder requestId(String requestId) {
            this.requestId = requestId;
            return this;
        }

        public SendBatchSmsApiResponse build() {
            return new SendBatchSmsApiResponse(sendStatuses, requestId);
        }
    }
}
