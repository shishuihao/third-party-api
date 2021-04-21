package cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk;

import cn.shishuihao.thirdparty.api.commons.http.HttpClient;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.api.CcbWlptOnlineMerchantApi;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.api.CcbWlptUrlApi;
import cn.shishuihao.thirdparty.api.pay.ccb.wlpt.sdk.codec.CcbWlptXmlDecoder;
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
        super(CcbWlptFactory.ENDPOINT);
        this.setXmlEncoder(CcbWlptXmlEncoder.INSTANCE);
        this.setXmlDecoder(CcbWlptXmlDecoder.INSTANCE);
    }

    /**
     * getOnlineMerchantApi.
     *
     * @param properties properties
     * @return CcbWlptOnlineMerchantApi
     */
    public CcbWlptOnlineMerchantApi
    getOnlineMerchantApi(final CcbWlptProperties properties) {
        return this.xmlApi(properties, CcbWlptOnlineMerchantApi.class);
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
        return this.xmlApi(properties, CcbWlptUrlApi.class);
    }
}
