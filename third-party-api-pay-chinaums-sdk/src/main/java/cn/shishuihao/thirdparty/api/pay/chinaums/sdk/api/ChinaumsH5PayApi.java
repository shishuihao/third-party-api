package cn.shishuihao.thirdparty.api.pay.chinaums.sdk.api;

import feign.Param;
import feign.RequestLine;

/**
 * 全民付移动支付 H5支付.
 *
 * @author shishuihao
 * @version 1.0.0
 */

public interface ChinaumsH5PayApi extends ChinaumsNetPayApi {
    /**
     * 下单.
     *
     * @param msgType 消息类型
     *                支付宝:  trade/h5-pay
     *                微信:  wxpay/h5-pay
     *                银联云闪付: uac/order
     * @param request request
     * @return response
     */
    @RequestLine("POST /v1/netpay/{msgType}")
    String place(@Param("msgType") String msgType,
                 String request);
}
