package cn.shishuihao.thirdparty.api.pay.wechat.sdk.api;

import cn.shishuihao.thirdparty.api.pay.wechat.sdk.request.WechatPayOrderQueryRequest;
import cn.shishuihao.thirdparty.api.pay.wechat.sdk.request.WechatPayRefundQueryRequest;
import cn.shishuihao.thirdparty.api.pay.wechat.sdk.response.WechatPayOrderQueryResponse;
import cn.shishuihao.thirdparty.api.pay.wechat.sdk.response.WechatPayRefundQueryResponse;
import feign.RequestLine;

/**
 * 通用.
 *
 * @author shishuihao
 * @version 1.0.0
 */

public interface WechatPayCommonApi {
    /**
     * 查询订单.
     * {@link "https://pay.weixin.qq.com/wiki/doc/api/micropay.php?chapter=9_2"}
     * 该接口提供所有微信支付订单的查询，商户可以通过查询订单接口主动查询订单状态，完成下一步的业务逻辑。
     * 需要调用查询接口的情况：
     * ◆ 当商户后台、网络、服务器等出现异常，商户系统最终未接收到支付通知；
     * ◆ 调用支付接口后，返回系统错误或未知交易状态情况；
     * ◆ 调用付款码支付API，返回USERPAYING的状态；
     * ◆ 调用关单或撤销接口API之前，需确认支付状态；
     *
     * @param request request
     * @return response
     */
    @RequestLine("POST /pay/orderquery")
    WechatPayOrderQueryResponse
    orderQuery(WechatPayOrderQueryRequest request);

    /**
     * 查询退款.
     * {@link "https://pay.weixin.qq.com/wiki/doc/api/micropay.php?chapter=9_5"}
     * 提交退款申请后，通过调用该接口查询退款状态。
     * 退款有一定延时，用零钱支付的退款20分钟内到账，银行卡支付的退款3个工作日后重新查询退款状态。
     * 注意：如果单个支付订单部分退款次数超过20次请使用退款单号查询
     *
     * @param request request
     * @return response
     */
    @RequestLine("POST /pay/refundquery")
    WechatPayRefundQueryResponse
    refundQuery(WechatPayRefundQueryRequest request);
}
