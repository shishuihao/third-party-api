package cn.shishuihao.thirdparty.api.pay.alipay.api;

import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.core.exception.ApiException;
import cn.shishuihao.thirdparty.api.pay.alipay.AlipayPayApiProperties;
import cn.shishuihao.thirdparty.api.pay.alipay.AlipayPayClient;
import cn.shishuihao.thirdparty.api.pay.api.H5PayApi;
import cn.shishuihao.thirdparty.api.pay.request.H5PayApiRequest;
import cn.shishuihao.thirdparty.api.pay.response.H5PayApiResponse;
import cn.shishuihao.thirdparty.api.pay.util.AmountUtils;
import lombok.AllArgsConstructor;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@AllArgsConstructor
public class AlipayH5PayApi implements H5PayApi {
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
    public H5PayApiResponse execute(final H5PayApiRequest request) {
        final AlipayPayApiProperties properties = (AlipayPayApiProperties)
                ApiRegistry.INSTANCE.getApiPropertiesOrThrow(request);
        try {
            // h5 = wap
            return H5PayApiResponse.builder()
                    .body(client
                            .getWapClient(properties)
                            .pay(request.getSubject(), request.getOutTradeNo(),
                                    AmountUtils.toYuanString(
                                            request.getTotalAmount()),
                                    request.getQuitUrl(),
                                    request.getReturnUrl())
                            .body)
                    .build();
        } catch (Exception e) {
            throw new ApiException(e);
        }
    }
}
