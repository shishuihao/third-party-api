package cn.shishuihao.thirdparty.api.pay.jdpay.sdk.api;

import feign.RequestLine;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public interface JdPayCommonPayApi {
    /**
     * 退款申请接口.
     * 退款申请接口提供给商户发起自动退款的能力。
     * 如果用户在商户系统下单支付以后发起退款，商户验证通过之后可以自动发起退款请求。
     * 同时京东支付商户管理后台提供手动退款的功能。
     * 退款申请的报文需按照接口规范进行加密，详见 4.4 加密算法
     *
     * @param request request
     * @return response
     */
    @RequestLine("POST /service/refund")
    String refund(String request);

    /**
     * 撤销申请接口.
     * 撤销申请接口提供给商户发起自动撤销的能力。
     * 对于未支付的订单撤销后不可再次支付，对于支付成功的订单则发起退款。
     * 撤销申请的报文需按照接口规范进行加密，详见 4.2 加密算法
     *
     * @param request request
     * @return response
     */
    @RequestLine("POST /service/revoke")
    String revoke(String request);

    /**
     * 交易查询接口.
     * 交易查询接口是为了处理商户服务器长时间没有接收到支付结果的情况设计的。
     * 一般情况，支付结果会通过前端同步返回和京东支付服务器的异步通知发送到商户服务。
     * 但是为避免特殊情况商户服务器仍然没有接收到支付结果，
     * 这时候商户服务可以通过主动查询交易结果的接口查询支付状态。
     *
     * @param request request
     * @return response
     */
    @RequestLine("POST /service/query")
    String query(String request);
}
