package cn.shishuihao.thirdparty.api.pay.alipay.api;

import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.core.exception.ApiException;
import cn.shishuihao.thirdparty.api.pay.alipay.AlipayPayApiProperties;
import cn.shishuihao.thirdparty.api.pay.alipay.AlipayPayClient;
import cn.shishuihao.thirdparty.api.pay.alipay.util.AlipayResponseUtils;
import cn.shishuihao.thirdparty.api.pay.api.RefundPayApi;
import cn.shishuihao.thirdparty.api.pay.request.RefundPayApiRequest;
import cn.shishuihao.thirdparty.api.pay.response.RefundPayApiResponse;
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
    public RefundPayApiResponse execute(final RefundPayApiRequest request) {
        AlipayPayApiProperties properties = (AlipayPayApiProperties)
                ApiRegistry.INSTANCE.getApiPropertiesOrThrow(request);
        try {
            AlipayTradeRefundResponse response = alipayPayClient
                    .getCommonClient(properties)
                    .refund(request.getOutTradeNo(), AmountUtils
                            .toYuanString(request.getRefundAmount()));
            return buildResponse(response);
        } catch (Exception e) {
            throw new ApiException(e);
        }
    }

    private RefundPayApiResponse buildResponse(
            final AlipayTradeRefundResponse response) {
        return RefundPayApiResponse.builder()
                .success(ResponseChecker.success(response))
                .code(AlipayResponseUtils.code(response))
                .message(AlipayResponseUtils.message(response))
                .requestId(null)
                .channelTransactionId(response.tradeNo)
                .channelRefundId(null)
                .build();
    }
}
