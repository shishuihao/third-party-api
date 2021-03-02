package cn.shishuihao.thirdparty.api.pay.weixin.sdk.api;

import cn.shishuihao.thirdparty.api.pay.weixin.sdk.request.WxPayMicropayRequest;
import cn.shishuihao.thirdparty.api.pay.weixin.sdk.response.WxPayMicropayResponse;
import feign.RequestLine;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public interface WxPayApi {
    /**
     * code pay
     *
     * @param request request
     * @return response
     */
    @RequestLine("POST /pay/micropay")
    WxPayMicropayResponse payMicropay(WxPayMicropayRequest request);
}
