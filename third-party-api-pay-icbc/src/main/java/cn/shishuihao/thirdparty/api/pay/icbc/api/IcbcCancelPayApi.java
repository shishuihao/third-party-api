package cn.shishuihao.thirdparty.api.pay.icbc.api;

import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.core.exception.ApiException;
import cn.shishuihao.thirdparty.api.pay.api.CancelPayApi;
import cn.shishuihao.thirdparty.api.pay.icbc.IcbcPayApiProperties;
import cn.shishuihao.thirdparty.api.pay.icbc.IcbcPayClient;
import cn.shishuihao.thirdparty.api.pay.icbc.assembler.IcbcPayRequestAssembler;
import cn.shishuihao.thirdparty.api.pay.icbc.assembler.IcbcPayResponseAssembler;
import cn.shishuihao.thirdparty.api.pay.request.CancelPayApiRequest;
import cn.shishuihao.thirdparty.api.pay.response.CancelPayApiResponse;
import lombok.AllArgsConstructor;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@AllArgsConstructor
public class IcbcCancelPayApi implements CancelPayApi {
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
    public CancelPayApiResponse execute(final CancelPayApiRequest request) {
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
