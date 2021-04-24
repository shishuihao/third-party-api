package cn.shishuihao.thirdparty.api.sms.aliyun.api;

import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.core.exception.ApiException;
import cn.shishuihao.thirdparty.api.sms.aliyun.AliYunSmsApiProperties;
import cn.shishuihao.thirdparty.api.sms.aliyun.AliYunSmsClient;
import cn.shishuihao.thirdparty.api.sms.aliyun.assembler.AliYunSmsRequestAssembler;
import cn.shishuihao.thirdparty.api.sms.aliyun.assembler.AliYunSmsResponseAssembler;
import cn.shishuihao.thirdparty.api.sms.api.SendSmsApi;
import cn.shishuihao.thirdparty.api.sms.request.SendSmsApiRequest;
import cn.shishuihao.thirdparty.api.sms.response.SendSmsApiResponse;
import lombok.AllArgsConstructor;

/**
 * send message.
 * {@link "https://help.aliyun.com/document_detail/101414.html
 * ?spm=a2c4g.11186623.6.626.35661040OzJgnG"}
 *
 * @author shishuihao
 * @version 1.0.0
 */
@AllArgsConstructor
public class AliYunSendSmsApi implements SendSmsApi {
    /**
     * aliyun sms client.
     */
    private final AliYunSmsClient smsClient;

    /**
     * execute request.
     *
     * @param request request
     * @return response
     */
    @Override
    public SendSmsApiResponse execute(final SendSmsApiRequest request) {
        final AliYunSmsApiProperties properties = (AliYunSmsApiProperties)
                ApiRegistry.INSTANCE.getApiPropertiesOrThrow(request);
        try {
            return AliYunSmsResponseAssembler.INSTANCE
                    .assemble(smsClient
                            .getAliYunClient(properties)
                            .sendSms(AliYunSmsRequestAssembler.INSTANCE
                                    .assemble(request, properties))
                            .getBody());
        } catch (Exception e) {
            throw new ApiException(e);
        }
    }
}
