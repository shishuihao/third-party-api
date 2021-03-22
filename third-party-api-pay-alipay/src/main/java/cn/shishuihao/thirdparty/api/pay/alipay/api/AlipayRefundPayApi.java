package cn.shishuihao.thirdparty.api.pay.alipay.api;

import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.core.exception.ApiException;
import cn.shishuihao.thirdparty.api.pay.alipay.AlipayPayApiProperties;
import cn.shishuihao.thirdparty.api.pay.alipay.AlipayPayClient;
import cn.shishuihao.thirdparty.api.pay.alipay.util.AlipayResponseUtils;
import cn.shishuihao.thirdparty.api.pay.api.RefundPayApi;
import cn.shishuihao.thirdparty.api.pay.request.RefundApiRequest;
import cn.shishuihao.thirdparty.api.pay.response.RefundApiResponse;
import cn.shishuihao.thirdparty.api.pay.util.AmountUtils;
import com.alipay.easysdk.kernel.util.ResponseChecker;
import com.alipay.easysdk.payment.common.models.AlipayTradeRefundResponse;
import lombok.AllArgsConstructor;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@AllArgsConstructor
public class AlipayRefundPayApi implements RefundPayApi {
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
    public RefundApiResponse execute(final RefundApiRequest request) {
        AlipayPayApiProperties properties = (AlipayPayApiProperties)
                ApiRegistry.INSTANCE.getApiPropertiesOrThrow(request);
        try {
            com.alipay.easysdk.payment.common.Client client
                    = alipayPayClient.getCommonClient(properties);
            AlipayTradeRefundResponse response = client.refund(
                    request.getOutTradeNo(),
                    AmountUtils.toYuanString(request.getRefundAmount()));
            return RefundApiResponse.builder()
                    .success(ResponseChecker.success(response))
                    .code(AlipayResponseUtils.code(response))
                    .message(AlipayResponseUtils.message(response))
                    .requestId(null)
                    .build();
        } catch (Exception e) {
            throw new ApiException(e);
        }
    }
}
