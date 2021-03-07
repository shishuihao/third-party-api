package cn.shishuihao.thirdparty.api.sms.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.Map;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
public class SmsMessage {
    /**
     * phone numbers.
     */
    private final String phoneNumber;
    /**
     * sms sign name.
     */
    private final String signName;
    /**
     * template params.
     */
    private final Map<String, String> templateParams;
    /**
     * sms extend code.
     */
    private final String extendCode;
}
