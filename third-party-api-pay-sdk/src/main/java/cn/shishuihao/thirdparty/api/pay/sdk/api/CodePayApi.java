package cn.shishuihao.thirdparty.api.pay.sdk.api;

import cn.shishuihao.thirdparty.api.pay.sdk.request.PayV1TransactionsCancelRequest;
import cn.shishuihao.thirdparty.api.pay.sdk.request.PayV1TransactionsCodeRequest;
import cn.shishuihao.thirdparty.api.pay.sdk.response.PayV1TransactionsCancelResponse;
import cn.shishuihao.thirdparty.api.pay.sdk.response.PayV1TransactionsCodeResponse;
import feign.Param;
import feign.RequestLine;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public interface CodePayApi extends CommonPayApi {
    /**
     * 统一下单.
     *
     * @param outTradeNo 商户订单号
     * @param request    请求参数
     * @return response 响应参数
     */
    @RequestLine("POST /pay/v1/transactions/applet")
    PayV1TransactionsCodeResponse
    codePay(@Param("outTradeNo") String outTradeNo,
            PayV1TransactionsCodeRequest request);

    /**
     * 撤销订单.
     *
     * @param outTradeNo 商户订单号
     * @param request    请求参数
     * @return response 响应参数
     */
    @RequestLine("POST /pay/v1/transactions/{outTradeNo}/cancel")
    PayV1TransactionsCancelResponse
    cancel(@Param("outTradeNo") String outTradeNo,
           PayV1TransactionsCancelRequest request);
}
