package cn.shishuihao.thirdparty.api.pay.alipay.api;

import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.core.exception.ApiException;
import cn.shishuihao.thirdparty.api.pay.alipay.AlipayPayApiProperties;
import cn.shishuihao.thirdparty.api.pay.alipay.AlipayPayClient;
import cn.shishuihao.thirdparty.api.pay.api.AppPayApi;
import cn.shishuihao.thirdparty.api.pay.request.AppPayApiRequest;
import cn.shishuihao.thirdparty.api.pay.response.AppPayApiResponse;
import cn.shishuihao.thirdparty.api.pay.util.AmountUtils;
import com.alipay.easysdk.payment.app.models.AlipayTradeAppPayResponse;
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
    private final AlipayPayClient alipayPayClient;

    /**
     * execute request by alipay.
     *
     * @param request request
     * @return response
     */
    @Override
    public AppPayApiResponse execute(final AppPayApiRequest request) {
        AlipayPayApiProperties properties = (AlipayPayApiProperties)
                ApiRegistry.INSTANCE.getApiPropertiesOrThrow(request);
        try {
            com.alipay.easysdk.payment.app.Client client
                    = alipayPayClient.getAppClient(properties);
            AlipayTradeAppPayResponse response = client.pay(
                    request.getSubject(),
                    request.getOutTradeNo(),
                    AmountUtils.toYuanString(request.getTotalAmount()));
            return AppPayApiResponse.builder()
                    .body(response.body)
                    .build();
        } catch (Exception e) {
            throw new ApiException(e);
        }
    }
}
