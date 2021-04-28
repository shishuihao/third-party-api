package cn.shishuihao.thirdparty.api.pay.chinaums.sdk.api;

import feign.RequestLine;

/**
 * POS通交易接口.
 *
 * @author shishuihao
 * @version 1.0.0
 */
public interface ChinaumsPosLinkTransactionPreAuthorizationApi {
    /**
     * 激活终端.
     *
     * @param request request
     * @return response
     */
    @RequestLine("POST /v1/poslink/transaction/activeterminal")
    String activeTerminal(String request);

    /**
     * 担保.
     *
     * @param request request
     * @return response
     */
    @RequestLine("POST /v1/poslink/transaction/preauthorization/preauthorize")
    String preAuthorize(String request);

    /**
     * 担保冲正（不支持该接口）.
     *
     * @param request request
     * @return response
     */
    @RequestLine("POST /v1/poslink/transaction/preauthorization"
            + "/reverseauthorization")
    String reverseAuthorization(String request);

    /**
     * 担保完成.
     *
     * @param request request
     * @return response
     */
    @RequestLine("POST /v1/poslink/transaction/preauthorization"
            + "/completeauthorization")
    String completeAuthorization(String request);

    /**
     * 担保撤销.
     *
     * @param request request
     * @return response
     */
    @RequestLine("POST /v1/poslink/transaction/preauthorization"
            + "/voidauthorization")
    String voidAuthorization(String request);

    /**
     * 快速担保完成.
     *
     * @param request request
     * @return response
     */
    @RequestLine("POST /v1/poslink/transaction/preauthorization"
            + "/quickcompleteauthorization")
    String quickCompleteAuthorization(String request);

    /**
     * 快速担保撤销.
     *
     * @param request request
     * @return response
     */
    @RequestLine("POST /v1/poslink/transaction/preauthorization"
            + "/quickvoidauthorization")
    String quickVoidAuthorization(String request);

    /**
     * 交易状态查询操作（根据原交易流水号查询）.
     *
     * @param request request
     * @return response
     */
    @RequestLine("POST /v1/poslink/transaction/preauthorization"
            + "/query-by-system-trace-num")
    String queryBySystemTraceNum(String request);

    /**
     * 交易状态查询操作（根据原交易流水号和支付订单号查询）.
     *
     * @param request request
     * @return response
     */
    @RequestLine("POST /v1/poslink/transaction/preauthorization/query")
    String query(String request);
}
