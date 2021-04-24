package cn.shishuihao.thirdparty.api.pay.alipay.api;

import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.core.exception.ApiException;
import cn.shishuihao.thirdparty.api.pay.alipay.AlipayPayApiProperties;
import cn.shishuihao.thirdparty.api.pay.alipay.AlipayPayClient;
import cn.shishuihao.thirdparty.api.pay.alipay.assembler.AlipayPayResponseAssembler;
import cn.shishuihao.thirdparty.api.pay.api.RefundQueryPayApi;
import cn.shishuihao.thirdparty.api.pay.request.RefundQueryPayApiRequest;
import cn.shishuihao.thirdparty.api.pay.response.RefundQueryPayApiResponse;
import lombok.AllArgsConstructor;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@AllArgsConstructor
public class AlipayRefundQueryPayApi implements RefundQueryPayApi {
    /**
     * alipay pay client.
     */
    private final AlipayPayClient client;

    /**
     * execute request.
     *
     * @param request request
     * @return response
     */
    @Override
    public RefundQueryPayApiResponse execute(
            final RefundQueryPayApiRequest request) {
        final AlipayPayApiProperties properties = (AlipayPayApiProperties)
                ApiRegistry.INSTANCE.getApiPropertiesOrThrow(request);
        try {
            return AlipayPayResponseAssembler.INSTANCE
                    .assemble(client.getCommonClient(properties)
                            .queryRefund(request.getOutTradeNo(),
                                    request.getOutRefundNo()));
        } catch (Exception e) {
            throw new ApiException(e);
        }
    }
}
