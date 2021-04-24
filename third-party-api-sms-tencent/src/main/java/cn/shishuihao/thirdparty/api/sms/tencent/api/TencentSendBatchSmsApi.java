package cn.shishuihao.thirdparty.api.sms.tencent.api;

import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.core.exception.ApiException;
import cn.shishuihao.thirdparty.api.sms.api.SendBatchSmsApi;
import cn.shishuihao.thirdparty.api.sms.request.SendBatchSmsApiRequest;
import cn.shishuihao.thirdparty.api.sms.response.SendBatchSmsApiResponse;
import cn.shishuihao.thirdparty.api.sms.tencent.TencentSmsApiProperties;
import cn.shishuihao.thirdparty.api.sms.tencent.TencentSmsClient;
import cn.shishuihao.thirdparty.api.sms.tencent.assembler.TencentSmsRequestAssembler;
import cn.shishuihao.thirdparty.api.sms.tencent.assembler.TencentSmsResponseAssembler;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import lombok.AllArgsConstructor;

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
     * execute request.
     *
     * @param request request
     * @return response
     */
    @Override
    public SendBatchSmsApiResponse execute(
            final SendBatchSmsApiRequest request) {
        final TencentSmsApiProperties properties = (TencentSmsApiProperties)
                ApiRegistry.INSTANCE.getApiPropertiesOrThrow(request);
        try {
            return TencentSmsResponseAssembler.INSTANCE
                    .assemble(tencentSmsClient
                            .getClient(properties)
                            .SendSms(TencentSmsRequestAssembler.INSTANCE
                                    .assemble(request, properties)));
        } catch (TencentCloudSDKException e) {
            throw new ApiException(e);
        }
    }
}
