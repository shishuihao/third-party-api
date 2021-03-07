package cn.shishuihao.thirdparty.api.sms.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@AllArgsConstructor
@Getter
public class SmsSendStatus {
    /**
     * code.
     */
    private final String code;
    /**
     * message.
     */
    private final String message;
}
