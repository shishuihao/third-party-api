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
            SendBatchSmsRequest sendBatchSmsRequest = new SendBatchSmsRequest();
            sendBatchSmsRequest.setPhoneNumberJson(GsonUtils
                    .toJson(request.getMessages().stream()
                            .map(SmsMessage::getPhoneNumber)
                            .collect(Collectors.toList())));
            sendBatchSmsRequest.setSignNameJson(GsonUtils
                    .toJson(request.getMessages().stream()
                            .map(it -> Optional.ofNullable(it.getSignName())
                                    .orElseGet(properties::getSignName))
                            .collect(Collectors.toList())));
            sendBatchSmsRequest.setTemplateCode(request.getTemplateId());
            sendBatchSmsRequest.setTemplateParamJson(GsonUtils
                    .toJson(request.getMessages().stream()
                            .map(SmsMessage::getTemplateParams)
                            .collect(Collectors.toList())));
            sendBatchSmsRequest.setSmsUpExtendCodeJson(GsonUtils
                    .toJson(request.getMessages().stream()
                            .map(SmsMessage::getExtendCode)
                            .collect(Collectors.toList())));
            SendBatchSmsResponseBody sendBatchSmsResponseBody = client
                    .sendBatchSms(sendBatchSmsRequest).getBody();
            return SendBatchSmsApiResponse.builder()
                    .requestId(sendBatchSmsResponseBody.getRequestId())
                    .success("OK".equals(sendBatchSmsResponseBody.getCode()))
                    .code(sendBatchSmsResponseBody.getCode())
                    .message(sendBatchSmsResponseBody.getMessage())
                    .build();
        } catch (Exception e) {
            throw new ApiException(e);
        }
    }
}
