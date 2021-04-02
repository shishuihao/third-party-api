package cn.shishuihao.thirdparty.api.pay.alipay.api;

import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.core.exception.ApiException;
import cn.shishuihao.thirdparty.api.pay.alipay.AlipayPayApiProperties;
import cn.shishuihao.thirdparty.api.pay.alipay.AlipayPayClient;
import cn.shishuihao.thirdparty.api.pay.alipay.domain.AlipayTradeStatus;
import cn.shishuihao.thirdparty.api.pay.alipay.util.AlipayResponseUtils;
import cn.shishuihao.thirdparty.api.pay.api.QueryPayApi;
import cn.shishuihao.thirdparty.api.pay.request.QueryPayApiRequest;
import cn.shishuihao.thirdparty.api.pay.response.QueryPayApiResponse;
import cn.shishuihao.thirdparty.api.pay.util.AmountUtils;
import com.alipay.easysdk.kernel.util.ResponseChecker;
import com.alipay.easysdk.payment.common.models.AlipayTradeQueryResponse;
import lombok.AllArgsConstructor;

import java.util.Optional;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@AllArgsConstructor
public class AlipayQueryPayApi implements QueryPayApi {
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
    public QueryPayApiResponse execute(final QueryPayApiRequest request) {
        AlipayPayApiProperties properties = (AlipayPayApiProperties)
                ApiRegistry.INSTANCE.getApiPropertiesOrThrow(request);
        try {
            com.alipay.easysdk.payment.common.Client client
                    = alipayPayClient.getCommonClient(properties);
            AlipayTradeQueryResponse response = client.query(
                    request.getOutTradeNo());
            return QueryPayApiResponse.builder()
                    .success(ResponseChecker.success(response))
                    .code(AlipayResponseUtils.code(response))
                    .message(AlipayResponseUtils.message(response))
                    .requestId(null)
                    .channelTransactionId(response.tradeNo)
                    .bankType(null)
                    .payCurrency(response.payCurrency)
                    .payTotalAmount(Optional
                            .ofNullable(response.payAmount)
                            .map(AmountUtils::toCent)
                            .orElse(null))
                    .settleCurrency(response.settleCurrency)
                    .settleTotalAmount(Optional
                            .ofNullable(response.settleAmount)
                            .map(AmountUtils::toCent)
                            .orElse(null))
                    .tradeStatus(AlipayTradeStatus
                            .tradeStatusOf(response.tradeStatus))
                    .build();
        } catch (Exception e) {
            throw new ApiException(e);
        }
    }
}
