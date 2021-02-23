package cn.shishuihao.thirdparty.api.sms.request;

import cn.shishuihao.thirdparty.api.sms.SmsRequest;
import cn.shishuihao.thirdparty.api.sms.api.SendSmsApi;
import cn.shishuihao.thirdparty.api.sms.response.SendSmsResponse;

import java.util.Map;

/**
 * @author shishuihao
 * @version 1.0.0
 */
public class SendSmsRequest implements SmsRequest<SendSmsApi, SendSmsRequest, SendSmsResponse> {
    /**
     * channel id
     */
    private final String channelId;
    /**
     * properties id
     */
    private final String propertiesId;
    /**
     * request id;
     */
    private final String requestId;
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

    protected SendSmsRequest(String channelId, String propertiesId,
                             String requestId, String phoneNumber, String templateId, Map<String, String> templateParams) {
        this.channelId = channelId;
        this.propertiesId = propertiesId;
        this.requestId = requestId;
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

    public String getRequestId() {
        return requestId;
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
    public Class<SendSmsResponse> responseClass() {
        return SendSmsResponse.class;
    }

    @Override
    public String channelId() {
        return channelId;
    }

    @Override
    public Class<SendSmsApi> apiType() {
        return SendSmsApi.class;
    }


    public static final class Builder {
        private String channelId;
        private String propertiesId;
        private String requestId;
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

        public Builder requestId(String requestId) {
            this.requestId = requestId;
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

        public SendSmsRequest build() {
            return new SendSmsRequest(channelId, propertiesId, requestId, phoneNumber, templateId, templateParams);
        }
    }
}
