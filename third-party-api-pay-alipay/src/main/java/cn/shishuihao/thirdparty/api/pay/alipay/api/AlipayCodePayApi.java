package cn.shishuihao.thirdparty.api.pay.alipay.api;

import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.core.exception.ApiException;
import cn.shishuihao.thirdparty.api.pay.alipay.AlipayPayApiProperties;
import cn.shishuihao.thirdparty.api.pay.alipay.AlipayPayClient;
import cn.shishuihao.thirdparty.api.pay.alipay.util.AlipayResponseUtils;
import cn.shishuihao.thirdparty.api.pay.api.CodePayApi;
import cn.shishuihao.thirdparty.api.pay.request.CodePayApiRequest;
import cn.shishuihao.thirdparty.api.pay.response.CodePayApiResponse;
import cn.shishuihao.thirdparty.api.pay.util.AmountUtils;
import com.alipay.easysdk.kernel.util.ResponseChecker;
import com.alipay.easysdk.payment.facetoface.models.AlipayTradePayResponse;
import lombok.AllArgsConstructor;

import java.util.Optional;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@AllArgsConstructor
public class AlipayCodePayApi implements CodePayApi {
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
    public CodePayApiResponse execute(final CodePayApiRequest request) {
        AlipayPayApiProperties properties = (AlipayPayApiProperties)
                ApiRegistry.INSTANCE.getApiPropertiesOrThrow(request);
        try {
            com.alipay.easysdk.payment.facetoface.Client client
                    = alipayPayClient.getFaceToFaceClient(properties);
            AlipayTradePayResponse response = client.pay(
                    request.getSubject(),
                    request.getOutTradeNo(),
                    AmountUtils.toYuanString(request.getTotalAmount()),
                    request.getAuthCode());
            return CodePayApiResponse.builder()
                    .success(ResponseChecker.success(response))
                    .code(AlipayResponseUtils.code(response))
                    .message(AlipayResponseUtils.message(response))
                    .requestId(null)
                    .channelTransactionId(response.tradeNo)
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
                    .build();
        } catch (Exception e) {
            throw new ApiException(e);
        }
    }
}
