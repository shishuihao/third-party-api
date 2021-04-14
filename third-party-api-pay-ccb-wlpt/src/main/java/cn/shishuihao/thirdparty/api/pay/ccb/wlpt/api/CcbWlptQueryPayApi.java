package cn.shishuihao.thirdparty.api.pay.ccb.wlpt.api;

import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.core.exception.ApiException;
import cn.shishuihao.thirdparty.api.pay.api.QueryPayApi;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.CcbWlptPayApiProperties;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.domain.CcbWlptTradeStatus;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.CcbWlptPayClient;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.request.CcbWlpt5W1002RequestTxInfo;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.request.CcbWlptRequest;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.response.CcbWlpt5W1002Response;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.response.CcbWlptResponse;
import cn.shishuihao.thirdparty.api.pay.domain.transaction.TradeStatus;
import cn.shishuihao.thirdparty.api.pay.request.QueryPayApiRequest;
import cn.shishuihao.thirdparty.api.pay.response.QueryPayApiResponse;
import com.ccb.wlpt.url.MerchantUrlInfo;
import lombok.AllArgsConstructor;

import java.util.Optional;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@AllArgsConstructor
public class CcbWlptQueryPayApi implements QueryPayApi {
    /**
     * CcbWlptPayClient.
     */
    private final CcbWlptPayClient client;

    /**
     * execute request by alipay.
     *
     * @param request request
     * @return response
     */
    @Override
    public QueryPayApiResponse execute(final QueryPayApiRequest request) {
        CcbWlptPayApiProperties properties = (CcbWlptPayApiProperties)
                ApiRegistry.INSTANCE.getApiPropertiesOrThrow(request);
        try {
            MerchantUrlInfo urlInfo = client.getUrlInfo(properties);
            CcbWlpt5W1002Response response = client
                    .getOnlineMerchantApi(properties)
                    .query(urlInfo.getChannelName(),
                            getRequest(request, properties));
            return getResponse(response);
        } catch (Exception e) {
            throw new ApiException(e);
        }
    }

    private CcbWlptRequest<CcbWlpt5W1002RequestTxInfo> getRequest(
            final QueryPayApiRequest request,
            final CcbWlptPayApiProperties properties) {
        return CcbWlptRequest.<CcbWlpt5W1002RequestTxInfo>builder()
                .requestSn(String.valueOf(System.nanoTime()))
                .customerId(properties.getCustomerId())
                .userId(properties.getUserId())
                .password(properties.getPassword())
                .txCode("5W1002")
                .language(Optional.ofNullable(properties.getLanguage())
                        .orElse("CN"))
                .txInfo(CcbWlpt5W1002RequestTxInfo.builder()
                        .kind(CcbWlpt5W1002RequestTxInfo.FlowStatus
                                .SETTLED.ordinal())
                        .orderId(request.getOutTradeNo())
                        .fileType(CcbWlpt5W1002RequestTxInfo.FileType
                                .NONE)
                        .orderBy(CcbWlpt5W1002RequestTxInfo.OrderBy
                                .ORDER)
                        .page(1)
                        .posCode(null)
                        .status(CcbWlpt5W1002RequestTxInfo.OrderStatus
                                .ALL.ordinal())
                        .merchantNo(null)
                        .build())
                .signInfo(null)
                .signCert(null)
                .build();
    }

    private QueryPayApiResponse getResponse(
            final CcbWlpt5W1002Response response) {
        // transaction
        CcbWlpt5W1002Response.Transaction transaction
                = Optional.ofNullable(response)
                .map(CcbWlptResponse::getTxInfo)
                .map(CcbWlpt5W1002Response.TxInfo::getList)
                .map(it -> it[0])
                .orElse(null);
        // tradeStatus
        TradeStatus tradeStatus = Optional.ofNullable(transaction)
                .map(it -> CcbWlptTradeStatus
                        .tradeStatusOf(it.getOrderStatus()))
                .orElse(null);
        return QueryPayApiResponse.builder()
                .success(response.isReturnSuccess())
                .code(response.getReturnCode())
                .message(response.getReturnMsg())
                .requestId(null)
                .channelTransactionId(null)
                .bankType(null)
                .tradeStatus(tradeStatus)
                .build();
    }
}
