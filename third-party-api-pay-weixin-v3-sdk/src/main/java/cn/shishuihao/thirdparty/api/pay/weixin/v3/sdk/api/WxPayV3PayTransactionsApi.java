package cn.shishuihao.thirdparty.api.pay.weixin.v3.sdk.api;

import cn.shishuihao.thirdparty.api.pay.weixin.v3.sdk.domain.WxPayV3PayTransaction;
import feign.Body;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public interface WxPayV3PayTransactionsApi {
    /**
     * 微信支付订单号查询.
     *
     * @param mchId         直连商户的商户号，由微信支付生成并下发。
     * @param transactionId 微信支付系统生成的订单号
     * @return 响应
     */
    @RequestLine("GET /v3/pay/transactions/id/{transactionId}?mchid={mchId}")
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    WxPayV3PayTransaction getByTransactionId(
            @Param("mchId") String mchId,
            @Param("transactionId") String transactionId);

    /**
     * 商户订单号查询.
     *
     * @param mchId      直连商户的商户号，由微信支付生成并下发。
     * @param outTradeNo 商户订单号
     * @return 响应
     */
    @RequestLine("GET /v3/pay/transactions/out-trade-no/{outTradeNo}"
            + "?mchid={mchId}")
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    WxPayV3PayTransaction getByOutTradeNo(
            @Param("mchId") String mchId,
            @Param("outTradeNo") String outTradeNo);

    /**
     * 关闭订单.
     *
     * @param mchId      直连商户的商户号，由微信支付生成并下发。
     * @param outTradeNo 商户系统内部订单号，只能是数字、大小写字母_-*且在同一个商户号下唯一
     */
    @RequestLine("POST /v3/pay/transactions/out-trade-no/{outTradeNo}/close")
    @Headers({"Content-Type: application/json", "Accept: application/json"})
    @Body("%7B\"mchid \": \"{mchId}\"%7D")
    void close(@Param("mchId") String mchId,
               @Param("outTradeNo") String outTradeNo);
}
