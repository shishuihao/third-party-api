package cn.shishuihao.thirdparty.api.pay.ccb.api;

import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.core.exception.ApiException;
import cn.shishuihao.thirdparty.api.pay.api.CancelPayApi;
import cn.shishuihao.thirdparty.api.pay.ccb.CcbPayApiProperties;
import cn.shishuihao.thirdparty.api.pay.ccb.assembler.CcbRequestAssembler;
import cn.shishuihao.thirdparty.api.pay.ccb.assembler.CcbResponseAssembler;
import cn.shishuihao.thirdparty.api.pay.ccb.sdk.CcbPayClient;
import cn.shishuihao.thirdparty.api.pay.ccb.sdk.response.CcbPay103Response;
import cn.shishuihao.thirdparty.api.pay.request.CancelPayApiRequest;
import cn.shishuihao.thirdparty.api.pay.response.CancelPayApiResponse;
import lombok.AllArgsConstructor;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@AllArgsConstructor
public class CcbCancelPayApi implements CancelPayApi {
    /**
     * CcbPayClient.
     */
    private final CcbPayClient client;

    /**
     * execute request.
     *
     * @param request request
     * @return response
     */
    @Override
    public CancelPayApiResponse execute(final CancelPayApiRequest request) {
        final CcbPayApiProperties properties = (CcbPayApiProperties)
                ApiRegistry.INSTANCE.getApiPropertiesOrThrow(request);
        try {
            final String channelName = client
                    .urlInfo(properties)
                    .getChannelName();
            final CcbPay103Response response = client
                    .scannedPayApi(properties)
                    .cancel(channelName, CcbRequestAssembler.INSTANCE
                            .assemble(request, properties));
            return CcbResponseAssembler.INSTANCE
                    .assemble(response);
        } catch (Exception e) {
            throw new ApiException(e);
        }
    }
}
