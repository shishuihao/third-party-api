package cn.shishuihao.thirdparty.api.pay.weixin.sdk;

import cn.shishuihao.thirdparty.api.pay.weixin.sdk.api.*;
import cn.shishuihao.thirdparty.api.pay.weixin.sdk.codec.WxXmlDecoder;
import cn.shishuihao.thirdparty.api.pay.weixin.sdk.codec.WxXmlEncoder;
import feign.Feign;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class WxFactory {
    public static final String ENDPOINT = "https://api.mch.weixin.qq.com";

    private WxFactory() {
    }

    public static class Payment {
        private Payment() {
        }

        public static Feign.Builder builder() {
            return Feign.builder()
                    .encoder(WxXmlEncoder.INSTANCE)
                    .decoder(WxXmlDecoder.INSTANCE);
        }

        public static WxPayCommonApi commonApi() {
            return builder().target(WxPayCommonApi.class, ENDPOINT);
        }

        public static WxPayCodeApi codeApi() {
            return builder().target(WxPayCodeApi.class, ENDPOINT);
        }

        public static WxPayJsApi jsApi() {
            return builder().target(WxPayJsApi.class, ENDPOINT);
        }

        public static WxPayNativeApi nativeApi() {
            return builder().target(WxPayNativeApi.class, ENDPOINT);
        }

        public static WxPayAppApi appApi() {
            return builder().target(WxPayAppApi.class, ENDPOINT);
        }

        public static WxPayH5Api h5Api() {
            return builder().target(WxPayH5Api.class, ENDPOINT);
        }

        public static WxPayAppletApi appletApi() {
            return builder().target(WxPayAppletApi.class, ENDPOINT);
        }

        public static WxPayFaceApi faceApi() {
            return builder().target(WxPayFaceApi.class, ENDPOINT);
        }
    }
}
