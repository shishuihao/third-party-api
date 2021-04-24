package cn.shishuihao.thirdparty.api.pay.weixin.assembler;

import cn.shishuihao.thirdparty.api.pay.request.CodePayApiRequest;
import cn.shishuihao.thirdparty.api.pay.request.QueryPayApiRequest;
import cn.shishuihao.thirdparty.api.pay.weixin.WxPayApiProperties;
import cn.shishuihao.thirdparty.api.pay.weixin.sdk.request.WxPayMicroPayRequest;
import cn.shishuihao.thirdparty.api.pay.weixin.sdk.request.WxPayOrderQueryRequest;
import org.apache.commons.lang3.RandomStringUtils;

import java.io.UnsupportedEncodingException;

/**
 * 请求装配器.
 *
 * @author shishuihao
 * @version 1.0.0
 */

public class WxRequestAssembler {
    /**
     * 实例.
     */
    public static final WxRequestAssembler INSTANCE
            = new WxRequestAssembler();

    /**
     * 装配 二维码被扫支付请求.
     * {@link "https://pay.weixin.qq.com/wiki/doc/api/micropay.php
     * ?chapter=9_10&index=1"}
     *
     * @param request    付款码支付请求
     * @param properties 配置属性
     * @return {@link WxPayMicroPayRequest}
     */
    public WxPayMicroPayRequest assemble(
            final CodePayApiRequest request,
            final WxPayApiProperties properties)
            throws UnsupportedEncodingException {
        WxPayMicroPayRequest wxRequest = WxPayMicroPayRequest.builder()
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
        wxRequest.sign(properties.getKey());
        return wxRequest;
    }

    /**
     * 装配 二维码被扫支付请求.
     * {@link = "https://pay.weixin.qq.com/wiki/doc/api/micropay.php
     * ?chapter=9_02"}
     *
     * @param request    查询订单请求
     * @param properties 配置属性
     * @return {@link WxPayMicroPayRequest}
     */
    public WxPayOrderQueryRequest assemble(
            final QueryPayApiRequest request,
            final WxPayApiProperties properties)
            throws UnsupportedEncodingException {
        WxPayOrderQueryRequest wxRequest = WxPayOrderQueryRequest.builder()
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
        wxRequest.sign(properties.getKey());
        return wxRequest;
    }
}
