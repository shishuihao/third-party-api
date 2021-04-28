package cn.shishuihao.thirdparty.api.pay.chinaums.sdk.api;

import feign.RequestLine;

/**
 * POS通交易接口.
 *
 * @author shishuihao
 * @version 1.0.0
 */
public interface ChinaumsPosLinkTransactionApi {
    /**
     * 激活终端.
     *
     * @param request request
     * @return response
     */
    @RequestLine("POST /v2/poslink/transaction/activeterminal")
    String activeTerminal(String request);

    /**
     * 支付.
     *
     * @param request request
     * @return response
     */
    @RequestLine("POST /v2/poslink/transaction/pay")
    String pay(String request);

    /**
     * 支付撤销.
     *
     * @param request request
     * @return response
     */
    @RequestLine("POST /v2/poslink/transaction/voidpayment")
    String cancel(String request);

    /**
     * 交易退款.
     *
     * @param request request
     * @return response
     */
    @RequestLine("POST /v2/poslink/transaction/refund")
    String refund(String request);

    /**
     * 交易状态查询.
     *
     * @param request request
     * @return response
     */
    @RequestLine("POST /v2/poslink/transaction/query")
    String query(String request);

    /**
     * 交易退款查询.
     *
     * @param request request
     * @return response
     */
    @RequestLine("POST /v2/poslink/transaction/query-refund")
    String queryRefund(String request);
}
