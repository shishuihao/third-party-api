package cn.shishuihao.thirdparty.api.sms.tencent.api;

import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.core.exception.ApiException;
import cn.shishuihao.thirdparty.api.sms.api.SendBatchSmsApi;
import cn.shishuihao.thirdparty.api.sms.domain.SmsMessage;
import cn.shishuihao.thirdparty.api.sms.domain.SmsSendStatus;
import cn.shishuihao.thirdparty.api.sms.request.SendBatchSmsApiRequest;
import cn.shishuihao.thirdparty.api.sms.response.SendBatchSmsApiResponse;
import cn.shishuihao.thirdparty.api.sms.tencent.TencentSmsApiProperties;
import cn.shishuihao.thirdparty.api.sms.tencent.TencentSmsClient;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.sms.v20190711.SmsClient;
import com.tencentcloudapi.sms.v20190711.models.SendSmsRequest;
import com.tencentcloudapi.sms.v20190711.models.SendSmsResponse;
import com.tencentcloudapi.sms.v20190711.models.SendStatus;
import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * send batch message.
 * {@link = "https://cloud.tencent.com/document/product/382/43194"}
 *
 * @author shishuihao
 * @version 1.0.0
 */
@AllArgsConstructor
public class TencentSendBatchSmsApi implements SendBatchSmsApi {
    /**
     * tencent sms client.
     */
    private final TencentSmsClient tencentSmsClient;

    /**
     * execute SendBatchSmsApiRequest by tencent.
     *
     * @param request request
     * @return SendBatchSmsApiResponse
     */
    @Override
    public SendBatchSmsApiResponse execute(final SendBatchSmsApiRequest request) {
        TencentSmsApiProperties properties = (TencentSmsApiProperties)
                ApiRegistry.INSTANCE.getApiPropertiesOrThrow(request);
        try {
            SmsClient client = tencentSmsClient.getClient(properties);
            SendSmsRequest req = new SendSmsRequest();
            req.setSmsSdkAppid(properties.getAppId());
            req.setSign(properties.getSign());
            req.setSenderId(properties.getSenderId());
            req.setExtendCode(properties.getExtendCode());
            req.setTemplateID(request.getTemplateId());
            req.setPhoneNumberSet(request.getMessages().stream()
                    .map(SmsMessage::getPhoneNumber).toArray(String[]::new));
            req.setTemplateParamSet(request.getMessages()
                    .stream()
                    .map(it -> it.getTemplateParams().values()
                            .toArray(new String[0]))
                    .findFirst()
                    .orElseGet(() -> new String[]{""}));
            SendSmsResponse sendSmsResponse = client.SendSms(req);
            return getSendBatchSmsApiResponse(sendSmsResponse);
        } catch (TencentCloudSDKException e) {
            throw new ApiException(e);
        }
    }

    private SendBatchSmsApiResponse getSendBatchSmsApiResponse(
            final SendSmsResponse sendSmsResponse) {
        return SendBatchSmsApiResponse.builder()
                .requestId(sendSmsResponse.getRequestId())
                .success(Arrays.stream(sendSmsResponse.getSendStatusSet())
                        .allMatch(it -> "Ok".equals(it.getCode())))
                .code(Arrays.stream(sendSmsResponse.getSendStatusSet())
                        .map(SendStatus::getCode)
                        .collect(Collectors.joining()))
                .message(Arrays.stream(sendSmsResponse.getSendStatusSet())
                        .map(SendStatus::getMessage)
                        .collect(Collectors.joining()))
                .sendStatuses(Arrays.stream(sendSmsResponse.getSendStatusSet())
                        .map(it -> new SmsSendStatus(
                                it.getCode(),
                                it.getMessage()))
                        .toArray(SmsSendStatus[]::new))
                .build();
    }
}
