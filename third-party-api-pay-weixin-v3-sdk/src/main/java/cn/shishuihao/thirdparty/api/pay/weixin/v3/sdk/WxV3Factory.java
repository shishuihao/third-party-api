package cn.shishuihao.thirdparty.api.pay.weixin.v3.sdk;

import cn.shishuihao.thirdparty.api.pay.weixin.v3.sdk.api.WxPayV3PayTransactionsApi;
import cn.shishuihao.thirdparty.api.pay.weixin.v3.sdk.codec.WxJacksonDecoder;
import cn.shishuihao.thirdparty.api.pay.weixin.v3.sdk.codec.WxJacksonEncoder;
import feign.Feign;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public final class WxV3Factory {
    /**
     * ENDPOINT.
     */
    public static final String ENDPOINT = "https://api.mch.weixin.qq.com";

    private WxV3Factory() {
    }

    public static final class Payment {
        private Payment() {
        }

        private static Feign.Builder builder() {
            return Feign.builder()
                    .encoder(WxJacksonEncoder.INSTANCE)
                    .decoder(WxJacksonDecoder.INSTANCE);
        }

        /**
         * commonApi.
         *
         * @return WxPayCommonApi
         */
        public static WxPayV3PayTransactionsApi payTransactionsApi() {
            return builder().target(WxPayV3PayTransactionsApi.class, ENDPOINT);
        }
    }
}
