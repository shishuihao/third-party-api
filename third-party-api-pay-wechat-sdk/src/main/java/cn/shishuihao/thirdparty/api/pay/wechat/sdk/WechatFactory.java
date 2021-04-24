package cn.shishuihao.thirdparty.api.pay.wechat.sdk;

import cn.shishuihao.thirdparty.api.pay.wechat.sdk.api.WechatPayAppApi;
import cn.shishuihao.thirdparty.api.pay.wechat.sdk.api.WechatPayAppletApi;
import cn.shishuihao.thirdparty.api.pay.wechat.sdk.api.WechatPayCodeApi;
import cn.shishuihao.thirdparty.api.pay.wechat.sdk.api.WechatPayCommonApi;
import cn.shishuihao.thirdparty.api.pay.wechat.sdk.api.WechatPayFaceApi;
import cn.shishuihao.thirdparty.api.pay.wechat.sdk.api.WechatPayH5Api;
import cn.shishuihao.thirdparty.api.pay.wechat.sdk.api.WechatPayJsApi;
import cn.shishuihao.thirdparty.api.pay.wechat.sdk.api.WechatPayNativeApi;
import cn.shishuihao.thirdparty.api.pay.wechat.sdk.codec.WechatXmlDecoder;
import cn.shishuihao.thirdparty.api.pay.wechat.sdk.codec.WechatXmlEncoder;
import feign.Feign;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public final class WechatFactory {
    /**
     * ENDPOINT.
     */
    public static final String ENDPOINT = "https://api.mch.weixin.qq.com";

    private WechatFactory() {
    }

    public static final class Payment {
        private Payment() {
        }

        private static Feign.Builder builder() {
            return Feign.builder()
                    .encoder(WechatXmlEncoder.INSTANCE)
                    .decoder(WechatXmlDecoder.INSTANCE);
        }

        /**
         * commonApi.
         *
         * @return WechatPayCommonApi
         */
        public static WechatPayCommonApi commonApi() {
            return builder().target(WechatPayCommonApi.class, ENDPOINT);
        }

        /**
         * codeApi.
         *
         * @return WechatPayCodeApi
         */
        public static WechatPayCodeApi codeApi() {
            return builder().target(WechatPayCodeApi.class, ENDPOINT);
        }

        /**
         * jsApi.
         *
         * @return WechatPayJsApi
         */
        public static WechatPayJsApi jsApi() {
            return builder().target(WechatPayJsApi.class, ENDPOINT);
        }

        /**
         * nativeApi.
         *
         * @return WechatPayNativeApi
         */
        public static WechatPayNativeApi nativeApi() {
            return builder().target(WechatPayNativeApi.class, ENDPOINT);
        }

        /**
         * appApi.
         *
         * @return WechatPayAppApi
         */
        public static WechatPayAppApi appApi() {
            return builder().target(WechatPayAppApi.class, ENDPOINT);
        }

        /**
         * h5Api.
         *
         * @return WechatPayH5Api
         */
        public static WechatPayH5Api h5Api() {
            return builder().target(WechatPayH5Api.class, ENDPOINT);
        }

        /**
         * appletApi.
         *
         * @return WechatPayAppletApi
         */

        public static WechatPayAppletApi appletApi() {
            return builder().target(WechatPayAppletApi.class, ENDPOINT);
        }

        /**
         * faceApi.
         *
         * @return WechatPayFaceApi
         */
        public static WechatPayFaceApi faceApi() {
            return builder().target(WechatPayFaceApi.class, ENDPOINT);
        }
    }
}
