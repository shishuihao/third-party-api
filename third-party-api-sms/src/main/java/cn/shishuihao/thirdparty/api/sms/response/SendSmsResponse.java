package cn.shishuihao.thirdparty.api.sms.response;

import cn.shishuihao.thirdparty.api.sms.SmsResponse;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class SendSmsResponse implements SmsResponse {
    private String code;
    private String message;
    private String requestId;

    public String getCode() {
        return code;
    }

    public SendSmsResponse setCode(String code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public SendSmsResponse setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getRequestId() {
        return requestId;
    }

    public SendSmsResponse setRequestId(String requestId) {
        this.requestId = requestId;
        return this;
    }
}
