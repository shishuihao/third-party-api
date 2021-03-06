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

import java.util.Map;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class WxCodePayApi implements CodePayApi {
    private final WxPayCodeApi wxPayCodeApi = WxFactory.Payment.codeApi();

    @Override
    public CodePayApiResponse execute(CodePayApiRequest request) {
        WxPayApiProperties properties = (WxPayApiProperties) ApiRegistry.INSTANCE.getApiPropertiesOrThrow(request);
        try {
            WxPayMicropayRequest wxPayMicropayRequest = WxPayMicropayRequest.Builder.builder()
                    .appId(properties.getAppId())
                    .mchId(properties.getMchId())
                    .subAppId(properties.getSubAppId())
                    .subMchId(properties.getSubMchId())
                    .deviceInfo(properties.getDeviceInfo())
                    .nonceStr(RandomStringUtils.randomAlphanumeric(32))
                    .signType(properties.getSignType())
                    .body(request.getSubject())
                    .outTradeNo(request.getOutTradeNo())
                    .totalFee(request.getTotalAmount())
                    .authCode(request.getAuthCode())
                    .build();
            Map<String, Object> params = XmlFieldUtils.getNameValueMap(wxPayMicropayRequest);
            wxPayMicropayRequest.setSign(wxPayMicropayRequest.getSignType().sign(properties.getKey(), params));
            WxPayMicropayResponse wxPayMicropayResponse = wxPayCodeApi.microPay(wxPayMicropayRequest);
            return CodePayApiResponse.Builder.builder()
                    .success(ResponseChecker.success(wxPayMicropayResponse))
                    .code(wxPayMicropayResponse.getReturnCode())
                    .message(wxPayMicropayResponse.getReturnMsg())
                    .requestId(null)
                    .build();
        } catch (Exception e) {
            throw new ApiException(e);
        }
    }
}
