package cn.shishuihao.thirdparty.api.sms.aliyun.api;

import cn.shishuihao.thirdparty.api.commons.json.GsonUtils;
import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.core.exception.ApiException;
import cn.shishuihao.thirdparty.api.sms.aliyun.AliYunSmsApiProperties;
import cn.shishuihao.thirdparty.api.sms.aliyun.AliYunSmsClient;
import cn.shishuihao.thirdparty.api.sms.api.SendSmsApi;
import cn.shishuihao.thirdparty.api.sms.request.SendSmsApiRequest;
import cn.shishuihao.thirdparty.api.sms.response.SendSmsApiResponse;
import com.aliyun.dysmsapi20170525.Client;
import com.aliyun.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.dysmsapi20170525.models.SendSmsResponseBody;
import lombok.AllArgsConstructor;

import java.util.Optional;

/**
 * send message.
 * {@link "https://help.aliyun.com/document_detail/101414.html
 * ?spm=a2c4g.11186623.6.626.35661040OzJgnG"}
 *
 * @author shishuihao
 * @version 1.0.0
 */
@AllArgsConstructor
public class AliYunSendSmsApi implements SendSmsApi {
    /**
     * aliyun sms client.
     */
    private final AliYunSmsClient smsClient;

    /**
     * execute SendSmsApiRequest by aliyun.
     *
     * @param request request
     * @return SendSmsApiResponse
     */
    @Override
    public SendSmsApiResponse execute(final SendSmsApiRequest request) {
        AliYunSmsApiProperties properties = (AliYunSmsApiProperties)
                ApiRegistry.INSTANCE.getApiPropertiesOrThrow(request);
        try {
            Client client = smsClient.getAliYunClient(properties);
            SendSmsRequest smsRequest = getSmsRequest(request, properties);
            SendSmsResponseBody smsResponseBody = client
                    .sendSms(smsRequest)
                    .getBody();
            return getApiResponse(smsResponseBody);
        } catch (Exception e) {
            throw new ApiException(e);
        }
    }

    private SendSmsRequest getSmsRequest(
            final SendSmsApiRequest request,
            final AliYunSmsApiProperties properties) {
        SendSmsRequest alyRequest = new SendSmsRequest();
        alyRequest.setPhoneNumbers(request.getMessage().getPhoneNumber());
        alyRequest.setSignName(getSignName(request, properties));
        alyRequest.setTemplateCode(request.getTemplateId());
        alyRequest.setTemplateParam(getTemplateParam(request));
        alyRequest.setSmsUpExtendCode(getExtendCode(request, properties));
        return alyRequest;
    }

    private SendSmsApiResponse getApiResponse(
            final SendSmsResponseBody smsResponseBody) {
        return SendSmsApiResponse.builder()
                .requestId(smsResponseBody.getRequestId())
                .success("OK".equals(smsResponseBody.getCode()))
                .code(smsResponseBody.getCode())
                .message(smsResponseBody.getMessage())
                .build();
    }

    private String getSignName(final SendSmsApiRequest request,
                               final AliYunSmsApiProperties properties) {
        return Optional.ofNullable(request.getMessage().getSignName())
                .orElseGet(properties::getSignName);
    }

    private String getExtendCode(final SendSmsApiRequest request,
                                 final AliYunSmsApiProperties properties) {
        return Optional.ofNullable(request.getMessage().getExtendCode())
                .orElseGet(properties::getSmsUpExtendCode);
    }

    private String getTemplateParam(final SendSmsApiRequest request) {
        return GsonUtils.toJson(request.getMessage().getTemplateParams());
    }
}
