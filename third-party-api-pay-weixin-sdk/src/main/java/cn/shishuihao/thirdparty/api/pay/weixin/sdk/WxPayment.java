package cn.shishuihao.thirdparty.api.pay.weixin.sdk;

import cn.shishuihao.thirdparty.api.pay.weixin.sdk.api.*;
import cn.shishuihao.thirdparty.api.pay.weixin.sdk.codec.WxXmlDecoder;
import cn.shishuihao.thirdparty.api.pay.weixin.sdk.codec.WxXmlEncoder;
import feign.Feign;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class WxPayment {
    public static final String ENDPOINT = "https://api.mch.weixin.qq.com";
    private final WxPayCommonApi commonApi = Feign.builder()
            .encoder(WxXmlEncoder.INSTANCE)
            .decoder(WxXmlDecoder.INSTANCE)
            .target(WxPayCommonApi.class, ENDPOINT);
    private final WxPayCodeApi codeApi = Feign.builder()
            .encoder(WxXmlEncoder.INSTANCE)
            .decoder(WxXmlDecoder.INSTANCE)
            .target(WxPayCodeApi.class, ENDPOINT);
    private final WxPayJsApi jsApi = Feign.builder()
            .encoder(WxXmlEncoder.INSTANCE)
            .decoder(WxXmlDecoder.INSTANCE)
            .target(WxPayJsApi.class, ENDPOINT);
    private final WxPayNativeApi nativeApi = Feign.builder()
            .encoder(WxXmlEncoder.INSTANCE)
            .decoder(WxXmlDecoder.INSTANCE)
            .target(WxPayNativeApi.class, ENDPOINT);
    private final WxPayAppApi appApi = Feign.builder()
            .encoder(WxXmlEncoder.INSTANCE)
            .decoder(WxXmlDecoder.INSTANCE)
            .target(WxPayAppApi.class, ENDPOINT);
    private final WxPayH5Api h5Api = Feign.builder()
            .encoder(WxXmlEncoder.INSTANCE)
            .decoder(WxXmlDecoder.INSTANCE)
            .target(WxPayH5Api.class, ENDPOINT);
    private final WxPayAppletApi appletApi = Feign.builder()
            .encoder(WxXmlEncoder.INSTANCE)
            .decoder(WxXmlDecoder.INSTANCE)
            .target(WxPayAppletApi.class, ENDPOINT);
    private final WxPayFaceApi faceApi = Feign.builder()
            .encoder(WxXmlEncoder.INSTANCE)
            .decoder(WxXmlDecoder.INSTANCE)
            .target(WxPayFaceApi.class, ENDPOINT);

    public WxPayCommonApi getCommonApi() {
        return commonApi;
    }

    public WxPayCodeApi getCodeApi() {
        return codeApi;
    }

    public WxPayJsApi getJsApi() {
        return jsApi;
    }

    public WxPayNativeApi getNativeApi() {
        return nativeApi;
    }

    public WxPayAppApi getAppApi() {
        return appApi;
    }

    public WxPayH5Api getH5Api() {
        return h5Api;
    }

    public WxPayAppletApi getAppletApi() {
        return appletApi;
    }

    public WxPayFaceApi getFaceApi() {
        return faceApi;
    }
}
