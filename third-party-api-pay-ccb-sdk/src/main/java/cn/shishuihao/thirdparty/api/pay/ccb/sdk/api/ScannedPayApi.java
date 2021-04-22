package cn.shishuihao.thirdparty.api.pay.ccb.sdk.api;

import cn.shishuihao.thirdparty.api.pay.ccb.sdk.request.CcbPay100Request;
import cn.shishuihao.thirdparty.api.pay.ccb.sdk.response.CcbPay100Response;
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
    CcbPay100Response pay(@Param("channelName") String channelName,
                          CcbPay100Request request);
}
