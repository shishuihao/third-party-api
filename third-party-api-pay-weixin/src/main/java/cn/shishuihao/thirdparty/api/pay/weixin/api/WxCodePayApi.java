package cn.shishuihao.thirdparty.api.pay.weixin.api;

import cn.shishuihao.thirdparty.api.core.ApiRegistry;
import cn.shishuihao.thirdparty.api.core.exception.ApiException;
import cn.shishuihao.thirdparty.api.pay.api.CodePayApi;
import cn.shishuihao.thirdparty.api.pay.request.CodePayApiRequest;
import cn.shishuihao.thirdparty.api.pay.response.CodePayApiResponse;
import cn.shishuihao.thirdparty.api.pay.weixin.WxPayApiProperties;
import cn.shishuihao.thirdparty.api.pay.weixin.sdk.WxFactory;
import cn.shishuihao.thirdparty.api.pay.weixin.sdk.api.WxPayCodeApi;
import cn.shishuihao.thirdparty.api.pay.weixin.sdk.request.WxPayMicropayRequest;
import cn.shishuihao.thirdparty.api.pay.weixin.sdk.response.WxPayMicropayResponse;
import cn.shishuihao.thirdparty.api.pay.weixin.sdk.util.ResponseChecker;
import cn.shishuihao.thirdparty.api.pay.weixin.sdk.util.XmlFieldUtils;
import org.apache.commons.lang3.RandomStringUtils;

import java.io.UnsupportedEncodingException;
import java.util.Map;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class WxCodePayApi implements CodePayApi {
    /**
     * WxPayCodeApi.
     */
    private final WxPayCodeApi wxPayCodeApi = WxFactory.Payment.codeApi();

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
            WxPayMicropayRequest wxRequest = getWxRequest(request, properties);
            wxRequest.setSign(getSign(properties, wxRequest));
            WxPayMicropayResponse wxResponse = wxPayCodeApi.microPay(wxRequest);
            return getApiResponse(wxResponse);
        } catch (Exception e) {
            throw new ApiException(e);
        }
    }

    private WxPayMicropayRequest getWxRequest(
            final CodePayApiRequest request,
            final WxPayApiProperties properties) {
        return WxPayMicropayRequest.builder()
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
    }

    private String getSign(final WxPayApiProperties properties,
                      final WxPayMicropayRequest wxRequest)
            throws UnsupportedEncodingException {
        Map<String, Object> params = XmlFieldUtils
                .getNameValueMap(wxRequest);
        return wxRequest.getSignType().sign(properties.getKey(), params);
    }

    private CodePayApiResponse getApiResponse(
            final WxPayMicropayResponse wxPayMicropayResponse) {
        return CodePayApiResponse.builder()
                .success(ResponseChecker.success(wxPayMicropayResponse))
                .code(wxPayMicropayResponse.getReturnCode())
                .message(wxPayMicropayResponse.getReturnMsg())
                .requestId(null)
                .build();
    }
}
