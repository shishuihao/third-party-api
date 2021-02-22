package cn.shishuihao.thirdparty.api.sms.aliyun.api;

import cn.shishuihao.thirdparty.api.core.ApiException;
import cn.shishuihao.thirdparty.api.core.PropertiesNotFoundException;
import cn.shishuihao.thirdparty.api.core.PropertiesRepository;
import cn.shishuihao.thirdparty.api.sms.aliyun.AliYunSmsProperties;
import cn.shishuihao.thirdparty.api.sms.api.SendBatchSmsApi;
import cn.shishuihao.thirdparty.api.sms.domain.SendStatus;
import cn.shishuihao.thirdparty.api.sms.request.SendBatchSmsRequest;
import cn.shishuihao.thirdparty.api.sms.response.SendBatchSmsResponse;
import com.aliyun.dysmsapi20170525.models.SendBatchSmsResponseBody;
import com.aliyun.teaopenapi.models.Config;

/**
 * @author shishuihao
 * @version 1.0.0
 */
public class AliYunSendBatchSmsApi implements SendBatchSmsApi {
    private final PropertiesRepository propertiesRepository;

    public AliYunSendBatchSmsApi(PropertiesRepository propertiesRepository) {
        this.propertiesRepository = propertiesRepository;
    }

    @Override
    public SendBatchSmsResponse execute(SendBatchSmsRequest request) {
        AliYunSmsProperties smsProperties = (AliYunSmsProperties) propertiesRepository.getById(request.getPropertiesId())
                .orElseThrow(() -> new PropertiesNotFoundException("properties not found"));
        try {
            Config config = new Config()
                    // 您的AccessKey ID
                    .setAccessKeyId(smsProperties.getAccessKeyId())
                    // 您的AccessKey Secret
                    .setAccessKeySecret(smsProperties.getAccessSecret());
            // 访问的域名
            config.endpoint = "dysmsapi.aliyuncs.com";
            com.aliyun.dysmsapi20170525.Client client = new com.aliyun.dysmsapi20170525.Client(config);
            com.aliyun.dysmsapi20170525.models.SendBatchSmsRequest sendBatchSmsRequest = new com.aliyun.dysmsapi20170525.models.SendBatchSmsRequest();
            //
            SendBatchSmsResponseBody smsResponse = client.sendBatchSms(sendBatchSmsRequest).getBody();
            return new SendBatchSmsResponse()
                    .setSendStatuses(new SendStatus[]{new SendStatus(smsResponse.getCode(), smsResponse.getMessage())})
                    .setRequestId(smsResponse.getRequestId());
        } catch (Exception e) {
            throw new ApiException(e);
        }
    }
}
