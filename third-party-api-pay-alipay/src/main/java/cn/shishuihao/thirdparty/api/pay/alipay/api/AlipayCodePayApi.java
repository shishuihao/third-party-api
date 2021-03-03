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
    private final AlipayPayClient alipayPayClient;

    public AlipayCodePayApi(AlipayPayClient alipayPayClient) {
        this.alipayPayClient = alipayPayClient;
    }

    @Override
    public CodePayApiResponse execute(CodePayApiRequest request) {
        AlipayPayApiProperties properties = (AlipayPayApiProperties) ApiRegistry.INSTANCE.getApiPropertiesOrThrow(request);
        com.alipay.easysdk.payment.facetoface.Client client = alipayPayClient.getFaceToFaceClient(properties);
        try {
            AlipayTradePayResponse response = client.pay(
                    request.getSubject(),
                    request.getOutTradeNo(),
                    AmountUtils.toYuanString(request.getTotalAmount()),
                    request.getAuthCode());
            return CodePayApiResponse.Builder.builder()
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
