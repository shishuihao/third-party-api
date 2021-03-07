package cn.shishuihao.thirdparty.api.pay.alipay.api;

import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.core.exception.ApiException;
import cn.shishuihao.thirdparty.api.pay.alipay.AlipayPayApiProperties;
import cn.shishuihao.thirdparty.api.pay.alipay.AlipayPayClient;
import cn.shishuihao.thirdparty.api.pay.api.CodePayApi;
import cn.shishuihao.thirdparty.api.pay.request.CodePayApiRequest;
import cn.shishuihao.thirdparty.api.pay.response.CodePayApiResponse;
import cn.shishuihao.thirdparty.api.pay.util.AmountUtils;
import com.alipay.easysdk.kernel.util.ResponseChecker;
import com.alipay.easysdk.payment.facetoface.models.AlipayTradePayResponse;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class AlipayCodePayApi implements CodePayApi {
    /**
     * alipay pay client.
     */
    private final AlipayPayClient alipayPayClient;

    /**
     * new AlipayCodePayApi.
     *
     * @param client alipay pay http client
     */
    public AlipayCodePayApi(final AlipayPayClient client) {
        this.alipayPayClient = client;
    }

    /**
     * execute CodePayApiRequest by alipay.
     *
     * @param request request
     * @return CodePayApiResponse
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
                    .code(response.code)
                    .message(response.msg)
                    .requestId(null)
                    .build();
        } catch (Exception e) {
            throw new ApiException(e);
        }
    }
}
