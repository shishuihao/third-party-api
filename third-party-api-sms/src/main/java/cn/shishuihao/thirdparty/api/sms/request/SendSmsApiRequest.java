package cn.shishuihao.thirdparty.api.sms.request;

import cn.shishuihao.thirdparty.api.core.request.AbstractRequest;
import cn.shishuihao.thirdparty.api.sms.SmsApiRequest;
import cn.shishuihao.thirdparty.api.sms.api.SendSmsApi;
import cn.shishuihao.thirdparty.api.sms.domain.SmsMessage;
import cn.shishuihao.thirdparty.api.sms.response.SendSmsApiResponse;
import lombok.Getter;
import lombok.experimental.SuperBuilder;
import lombok.extern.jackson.Jacksonized;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Getter
@Jacksonized
@SuperBuilder
public class SendSmsApiRequest extends AbstractRequest<
        SendSmsApi,
        SendSmsApiRequest,
        SendSmsApiResponse> implements SmsApiRequest<
        SendSmsApi,
        SendSmsApiRequest,
        SendSmsApiResponse> {
    /**
     * template Id.
     */
    @NotBlank
    private final String templateId;
    /**
     * message.
     */
    @Valid
    @NotNull
    private final SmsMessage message;

    /**
     * get api type.
     * immutable
     *
     * @return api type
     */
    @Override
    public Class<SendSmsApi> apiType() {
        return SendSmsApi.class;
    }

    /**
     * get properties id.
     * immutable
     *
     * @return properties id
     */
    @Override
    public Class<SendSmsApiResponse> responseType() {
        return SendSmsApiResponse.class;
    }
}
