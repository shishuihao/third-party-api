package cn.shishuihao.thirdparty.api.pay.wechat.assembler;

import cn.shishuihao.thirdparty.api.pay.request.CancelPayApiRequest;
import cn.shishuihao.thirdparty.api.pay.request.CodePayApiRequest;
import cn.shishuihao.thirdparty.api.pay.request.QueryPayApiRequest;
import cn.shishuihao.thirdparty.api.pay.request.RefundPayApiRequest;
import cn.shishuihao.thirdparty.api.pay.request.RefundQueryPayApiRequest;
import cn.shishuihao.thirdparty.api.pay.wechat.WechatPayApiProperties;
import cn.shishuihao.thirdparty.api.pay.wechat.sdk.request.WechatPayMicroPayRequest;
import cn.shishuihao.thirdparty.api.pay.wechat.sdk.request.WechatPayOrderQueryRequest;
import cn.shishuihao.thirdparty.api.pay.wechat.sdk.request.WechatPayRefundQueryRequest;
import cn.shishuihao.thirdparty.api.pay.wechat.sdk.request.WechatPaySecApiPayRefundRequest;
import cn.shishuihao.thirdparty.api.pay.wechat.sdk.request.WechatPaySecApiPayReverseRequest;
import org.apache.commons.lang3.RandomStringUtils;

import java.io.UnsupportedEncodingException;

/**
 * 请求装配器.
 *
 * @author shishuihao
 * @version 1.0.0
 */

public class WechatPayRequestAssembler {
    /**
     * 实例.
     */
    public static final WechatPayRequestAssembler INSTANCE
            = new WechatPayRequestAssembler();

    /**
     * 装配 撤销订单请求.
     * {@link "https://pay.weixin.qq.com/wiki/doc/api/micropay.php
     * ?chapter=9_11&index=3"}
     *
     * @param request    请求
     * @param properties 配置属性
     * @return {@link WechatPaySecApiPayReverseRequest}
     */
    public WechatPaySecApiPayReverseRequest assemble(
            final CancelPayApiRequest request,
            final WechatPayApiProperties properties)
            throws UnsupportedEncodingException {
        final WechatPaySecApiPayReverseRequest wechatRequest
                = WechatPaySecApiPayReverseRequest.builder()
                .appId(properties.getAppId())
                .mchId(properties.getMchId())
                .subAppId(properties.getSubAppId())
                .subMchId(properties.getSubMchId())
                .deviceInfo(properties.getDeviceInfo())
                .nonceStr(RandomStringUtils
                        .randomAlphanumeric(Integer.SIZE))
                .signType(properties.getSignType())
                .outTradeNo(request.getOutTradeNo())
                .transactionId(request.getChannelTransactionId())
                .build();
        wechatRequest.sign(properties.getKey());
        return wechatRequest;
    }

    /**
     * 装配 二维码被扫支付请求.
     * {@link "https://pay.weixin.qq.com/wiki/doc/api/micropay.php
     * ?chapter=9_10&index=1"}
     *
     * @param request    请求
     * @param properties 配置属性
     * @return {@link WechatPayMicroPayRequest}
     */
    public WechatPayMicroPayRequest assemble(
            final CodePayApiRequest request,
            final WechatPayApiProperties properties)
            throws UnsupportedEncodingException {
        final WechatPayMicroPayRequest wechatRequest
                = WechatPayMicroPayRequest.builder()
                .appId(properties.getAppId())
                .mchId(properties.getMchId())
                .subAppId(properties.getSubAppId())
                .subMchId(properties.getSubMchId())
                .deviceInfo(properties.getDeviceInfo())
                .nonceStr(RandomStringUtils
                        .randomAlphanumeric(Integer.SIZE))
                .signType(properties.getSignType())
                .body(request.getSubject())
                .outTradeNo(request.getOutTradeNo())
                .totalFee(request.getTotalAmount())
                .authCode(request.getAuthCode())
                .build();
        wechatRequest.sign(properties.getKey());
        return wechatRequest;
    }

    /**
     * 装配 查询订单请求.
     * {@link = "https://pay.weixin.qq.com/wiki/doc/api/micropay.php
     * ?chapter=9_02"}
     *
     * @param request    请求
     * @param properties 配置属性
     * @return {@link WechatPayOrderQueryRequest}
     */
    public WechatPayOrderQueryRequest assemble(
            final QueryPayApiRequest request,
            final WechatPayApiProperties properties)
            throws UnsupportedEncodingException {
        final WechatPayOrderQueryRequest wechatRequest
                = WechatPayOrderQueryRequest.builder()
                .appId(properties.getAppId())
                .mchId(properties.getMchId())
                .subAppId(properties.getSubAppId())
                .subMchId(properties.getSubMchId())
                .deviceInfo(properties.getDeviceInfo())
                .nonceStr(RandomStringUtils
                        .randomAlphanumeric(Integer.SIZE))
                .signType(properties.getSignType())
                .outTradeNo(request.getOutTradeNo())
                .build();
        wechatRequest.sign(properties.getKey());
        return wechatRequest;
    }

    /**
     * 装配 申请退款请求.
     * {@link = "https://pay.weixin.qq.com/wiki/doc/api/micropay.php
     * ?chapter=9_4"}
     *
     * @param request    请求
     * @param properties 配置属性
     * @return {@link WechatPaySecApiPayRefundRequest}
     */
    public WechatPaySecApiPayRefundRequest assemble(
            final RefundPayApiRequest request,
            final WechatPayApiProperties properties)
            throws UnsupportedEncodingException {
        final WechatPaySecApiPayRefundRequest wechatRequest
                = WechatPaySecApiPayRefundRequest.builder()
                .appId(properties.getAppId())
                .mchId(properties.getMchId())
                .subAppId(properties.getSubAppId())
                .subMchId(properties.getSubMchId())
                .deviceInfo(properties.getDeviceInfo())
                .nonceStr(RandomStringUtils
                        .randomAlphanumeric(Integer.SIZE))
                .signType(properties.getSignType())
                .outTradeNo(request.getOutTradeNo())
                .transactionId(request.getChannelTransactionId())
                .outRefundNo(request.getOutRefundNo())
                .totalFee(request.getTotalAmount())
                .refundFee(request.getRefundAmount())
                .refundAccount(request.getRefundReason())
                .build();
        wechatRequest.sign(properties.getKey());
        return wechatRequest;
    }

    /**
     * 装配 查询退款请求.
     * {@link = "https://pay.weixin.qq.com/wiki/doc/api/micropay.php
     * ?chapter=9_5"}
     *
     * @param request    请求
     * @param properties 配置属性
     * @return {@link WechatPayRefundQueryRequest}
     */
    public WechatPayRefundQueryRequest assemble(
            final RefundQueryPayApiRequest request,
            final WechatPayApiProperties properties)
            throws UnsupportedEncodingException {
        final WechatPayRefundQueryRequest wechatRequest
                = WechatPayRefundQueryRequest.builder()
                .appId(properties.getAppId())
                .mchId(properties.getMchId())
                .subAppId(properties.getSubAppId())
                .subMchId(properties.getSubMchId())
                .deviceInfo(properties.getDeviceInfo())
                .nonceStr(RandomStringUtils
                        .randomAlphanumeric(Integer.SIZE))
                .signType(properties.getSignType())
                .outTradeNo(request.getOutTradeNo())
                .transactionId(request.getChannelTransactionId())
                .outRefundNo(request.getOutRefundNo())
                .refundId(request.getChannelRefundId())
                .build();
        wechatRequest.sign(properties.getKey());
        return wechatRequest;
    }
}
