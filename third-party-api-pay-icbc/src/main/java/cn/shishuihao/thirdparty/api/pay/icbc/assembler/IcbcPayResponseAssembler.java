package cn.shishuihao.thirdparty.api.pay.icbc.assembler;

import cn.shishuihao.thirdparty.api.commons.json.JacksonUtils;
import cn.shishuihao.thirdparty.api.pay.icbc.domain.IcbcRefund;
import cn.shishuihao.thirdparty.api.pay.icbc.domain.IcbcRefundStatus;
import cn.shishuihao.thirdparty.api.pay.icbc.domain.IcbcTradeStatus;
import cn.shishuihao.thirdparty.api.pay.response.CancelPayApiResponse;
import cn.shishuihao.thirdparty.api.pay.response.CodePayApiResponse;
import cn.shishuihao.thirdparty.api.pay.response.QueryPayApiResponse;
import cn.shishuihao.thirdparty.api.pay.response.RefundPayApiResponse;
import cn.shishuihao.thirdparty.api.pay.response.RefundQueryPayApiResponse;
import com.icbc.api.response.QrcodePayResponseV2;
import com.icbc.api.response.QrcodeQueryResponseV2;
import com.icbc.api.response.QrcodeRejectQueryResponseV3;
import com.icbc.api.response.QrcodeRejectResponseV2;
import com.icbc.api.response.QrcodeReverseResponseV2;

import java.util.List;
import java.util.Optional;

/**
 * 响应装配器.
 *
 * @author shishuihao
 * @version 1.0.0
 */

public class IcbcPayResponseAssembler {
    /**
     * 实例.
     */
    public static final IcbcPayResponseAssembler INSTANCE
            = new IcbcPayResponseAssembler();

    /**
     * 装配.
     *
     * @param response 二维码冲正响应
     * @return {@link CancelPayApiResponse}
     */
    public CancelPayApiResponse assemble(
            final QrcodeReverseResponseV2 response) {
        return CancelPayApiResponse.builder()
                .success(response.isSuccess())
                .code(String.valueOf(response.getReturnCode()))
                .message(response.getReturnMsg())
                .requestId(response.getMsgId())
                .retry(false)
                .build();
    }

    /**
     * 装配.
     *
     * @param response 二维码被扫支付响应
     * @return {@link CodePayApiResponse}
     */
    public CodePayApiResponse assemble(
            final QrcodePayResponseV2 response) {
        return CodePayApiResponse.builder()
                .success(response.isSuccess())
                .code(String.valueOf(response.getReturnCode()))
                .message(response.getReturnMsg())
                .requestId(response.getMsgId())
                .build();
    }

    /**
     * 装配.
     *
     * @param response 二维码查询响应
     * @return {@link CodePayApiResponse}
     */
    public QueryPayApiResponse assemble(
            final QrcodeQueryResponseV2 response) {
        return QueryPayApiResponse.builder()
                .success(response.isSuccess())
                .code(String.valueOf(response.getReturnCode()))
                .message(response.getReturnMsg())
                .requestId(response.getMsgId())
                .channelTransactionId(response.getOrderId())
                .bankType(null)
                .payCurrency(null)
                .payTotalAmount(null)
                .settleCurrency(null)
                .settleTotalAmount(null)
                .tradeStatus(IcbcTradeStatus
                        .tradeStatusOf(response.getPayStatus()))
                .build();
    }

    /**
     * 装配.
     *
     * @param response 二维码退款响应
     * @return {@link CodePayApiResponse}
     */
    public RefundPayApiResponse assemble(
            final QrcodeRejectResponseV2 response) {
        return RefundPayApiResponse.builder()
                .success(response.isSuccess())
                .code(String.valueOf(response.getReturnCode()))
                .message(response.getReturnMsg())
                .requestId(response.getMsgId())
                .channelTransactionId(response.getOrderId())
                .channelRefundId(null)
                .build();
    }

    /**
     * 装配.
     *
     * @param response 二维码退款查询响应
     * @return {@link RefundQueryPayApiResponse}
     */
    @SuppressWarnings("unchecked")
    public RefundQueryPayApiResponse assemble(
            final QrcodeRejectQueryResponseV3 response) {
        final List<IcbcRefund> refundList = Optional
                .ofNullable(response.getRefundJsonList())
                .map(it -> JacksonUtils.fromJson(it, List.class))
                .orElse(null);
        return RefundQueryPayApiResponse.builder()
                .success(response.isSuccess())
                .code(String.valueOf(response.getReturnCode()))
                .message(response.getReturnMsg())
                .requestId(response.getMsgId())
                .tradeStatus(null)
                .refundStatuses(IcbcRefundStatus.refundStatusesOf(refundList))
                .channelTransactionId(response.getOrderId())
                .channelRefundIds(null)
                .build();
    }
}
