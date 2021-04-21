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
     * USER_AGENT.
     */
    public static final String USER_AGENT
            = "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)";
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
        this.setXmlDecoder(CcbWlptXmlDecoder.INSTANCE);
    }

    /**
     * getOnlineMerchantApi.
     *
     * @param properties properties
     * @return CcbWlptOnlineMerchantApi
     */
    public CcbWlptOnlineMerchantApi
    onlineMerchantApi(final CcbWlptProperties properties) {
        return this.xmlApi(properties, CcbWlptOnlineMerchantApi.class);
    }

    /**
     * getUrlApi.
     *
     * @param properties properties
     * @return CcbWlptUrlApi
     */
    private CcbWlptUrlApi
    urlApi(final CcbWlptProperties properties) {
        return this.xmlApi(properties, CcbWlptUrlApi.class);
    }

    /**
     * getUrlInfo.
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
