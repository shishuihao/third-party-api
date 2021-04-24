package cn.shishuihao.thirdparty.api.pay.alipay.assembler;

import cn.shishuihao.thirdparty.api.pay.alipay.domain.AlipayRefundStatus;
import cn.shishuihao.thirdparty.api.pay.alipay.domain.AlipayTradeStatus;
import cn.shishuihao.thirdparty.api.pay.alipay.util.AlipayResponseUtils;
import cn.shishuihao.thirdparty.api.pay.domain.transaction.RefundStatus;
import cn.shishuihao.thirdparty.api.pay.response.CancelPayApiResponse;
import cn.shishuihao.thirdparty.api.pay.response.CodePayApiResponse;
import cn.shishuihao.thirdparty.api.pay.response.QueryPayApiResponse;
import cn.shishuihao.thirdparty.api.pay.response.RefundPayApiResponse;
import cn.shishuihao.thirdparty.api.pay.response.RefundQueryPayApiResponse;
import cn.shishuihao.thirdparty.api.pay.util.AmountUtils;
import com.alipay.easysdk.kernel.util.ResponseChecker;
import com.alipay.easysdk.payment.common.models.AlipayTradeCancelResponse;
import com.alipay.easysdk.payment.common.models.AlipayTradeFastpayRefundQueryResponse;
import com.alipay.easysdk.payment.common.models.AlipayTradeQueryResponse;
import com.alipay.easysdk.payment.common.models.AlipayTradeRefundResponse;
import com.alipay.easysdk.payment.facetoface.models.AlipayTradePayResponse;

import java.util.Optional;

/**
 * 响应装配器.
 *
 * @author shishuihao
 * @version 1.0.0
 */

public class AlipayPayResponseAssembler {
    /**
     * 实例.
     */
    public static final AlipayPayResponseAssembler INSTANCE
            = new AlipayPayResponseAssembler();

    /**
     * 装配.
     * {@link "https://opendocs.alipay.com/apis/api_1/alipay.trade.cancel"}
     *
     * @param response 统一收单交易撤销接口响应
     * @return {@link CancelPayApiResponse}
     */
    public CancelPayApiResponse assemble(
            final AlipayTradeCancelResponse response) {
        return CancelPayApiResponse.builder()
                .success(ResponseChecker.success(response))
                .code(AlipayResponseUtils.code(response))
                .message(AlipayResponseUtils.message(response))
                .requestId(null)
                .channelTransactionId(response.tradeNo)
                .retry("Y".equals(response.retryFlag))
                .build();
    }

    /**
     * 装配.
     * {@link "https://opendocs.alipay.com/apis/api_1/alipay.trade.pay"}
     *
     * @param response 统一收单交易支付接口
     * @return {@link CodePayApiResponse}
     */
    public CodePayApiResponse assemble(
            final AlipayTradePayResponse response) {
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
    }

    /**
     * 装配.
     * {@link "https://opendocs.alipay.com/apis/api_1/alipay.trade.query"}
     *
     * @param response 统一收单线下交易查询
     * @return {@link QueryPayApiResponse}
     */
    public QueryPayApiResponse assemble(
            final AlipayTradeQueryResponse response) {
        return QueryPayApiResponse.builder()
                .success(ResponseChecker.success(response))
                .code(AlipayResponseUtils.code(response))
                .message(AlipayResponseUtils.message(response))
                .requestId(null)
                .channelTransactionId(response.tradeNo)
                .bankType(null)
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
                .tradeStatus(AlipayTradeStatus
                        .tradeStatusOf(response.tradeStatus))
                .build();
    }

    /**
     * 装配.
     * {@link "https://opendocs.alipay.com/apis/api_1/alipay.trade.refund"}
     *
     * @param response 统一收单交易退款接口
     * @return {@link RefundPayApiResponse}
     */
    public RefundPayApiResponse assemble(
            final AlipayTradeRefundResponse response) {
        return RefundPayApiResponse.builder()
                .success(ResponseChecker.success(response))
                .code(AlipayResponseUtils.code(response))
                .message(AlipayResponseUtils.message(response))
                .requestId(null)
                .channelTransactionId(response.tradeNo)
                .channelRefundId(null)
                .build();
    }

    /**
     * 装配.
     * {@link "https://opendocs.alipay.com/apis/api_1/alipay.trade.
     * fastpay.refund.query"}
     *
     * @param response 统一收单交易退款查询
     * @return {@link RefundQueryPayApiResponse}
     */
    public RefundQueryPayApiResponse assemble(
            final AlipayTradeFastpayRefundQueryResponse response) {
        return RefundQueryPayApiResponse.builder()
                .success(ResponseChecker.success(response))
                .code(AlipayResponseUtils.code(response))
                .message(AlipayResponseUtils.message(response))
                .requestId(null)
                .refundStatuses(new RefundStatus[]{AlipayRefundStatus
                        .refundStatusOf(response.refundStatus)})
                .build();
    }
}
