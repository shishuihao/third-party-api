package cn.shishuihao.thirdparty.api.sms.request;

import cn.shishuihao.thirdparty.api.sms.SmsApiRequest;
import cn.shishuihao.thirdparty.api.sms.api.SendSmsApi;
import cn.shishuihao.thirdparty.api.sms.response.SendSmsApiResponse;

import java.util.Map;

/**
 * @author shishuihao
 * @version 1.0.0
 */
public class SendSmsApiRequest implements SmsApiRequest<SendSmsApi, SendSmsApiRequest, SendSmsApiResponse> {
    /**
     * channel id
     */
    private final String channelId;
    /**
     * properties id
     */
    private final String propertiesId;
    /**
     * phone number
     */
    private final String phoneNumber;
    /**
     * template Id
     */
    private final String templateId;
    /**
     * template params
     */
    private final Map<String, String> templateParams;

    protected SendSmsApiRequest(String channelId, String propertiesId,
                                String phoneNumber, String templateId, Map<String, String> templateParams) {
        this.channelId = channelId;
        this.propertiesId = propertiesId;
        this.phoneNumber = phoneNumber;
        this.templateId = templateId;
        this.templateParams = templateParams;
    }

    public String getChannelId() {
        return channelId;
    }

    public String getPropertiesId() {
        return propertiesId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getTemplateId() {
        return templateId;
    }

    public Map<String, String> getTemplateParams() {
        return templateParams;
    }

    @Override
    public Class<SendSmsApi> apiType() {
        return SendSmsApi.class;
    }

    @Override
    public Class<SendSmsApiResponse> responseType() {
        return SendSmsApiResponse.class;
    }

    @Override
    public String channelId() {
        return channelId;
    }

    @Override
    public String propertiesId() {
        return propertiesId;
    }

    public static final class Builder {
        private String channelId;
        private String propertiesId;
        private String phoneNumber;
        private String templateId;
        private Map<String, String> templateParams;

        private Builder() {
        }

        public static Builder builder() {
            return new Builder();
        }

        public Builder channelId(String channelId) {
            this.channelId = channelId;
            return this;
        }

        public Builder propertiesId(String propertiesId) {
            this.propertiesId = propertiesId;
            return this;
        }

        public Builder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder templateId(String templateId) {
            this.templateId = templateId;
            return this;
        }

        public Builder templateParams(Map<String, String> templateParams) {
            this.templateParams = templateParams;
            return this;
        }

        public SendSmsApiRequest build() {
            return new SendSmsApiRequest(channelId, propertiesId, phoneNumber, templateId, templateParams);
        }
    }
}
