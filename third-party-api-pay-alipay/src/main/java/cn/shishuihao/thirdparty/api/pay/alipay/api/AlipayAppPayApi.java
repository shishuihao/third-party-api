package cn.shishuihao.thirdparty.api.pay.alipay.api;

import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.core.exception.ApiException;
import cn.shishuihao.thirdparty.api.pay.alipay.AlipayPayApiProperties;
import cn.shishuihao.thirdparty.api.pay.alipay.AlipayPayClient;
import cn.shishuihao.thirdparty.api.pay.api.AppPayApi;
import cn.shishuihao.thirdparty.api.pay.request.AppPayApiRequest;
import cn.shishuihao.thirdparty.api.pay.response.AppPayApiResponse;
import cn.shishuihao.thirdparty.api.pay.util.AmountUtils;
import lombok.AllArgsConstructor;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@AllArgsConstructor
public class AlipayAppPayApi implements AppPayApi {
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
    public AppPayApiResponse execute(final AppPayApiRequest request) {
        final AlipayPayApiProperties properties = (AlipayPayApiProperties)
                ApiRegistry.INSTANCE.getApiPropertiesOrThrow(request);
        try {
            return AppPayApiResponse.builder()
                    .body(client
                            .getAppClient(properties)
                            .pay(request.getSubject(), request.getOutTradeNo(),
                                    AmountUtils.toYuanString(
                                            request.getTotalAmount()))
                            .body)
                    .build();
        } catch (Exception e) {
            throw new ApiException(e);
        }
    }
}
