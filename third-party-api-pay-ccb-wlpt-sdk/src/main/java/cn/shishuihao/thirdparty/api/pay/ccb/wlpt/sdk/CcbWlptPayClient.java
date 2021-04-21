package cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk;

import cn.shishuihao.thirdparty.api.commons.http.HttpClient;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.api.CcbWlptOnlineMerchantApi;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.api.CcbWlptUrlApi;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.codec.CcbWlptXmlEncoder;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.util.UrlInfoInterfaceUtils;
import com.ccb.wlpt.url.MerchantUrlInfo;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

import java.time.Duration;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class CcbWlptPayClient extends HttpClient {
    /**
     * ENDPOINT.
     */
    public static final String ENDPOINT = "https://merchant.ccb.com";

    /**
     * UrlInfo Cache.
     */
    private final Cache<CcbWlptProperties, MerchantUrlInfo> urlInfoCache
            = Caffeine.newBuilder()
            .expireAfterWrite(Duration.ofDays(1))
            .build();

    /**
     * new CcbWlptPayClient.
     */
    public CcbWlptPayClient() {
        super(ENDPOINT);
        this.setXmlEncoder(CcbWlptXmlEncoder.INSTANCE);
    }

    /**
     * onlineMerchantApi.
     *
     * @param properties properties
     * @return CcbWlptOnlineMerchantApi
     */
    public CcbWlptOnlineMerchantApi
    onlineMerchantApi(final CcbWlptProperties properties) {
        return this.xmlApi(properties, CcbWlptOnlineMerchantApi.class);
    }

    /**
     * urlApi.
     *
     * @param properties properties
     * @return CcbWlptUrlApi
     */
    private CcbWlptUrlApi
    urlApi(final CcbWlptProperties properties) {
        return this.xmlApi(properties, CcbWlptUrlApi.class);
    }

    /**
     * urlInfo.
     *
     * @param properties properties
     * @return MerchantUrlInfo
     */
    public MerchantUrlInfo
    urlInfo(final CcbWlptProperties properties) {
        return urlInfoCache.get(properties, k -> {
            final String response = urlApi(properties)
                    .getUrl(properties.getCustomerId());
            return UrlInfoInterfaceUtils.getUrlInfo(response);
        });
    }
}
