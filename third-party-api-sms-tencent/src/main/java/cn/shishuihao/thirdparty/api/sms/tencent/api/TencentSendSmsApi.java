package cn.shishuihao.thirdparty.api.sms.tencent.api;

import cn.shishuihao.thirdparty.api.sms.api.SendSmsApi;
import cn.shishuihao.thirdparty.api.sms.request.SendSmsApiRequest;
import cn.shishuihao.thirdparty.api.sms.response.SendSmsApiResponse;
import cn.shishuihao.thirdparty.api.sms.tencent.assembler.TencentSmsRequestAssembler;
import cn.shishuihao.thirdparty.api.sms.tencent.assembler.TencentSmsResponseAssembler;
import lombok.AllArgsConstructor;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@AllArgsConstructor
public class TencentSendSmsApi implements SendSmsApi {
    /**
     * tencent sms api.
     */
    private final TencentSendBatchSmsApi tencentSendBatchSmsApi;

    /**
     * execute request.
     *
     * @param request request
     * @return response
     */
    @Override
    public SendSmsApiResponse execute(final SendSmsApiRequest request) {
        return TencentSmsResponseAssembler.INSTANCE
                .assemble(tencentSendBatchSmsApi
                        .execute(TencentSmsRequestAssembler.INSTANCE
                                .assemble(request)));
    }
}
