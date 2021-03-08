package cn.shishuihao.thirdparty.api.pay.ccb.hsb.sdk.api;

import cn.shishuihao.thirdparty.api.pay.ccb.hsb.sdk.request.OnlineDirectGatherPlaceOrderRequest;
import cn.shishuihao.thirdparty.api.pay.ccb.hsb.sdk.response.OnlineDirectGatherPlaceOrderResponse;
import feign.Headers;
import feign.RequestLine;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public interface CcbHsbOnlineDirectApi {
    /**
     * 这个接口用于让客户生成订单信息.
     *
     * @param request request
     * @return response
     */
    @Headers("Content-Type: application/json; charset=UTF-8")
    @RequestLine("POST /online/direct/gatherPlaceorder")
    OnlineDirectGatherPlaceOrderResponse gatherPlaceOrder(
            OnlineDirectGatherPlaceOrderRequest request);
}
