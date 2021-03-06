package cn.shishuihao.thirdparty.api.sms.tencent.api;

import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.core.exception.ApiException;
import cn.shishuihao.thirdparty.api.sms.api.SendBatchSmsApi;
import cn.shishuihao.thirdparty.api.sms.domain.SendStatus;
import cn.shishuihao.thirdparty.api.sms.domain.SmsMessage;
import cn.shishuihao.thirdparty.api.sms.request.SendBatchSmsApiRequest;
import cn.shishuihao.thirdparty.api.sms.response.SendBatchSmsApiResponse;
import cn.shishuihao.thirdparty.api.sms.tencent.TencentSmsApiProperties;
import cn.shishuihao.thirdparty.api.sms.tencent.TencentSmsClient;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.sms.v20190711.SmsClient;
import com.tencentcloudapi.sms.v20190711.models.SendSmsRequest;
import com.tencentcloudapi.sms.v20190711.models.SendSmsResponse;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * {@link = "https://cloud.tencent.com/document/product/382/43194"}
 *
 * @author shishuihao
 * @version 1.0.0
 */
public class TencentSendBatchSmsApi implements SendBatchSmsApi {
    private final TencentSmsClient tencentSmsClient;

    public TencentSendBatchSmsApi(TencentSmsClient tencentSmsClient) {
        this.tencentSmsClient = tencentSmsClient;
    }

    @Override
    public SendBatchSmsApiResponse execute(SendBatchSmsApiRequest request) {
        TencentSmsApiProperties properties = (TencentSmsApiProperties) ApiRegistry.INSTANCE.getApiPropertiesOrThrow(request);
        try {
            SmsClient client = tencentSmsClient.getClient(properties);
            SendSmsRequest req = new com.tencentcloudapi.sms.v20190711.models.SendSmsRequest();
            req.setSmsSdkAppid(properties.getAppId());
            req.setSign(properties.getSign());
            req.setSenderId(properties.getSenderId());
            req.setExtendCode(properties.getExtendCode());
            req.setTemplateID(request.getTemplateId());
            req.setPhoneNumberSet(request.getMessages().stream()
                    .map(SmsMessage::getPhoneNumber).toArray(String[]::new));
            req.setTemplateParamSet(request.getMessages().stream()
                    .map(it -> it.getTemplateParams().values().toArray(new String[0]))
                    .findFirst()
                    .orElseGet(() -> new String[]{""}));
            SendSmsResponse sendSmsResponse = client.SendSms(req);
            return getSendBatchSmsApiResponse(sendSmsResponse);
        } catch (TencentCloudSDKException e) {
            throw new ApiException(e);
        }
    }

    private SendBatchSmsApiResponse getSendBatchSmsApiResponse(com.tencentcloudapi.sms.v20190711.models.SendSmsResponse sendSmsResponse) {
        return SendBatchSmsApiResponse.Builder.builder()
                .requestId(sendSmsResponse.getRequestId())
                .success(Arrays.stream(sendSmsResponse.getSendStatusSet()).allMatch(it -> "Ok".equals(it.getCode())))
                .code(Arrays.stream(sendSmsResponse.getSendStatusSet())
                        .map(com.tencentcloudapi.sms.v20190711.models.SendStatus::getCode)
                        .collect(Collectors.joining()))
                .message(Arrays.stream(sendSmsResponse.getSendStatusSet())
                        .map(com.tencentcloudapi.sms.v20190711.models.SendStatus::getMessage)
                        .collect(Collectors.joining()))
                .sendStatuses(Arrays.stream(sendSmsResponse.getSendStatusSet())
                        .map(it -> new SendStatus(it.getCode(), it.getMessage()))
                        .toArray(SendStatus[]::new))
                .build();
    }
}
