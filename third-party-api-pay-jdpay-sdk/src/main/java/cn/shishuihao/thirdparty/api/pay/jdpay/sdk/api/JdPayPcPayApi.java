package cn.shishuihao.thirdparty.api.pay.jdpay.sdk.api;

import feign.RequestLine;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public interface JdPayPcPayApi extends JdPayCommonPayApi {
    /**
     * 在线支付接口.
     * 在线支付接口提供给商户向京东支付服务发送支付请求数据集合，
     * 京东支付服务会根据请求数据验证商户身份，以及验证支付信息是否被篡改。
     * 验证通过后，京东支付服务会在当前页面弹出支付页面弹框。
     * 1) 在以上的请求参数中，商户号是在注册开通京东支付功能的时候，京东支付商户管理系统为用户分配的。
     * 2) 用户账号是商户系统的用户账号。
     * 3) 交易流水号是用来标识每次支付请求的号码，需要商户保证在每一次支付请求的时候交易流水号唯一，
     * 多次请求不能使用同一交易流水号，否则京东支付服务在处理后面的支付请求时，会把此交易当做重复支付处理。
     * 4) 签名规则详见：“4.1 签名算法”章节
     * 5) 为保证信息安全，表单中的各个字段除了 merchant（商户号）、版本号（version）、签名（sign）以外，
     * 其余字段全部采用 3DES 进行加密
     *
     * @param request request
     * @return response
     */
    @RequestLine("POST /jdpay/saveOrder")
    String saveOrder(String request);

    /**
     * 用户关系查询接口.
     * 若商户用户与京东用户关联，下次支付时可跳过身份识别环境进行支付。
     * 此接口提供了用户关系查询功能。
     *
     * @param request request
     * @return response
     */
    @RequestLine("POST /service/getUserRelation")
    String getUserRelation(String request);

    /**
     * 用户关系解绑接口.
     * 解绑用户关系，解绑后，用户下一次支付，需重新通过手机等登录方式进行身份验证。
     *
     * @param request request
     * @return response
     */
    @RequestLine("POST /service/cancelUserRelation")
    String cancelUserRelation(String request);

    /**
     * 白条分期策略查询接口.
     * 该接口用于商户接入白条分期前置时，先调用此接口查询订单金额对应的白条分期策略，展示到商户的页面上。
     * 其目的是为了可以在商户的页面展示白条可支持的分期信息。
     * 4) 在以上的请求参数中，商户号是在注册开通京东支付功能的时候，京东支付商户管理系统为用户分配的。
     * 5) 用户账号是商户系统的用户账号。
     * 6) 交易流水号是用来标识每次支付请求的号码，需要商户保证在每一次支付请求的时候交易流水号唯一，
     * 多次请求不能使用同一交易流水号，否则京东支付服务在处理后面的支付请求时，会把此交易当做重复支付处理。
     * 7) 签名规则详见：“4.1 签名算法”章节
     * 8) 为保证信息安全，表单中的各个字段除了 merchant（商户号）、版本号（version）、签名（sign）以外，
     * 其余字段全部采用 3DES 进行加密
     *
     * @param request request
     * @return response
     */
    @RequestLine("POST /service/queryBaiTiaoFQ")
    String queryBaiTiaoFQ(String request);
}
