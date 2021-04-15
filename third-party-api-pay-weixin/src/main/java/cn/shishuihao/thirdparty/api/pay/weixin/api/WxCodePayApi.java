package cn.shishuihao.thirdparty.api.pay.weixin.api;

import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.core.exception.ApiException;
import cn.shishuihao.thirdparty.api.pay.api.CodePayApi;
import cn.shishuihao.thirdparty.api.pay.request.CodePayApiRequest;
import cn.shishuihao.thirdparty.api.pay.response.CodePayApiResponse;
import cn.shishuihao.thirdparty.api.pay.weixin.WxPayApiProperties;
import cn.shishuihao.thirdparty.api.pay.weixin.sdk.api.WxPayCodeApi;
import cn.shishuihao.thirdparty.api.pay.weixin.sdk.request.WxPayMicroPayRequest;
import cn.shishuihao.thirdparty.api.pay.weixin.sdk.response.WxPayMicroPayResponse;
import cn.shishuihao.thirdparty.api.pay.weixin.sdk.util.ResponseChecker;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;

import java.io.UnsupportedEncodingException;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@AllArgsConstructor
public class WxCodePayApi implements CodePayApi {
    /**
     * WxPayCodeApi.
     */
    private final WxPayCodeApi wxPayCodeApi;

    /**
     * execute CodePayApiRequest by weixin.
     *
     * @param request request
     * @return CodePayApiResponse
     */
    @Override
    public CodePayApiResponse execute(final CodePayApiRequest request) {
        WxPayApiProperties properties = (WxPayApiProperties)
                ApiRegistry.INSTANCE.getApiPropertiesOrThrow(request);
        try {
            WxPayMicroPayResponse response = wxPayCodeApi
                    .microPay(buildRequest(request, properties));
            return buildResponse(response);
        } catch (Exception e) {
            throw new ApiException(e);
        }
    }

    private WxPayMicroPayRequest buildRequest(
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

    private CodePayApiResponse buildResponse(
            final WxPayMicroPayResponse response) {
        return CodePayApiResponse.builder()
                .success(ResponseChecker.success(response))
                .code(ResponseChecker.getCode(response))
                .message(ResponseChecker.getMsg(response))
                .requestId(null)
                .build();
    }
}
