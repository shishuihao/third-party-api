package cn.shishuihao.thirdparty.api.sms.aliyun.api;

import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.core.exception.ApiException;
import cn.shishuihao.thirdparty.api.sms.aliyun.AliYunSmsApiProperties;
import cn.shishuihao.thirdparty.api.sms.aliyun.AliYunSmsClient;
import cn.shishuihao.thirdparty.api.sms.aliyun.assembler.AliYunSmsRequestAssembler;
import cn.shishuihao.thirdparty.api.sms.aliyun.assembler.AliYunSmsResponseAssembler;
import cn.shishuihao.thirdparty.api.sms.api.SendBatchSmsApi;
import cn.shishuihao.thirdparty.api.sms.request.SendBatchSmsApiRequest;
import cn.shishuihao.thirdparty.api.sms.response.SendBatchSmsApiResponse;
import lombok.AllArgsConstructor;

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
     * execute request.
     *
     * @param request request
     * @return response
     */
    @Override
    public SendBatchSmsApiResponse
    execute(final SendBatchSmsApiRequest request) {
        final AliYunSmsApiProperties properties = (AliYunSmsApiProperties)
                ApiRegistry.INSTANCE.getApiPropertiesOrThrow(request);
        try {
            return AliYunSmsResponseAssembler.INSTANCE
                    .assemble(smsClient
                            .getAliYunClient(properties)
                            .sendBatchSms(AliYunSmsRequestAssembler.INSTANCE
                                    .assemble(request, properties))
                            .getBody());
        } catch (Exception e) {
            throw new ApiException(e);
        }
    }
}
