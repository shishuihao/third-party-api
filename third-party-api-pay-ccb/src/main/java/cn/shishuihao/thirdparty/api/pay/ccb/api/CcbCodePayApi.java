package cn.shishuihao.thirdparty.api.pay.ccb.api;

import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.core.exception.ApiException;
import cn.shishuihao.thirdparty.api.pay.api.CodePayApi;
import cn.shishuihao.thirdparty.api.pay.ccb.CcbPayApiProperties;
import cn.shishuihao.thirdparty.api.pay.ccb.sdk.CcbPayClient;
import cn.shishuihao.thirdparty.api.pay.ccb.sdk.request.CcbPay100Request;
import cn.shishuihao.thirdparty.api.pay.ccb.sdk.response.CcbPay100Response;
import cn.shishuihao.thirdparty.api.pay.request.CodePayApiRequest;
import cn.shishuihao.thirdparty.api.pay.response.CodePayApiResponse;
import cn.shishuihao.thirdparty.api.pay.util.AmountUtils;
import lombok.AllArgsConstructor;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@AllArgsConstructor
public class CcbCodePayApi implements CodePayApi {
    /**
     * CcbPayClient.
     */
    private final CcbPayClient client;

    /**
     * execute request.
     *
     * @param request request
     * @return response
     */
    @Override
    public CodePayApiResponse execute(final CodePayApiRequest request) {
        final CcbPayApiProperties properties = (CcbPayApiProperties)
                ApiRegistry.INSTANCE.getApiPropertiesOrThrow(request);
        try {
            final String channelName = client
                    .urlInfo(properties)
                    .getChannelName();
            final CcbPay100Response response = client
                    .scannedPayApi(properties)
                    .codePay(channelName, buildRequest(request, properties));
            return buildResponse(response);
        } catch (Exception e) {
            throw new ApiException(e);
        }
    }

    private CcbPay100Request buildRequest(
            final CodePayApiRequest request,
            final CcbPayApiProperties properties) {
        final CcbPay100Request ccbRequest = CcbPay100Request.builder()
                .merchantId(properties.getMerchantId())
                .posId(properties.getPosId())
                .branchId(properties.getBranchId())
                .groupMch(properties.getGroupMch())
                .txCode("PAY100")
                .merchantFlag(properties.getMerchantFlag())
                .termNo1(properties.getTermNo1())
                .termNo2(properties.getTermNo2())
                .orderId(request.getOutTradeNo())
                .qrCode(request.getAuthCode())
                .amount(AmountUtils.toYuanString(request.getTotalAmount()))
                .productInfo(properties.getProductInfo())
                .fzInfo1(properties.getFzInfo1())
                .fzInfo2(properties.getFzInfo2())
                .returnField(properties.getReturnField())
                .queryString((r) -> r.queryString(properties.getPublicKey()))
                .build();
        return ccbRequest;
    }

    private CodePayApiResponse buildResponse(
            final CcbPay100Response response) {
        return CodePayApiResponse.builder()
                .success("Y".equalsIgnoreCase(response.getResult()))
                .code(response.getErrCode())
                .message(response.getErrMsg())
                .requestId(response.getTraceId())
                .build();
    }
}
