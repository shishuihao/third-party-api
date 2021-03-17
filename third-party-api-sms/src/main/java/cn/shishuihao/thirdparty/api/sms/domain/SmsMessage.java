package cn.shishuihao.thirdparty.api.sms.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

import javax.validation.constraints.NotBlank;
import java.util.Map;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
@Jacksonized
public class SmsMessage {
    /**
     * phone numbers.
     */
    @NotBlank
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
