package cn.shishuihao.thirdparty.api.pay.chinaums.sdk.api;

import feign.Param;
import feign.RequestLine;

/**
 * 全民付移动支付 小程序支付.
 *
 * @author shishuihao
 * @version 1.0.0
 */

public interface ChinaumsAppletPayApi extends ChinaumsNetPayApi {
    /**
     * 下单.
     *
     * @param msgType 消息类型
     *                微信：wx/unified-order
     *                支付宝：trade/create
     * @param request request
     * @return response
     */
    @RequestLine("POST /v1/netpay/{msgType}")
    String place(@Param("msgType") String msgType,
                 String request);

    /**
     * 异步分账确认.
     *
     * @param request request
     * @return response
     */
    @RequestLine("POST /sub-orders-confirm")
    String subOrdersConfirm(String request);
}
