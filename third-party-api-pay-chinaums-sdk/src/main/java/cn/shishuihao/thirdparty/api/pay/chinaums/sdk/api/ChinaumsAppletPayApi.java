package cn.shishuihao.thirdparty.api.pay.chinaums.sdk.api;

import cn.shishuihao.thirdparty.api.pay.chinaums.sdk.request.ChinaumsV1NetPayPlaceRequest;
import cn.shishuihao.thirdparty.api.pay.chinaums.sdk.request.ChinaumsV1NetPaySubOrdersConfirmRequest;
import cn.shishuihao.thirdparty.api.pay.chinaums.sdk.response.ChinaumsV1NetPayPlaceResponse;
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
    ChinaumsV1NetPayPlaceResponse
    place(@Param("msgType") String msgType,
          ChinaumsV1NetPayPlaceRequest request);

    /**
     * 异步分账确认.
     *
     * @param request request
     * @return response
     */
    @RequestLine("POST /sub-orders-confirm")
    ChinaumsV1NetPaySubOrdersConfirmRequest
    subOrdersConfirm(ChinaumsV1NetPaySubOrdersConfirmRequest request);
}
