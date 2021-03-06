package cn.shishuihao.thirdparty.api.sms.aliyun.api;

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
import com.google.gson.Gson;

import java.util.Optional;
import java.util.stream.Collectors;

/**
 * {@link "https://help.aliyun.com/document_detail/102364.html?spm=a2c4g.11186623.6.627.470965f4ZszVvE"}
 *
 * @author shishuihao
 * @version 1.0.0
 */
public class AliYunSendBatchSmsApi implements SendBatchSmsApi {
    private final AliYunSmsClient smsClient;

    public AliYunSendBatchSmsApi(AliYunSmsClient smsClient) {
        this.smsClient = smsClient;
    }

    @Override
    public SendBatchSmsApiResponse execute(SendBatchSmsApiRequest request) {
        AliYunSmsApiProperties properties = (AliYunSmsApiProperties) ApiRegistry.INSTANCE.getApiPropertiesOrThrow(request);
        try {
            Client client = smsClient.getAliYunClient(properties);
            SendBatchSmsRequest sendBatchSmsRequest = new SendBatchSmsRequest();
            sendBatchSmsRequest.setPhoneNumberJson(new Gson().toJson(request.getMessages().stream()
                    .map(SmsMessage::getPhoneNumber)
                    .collect(Collectors.toList())));
            sendBatchSmsRequest.setSignNameJson(new Gson().toJson(request.getMessages().stream()
                    .map(it -> Optional.ofNullable(it.getSignName()).orElseGet(properties::getSignName))
                    .collect(Collectors.toList())));
            sendBatchSmsRequest.setTemplateCode(request.getTemplateId());
            sendBatchSmsRequest.setTemplateParamJson(new Gson().toJson(request.getMessages().stream()
                    .map(SmsMessage::getTemplateParams)
                    .collect(Collectors.toList())));
            sendBatchSmsRequest.setSmsUpExtendCodeJson(new Gson().toJson(request.getMessages().stream()
                    .map(SmsMessage::getExtendCode)
                    .collect(Collectors.toList())));
            SendBatchSmsResponseBody sendBatchSmsResponseBody = client.sendBatchSms(sendBatchSmsRequest).getBody();
            return SendBatchSmsApiResponse.Builder.builder()
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
