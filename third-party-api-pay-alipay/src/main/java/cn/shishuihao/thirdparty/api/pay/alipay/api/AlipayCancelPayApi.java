package cn.shishuihao.thirdparty.api.pay.alipay.api;

import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.core.exception.ApiException;
import cn.shishuihao.thirdparty.api.pay.alipay.AlipayPayApiProperties;
import cn.shishuihao.thirdparty.api.pay.alipay.AlipayPayClient;
import cn.shishuihao.thirdparty.api.pay.alipay.util.AlipayResponseUtils;
import cn.shishuihao.thirdparty.api.pay.api.CancelPayApi;
import cn.shishuihao.thirdparty.api.pay.request.CancelPayApiRequest;
import cn.shishuihao.thirdparty.api.pay.response.CancelPayApiResponse;
import com.alipay.easysdk.kernel.util.ResponseChecker;
import com.alipay.easysdk.payment.common.models.AlipayTradeCancelResponse;
import lombok.AllArgsConstructor;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@AllArgsConstructor
public class AlipayCancelPayApi implements CancelPayApi {
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
    public CancelPayApiResponse execute(final CancelPayApiRequest request) {
        AlipayPayApiProperties properties = (AlipayPayApiProperties)
                ApiRegistry.INSTANCE.getApiPropertiesOrThrow(request);
        try {
            com.alipay.easysdk.payment.common.Client client
                    = alipayPayClient.getCommonClient(properties);
            AlipayTradeCancelResponse response = client.cancel(
                    request.getOutTradeNo());
            return CancelPayApiResponse.builder()
                    .success(ResponseChecker.success(response))
                    .code(AlipayResponseUtils.code(response))
                    .message(AlipayResponseUtils.message(response))
                    .requestId(null)
                    .channelTransactionId(response.tradeNo)
                    .retry("Y".equals(response.retryFlag))
                    .build();
        } catch (Exception e) {
            throw new ApiException(e);
        }
    }
}
