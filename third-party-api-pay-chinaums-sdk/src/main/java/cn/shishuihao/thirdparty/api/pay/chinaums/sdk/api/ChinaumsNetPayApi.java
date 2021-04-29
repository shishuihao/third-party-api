package cn.shishuihao.thirdparty.api.pay.chinaums.sdk.api;

import cn.shishuihao.thirdparty.api.pay.chinaums.sdk.request.ChinaumsV1NetPayCloseRequest;
import cn.shishuihao.thirdparty.api.pay.chinaums.sdk.request.ChinaumsV1NetPayQueryRequest;
import cn.shishuihao.thirdparty.api.pay.chinaums.sdk.request.ChinaumsV1NetPayRefundQueryRequest;
import cn.shishuihao.thirdparty.api.pay.chinaums.sdk.request.ChinaumsV1NetPayRefundRequest;
import cn.shishuihao.thirdparty.api.pay.chinaums.sdk.request.ChinaumsV1NetPaySecureCancelRequest;
import cn.shishuihao.thirdparty.api.pay.chinaums.sdk.request.ChinaumsV1NetPaySecureCompleteRequest;
import cn.shishuihao.thirdparty.api.pay.chinaums.sdk.response.ChinaumsV1NetPayCloseResponse;
import cn.shishuihao.thirdparty.api.pay.chinaums.sdk.response.ChinaumsV1NetPayQueryResponse;
import cn.shishuihao.thirdparty.api.pay.chinaums.sdk.response.ChinaumsV1NetPayRefundQueryResponse;
import cn.shishuihao.thirdparty.api.pay.chinaums.sdk.response.ChinaumsV1NetPayRefundResponse;
import cn.shishuihao.thirdparty.api.pay.chinaums.sdk.response.ChinaumsV1NetPaySecureCancelResponse;
import cn.shishuihao.thirdparty.api.pay.chinaums.sdk.response.ChinaumsV1NetPaySecureCompleteResponse;
import feign.RequestLine;

/**
 * 全民付移动支付.
 *
 * @author shishuihao
 * @version 1.0.0
 */

public interface ChinaumsNetPayApi {
    /**
     * 订单交易查询.
     *
     * @param request request
     * @return response
     */
    @RequestLine("POST /v1/netpay/query")
    ChinaumsV1NetPayQueryResponse
    query(ChinaumsV1NetPayQueryRequest request);

    /**
     * 退款.
     *
     * @param request request
     * @return response
     */
    @RequestLine("POST /v1/netpay/refund")
    ChinaumsV1NetPayRefundResponse
    refund(ChinaumsV1NetPayRefundRequest request);

    /**
     * 退款查询.
     *
     * @param request request
     * @return response
     */
    @RequestLine("POST /v1/netpay/refund-query")
    ChinaumsV1NetPayRefundQueryResponse
    refundQuery(ChinaumsV1NetPayRefundQueryRequest request);

    /**
     * 担保撤销.
     *
     * @param request request
     * @return response
     */
    @RequestLine("POST /v1/netpay/secure-cancel")
    ChinaumsV1NetPaySecureCancelResponse
    secureCancel(ChinaumsV1NetPaySecureCancelRequest request);

    /**
     * 担保完成.
     *
     * @param request request
     * @return response
     */
    @RequestLine("POST /v1/netpay/secure-complete")
    ChinaumsV1NetPaySecureCompleteResponse
    secureComplete(ChinaumsV1NetPaySecureCompleteRequest request);

    /**
     * 订单关闭.
     *
     * @param request request
     * @return response
     */
    @RequestLine("POST /v1/netpay/close")
    ChinaumsV1NetPayCloseResponse
    close(ChinaumsV1NetPayCloseRequest request);
}
