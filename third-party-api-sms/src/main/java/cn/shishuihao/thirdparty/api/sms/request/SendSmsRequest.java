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
    private String channelId;
    /**
     * properties id
     */
    private String propertiesId;
    /**
     * phone number
     */
    private String phoneNumber;
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

    public SendSmsRequest setChannelId(String channelId) {
        this.channelId = channelId;
        return this;
    }

    public String getPropertiesId() {
        return propertiesId;
    }

    public SendSmsRequest setPropertiesId(String propertiesId) {
        this.propertiesId = propertiesId;
        return this;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public SendSmsRequest setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public String getTemplateId() {
        return templateId;
    }

    public SendSmsRequest setTemplateId(String templateId) {
        this.templateId = templateId;
        return this;
    }

    public Map<String, String> getTemplateParams() {
        return templateParams;
    }

    public SendSmsRequest setTemplateParams(Map<String, String> templateParams) {
        this.templateParams = templateParams;
        return this;
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
}
