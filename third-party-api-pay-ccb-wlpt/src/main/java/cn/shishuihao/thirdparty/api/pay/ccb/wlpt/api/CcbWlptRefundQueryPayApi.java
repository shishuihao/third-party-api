package cn.shishuihao.thirdparty.api.pay.ccb.wlpt.api;

import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.core.exception.ApiException;
import cn.shishuihao.thirdparty.api.pay.api.RefundQueryPayApi;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.CcbWlptPayApiProperties;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.domain.CcbWlptRefundStatus;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.domain.CcbWlptTradeStatus;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.CcbWlptPayClient;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.domain.FlowStatus;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.domain.OrderBy;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.domain.QueryOrderStatus;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.request.CcbWlpt5W1003RequestTxInfo;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.request.CcbWlptRequest;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.response.CcbWlpt5W1003Response;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.response.CcbWlptResponse;
import cn.shishuihao.thirdparty.api.pay.domain.transaction.RefundStatus;
import cn.shishuihao.thirdparty.api.pay.domain.transaction.TradeStatus;
import cn.shishuihao.thirdparty.api.pay.request.RefundQueryPayApiRequest;
import cn.shishuihao.thirdparty.api.pay.response.RefundQueryPayApiResponse;
import lombok.AllArgsConstructor;

import java.util.Optional;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@AllArgsConstructor
public class CcbWlptRefundQueryPayApi implements RefundQueryPayApi {
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
    public RefundQueryPayApiResponse
    execute(final RefundQueryPayApiRequest request) {
        CcbWlptPayApiProperties properties = (CcbWlptPayApiProperties)
                ApiRegistry.INSTANCE.getApiPropertiesOrThrow(request);
        try {
            String channelName = client
                    .urlInfo(properties)
                    .getChannelName();
            CcbWlpt5W1003Response response = client
                    .onlineMerchantApi(properties)
                    .refundQuery(channelName,
                            buildRequest(request, properties));
            return buildResponse(response);
        } catch (Exception e) {
            throw new ApiException(e);
        }
    }

    private CcbWlptRequest<CcbWlpt5W1003RequestTxInfo> buildRequest(
            final RefundQueryPayApiRequest request,
            final CcbWlptPayApiProperties properties) {
        return CcbWlptRequest.<CcbWlpt5W1003RequestTxInfo>builder()
                .requestSn(String.valueOf(System.nanoTime()))
                .customerId(properties.getCustomerId())
                .userId(properties.getUserId())
                .password(properties.getPassword())
                .txCode("5W1003")
                .language(Optional.ofNullable(properties.getLanguage())
                        .orElse("CN"))
                .txInfo(CcbWlpt5W1003RequestTxInfo.builder()
                        .kind(FlowStatus.SETTLED.ordinal())
                        .orderId(request.getOutTradeNo())
                        .orderBy(OrderBy.ORDER)
                        .page(1)
                        .posCode(null)
                        .status(QueryOrderStatus.ALL.ordinal())
                        .merchantNo(null)
                        .build())
                .signInfo(null)
                .signCert(null)
                .build();
    }

    private RefundQueryPayApiResponse buildResponse(
            final CcbWlpt5W1003Response response) {
        CcbWlpt5W1003Response.Refund refund
                = Optional.ofNullable(response)
                .map(CcbWlptResponse::getTxInfo)
                .map(CcbWlpt5W1003Response.TxInfo::getList)
                .map(it -> it[0])
                .orElse(null);
        TradeStatus tradeStatus = Optional.ofNullable(refund)
                .map(it -> CcbWlptTradeStatus
                        .tradeStatusOf(it.getOrderStatus()))
                .orElse(null);
        RefundStatus refundStatus = Optional.ofNullable(refund)
                .map(it -> CcbWlptRefundStatus
                        .refundStatusOf(it.getOrderStatus()))
                .orElse(null);
        return RefundQueryPayApiResponse.builder()
                .success(response.isReturnSuccess())
                .code(response.getReturnCode())
                .message(response.getReturnMsg())
                .requestId(null)
                .tradeStatus(tradeStatus)
                .refundStatus(refundStatus)
                .build();
    }
}
