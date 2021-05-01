package cn.shishuihao.thirdparty.api.pay.sdk.api;

import cn.shishuihao.thirdparty.api.pay.sdk.request.GetPayV1RefundsRequest;
import cn.shishuihao.thirdparty.api.pay.sdk.request.GetPayV1TransactionsRequest;
import cn.shishuihao.thirdparty.api.pay.sdk.request.PayV1RefundsRequest;
import cn.shishuihao.thirdparty.api.pay.sdk.response.GetPayV1RefundsResponse;
import cn.shishuihao.thirdparty.api.pay.sdk.response.GetPayV1TransactionsResponse;
import cn.shishuihao.thirdparty.api.pay.sdk.response.PayV1RefundsResponse;
import feign.Param;
import feign.RequestLine;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public interface CommonPayApi {
    /**
     * 查询订单.
     *
     * @param outTradeNo 商户订单号
     * @param request    请求参数
     * @return response 响应参数
     */
    @RequestLine("GET /pay/v1/transactions/{outTradeNo}")
    GetPayV1TransactionsResponse
    query(@Param("outTradeNo") String outTradeNo,
          GetPayV1TransactionsRequest request);


    /**
     * 申请退款.
     *
     * @param request 请求参数
     * @return 响应参数
     */
    @RequestLine("POST /pay/v1/refunds")
    PayV1RefundsResponse
    refund(PayV1RefundsRequest request);

    /**
     * 查询单笔退款.
     *
     * @param outRefundNo 商户退款单号
     * @param request     请求参数
     * @return response 响应参数
     */
    @RequestLine("GET /pay/v1/refunds/{outRefundNo}")
    GetPayV1RefundsResponse
    refundQuery(@Param("outRefundNo") String outRefundNo,
                GetPayV1RefundsRequest request);
}
