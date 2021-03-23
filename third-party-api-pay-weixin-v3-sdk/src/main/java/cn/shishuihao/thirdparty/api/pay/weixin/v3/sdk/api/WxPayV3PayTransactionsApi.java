package cn.shishuihao.thirdparty.api.pay.weixin.v3.sdk.api;

import cn.shishuihao.thirdparty.api.pay.weixin.v3.sdk.domain.WxPayV3PayTransaction;
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
    WxPayV3PayTransaction getByOutTradeNo(
            @Param("mchId") String mchId,
            @Param("outTradeNo") String outTradeNo);
}
