package cn.shishuihao.thirdparty.api.pay.ccb.hsb.sdk;

import cn.shishuihao.thirdparty.api.pay.ccb.hsb.sdk.api.CcbHsbOnlineDirectApi;
import cn.shishuihao.thirdparty.api.pay.ccb.hsb.sdk.codec.CcbHsbJsonDecoder;
import cn.shishuihao.thirdparty.api.pay.ccb.hsb.sdk.codec.CcbHsbJsonEncoder;
import feign.Feign;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public final class CcbHsbFactory {
    /**
     * ENDPOINT.
     */
    public static final String GATEWAY = "https://marketpay.ccb.com";

    private CcbHsbFactory() {
    }

    public static final class Payment {
        private Payment() {
        }

        private static Feign.Builder builder() {
            return Feign.builder()
                    .encoder(CcbHsbJsonEncoder.INSTANCE)
                    .decoder(CcbHsbJsonDecoder.INSTANCE);
        }

        /**
         * onlineDirectApi.
         *
         * @param gateway gateway
         * @return OnlineDirectApi
         */
        public static CcbHsbOnlineDirectApi onlineDirectApi(
                final String gateway) {
            return builder().target(CcbHsbOnlineDirectApi.class, gateway);
        }

        /**
         * onlineDirectApi.
         *
         * @return OnlineDirectApi
         */
        public static CcbHsbOnlineDirectApi onlineDirectApi() {
            return onlineDirectApi(GATEWAY);
        }
    }
}
