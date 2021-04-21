package cn.shishuihao.thirdparty.api.pay.ccb.wlpt.api;

import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.core.exception.ApiException;
import cn.shishuihao.thirdparty.api.pay.api.RefundPayApi;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.CcbWlptPayApiProperties;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.CcbWlptPayClient;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.request.CcbWlpt5W1004RequestTxInfo;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.request.CcbWlptRequest;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.response.CcbWlpt5W1004Response;
import cn.shishuihao.thirdparty.api.pay.request.RefundPayApiRequest;
import cn.shishuihao.thirdparty.api.pay.response.RefundPayApiResponse;
import cn.shishuihao.thirdparty.api.pay.util.AmountUtils;
import lombok.AllArgsConstructor;

import java.util.Optional;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@AllArgsConstructor
public class CcbWlptRefundPayApi implements RefundPayApi {
    /**
     * CcbWlptPayClient.
     */
    private final CcbWlptPayClient client;

    /**
     * execute request.
     *
     * @param request request
     * @return response
     */
    @Override
    public RefundPayApiResponse execute(final RefundPayApiRequest request) {
        CcbWlptPayApiProperties properties = (CcbWlptPayApiProperties)
                ApiRegistry.INSTANCE.getApiPropertiesOrThrow(request);
        try {
            String channelName = client
                    .urlInfo(properties)
                    .getChannelName();
            CcbWlpt5W1004Response response = client
                    .onlineMerchantApi(properties)
                    .refund(channelName, buildRequest(request, properties));
            return buildResponse(response);
        } catch (Exception e) {
            throw new ApiException(e);
        }
    }

    private CcbWlptRequest<CcbWlpt5W1004RequestTxInfo> buildRequest(
            final RefundPayApiRequest request,
            final CcbWlptPayApiProperties properties) {
        return CcbWlptRequest.<CcbWlpt5W1004RequestTxInfo>builder()
                .requestSn(String.valueOf(System.nanoTime()))
                .customerId(properties.getCustomerId())
                .userId(properties.getUserId())
                .password(properties.getPassword())
                .txCode("5W1004")
                .language(Optional.ofNullable(properties.getLanguage())
                        .orElse("CN"))
                .txInfo(CcbWlpt5W1004RequestTxInfo.builder()
                        .orderId(request.getOutTradeNo())
                        .refundCode(request.getOutRefundNo())
                        .money(AmountUtils
                                .toYuanString(request.getRefundAmount()))
                        .build())
                .signInfo(null)
                .signCert(null)
                .build();
    }

    private RefundPayApiResponse buildResponse(
            final CcbWlpt5W1004Response response) {
        return RefundPayApiResponse.builder()
                .success(response.isReturnSuccess())
                .code(response.getReturnCode())
                .message(response.getReturnMsg())
                .requestId(null)
                .channelTransactionId(null)
                .channelRefundId(null)
                .build();
    }
}
