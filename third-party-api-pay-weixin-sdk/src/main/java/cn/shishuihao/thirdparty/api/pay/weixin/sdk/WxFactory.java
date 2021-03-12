package cn.shishuihao.thirdparty.api.pay.weixin.sdk;

import cn.shishuihao.thirdparty.api.pay.weixin.sdk.api.WxPayAppApi;
import cn.shishuihao.thirdparty.api.pay.weixin.sdk.api.WxPayAppletApi;
import cn.shishuihao.thirdparty.api.pay.weixin.sdk.api.WxPayCodeApi;
import cn.shishuihao.thirdparty.api.pay.weixin.sdk.api.WxPayCommonApi;
import cn.shishuihao.thirdparty.api.pay.weixin.sdk.api.WxPayFaceApi;
import cn.shishuihao.thirdparty.api.pay.weixin.sdk.api.WxPayH5Api;
import cn.shishuihao.thirdparty.api.pay.weixin.sdk.api.WxPayJsApi;
import cn.shishuihao.thirdparty.api.pay.weixin.sdk.api.WxPayNativeApi;
import cn.shishuihao.thirdparty.api.pay.weixin.sdk.codec.WxXmlDecoder;
import cn.shishuihao.thirdparty.api.pay.weixin.sdk.codec.WxXmlEncoder;
import feign.Feign;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public final class WxFactory {
    /**
     * ENDPOINT.
     */
    public static final String ENDPOINT = "https://api.mch.weixin.qq.com";

    private WxFactory() {
    }

    public static final class Payment {
        private Payment() {
        }

        private static Feign.Builder builder() {
            return Feign.builder()
                    .encoder(WxXmlEncoder.INSTANCE)
                    .decoder(WxXmlDecoder.INSTANCE);
        }

        /**
         * commonApi.
         *
         * @return WxPayCommonApi
         */
        public static WxPayCommonApi commonApi() {
            return builder().target(WxPayCommonApi.class, ENDPOINT);
        }

        /**
         * codeApi.
         *
         * @return WxPayCodeApi
         */
        public static WxPayCodeApi codeApi() {
            return builder().target(WxPayCodeApi.class, ENDPOINT);
        }

        /**
         * jsApi.
         *
         * @return WxPayJsApi
         */
        public static WxPayJsApi jsApi() {
            return builder().target(WxPayJsApi.class, ENDPOINT);
        }

        /**
         * nativeApi.
         *
         * @return WxPayNativeApi
         */
        public static WxPayNativeApi nativeApi() {
            return builder().target(WxPayNativeApi.class, ENDPOINT);
        }

        /**
         * appApi.
         *
         * @return WxPayAppApi
         */
        public static WxPayAppApi appApi() {
            return builder().target(WxPayAppApi.class, ENDPOINT);
        }

        /**
         * h5Api.
         *
         * @return WxPayH5Api
         */
        public static WxPayH5Api h5Api() {
            return builder().target(WxPayH5Api.class, ENDPOINT);
        }

        /**
         * appletApi.
         *
         * @return WxPayAppletApi
         */

        public static WxPayAppletApi appletApi() {
            return builder().target(WxPayAppletApi.class, ENDPOINT);
        }

        /**
         * faceApi.
         *
         * @return WxPayFaceApi
         */
        public static WxPayFaceApi faceApi() {
            return builder().target(WxPayFaceApi.class, ENDPOINT);
        }
    }
}
