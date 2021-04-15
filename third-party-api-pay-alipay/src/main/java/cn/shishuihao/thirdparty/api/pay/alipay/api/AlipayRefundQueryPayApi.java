package cn.shishuihao.thirdparty.api.pay.alipay.api;

import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.core.exception.ApiException;
import cn.shishuihao.thirdparty.api.pay.alipay.AlipayPayApiProperties;
import cn.shishuihao.thirdparty.api.pay.alipay.AlipayPayClient;
import cn.shishuihao.thirdparty.api.pay.alipay.domain.AlipayRefundStatus;
import cn.shishuihao.thirdparty.api.pay.alipay.util.AlipayResponseUtils;
import cn.shishuihao.thirdparty.api.pay.api.RefundQueryPayApi;
import cn.shishuihao.thirdparty.api.pay.request.RefundQueryPayApiRequest;
import cn.shishuihao.thirdparty.api.pay.response.RefundQueryPayApiResponse;
import com.alipay.easysdk.kernel.util.ResponseChecker;
import com.alipay.easysdk.payment.common.models.AlipayTradeFastpayRefundQueryResponse;
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
    private final AlipayPayClient alipayPayClient;

    /**
     * execute request by alipay.
     *
     * @param request request
     * @return response
     */
    @Override
    public RefundQueryPayApiResponse execute(
            final RefundQueryPayApiRequest request) {
        AlipayPayApiProperties properties = (AlipayPayApiProperties)
                ApiRegistry.INSTANCE.getApiPropertiesOrThrow(request);
        try {
            AlipayTradeFastpayRefundQueryResponse response = alipayPayClient
                    .getCommonClient(properties)
                    .queryRefund(request.getOutTradeNo(),
                            request.getOutRefundNo());
            return buildResponse(response);
        } catch (Exception e) {
            throw new ApiException(e);
        }
    }

    private RefundQueryPayApiResponse buildResponse(
            final AlipayTradeFastpayRefundQueryResponse response) {
        return RefundQueryPayApiResponse.builder()
                .success(ResponseChecker.success(response))
                .code(AlipayResponseUtils.code(response))
                .message(AlipayResponseUtils.message(response))
                .requestId(null)
                .refundStatus(AlipayRefundStatus
                        .refundStatusOf(response.refundStatus))
                .build();
    }
}
