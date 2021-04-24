package cn.shishuihao.thirdparty.api.pay.icbc.api;

import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.core.exception.ApiException;
import cn.shishuihao.thirdparty.api.pay.api.RefundPayApi;
import cn.shishuihao.thirdparty.api.pay.icbc.IcbcPayApiProperties;
import cn.shishuihao.thirdparty.api.pay.icbc.IcbcPayClient;
import cn.shishuihao.thirdparty.api.pay.icbc.assembler.IcbcPayRequestAssembler;
import cn.shishuihao.thirdparty.api.pay.icbc.assembler.IcbcPayResponseAssembler;
import cn.shishuihao.thirdparty.api.pay.request.RefundPayApiRequest;
import cn.shishuihao.thirdparty.api.pay.response.RefundPayApiResponse;
import lombok.AllArgsConstructor;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@AllArgsConstructor
public class IcbcRefundPayApi implements RefundPayApi {
    /**
     * IcbcPayClient.
     */
    private final IcbcPayClient client;

    /**
     * execute request.
     *
     * @param request request
     * @return response
     */
    @Override
    public RefundPayApiResponse execute(final RefundPayApiRequest request) {
        final IcbcPayApiProperties properties = (IcbcPayApiProperties)
                ApiRegistry.INSTANCE.getApiPropertiesOrThrow(request);
        try {
            return IcbcPayResponseAssembler.INSTANCE
                    .assemble(client
                            .getClient(properties)
                            .execute(IcbcPayRequestAssembler.INSTANCE
                                    .assemble(request, properties)));
        } catch (Exception e) {
            throw new ApiException(e);
        }
    }
}
