package cn.shishuihao.thirdparty.api.pay.wechat.assembler;

import cn.shishuihao.thirdparty.api.pay.request.CodePayApiRequest;
import cn.shishuihao.thirdparty.api.pay.request.QueryPayApiRequest;
import cn.shishuihao.thirdparty.api.pay.wechat.WechatPayApiProperties;
import cn.shishuihao.thirdparty.api.pay.wechat.sdk.request.WechatPayMicroPayRequest;
import cn.shishuihao.thirdparty.api.pay.wechat.sdk.request.WechatPayOrderQueryRequest;
import org.apache.commons.lang3.RandomStringUtils;

import java.io.UnsupportedEncodingException;

/**
 * 请求装配器.
 *
 * @author shishuihao
 * @version 1.0.0
 */

public class WechatRequestAssembler {
    /**
     * 实例.
     */
    public static final WechatRequestAssembler INSTANCE
            = new WechatRequestAssembler();

    /**
     * 装配 二维码被扫支付请求.
     * {@link "https://pay.weixin.qq.com/wiki/doc/api/micropay.php
     * ?chapter=9_10&index=1"}
     *
     * @param request    付款码支付请求
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
     * 装配 二维码被扫支付请求.
     * {@link = "https://pay.weixin.qq.com/wiki/doc/api/micropay.php
     * ?chapter=9_02"}
     *
     * @param request    查询订单请求
     * @param properties 配置属性
     * @return {@link WechatPayMicroPayRequest}
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
}
