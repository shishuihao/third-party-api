package cn.shishuihao.thirdparty.api.push.huawei.sdk;

import cn.shishuihao.thirdparty.api.push.huawei.sdk.api.HuaweiPushApi;
import cn.shishuihao.thirdparty.api.push.huawei.sdk.codec.HuaweiJsonDecoder;
import cn.shishuihao.thirdparty.api.push.huawei.sdk.codec.HuaweiJsonEncoder;
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
                    .encoder(HuaweiJsonEncoder.INSTANCE)
                    .decoder(HuaweiJsonDecoder.INSTANCE);
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
