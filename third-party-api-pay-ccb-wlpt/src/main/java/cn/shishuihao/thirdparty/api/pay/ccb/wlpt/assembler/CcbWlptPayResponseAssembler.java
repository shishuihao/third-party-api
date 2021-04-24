package cn.shishuihao.thirdparty.api.pay.ccb.wlpt.assembler;

import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.domain.CcbWlptRefundStatus;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.domain.CcbWlptTradeStatus;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.response.CcbWlpt5W1002Response;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.response.CcbWlpt5W1003Response;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.response.CcbWlpt5W1004Response;
import cn.shishuihao.thirdparty.api.pay.domain.transaction.RefundStatus;
import cn.shishuihao.thirdparty.api.pay.domain.transaction.TradeStatus;
import cn.shishuihao.thirdparty.api.pay.response.QueryPayApiResponse;
import cn.shishuihao.thirdparty.api.pay.response.RefundPayApiResponse;
import cn.shishuihao.thirdparty.api.pay.response.RefundQueryPayApiResponse;

import java.util.Optional;

/**
 * 响应装配器.
 *
 * @author shishuihao
 * @version 1.0.0
 */

public class CcbWlptPayResponseAssembler {
    /**
     * 实例.
     */
    public static final CcbWlptPayResponseAssembler INSTANCE
            = new CcbWlptPayResponseAssembler();

    /**
     * 装配.
     *
     * @param response （5W1002）商户支付流水查询响应
     * @return {@link QueryPayApiResponse}
     */
    public QueryPayApiResponse assemble(
            final CcbWlpt5W1002Response response) {
        final CcbWlpt5W1002Response.Transaction transaction
                = Optional.of(response.getTxInfo())
                .map(CcbWlpt5W1002Response.TxInfo::getList)
                .map(it -> it[0])
                .orElse(null);
        final TradeStatus tradeStatus = Optional.ofNullable(transaction)
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

    /**
     * 装配.
     *
     * @param response （5W1003）商户退款流水查询响应
     * @return {@link RefundQueryPayApiResponse}
     */
    public RefundQueryPayApiResponse assemble(
            final CcbWlpt5W1003Response response) {
        final CcbWlpt5W1003Response.Refund refund
                = Optional.of(response.getTxInfo())
                .map(CcbWlpt5W1003Response.TxInfo::getList)
                .map(it -> it[0])
                .orElse(null);
        final TradeStatus tradeStatus = Optional.ofNullable(refund)
                .map(it -> CcbWlptTradeStatus
                        .tradeStatusOf(it.getOrderStatus()))
                .orElse(null);
        final RefundStatus refundStatus = Optional.ofNullable(refund)
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

    /**
     * 装配.
     *
     * @param response （5W1004）商户单笔退款交易响应
     * @return {@link RefundPayApiResponse}
     */
    public RefundPayApiResponse assemble(
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
