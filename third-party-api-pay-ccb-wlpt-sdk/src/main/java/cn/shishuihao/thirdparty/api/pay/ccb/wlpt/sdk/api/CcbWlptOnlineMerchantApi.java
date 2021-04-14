package cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.api;

import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.request.CcbWlpt5W1001RequestTxInfo;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.request.CcbWlpt5W1002RequestTxInfo;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.request.CcbWlpt5W1003RequestTxInfo;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.request.CcbWlpt5W1004RequestTxInfo;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.request.CcbWlpt5W1005RequestTxInfo;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.request.CcbWlpt5W1006RequestTxInfo;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.request.CcbWlpt5W1007RequestTxInfo;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.request.CcbWlpt5W1015RequestTxInfo;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.request.CcbWlpt5W1024RequestTxInfo;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.request.CcbWlptRequest;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.response.CcbWlpt5W1001Response;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.response.CcbWlpt5W1002Response;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.response.CcbWlpt5W1003Response;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.response.CcbWlpt5W1004Response;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.response.CcbWlpt5W1005Response;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.response.CcbWlpt5W1006Response;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.response.CcbWlpt5W1007Response;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.response.CcbWlpt5W1024Response;

/**
 * 线上商户.
 *
 * @author shishuihao
 * @version 1.0.0
 */

public interface CcbWlptOnlineMerchantApi {
    /**
     * 5W1001 商户连接交易.
     *
     * @param request 请求
     * @return 响应
     */
    CcbWlpt5W1001Response connect(
            CcbWlptRequest<CcbWlpt5W1001RequestTxInfo> request);

    /**
     * 5W1002 商户支付流水查询.
     *
     * @param request 请求
     * @return 响应
     */
    CcbWlpt5W1002Response query(
            CcbWlptRequest<CcbWlpt5W1002RequestTxInfo> request);

    /**
     * 5W1003 商户退款流水查询.
     *
     * @param request 请求
     * @return 响应
     */
    CcbWlpt5W1003Response refundQuery(
            CcbWlptRequest<CcbWlpt5W1003RequestTxInfo> request);

    /**
     * 5W1004 商户单笔退款交易.
     *
     * @param request 请求
     * @return 响应
     */
    CcbWlpt5W1004Response refund(
            CcbWlptRequest<CcbWlpt5W1004RequestTxInfo> request);

    /**
     * 5W1005 商户流水文件下载.
     *
     * @param request 请求
     * @return 响应
     */
    CcbWlpt5W1005Response downloadFlow(
            CcbWlptRequest<CcbWlpt5W1005RequestTxInfo> request);

    /**
     * 5W1006 E付通授权信息查询.
     *
     * @param request 请求
     * @return 响应
     */
    CcbWlpt5W1006Response grantInfoQuery(
            CcbWlptRequest<CcbWlpt5W1006RequestTxInfo> request);

    /**
     * 5W1007 外卡收单商户端mpi(安全合法验证在商户).
     *
     * @param request 请求
     * @return 响应
     */
    CcbWlpt5W1007Response verify(
            CcbWlptRequest<CcbWlpt5W1007RequestTxInfo> request);

    /**
     * 5W1015 历史订单退款交易.
     *
     * @param request 请求
     * @return 响应
     */
    CcbWlpt5W1007Response historyRefund(
            CcbWlptRequest<CcbWlpt5W1015RequestTxInfo> request);

    /**
     * 5W1024 线上集团商户单笔退款.
     *
     * @param request 请求
     * @return 响应
     */
    CcbWlpt5W1024Response groupRefund(
            CcbWlptRequest<CcbWlpt5W1024RequestTxInfo> request);
}
