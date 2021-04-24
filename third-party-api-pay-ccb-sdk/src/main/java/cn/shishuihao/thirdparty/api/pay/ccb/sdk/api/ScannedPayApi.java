package cn.shishuihao.thirdparty.api.pay.ccb.sdk.api;

import cn.shishuihao.thirdparty.api.pay.ccb.sdk.request.CcbPay100Request;
import cn.shishuihao.thirdparty.api.pay.ccb.sdk.request.CcbPay101Request;
import cn.shishuihao.thirdparty.api.pay.ccb.sdk.request.CcbPay102Request;
import cn.shishuihao.thirdparty.api.pay.ccb.sdk.request.CcbPay103Request;
import cn.shishuihao.thirdparty.api.pay.ccb.sdk.request.CcbPay107Request;
import cn.shishuihao.thirdparty.api.pay.ccb.sdk.response.CcbPay100Response;
import cn.shishuihao.thirdparty.api.pay.ccb.sdk.response.CcbPay101Response;
import cn.shishuihao.thirdparty.api.pay.ccb.sdk.response.CcbPay102Response;
import cn.shishuihao.thirdparty.api.pay.ccb.sdk.response.CcbPay103Response;
import cn.shishuihao.thirdparty.api.pay.ccb.sdk.response.CcbPay107Response;
import feign.Param;
import feign.RequestLine;

/**
 * 建行互联网银企被扫支付接口.
 *
 * @author shishuihao
 * @version 1.0.0
 */

public interface ScannedPayApi {
    /**
     * 客户被扫支付-PAY100.
     *
     * @param channelName channel name
     * @param request     请求
     * @return 响应
     */
    @RequestLine("POST /NCCB/{channelName}B2BMainPlat")
    CcbPay100Response codePay(@Param("channelName") String channelName,
                              CcbPay100Request request);

    /**
     * 轮询订单结果-PAY101.
     *
     * @param channelName channel name
     * @param request     请求
     * @return 响应
     */
    @RequestLine("POST /NCCB/{channelName}B2BMainPlat")
    CcbPay101Response query(@Param("channelName") String channelName,
                            CcbPay101Request request);

    /**
     * 支付宝/微信订单查询-PAY102.
     *
     * @param channelName channel name
     * @param request     请求
     * @return 响应
     */
    @RequestLine("POST /NCCB/{channelName}B2BMainPlat")
    CcbPay102Response query(@Param("channelName") String channelName,
                            CcbPay102Request request);

    /**
     * 支付宝/微信订单关闭-PAY103.
     *
     * @param channelName channel name
     * @param request     请求
     * @return 响应
     */
    @RequestLine("POST /NCCB/{channelName}B2BMainPlat")
    CcbPay103Response cancel(@Param("channelName") String channelName,
                             CcbPay103Request request);

    /**
     * 扫付款码获取客户ID-PAY107.
     *
     * @param channelName channel name
     * @param request     请求
     * @return 响应
     */
    @RequestLine("POST /NCCB/{channelName}B2BMainPlat")
    CcbPay107Response getUserId(@Param("channelName") String channelName,
                                CcbPay107Request request);
}
