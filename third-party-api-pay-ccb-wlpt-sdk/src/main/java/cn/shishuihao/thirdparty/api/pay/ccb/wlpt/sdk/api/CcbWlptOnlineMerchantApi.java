package cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.api;

import cn.shishuihao.thirdparty.api.commons.http.HttpClient;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.request.CcbWlpt520200RequestTxInfo;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.request.CcbWlpt5W1001RequestTxInfo;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.request.CcbWlpt5W1002RequestTxInfo;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.request.CcbWlpt5W1003RequestTxInfo;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.request.CcbWlpt5W1004RequestTxInfo;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.request.CcbWlpt5W1005RequestTxInfo;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.request.CcbWlpt5W1006RequestTxInfo;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.request.CcbWlpt5W1007RequestTxInfo;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.request.CcbWlpt5W1015RequestTxInfo;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.request.CcbWlpt5W1016RequestTxInfo;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.request.CcbWlpt5W1024RequestTxInfo;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.request.CcbWlptRequest;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.response.CcbWlpt520200Response;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.response.CcbWlpt5W1001Response;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.response.CcbWlpt5W1002Response;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.response.CcbWlpt5W1003Response;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.response.CcbWlpt5W1004Response;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.response.CcbWlpt5W1005Response;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.response.CcbWlpt5W1006Response;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.response.CcbWlpt5W1007Response;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.response.CcbWlpt5W1016Response;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.response.CcbWlpt5W1024Response;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

/**
 * 线上商户.
 *
 * @author shishuihao
 * @version 1.0.0
 */
@Headers({
        "User-Agent: " + HttpClient.USER_AGENT,
        "Content-Type: application/x-www-form-urlencoded;charset=UTF-8"
})
public interface CcbWlptOnlineMerchantApi {
    /**
     * 5W1001 商户连接交易.
     *
     * @param channelName channel name
     * @param request     请求
     * @return 响应
     */
    @RequestLine("POST /NCCB/{channelName}B2BMainPlat")
    CcbWlpt5W1001Response connect(
            @Param("channelName") String channelName,
            CcbWlptRequest<CcbWlpt5W1001RequestTxInfo> request);

    /**
     * 5W1002 商户支付流水查询.
     *
     * @param channelName channel name
     * @param request     请求
     * @return 响应
     */
    @RequestLine("POST /NCCB/{channelName}B2BMainPlat")
    CcbWlpt5W1002Response query(
            @Param("channelName") String channelName,
            CcbWlptRequest<CcbWlpt5W1002RequestTxInfo> request);

    /**
     * 5W1003 商户退款流水查询.
     *
     * @param channelName channel name
     * @param request     请求
     * @return 响应
     */
    @RequestLine("POST /NCCB/{channelName}B2BMainPlat")
    CcbWlpt5W1003Response refundQuery(
            @Param("channelName") String channelName,
            CcbWlptRequest<CcbWlpt5W1003RequestTxInfo> request);

    /**
     * 5W1004 商户单笔退款交易.
     *
     * @param channelName channel name
     * @param request     请求
     * @return 响应
     */
    @RequestLine("POST /NCCB/{channelName}B2BMainPlat")
    CcbWlpt5W1004Response refund(
            @Param("channelName") String channelName,
            CcbWlptRequest<CcbWlpt5W1004RequestTxInfo> request);

    /**
     * 5W1005 商户流水文件下载.
     *
     * @param channelName channel name
     * @param request     请求
     * @return 响应
     */
    @RequestLine("POST /NCCB/{channelName}B2BMainPlat")
    CcbWlpt5W1005Response downloadFlow(
            @Param("channelName") String channelName,
            CcbWlptRequest<CcbWlpt5W1005RequestTxInfo> request);

    /**
     * 5W1006 E付通授权信息查询.
     *
     * @param channelName channel name
     * @param request     请求
     * @return 响应
     */
    @RequestLine("POST /NCCB/{channelName}B2BMainPlat")
    CcbWlpt5W1006Response grantInfoQuery(
            @Param("channelName") String channelName,
            CcbWlptRequest<CcbWlpt5W1006RequestTxInfo> request);

    /**
     * 5W1007 外卡收单商户端mpi(安全合法验证在商户).
     *
     * @param channelName channel name
     * @param request     请求
     * @return 响应
     */
    @RequestLine("POST /NCCB/{channelName}B2BMainPlat")
    CcbWlpt5W1007Response verify(
            @Param("channelName") String channelName,
            CcbWlptRequest<CcbWlpt5W1007RequestTxInfo> request);

    /**
     * 5W1015 历史订单退款交易.
     *
     * @param channelName channel name
     * @param request     请求
     * @return 响应
     */
    @RequestLine("POST /NCCB/{channelName}B2BMainPlat")
    CcbWlpt5W1007Response historyRefund(
            @Param("channelName") String channelName,
            CcbWlptRequest<CcbWlpt5W1015RequestTxInfo> request);

    /**
     * 5W1016 历史订单退款结果查询.
     *
     * @param channelName channel name
     * @param request     请求
     * @return 响应
     */
    @RequestLine("POST /NCCB/{channelName}B2BMainPlat")
    CcbWlpt5W1016Response historyRefundQuery(
            @Param("channelName") String channelName,
            CcbWlptRequest<CcbWlpt5W1016RequestTxInfo> request);

    /**
     * 5W1024 线上集团商户单笔退款.
     *
     * @param channelName channel name
     * @param request     请求
     * @return 响应
     */
    @RequestLine("POST /NCCB/{channelName}B2BMainPlat")
    CcbWlpt5W1024Response groupRefund(
            @Param("channelName") String channelName,
            CcbWlptRequest<CcbWlpt5W1024RequestTxInfo> request);

    /**
     * 520200 商户支付交易.
     *
     * @param channelName channel name
     * @param request     请求
     * @return 响应
     */
    @RequestLine("POST /NCCB/{channelName}B2BMainPlat")
    CcbWlpt520200Response pay(
            @Param("channelName") String channelName,
            CcbWlptRequest<CcbWlpt520200RequestTxInfo> request);
}
