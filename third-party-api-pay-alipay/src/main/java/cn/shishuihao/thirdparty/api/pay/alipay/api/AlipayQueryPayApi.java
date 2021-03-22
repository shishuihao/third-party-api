package cn.shishuihao.thirdparty.api.pay.alipay.api;

import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.core.exception.ApiException;
import cn.shishuihao.thirdparty.api.pay.alipay.AlipayPayApiProperties;
import cn.shishuihao.thirdparty.api.pay.alipay.AlipayPayClient;
import cn.shishuihao.thirdparty.api.pay.alipay.domain.AlipayTradeStatus;
import cn.shishuihao.thirdparty.api.pay.api.QueryPayApi;
import cn.shishuihao.thirdparty.api.pay.request.QueryApiRequest;
import cn.shishuihao.thirdparty.api.pay.response.QueryApiResponse;
import com.alipay.easysdk.kernel.util.ResponseChecker;
import com.alipay.easysdk.payment.common.models.AlipayTradeQueryResponse;
import com.google.common.base.Strings;
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
     * @return QueryOrderPayApiResponse
     */
    @Override
    public QueryApiResponse execute(final QueryApiRequest request) {
        AlipayPayApiProperties properties = (AlipayPayApiProperties)
                ApiRegistry.INSTANCE.getApiPropertiesOrThrow(request);
        try {
            com.alipay.easysdk.payment.common.Client client
                    = alipayPayClient.getCommonClient(properties);
            AlipayTradeQueryResponse response = client.query(
                    request.getOutTradeNo());
            return QueryApiResponse.builder()
                    .success(ResponseChecker.success(response))
                    .code(Optional.ofNullable(response.subCode)
                            .filter(it -> !Strings.isNullOrEmpty(it))
                            .orElse(response.code))
                    .message(Optional.ofNullable(response.subMsg)
                            .filter(it -> !Strings.isNullOrEmpty(it))
                            .orElse(response.msg))
                    .requestId(null)
                    .status(AlipayTradeStatus.tradeStatusOf(response.tradeStatus))
                    .build();
        } catch (Exception e) {
            throw new ApiException(e);
        }
    }
}
