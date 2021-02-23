package cn.shishuihao.thirdparty.api.sms.request;

import cn.shishuihao.thirdparty.api.sms.SmsRequest;
import cn.shishuihao.thirdparty.api.sms.api.SendBatchSmsApi;
import cn.shishuihao.thirdparty.api.sms.response.SendBatchSmsResponse;

import java.util.List;
import java.util.Map;

/**
 * @author shishuihao
 * @version 1.0.0
 */
public class SendBatchSmsRequest implements SmsRequest<SendBatchSmsApi, SendBatchSmsRequest, SendBatchSmsResponse> {
    /**
     * channel id
     */
    private final String channelId;
    /**
     * properties id
     */
    private final String propertiesId;
    /**
     * phone numbers
     */
    private final List<String> phoneNumbers;
    /**
     * template Id
     */
    private final String templateId;
    /**
     * template params
     */
    private final Map<String, String> templateParams;

    protected SendBatchSmsRequest(String channelId, String propertiesId,
                                  List<String> phoneNumbers, String templateId, Map<String, String> templateParams) {
        this.channelId = channelId;
        this.propertiesId = propertiesId;
        this.phoneNumbers = phoneNumbers;
        this.templateId = templateId;
        this.templateParams = templateParams;
    }

    public String getChannelId() {
        return channelId;
    }

    public String getPropertiesId() {
        return propertiesId;
    }

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public String getTemplateId() {
        return templateId;
    }

    public Map<String, String> getTemplateParams() {
        return templateParams;
    }

    @Override
    public Class<SendBatchSmsResponse> responseClass() {
        return SendBatchSmsResponse.class;
    }

    @Override
    public String channelId() {
        return channelId;
    }

    @Override
    public Class<SendBatchSmsApi> apiType() {
        return SendBatchSmsApi.class;
    }

    public static final class Builder {
        private String channelId;
        private String propertiesId;
        private List<String> phoneNumbers;
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

        public Builder phoneNumbers(List<String> phoneNumbers) {
            this.phoneNumbers = phoneNumbers;
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

        public SendBatchSmsRequest build() {
            return new SendBatchSmsRequest(channelId, propertiesId, phoneNumbers, templateId, templateParams);
        }
    }
}
