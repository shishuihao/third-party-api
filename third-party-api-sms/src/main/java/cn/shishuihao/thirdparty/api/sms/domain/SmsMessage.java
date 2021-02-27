package cn.shishuihao.thirdparty.api.sms.domain;

import java.util.Map;

/**
 * @author shishuihao
 * @version 1.0.0
 */
public class SmsMessage {
    /**
     * phone numbers
     */
    private final String phoneNumber;
    /**
     * sms sign name
     */
    private final String signName;
    /**
     * template params
     */
    private final Map<String, String> templateParams;
    /**
     * sms extend code
     */
    private final String extendCode;

    protected SmsMessage(String phoneNumber, String signName, Map<String, String> templateParams, String extendCode) {
        this.phoneNumber = phoneNumber;
        this.signName = signName;
        this.templateParams = templateParams;
        this.extendCode = extendCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getSignName() {
        return signName;
    }

    public Map<String, String> getTemplateParams() {
        return templateParams;
    }

    public String getExtendCode() {
        return extendCode;
    }

    public static final class Builder {
        private String phoneNumber;
        private String signName;
        private Map<String, String> templateParams;
        private String extendCode;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder signName(String signName) {
            this.signName = signName;
            return this;
        }

        public Builder templateParams(Map<String, String> templateParams) {
            this.templateParams = templateParams;
            return this;
        }

        public Builder extendCode(String extendCode) {
            this.extendCode = extendCode;
            return this;
        }

        public SmsMessage build() {
            return new SmsMessage(phoneNumber, signName, templateParams, extendCode);
        }
    }
}
