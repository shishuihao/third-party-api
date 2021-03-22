package cn.shishuihao.thirdparty.api.pay.alipay.api;

import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.core.exception.ApiException;
import cn.shishuihao.thirdparty.api.pay.alipay.AlipayPayApiProperties;
import cn.shishuihao.thirdparty.api.pay.alipay.AlipayPayClient;
import cn.shishuihao.thirdparty.api.pay.alipay.util.AlipayResponseUtils;
import cn.shishuihao.thirdparty.api.pay.api.CancelPayApi;
import cn.shishuihao.thirdparty.api.pay.request.CancelApiRequest;
import cn.shishuihao.thirdparty.api.pay.response.CancelApiResponse;
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
    public CancelApiResponse execute(final CancelApiRequest request) {
        AlipayPayApiProperties properties = (AlipayPayApiProperties)
                ApiRegistry.INSTANCE.getApiPropertiesOrThrow(request);
        try {
            com.alipay.easysdk.payment.common.Client client
                    = alipayPayClient.getCommonClient(properties);
            AlipayTradeCancelResponse response = client.cancel(
                    request.getOutTradeNo());
            return CancelApiResponse.builder()
                    .success(ResponseChecker.success(response))
                    .code(AlipayResponseUtils.code(response))
                    .message(AlipayResponseUtils.message(response))
                    .requestId(null)
                    .retry("Y".equals(response.getRetryFlag()))
                    .build();
        } catch (Exception e) {
            throw new ApiException(e);
        }
    }
}
