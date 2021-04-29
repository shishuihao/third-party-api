package cn.shishuihao.thirdparty.api.pay.chinaums.sdk.api;

import cn.shishuihao.thirdparty.api.pay.chinaums.sdk.request.ChinaumsV1NetPayPlaceRequest;
import cn.shishuihao.thirdparty.api.pay.chinaums.sdk.response.ChinaumsV1NetPayPlaceResponse;
import feign.Param;
import feign.RequestLine;

/**
 * 全民付移动支付 H5支付.
 *
 * @author shishuihao
 * @version 1.0.0
 */

public interface ChinaumsAppPayApi extends ChinaumsNetPayApi {
    /**
     * 下单.
     *
     * @param msgType 消息类型
     *                微信：wx/app-pre-order
     *                支付宝：trade/precreate
     *                全民付：qmf/order
     *                银联云闪付：uac/app-order
     *                Apple Pay： applepay/order
     *                支付宝(支付宝跳转小程序支付)：trade/app-pre-order
     * @param request request
     * @return response
     */
    @RequestLine("POST /v1/netpay/{msgType}")
    ChinaumsV1NetPayPlaceResponse
    place(@Param("msgType") String msgType,
          ChinaumsV1NetPayPlaceRequest request);
}
