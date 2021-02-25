package cn.shishuihao.thirdparty.api.sms.aliyun.api;

import cn.shishuihao.thirdparty.api.core.ApiException;
import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.sms.aliyun.AliYunSmsApiProperties;
import cn.shishuihao.thirdparty.api.sms.api.SendBatchSmsApi;
import cn.shishuihao.thirdparty.api.sms.domain.SendStatus;
import cn.shishuihao.thirdparty.api.sms.request.SendBatchSmsApiRequest;
import cn.shishuihao.thirdparty.api.sms.response.SendBatchSmsApiResponse;
import com.aliyun.dysmsapi20170525.Client;
import com.aliyun.dysmsapi20170525.models.SendBatchSmsRequest;
import com.aliyun.dysmsapi20170525.models.SendBatchSmsResponseBody;
import com.aliyun.teaopenapi.models.Config;

/**
 * @author shishuihao
 * @version 1.0.0
 */
public class AliYunSendBatchSmsApi implements SendBatchSmsApi {
    @Override
    public SendBatchSmsApiResponse execute(SendBatchSmsApiRequest request) {
        AliYunSmsApiProperties properties = (AliYunSmsApiProperties) ApiRegistry.INSTANCE.getApiPropertiesOrThrow(request);
        try {
            Config config = new Config()
                    // 您的AccessKey ID
                    .setAccessKeyId(properties.getAccessKeyId())
                    // 您的AccessKey Secret
                    .setAccessKeySecret(properties.getAccessSecret());
            // 访问的域名
            config.endpoint = "dysmsapi.aliyuncs.com";
            Client client = new Client(config);
            SendBatchSmsRequest sendBatchSmsRequest = new SendBatchSmsRequest();
            //
            SendBatchSmsResponseBody sendBatchSmsResponseBody = client.sendBatchSms(sendBatchSmsRequest).getBody();
            return SendBatchSmsApiResponse.Builder.builder()
                    .sendStatuses(new SendStatus[]{new SendStatus(sendBatchSmsResponseBody.getCode(), sendBatchSmsResponseBody.getMessage())})
                    .requestId(sendBatchSmsResponseBody.getRequestId())
                    .build();
        } catch (Exception e) {
            throw new ApiException(e);
        }
    }
}
