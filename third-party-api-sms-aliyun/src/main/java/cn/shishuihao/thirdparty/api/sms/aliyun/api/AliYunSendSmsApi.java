package cn.shishuihao.thirdparty.api.sms.aliyun.api;

import cn.shishuihao.thirdparty.api.core.ApiException;
import cn.shishuihao.thirdparty.api.core.exception.PropertiesNotFoundException;
import cn.shishuihao.thirdparty.api.core.ApiPropertiesRepository;
import cn.shishuihao.thirdparty.api.sms.aliyun.AliYunSmsApiProperties;
import cn.shishuihao.thirdparty.api.sms.api.SendSmsApi;
import cn.shishuihao.thirdparty.api.sms.request.SendSmsApiRequest;
import cn.shishuihao.thirdparty.api.sms.response.SendSmsApiResponse;
import com.aliyun.dysmsapi20170525.Client;
import com.aliyun.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.dysmsapi20170525.models.SendSmsResponseBody;
import com.aliyun.teaopenapi.models.Config;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class AliYunSendSmsApi implements SendSmsApi {
    private final ApiPropertiesRepository propertiesRepository;

    public AliYunSendSmsApi(ApiPropertiesRepository propertiesRepository) {
        this.propertiesRepository = propertiesRepository;
    }

    @Override
    public SendSmsApiResponse execute(SendSmsApiRequest request) {
        AliYunSmsApiProperties properties = (AliYunSmsApiProperties) propertiesRepository.getById(request.getPropertiesId())
                .orElseThrow(() -> new PropertiesNotFoundException("properties not found"));
        try {
            Config config = new Config()
                    // 您的AccessKey ID
                    .setAccessKeyId(properties.getAccessKeyId())
                    // 您的AccessKey Secret
                    .setAccessKeySecret(properties.getAccessSecret());
            // 访问的域名
            config.endpoint = "dysmsapi.aliyuncs.com";
            Client client = new Client(config);
            SendSmsRequest sendSmsRequest = new SendSmsRequest();
            //
            SendSmsResponseBody sendSmsResponseBody = client.sendSms(sendSmsRequest).getBody();
            return SendSmsApiResponse.Builder.builder()
                    .code(sendSmsResponseBody.getCode())
                    .message(sendSmsResponseBody.getMessage())
                    .requestId(sendSmsResponseBody.getRequestId())
                    .build();
        } catch (Exception e) {
            throw new ApiException(e);
        }
    }
}
