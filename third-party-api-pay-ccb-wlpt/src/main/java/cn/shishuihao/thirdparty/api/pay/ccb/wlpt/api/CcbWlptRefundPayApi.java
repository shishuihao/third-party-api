package cn.shishuihao.thirdparty.api.pay.ccb.wlpt.api;

import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.core.exception.ApiException;
import cn.shishuihao.thirdparty.api.pay.api.RefundPayApi;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.CcbWlptPayApiProperties;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.assembler.CcbWlptPayRequestAssembler;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.assembler.CcbWlptPayResponseAssembler;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.CcbWlptPayClient;
import cn.shishuihao.thirdparty.api.pay.request.RefundPayApiRequest;
import cn.shishuihao.thirdparty.api.pay.response.RefundPayApiResponse;
import lombok.AllArgsConstructor;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@AllArgsConstructor
public class CcbWlptRefundPayApi implements RefundPayApi {
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
    public RefundPayApiResponse execute(final RefundPayApiRequest request) {
        final CcbWlptPayApiProperties properties = (CcbWlptPayApiProperties)
                ApiRegistry.INSTANCE.getApiPropertiesOrThrow(request);
        try {
            return CcbWlptPayResponseAssembler.INSTANCE
                    .assemble(client
                            .onlineMerchantApi(properties)
                            .refund(client.urlInfo(properties)
                                            .getChannelName(),
                                    CcbWlptPayRequestAssembler.INSTANCE
                                            .assemble(request, properties)));
        } catch (Exception e) {
            throw new ApiException(e);
        }
    }
}
