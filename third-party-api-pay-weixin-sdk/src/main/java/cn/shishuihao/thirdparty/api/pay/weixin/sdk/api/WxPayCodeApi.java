package cn.shishuihao.thirdparty.api.pay.weixin.sdk.api;

import cn.shishuihao.thirdparty.api.pay.weixin.sdk.request.WxPayMicropayRequest;
import cn.shishuihao.thirdparty.api.pay.weixin.sdk.response.WxPayMicropayResponse;
import feign.RequestLine;

/**
 * 付款码支付
 * {@link "https://pay.weixin.qq.com/wiki/doc/api/micropay.php?chapter=5_1"}
 *
 * @author shishuihao
 * @version 1.0.0
 */

public interface WxPayCodeApi extends WxPayCommonApi {
    /**
     * code pay
     *
     * @param request request
     * @return response
     */
    @RequestLine("POST /pay/micropay")
    WxPayMicropayResponse microPay(WxPayMicropayRequest request);
}
