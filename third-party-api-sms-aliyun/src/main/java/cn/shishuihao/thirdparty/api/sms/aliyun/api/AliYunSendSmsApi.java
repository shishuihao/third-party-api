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
            SendSmsRequest sendSmsRequest = new SendSmsRequest();
            sendSmsRequest.setPhoneNumbers(request.getMessage()
                    .getPhoneNumber());
            sendSmsRequest.setSignName(Optional
                    .ofNullable(request.getMessage()
                            .getSignName())
                    .orElseGet(properties::getSignName));
            sendSmsRequest.setTemplateCode(request.getTemplateId());
            sendSmsRequest.setTemplateParam(GsonUtils
                    .toJson(request.getMessage()
                            .getTemplateParams()));
            sendSmsRequest.setSmsUpExtendCode(Optional
                    .ofNullable(request.getMessage()
                            .getExtendCode())
                    .orElseGet(properties::getSmsUpExtendCode));
            SendSmsResponseBody sendSmsResponseBody = client
                    .sendSms(sendSmsRequest).getBody();
            return SendSmsApiResponse.builder()
                    .requestId(sendSmsResponseBody.getRequestId())
                    .success("OK".equals(sendSmsResponseBody.getCode()))
                    .code(sendSmsResponseBody.getCode())
                    .message(sendSmsResponseBody.getMessage())
                    .build();
        } catch (Exception e) {
            throw new ApiException(e);
        }
    }
}
