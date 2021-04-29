package cn.shishuihao.thirdparty.api.pay.jdpay.sdk.api;

import feign.RequestLine;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public interface JdPayCodePayApi {
    /**
     * 扫一扫支付接口.
     * 商户系统先调用该接口在京东支付服务后台生成交易单，
     * 再按扫码、APP等不同场景发起支付。
     * 1) 在以上的请求参数中，商户号是在注册开通京东支付功能的时候，京东支付商户管理系统为用户分配的。
     * 2) 用户账号是商户系统的用户账号。
     * 3) 交易流水号是用来标识每次支付请求的号码，需要商户保证在每一次支付请求的时候交易流水号唯一，
     * 多次请求不能使用同一交易流水号，否则京东支付服务在处理后面的支付请求时，会把此交易当做重复支付处理。
     * 4) 扫码支付场景下，商户需要指定交易类型（tradeType）为 QR，接收到京东支付返回二维码字符串（qrCode）后生成二维码图片。
     * 5) 签名规则详见：“4.1 签名算法”章节
     * 6) 为保证信息安全，表单中的各个字段除了 merchant（商户号）、版本号（version）以外，其余字段全部采用 3DES 进行加密
     *
     * @param request request
     * @return response
     */
    @RequestLine("POST /service/uniorder")
    String uniOrder(String request);

    /**
     * 付款码支付接口.
     * 付款码支付接口用于客户使用付款码支付时，商户使用扫码枪完成一键下单并支付功能。
     * 在支付过程中对支付请求进行校验后，完成支付流程。
     * 说明：此接口建议超时时间设置为 15 秒，因快捷支付极端情况下银行会有超时情况，
     * 如超时，可调用查询接口查询支付结果。
     *
     * @param request request
     * @return response
     */
    @RequestLine("POST /service/fkmPay")
    String fkmPay(String request);

    /**
     * 商户二维码支付接口.
     * 该接口用于展示商户二维码，客户自定义金额支付或商户自定义金额支付等场景，
     * 京东支付服务会根据请求数据验证商户身份，以及验证支付信息是否被篡改。
     * 验证通过后，京东支付服务会在当前页面弹出支付页面弹框。
     * (金融的 UA是 jdjr，商城的ＵＡ是 jdapp)
     *
     * @param request request
     * @return response
     */
    @RequestLine("POST /jdpay/customerPay")
    String customerPay(String request);

    /**
     * 退款申请接口.
     * 退款申请接口提供给商户发起自动退款的能力。
     * 如果用户在商户系统下单支付以后发起退款，商户验证通过之后可以自动发起退款请求。
     * 同时京东支付商户管理后台提供手动退款的功能。
     * 退款申请的报文需按照接口规范进行加密，详见 4.4 加密算法
     *
     * @param request request
     * @return response
     */
    @RequestLine("POST /service/refund")
    String refund(String request);

    /**
     * 撤销申请接口.
     * 撤销申请接口提供给商户发起自动撤销的能力。
     * 对于未支付的订单撤销后不可再次支付，对于支付成功的订单则发起退款。
     * 撤销申请的报文需按照接口规范进行加密，详见 4.2 加密算法
     *
     * @param request request
     * @return response
     */
    @RequestLine("POST /service/revoke")
    String revoke(String request);

    /**
     * 交易查询接口.
     * 交易查询接口是为了处理商户服务器长时间没有接收到支付结果的情况设计的。
     * 一般情况，支付结果会通过前端同步返回和京东支付服务器的异步通知发送到商户服务。
     * 但是为避免特殊情况商户服务器仍然没有接收到支付结果，
     * 这时候商户服务可以通过主动查询交易结果的接口查询支付状态。
     *
     * @param request request
     * @return response
     */
    @RequestLine("POST /service/query")
    String query(String request);
}
