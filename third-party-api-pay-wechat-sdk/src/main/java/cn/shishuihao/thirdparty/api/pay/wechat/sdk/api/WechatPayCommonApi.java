package cn.shishuihao.thirdparty.api.pay.wechat.sdk.api;

import cn.shishuihao.thirdparty.api.pay.wechat.sdk.request.WechatPayOrderQueryRequest;
import cn.shishuihao.thirdparty.api.pay.wechat.sdk.request.WechatPayRefundQueryRequest;
import cn.shishuihao.thirdparty.api.pay.wechat.sdk.request.WechatPaySecApiPayRefundRequest;
import cn.shishuihao.thirdparty.api.pay.wechat.sdk.request.WechatPaySecApiPayReverseRequest;
import cn.shishuihao.thirdparty.api.pay.wechat.sdk.response.WechatPayOrderQueryResponse;
import cn.shishuihao.thirdparty.api.pay.wechat.sdk.response.WechatPayRefundQueryResponse;
import cn.shishuihao.thirdparty.api.pay.wechat.sdk.response.WechatPaySecApiPayRefundResponse;
import cn.shishuihao.thirdparty.api.pay.wechat.sdk.response.WechatPaySecApiPayReverseResponse;
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
     * 撤销订单.
     * {@link "https://pay.weixin.qq.com/wiki/doc/api/micropay.php
     * ?chapter=9_11&index=3"}
     * 支付交易返回失败或支付系统超时，调用该接口撤销交易。如果此订单用户支付失败，微信支付系统会将此订单关闭；
     * 如果用户支付成功，微信支付系统会将此订单资金退还给用户。
     * 注意：7天以内的交易单可调用撤销，其他正常支付的单如需实现相同功能请调用申请退款API。
     * 提交支付交易后调用【查询订单API】，没有明确的支付结果再调用【撤销订单API】。
     * 调用支付接口后请勿立即调用撤销订单API，建议支付后至少15s后再调用撤销订单接口。
     *
     * @param request request
     * @return response
     */
    @RequestLine("POST /secapi/pay/reverse")
    WechatPaySecApiPayReverseResponse
    reverse(WechatPaySecApiPayReverseRequest request);

    /**
     * 申请退款.
     * {@link "https://pay.weixin.qq.com/wiki/doc/api/micropay.php
     * ?chapter=9_11&index=3"}
     * 当交易发生之后一段时间内，由于买家或者卖家的原因需要退款时，卖家可以通过退款接口将支付款退还给买家，
     * 微信支付将在收到退款请求并且验证成功之后，按照退款规则将支付款按原路退到买家帐号上。
     * 注意：
     * 1、交易时间超过一年的订单无法提交退款
     * 2、微信支付退款支持单笔交易分多次退款，多次退款需要提交原支付订单的商户订单号和设置不同的退款单号。
     * 申请退款总金额不能超过订单金额。 一笔退款失败后重新提交，请不要更换退款单号，请使用原商户退款单号
     * 3、请求频率限制：150qps，即每秒钟正常的申请退款请求次数不超过150次错误或无效请求频率限制：
     * 6qps，即每秒钟异常或错误的退款申请请求不超过6次
     * 4、每个支付订单的部分退款次数不能超过50次
     * 5、如果同一个用户有多笔退款，建议分不同批次进行退款，避免并发退款导致退款失败
     * 6、申请退款接口的返回仅代表业务的受理情况，具体退款是否成功，需要通过退款查询接口获取结果。
     *
     * @param request request
     * @return response
     */
    @RequestLine("POST /secapi/pay/refund")
    WechatPaySecApiPayRefundResponse
    refund(WechatPaySecApiPayRefundRequest request);

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
