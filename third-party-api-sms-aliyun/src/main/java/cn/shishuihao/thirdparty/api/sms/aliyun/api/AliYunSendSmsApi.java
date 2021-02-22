package cn.shishuihao.thirdparty.api.sms.aliyun.api;

import cn.shishuihao.thirdparty.api.core.ApiException;
import cn.shishuihao.thirdparty.api.core.PropertiesNotFoundException;
import cn.shishuihao.thirdparty.api.core.PropertiesRepository;
import cn.shishuihao.thirdparty.api.sms.aliyun.AliYunSmsProperties;
import cn.shishuihao.thirdparty.api.sms.api.SendSmsApi;
import cn.shishuihao.thirdparty.api.sms.request.SendSmsRequest;
import cn.shishuihao.thirdparty.api.sms.response.SendSmsResponse;
import com.aliyun.dysmsapi20170525.models.SendSmsResponseBody;
import com.aliyun.teaopenapi.models.Config;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class AliYunSendSmsApi implements SendSmsApi {
    private final PropertiesRepository propertiesRepository;

    public AliYunSendSmsApi(PropertiesRepository propertiesRepository) {
        this.propertiesRepository = propertiesRepository;
    }

    @Override
    public SendSmsResponse execute(SendSmsRequest request) {
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
            com.aliyun.dysmsapi20170525.models.SendSmsRequest sendSmsRequest = new com.aliyun.dysmsapi20170525.models.SendSmsRequest();
            //
            SendSmsResponseBody smsResponse = client.sendSms(sendSmsRequest).getBody();
            return new SendSmsResponse()
                    .setCode(smsResponse.getCode())
                    .setMessage(smsResponse.getMessage())
                    .setRequestId(smsResponse.getRequestId());
        } catch (Exception e) {
            throw new ApiException(e);
        }
    }
}
