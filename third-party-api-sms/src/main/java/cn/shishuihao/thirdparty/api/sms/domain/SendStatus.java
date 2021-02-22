package cn.shishuihao.thirdparty.api.sms.domain;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class SendStatus {
    private final String code;
    private final String message;

    public SendStatus(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
