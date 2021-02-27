package cn.shishuihao.thirdparty.api.sms.aliyun.api;

import cn.shishuihao.thirdparty.api.core.ApiException;
import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.sms.aliyun.AliYunSmsApiProperties;
import cn.shishuihao.thirdparty.api.sms.aliyun.AliYunSmsClient;
import cn.shishuihao.thirdparty.api.sms.api.SendSmsApi;
import cn.shishuihao.thirdparty.api.sms.request.SendSmsApiRequest;
import cn.shishuihao.thirdparty.api.sms.response.SendSmsApiResponse;
import com.aliyun.dysmsapi20170525.Client;
import com.aliyun.dysmsapi20170525.models.SendSmsRequest;
import com.aliyun.dysmsapi20170525.models.SendSmsResponseBody;
import com.google.gson.Gson;

import java.util.Optional;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class AliYunSendSmsApi implements SendSmsApi {
    private final AliYunSmsClient smsClient;

    public AliYunSendSmsApi(AliYunSmsClient smsClient) {
        this.smsClient = smsClient;
    }

    @Override
    public SendSmsApiResponse execute(SendSmsApiRequest request) {
        AliYunSmsApiProperties properties = (AliYunSmsApiProperties) ApiRegistry.INSTANCE.getApiPropertiesOrThrow(request);
        try {
            Client client = smsClient.getAliYunClient(properties);
            SendSmsRequest sendSmsRequest = new SendSmsRequest();
            // 接收短信的手机号码。
            // 格式：
            // 国内短信：11位手机号码，例如1381111****。
            // 国际/港澳台消息：国际区号+号码，例如852000012****。
            // 支持对多个手机号码发送短信，手机号码之间以英文逗号（,）分隔。上限为1000个手机号码。批量调用相对于单条调用及时性稍有延迟。
            sendSmsRequest.setPhoneNumbers(request.getMessage().getPhoneNumber());
            // 短信签名名称。请在控制台国内消息或国际/港澳台消息页面中的签名管理页签下签名名称一列查看。
            sendSmsRequest.setSignName(Optional.ofNullable(request.getMessage().getSignName())
                    .orElseGet(properties::getSignName));
            // 短信模板ID。请在控制台国内消息或国际/港澳台消息页面中的模板管理页签下模板CODE一列查看。
            sendSmsRequest.setTemplateCode(request.getTemplateId());
            // 短信模板变量对应的实际值，JSON格式。
            sendSmsRequest.setTemplateParam(new Gson().toJson(request.getMessage().getTemplateParams()));
            // 上行短信扩展码，上行短信，指发送给通信服务提供商的短信，用于定制某种服务、完成查询，或是办理某种业务等，需要收费的，按运营商普通短信资费进行扣费。
            sendSmsRequest.setSmsUpExtendCode(Optional.ofNullable(request.getMessage().getExtendCode())
                    .orElseGet(properties::getSmsUpExtendCode));
            // 外部流水扩展字段。
            SendSmsResponseBody sendSmsResponseBody = client.sendSms(sendSmsRequest).getBody();
            return SendSmsApiResponse.Builder.builder()
                    .success("OK".equals(sendSmsResponseBody.getCode()))
                    .code(sendSmsResponseBody.getCode())
                    .message(sendSmsResponseBody.getMessage())
                    .requestId(sendSmsResponseBody.getRequestId())
                    .build();
        } catch (Exception e) {
            throw new ApiException(e);
        }
    }
}
