package cn.shishuihao.thirdparty.api.pay.wechat.assembler;

import cn.shishuihao.thirdparty.api.pay.response.CancelPayApiResponse;
import cn.shishuihao.thirdparty.api.pay.response.CodePayApiResponse;
import cn.shishuihao.thirdparty.api.pay.response.QueryPayApiResponse;
import cn.shishuihao.thirdparty.api.pay.response.RefundPayApiResponse;
import cn.shishuihao.thirdparty.api.pay.response.RefundQueryPayApiResponse;
import cn.shishuihao.thirdparty.api.pay.wechat.domain.WechatRefundStatus;
import cn.shishuihao.thirdparty.api.pay.wechat.domain.WechatTradeStatus;
import cn.shishuihao.thirdparty.api.pay.wechat.sdk.response.WechatPayMicroPayResponse;
import cn.shishuihao.thirdparty.api.pay.wechat.sdk.response.WechatPayOrderQueryResponse;
import cn.shishuihao.thirdparty.api.pay.wechat.sdk.response.WechatPayRefundQueryResponse;
import cn.shishuihao.thirdparty.api.pay.wechat.sdk.response.WechatPaySecApiPayRefundResponse;
import cn.shishuihao.thirdparty.api.pay.wechat.sdk.response.WechatPaySecApiPayReverseResponse;
import cn.shishuihao.thirdparty.api.pay.wechat.sdk.util.ResponseChecker;

import java.util.Optional;

/**
 * 响应装配器.
 *
 * @author shishuihao
 * @version 1.0.0
 */

public class WechatPayResponseAssembler {
    /**
     * 实例.
     */
    public static final WechatPayResponseAssembler INSTANCE
            = new WechatPayResponseAssembler();

    /**
     * 装配.
     * {@link "https://pay.weixin.qq.com/wiki/doc/api/micropay.php
     * ?chapter=9_11&index=3"}
     *
     * @param response 付款码支付响应
     * @return {@link CodePayApiResponse}
     */
    public CancelPayApiResponse assemble(
            final WechatPaySecApiPayReverseResponse response) {
        return CancelPayApiResponse.builder()
                .success(ResponseChecker.success(response))
                .code(ResponseChecker.getCode(response))
                .message(ResponseChecker.getMsg(response))
                .requestId(null)
                .retry("Y".equalsIgnoreCase(response.getRecall()))
                .build();
    }

    /**
     * 装配.
     * {@link "https://pay.weixin.qq.com/wiki/doc/api/micropay.php
     * ?chapter=9_10&index=1"}
     *
     * @param response 付款码支付响应
     * @return {@link CodePayApiResponse}
     */
    public CodePayApiResponse assemble(
            final WechatPayMicroPayResponse response) {
        return CodePayApiResponse.builder()
                .success(ResponseChecker.success(response))
                .code(ResponseChecker.getCode(response))
                .message(ResponseChecker.getMsg(response))
                .requestId(null)
                .build();
    }

    /**
     * 装配.
     * {@link = "https://pay.weixin.qq.com/wiki/doc/api/micropay.php
     * ?chapter=9_02"}
     *
     * @param response 查询订单响应
     * @return {@link QueryPayApiResponse}
     */
    public QueryPayApiResponse assemble(
            final WechatPayOrderQueryResponse response) {
        return QueryPayApiResponse.builder()
                .success(ResponseChecker.success(response))
                .code(ResponseChecker.getCode(response))
                .message(ResponseChecker.getMsg(response))
                .requestId(null)
                .channelTransactionId(response.getTransactionId())
                .payCurrency(response.getFeeType())
                .payTotalAmount(Optional
                        .ofNullable(response.getTotalFee())
                        .orElse(null))
                .settleCurrency(null)
                .settleTotalAmount(null)
                .tradeStatus(WechatTradeStatus
                        .tradeStatusOf(response.getTradeState()))
                .build();
    }

    /**
     * 装配.
     * {@link = "https://pay.weixin.qq.com/wiki/doc/api/micropay.php
     * ?chapter=9_4"}
     *
     * @param response 申请退款响应
     * @return {@link QueryPayApiResponse}
     */
    public RefundPayApiResponse assemble(
            final WechatPaySecApiPayRefundResponse response) {
        return RefundPayApiResponse.builder()
                .success(ResponseChecker.success(response))
                .code(ResponseChecker.getCode(response))
                .message(ResponseChecker.getMsg(response))
                .requestId(null)
                .channelTransactionId(response.getTransactionId())
                .channelRefundId(response.getRefundId())
                .build();
    }

    /**
     * 装配.
     * {@link = "https://pay.weixin.qq.com/wiki/doc/api/micropay.php
     * ?chapter=9_5"}
     *
     * @param response 查询退款响应
     * @return {@link QueryPayApiResponse}
     */
    public RefundQueryPayApiResponse assemble(
            final WechatPayRefundQueryResponse response) {
        return RefundQueryPayApiResponse.builder()
                .success(ResponseChecker.success(response))
                .code(ResponseChecker.getCode(response))
                .message(ResponseChecker.getMsg(response))
                .requestId(null)
                .channelTransactionId(response.getTransactionId())
                .channelRefundIds(Optional.ofNullable(response.getRefundIds())
                        .map(it -> it.toArray(new String[0]))
                        .orElse(null))
                .tradeStatus(null)
                .refundStatuses(WechatRefundStatus
                        .refundStatusesOf(response.getRefundStatuses()))
                .build();
    }
}
