package cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk;

import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.api.CcbWlptFileApi;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.api.CcbWlptOfflineMerchantApi;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.api.CcbWlptOnlineMerchantApi;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.api.CcbWlptUrlApi;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.codec.CcbWlptXmlDecoder;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.codec.CcbWlptXmlEncoder;
import feign.Client;
import feign.Feign;

import javax.net.ssl.SSLContext;
import java.util.Optional;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public final class CcbWlptFactory {
    /**
     * USER_AGENT.
     */
    public static final String USER_AGENT
            = "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)";
    /**
     * ENDPOINT.
     */
    public static final String ENDPOINT = "https://merchant.ccb.com";

    private CcbWlptFactory() {
    }

    public static final class Payment {
        private Payment() {
        }

        private static Feign.Builder builder(final SSLContext sslContext) {
            return Feign.builder()
                    .encoder(CcbWlptXmlEncoder.INSTANCE)
                    .decoder(CcbWlptXmlDecoder.INSTANCE)
                    .client(new Client.Default(
                            Optional.ofNullable(sslContext)
                                    .map(SSLContext::getSocketFactory)
                                    .orElse(null),
                            null));
        }

        /**
         * urlApi.
         *
         * @param sslContext sslContext
         * @return CcbWlptUrlApi
         */
        public static CcbWlptUrlApi
        urlApi(final SSLContext sslContext) {
            return builder(sslContext)
                    .target(CcbWlptUrlApi.class, ENDPOINT);
        }

        /**
         * fileApi.
         *
         * @param sslContext sslContext
         * @return CcbWlptFileApi
         */
        public static CcbWlptFileApi
        fileApi(final SSLContext sslContext) {
            return builder(sslContext)
                    .target(CcbWlptFileApi.class, ENDPOINT);
        }

        /**
         * offlineMerchantApi.
         *
         * @param sslContext sslContext
         * @return CcbWlptOfflineMerchantApi
         */
        public static CcbWlptOfflineMerchantApi
        offlineMerchantApi(final SSLContext sslContext) {
            return builder(sslContext)
                    .target(CcbWlptOfflineMerchantApi.class, ENDPOINT);
        }

        /**
         * onlineMerchantApi.
         *
         * @param sslContext sslContext
         * @return CcbWlptOfflineMerchantApi
         */
        public static CcbWlptOnlineMerchantApi
        onlineMerchantApi(final SSLContext sslContext) {
            return builder(sslContext)
                    .target(CcbWlptOnlineMerchantApi.class, ENDPOINT);
        }
    }
}
