package cn.shishuihao.thirdparty.api.pay.alipay.api;

import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.core.exception.ApiException;
import cn.shishuihao.thirdparty.api.pay.alipay.AlipayPayApiProperties;
import cn.shishuihao.thirdparty.api.pay.alipay.AlipayPayClient;
import cn.shishuihao.thirdparty.api.pay.alipay.assembler.AlipayPayResponseAssembler;
import cn.shishuihao.thirdparty.api.pay.api.QueryPayApi;
import cn.shishuihao.thirdparty.api.pay.request.QueryPayApiRequest;
import cn.shishuihao.thirdparty.api.pay.response.QueryPayApiResponse;
import lombok.AllArgsConstructor;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@AllArgsConstructor
public class AlipayQueryPayApi implements QueryPayApi {
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
    public QueryPayApiResponse execute(final QueryPayApiRequest request) {
        final AlipayPayApiProperties properties = (AlipayPayApiProperties)
                ApiRegistry.INSTANCE.getApiPropertiesOrThrow(request);
        try {
            return AlipayPayResponseAssembler.INSTANCE
                    .assemble(client
                            .getCommonClient(properties)
                            .query(request.getOutTradeNo()));
        } catch (Exception e) {
            throw new ApiException(e);
        }
    }
}
