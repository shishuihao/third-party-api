package cn.shishuihao.thirdparty.api.pay.ccb.api;

import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.core.exception.ApiException;
import cn.shishuihao.thirdparty.api.pay.api.CancelPayApi;
import cn.shishuihao.thirdparty.api.pay.ccb.CcbPayApiProperties;
import cn.shishuihao.thirdparty.api.pay.ccb.sdk.CcbPayClient;
import cn.shishuihao.thirdparty.api.pay.ccb.sdk.domain.QrCodeType;
import cn.shishuihao.thirdparty.api.pay.ccb.sdk.request.CcbPay103Request;
import cn.shishuihao.thirdparty.api.pay.ccb.sdk.response.CcbPay103Response;
import cn.shishuihao.thirdparty.api.pay.request.CancelPayApiRequest;
import cn.shishuihao.thirdparty.api.pay.response.CancelPayApiResponse;
import lombok.AllArgsConstructor;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@AllArgsConstructor
public class CcbCancelPayApi implements CancelPayApi {
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
    public CancelPayApiResponse execute(final CancelPayApiRequest request) {
        final CcbPayApiProperties properties = (CcbPayApiProperties)
                ApiRegistry.INSTANCE.getApiPropertiesOrThrow(request);
        try {
            final String channelName = client
                    .urlInfo(properties)
                    .getChannelName();
            final CcbPay103Response response = client
                    .scannedPayApi(properties)
                    .cancel(channelName, buildRequest(request, properties));
            return buildResponse(response);
        } catch (Exception e) {
            throw new ApiException(e);
        }
    }

    private CcbPay103Request buildRequest(
            final CancelPayApiRequest request,
            final CcbPayApiProperties properties) {
        final CcbPay103Request ccbRequest = CcbPay103Request.builder()
                .merchantId(properties.getMerchantId())
                .posId(properties.getPosId())
                .branchId(properties.getBranchId())
                .groupMch(properties.getGroupMch())
                .txCode("PAY103")
                .merchantFlag(properties.getMerchantFlag())
                .termNo1(properties.getTermNo1())
                .termNo2(properties.getTermNo2())
                .orderId(request.getOutTradeNo())
                .qrCodeType(String.valueOf(QrCodeType
                        .codeType(request.getAuthCode())
                        .ordinal()))
                .queryString((r) -> r.queryString(properties.getPublicKey()))
                .build();
        return ccbRequest;
    }

    private CancelPayApiResponse buildResponse(
            final CcbPay103Response response) {
        return CancelPayApiResponse.builder()
                .success(response.isSuccess())
                .code(response.getErrCode())
                .message(response.getErrMsg())
                .requestId(response.getTraceId())
                .retry("Y".equals(response.getRecall()))
                .build();
    }
}
