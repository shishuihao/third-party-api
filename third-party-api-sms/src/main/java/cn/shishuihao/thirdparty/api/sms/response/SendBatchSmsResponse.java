package cn.shishuihao.thirdparty.api.sms.response;

import cn.shishuihao.thirdparty.api.sms.SmsResponse;
import cn.shishuihao.thirdparty.api.sms.domain.SendStatus;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class SendBatchSmsResponse implements SmsResponse {
    private SendStatus[] sendStatuses;
    private String requestId;

    public SendStatus[] getSendStatuses() {
        return sendStatuses;
    }

    public String getRequestId() {
        return requestId;
    }

    public SendBatchSmsResponse setSendStatuses(SendStatus[] sendStatuses) {
        this.sendStatuses = sendStatuses;
        return this;
    }

    public SendBatchSmsResponse setRequestId(String requestId) {
        this.requestId = requestId;
        return this;
    }
}
