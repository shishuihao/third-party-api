package cn.shishuihao.thirdparty.api.pay.weixin.sdk.api;

import cn.shishuihao.thirdparty.api.pay.weixin.sdk.request.WxPayMicroPayRequest;
import cn.shishuihao.thirdparty.api.pay.weixin.sdk.response.WxPayMicropayResponse;
import feign.RequestLine;

/**
 * 付款码支付.
 * {@link "https://pay.weixin.qq.com/wiki/doc/api/micropay.php?chapter=5_1"}
 *
 * @author shishuihao
 * @version 1.0.0
 */

public interface WxPayCodeApi extends WxPayCommonApi {
    /**
     * 付款码支付.
     * {@link "https://pay.weixin.qq.com/wiki/doc/api/micropay.php
     * ?chapter=9_10&index=1"}
     * 收银员使用扫码设备读取微信用户付款码以后，二维码或条码信息会传送至商户收银台，
     * 由商户收银台或者商户后台调用该接口发起支付。
     * 提醒1：提交支付请求后微信会同步返回支付结果。
     * 当返回结果为“系统错误”时，商户系统等待5秒后调用【查询订单API】，查询支付实际交易结果；
     * 当返回结果为“USERPAYING”时，商户系统可设置间隔时间(建议10秒)重新查询支付结果，直到支付成功或超时(建议30秒)；
     * 提醒2：在调用查询接口返回后，如果交易状况不明晰，请调用【撤销订单API】，
     * 此时如果交易失败则关闭订单，该单不能再支付成功；
     * 如果交易成功，则将扣款退回到用户账户。
     * 当撤销无返回或错误时，请再次调用。
     * 注意：请勿扣款后立即调用【撤销订单API】,建议至少15秒后再调用。
     * 撤销订单API需要双向证书。
     *
     * @param request request
     * @return response
     */
    @RequestLine("POST /pay/micropay")
    WxPayMicropayResponse microPay(WxPayMicroPayRequest request);
}
