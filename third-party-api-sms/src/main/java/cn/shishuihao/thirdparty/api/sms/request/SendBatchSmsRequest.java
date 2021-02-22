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
    private String channelId;
    /**
     * properties id
     */
    private String propertiesId;
    /**
     * phone numbers
     */
    private List<String> phoneNumbers;
    /**
     * template Id
     */
    private String templateId;
    /**
     * template params
     */
    private Map<String, String> templateParams;

    public String getChannelId() {
        return channelId;
    }

    public SendBatchSmsRequest setChannelId(String channelId) {
        this.channelId = channelId;
        return this;
    }

    public String getPropertiesId() {
        return propertiesId;
    }

    public SendBatchSmsRequest setPropertiesId(String propertiesId) {
        this.propertiesId = propertiesId;
        return this;
    }

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public SendBatchSmsRequest setPhoneNumbers(List<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
        return this;
    }

    public String getTemplateId() {
        return templateId;
    }

    public SendBatchSmsRequest setTemplateId(String templateId) {
        this.templateId = templateId;
        return this;
    }

    public Map<String, String> getTemplateParams() {
        return templateParams;
    }

    public SendBatchSmsRequest setTemplateParams(Map<String, String> templateParams) {
        this.templateParams = templateParams;
        return this;
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
}
