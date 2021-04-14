package cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk;

import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.api.CcbWlptOnlineMerchantApi;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.api.CcbWlptUrlApi;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.util.UrlInfoInterfaceUtils;
import com.ccb.wlpt.url.MerchantUrlInfo;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

import javax.net.ssl.SSLContext;
import java.time.Duration;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class CcbWlptPayClient {
    /**
     * SSLContext Cache.
     */
    private final Cache<CcbWlptProperties, SSLContext>
            sslContextCache = Caffeine.newBuilder()
            .expireAfterWrite(Duration.ofHours(1))
            .build();
    /**
     * CcbWlptUrlApi Cache.
     */
    private final Cache<CcbWlptProperties, CcbWlptUrlApi>
            urlApiCache = Caffeine.newBuilder()
            .expireAfterWrite(Duration.ofHours(1))
            .build();
    /**
     * CcbWlptOnlineMerchantApi Cache.
     */
    private final Cache<CcbWlptProperties, CcbWlptOnlineMerchantApi>
            onlineMerchantApiCache = Caffeine.newBuilder()
            .expireAfterWrite(Duration.ofHours(1))
            .build();
    /**
     * UrlInfo Cache.
     */
    private final Cache<CcbWlptProperties, MerchantUrlInfo> urlInfoCache
            = Caffeine.newBuilder()
            .expireAfterWrite(Duration.ofDays(1))
            .build();


    /**
     * getOnlineMerchantApi.
     *
     * @param properties properties
     * @return CcbWlptOnlineMerchantApi
     */
    public CcbWlptOnlineMerchantApi
    getOnlineMerchantApi(final CcbWlptProperties properties) {
        return onlineMerchantApiCache.get(properties, k ->
                CcbWlptFactory.Payment
                        .onlineMerchantApi(getSslContext(properties)));
    }

    /**
     * getUrlInfo.
     *
     * @param properties properties
     * @return MerchantUrlInfo
     */
    public MerchantUrlInfo
    getUrlInfo(final CcbWlptProperties properties) {
        return urlInfoCache.get(properties, k -> {
            String response = getUrlApi(properties)
                    .getUrl(properties.getCustomerId());
            return UrlInfoInterfaceUtils.getUrlInfo(response);
        });
    }

    /**
     * getUrlApi.
     *
     * @param properties properties
     * @return CcbWlptUrlApi
     */
    private CcbWlptUrlApi
    getUrlApi(final CcbWlptProperties properties) {
        return urlApiCache.get(properties, k ->
                CcbWlptFactory.Payment.urlApi(getSslContext(properties)));
    }


    private SSLContext getSslContext(final CcbWlptProperties properties) {
        return sslContextCache.get(properties, k ->
                properties.sslContext());
    }
}
