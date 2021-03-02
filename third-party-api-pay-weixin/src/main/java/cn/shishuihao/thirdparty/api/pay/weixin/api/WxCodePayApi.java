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
import org.apache.commons.lang3.RandomStringUtils;

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
            WxPayMicropayResponse response = wxPayCodeApi.microPay(
                    WxPayMicropayRequest.Builder.builder()
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
                            .build(properties.getKey()));
            return CodePayApiResponse.Builder.builder()
                    .success(ResponseChecker.success(response))
                    .code(response.getReturnCode())
                    .message(response.getReturnMsg())
                    .requestId(null)
                    .build();
        } catch (Exception e) {
            throw new ApiException(e);
        }
    }
}
