package cn.shishuihao.thirdparty.api.push.huawei.sdk;

import cn.shishuihao.thirdparty.api.commons.http.codec.JacksonDecoder;
import cn.shishuihao.thirdparty.api.commons.http.codec.JacksonEncoder;
import cn.shishuihao.thirdparty.api.push.huawei.sdk.api.HuaweiPushApi;
import feign.Feign;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public final class HuaweiFactory {
    /**
     * HTTPS POST URL.
     */
    public static final String ENDPOINT = "https://api.push.hicloud.com";

    private HuaweiFactory() {
    }

    public static final class Push {
        private Push() {

        }

        private static Feign.Builder builder() {
            return Feign.builder()
                    .encoder(JacksonEncoder.INSTANCE)
                    .decoder(JacksonDecoder.INSTANCE);
        }

        /**
         * build pushApi.
         *
         * @return HuaweiPushApi
         */
        public static HuaweiPushApi pushApi() {
            return builder().target(HuaweiPushApi.class, ENDPOINT);
        }
    }
}
