package cn.shishuihao.thirdparty.api.sms.aliyun.api;

import cn.shishuihao.thirdparty.api.commons.json.GsonUtils;
import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.core.exception.ApiException;
import cn.shishuihao.thirdparty.api.sms.aliyun.AliYunSmsApiProperties;
import cn.shishuihao.thirdparty.api.sms.aliyun.AliYunSmsClient;
import cn.shishuihao.thirdparty.api.sms.api.SendBatchSmsApi;
import cn.shishuihao.thirdparty.api.sms.domain.SmsMessage;
import cn.shishuihao.thirdparty.api.sms.request.SendBatchSmsApiRequest;
import cn.shishuihao.thirdparty.api.sms.response.SendBatchSmsApiResponse;
import com.aliyun.dysmsapi20170525.Client;
import com.aliyun.dysmsapi20170525.models.SendBatchSmsRequest;
import com.aliyun.dysmsapi20170525.models.SendBatchSmsResponseBody;
import lombok.AllArgsConstructor;

import java.util.Optional;
import java.util.stream.Collectors;

/**
 * send batch message.
 * {@link "https://help.aliyun.com/document_detail/102364.html
 * ?spm=a2c4g.11186623.6.627.470965f4ZszVvE"}
 *
 * @author shishuihao
 * @version 1.0.0
 */
@AllArgsConstructor
public class AliYunSendBatchSmsApi implements SendBatchSmsApi {
    /**
     * aliyun sms client.
     */
    private final AliYunSmsClient smsClient;

    /**
     * execute SendBatchSmsApiRequest by aliyun.
     *
     * @param request request
     * @return SendBatchSmsApiResponse
     */
    @Override
    public SendBatchSmsApiResponse
    execute(final SendBatchSmsApiRequest request) {
        AliYunSmsApiProperties properties = (AliYunSmsApiProperties)
                ApiRegistry.INSTANCE.getApiPropertiesOrThrow(request);
        try {
            Client client = smsClient.getAliYunClient(properties);
            SendBatchSmsRequest sbRequest = new SendBatchSmsRequest();
            sbRequest.setPhoneNumberJson(getPhoneNumberJson(request));
            sbRequest.setSignNameJson(getSignNameJson(request, properties));
            sbRequest.setTemplateCode(request.getTemplateId());
            sbRequest.setTemplateParamJson(getTemplateParamJson(request));
            sbRequest.setSmsUpExtendCodeJson(getExtendCodeJson(request));
            SendBatchSmsResponseBody sbResponseBody = client
                    .sendBatchSms(sbRequest)
                    .getBody();
            return SendBatchSmsApiResponse.builder()
                    .requestId(sbResponseBody.getRequestId())
                    .success("OK".equals(sbResponseBody.getCode()))
                    .code(sbResponseBody.getCode())
                    .message(sbResponseBody.getMessage())
                    .build();
        } catch (Exception e) {
            throw new ApiException(e);
        }
    }

    private String getPhoneNumberJson(final SendBatchSmsApiRequest request) {
        return GsonUtils.toJson(request.getMessages().stream()
                .map(SmsMessage::getPhoneNumber)
                .collect(Collectors.toList()));
    }

    private String getSignNameJson(final SendBatchSmsApiRequest request,
                                   final AliYunSmsApiProperties properties) {
        return GsonUtils.toJson(request.getMessages().stream()
                .map(it -> Optional.ofNullable(it.getSignName())
                        .orElseGet(properties::getSignName))
                .collect(Collectors.toList()));
    }

    private String getTemplateParamJson(final SendBatchSmsApiRequest request) {
        return GsonUtils.toJson(request.getMessages().stream()
                .map(SmsMessage::getTemplateParams)
                .collect(Collectors.toList()));
    }

    private String getExtendCodeJson(final SendBatchSmsApiRequest request) {
        return GsonUtils.toJson(request.getMessages().stream()
                .map(SmsMessage::getExtendCode)
                .collect(Collectors.toList()));
    }
}
