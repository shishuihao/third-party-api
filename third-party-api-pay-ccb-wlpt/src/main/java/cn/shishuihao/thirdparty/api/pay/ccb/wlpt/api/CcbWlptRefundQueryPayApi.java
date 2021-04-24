package cn.shishuihao.thirdparty.api.pay.ccb.wlpt.api;

import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.core.exception.ApiException;
import cn.shishuihao.thirdparty.api.pay.api.RefundQueryPayApi;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.CcbWlptPayApiProperties;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.assembler.CcbWlptPayRequestAssembler;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.assembler.CcbWlptPayResponseAssembler;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.CcbWlptPayClient;
import cn.shishuihao.thirdparty.api.pay.request.RefundQueryPayApiRequest;
import cn.shishuihao.thirdparty.api.pay.response.RefundQueryPayApiResponse;
import lombok.AllArgsConstructor;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@AllArgsConstructor
public class CcbWlptRefundQueryPayApi implements RefundQueryPayApi {
    /**
     * CcbWlptPayClient.
     */
    private final CcbWlptPayClient client;

    /**
     * execute request.
     *
     * @param request request
     * @return response
     */
    @Override
    public RefundQueryPayApiResponse
    execute(final RefundQueryPayApiRequest request) {
        final CcbWlptPayApiProperties properties = (CcbWlptPayApiProperties)
                ApiRegistry.INSTANCE.getApiPropertiesOrThrow(request);
        try {
            return CcbWlptPayResponseAssembler.INSTANCE
                    .assemble(client
                            .onlineMerchantApi(properties)
                            .refundQuery(client.urlInfo(properties)
                                            .getChannelName(),
                                    CcbWlptPayRequestAssembler.INSTANCE
                                            .assemble(request, properties)));
        } catch (Exception e) {
            throw new ApiException(e);
        }
    }
}
