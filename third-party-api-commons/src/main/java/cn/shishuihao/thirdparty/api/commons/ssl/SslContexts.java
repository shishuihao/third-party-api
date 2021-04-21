package cn.shishuihao.thirdparty.api.commons.ssl;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import java.time.Duration;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class SslContexts {
    /**
     * SSLContext Cache.
     */
    private final Cache<KeyStoreProperties, SSLContext>
            sslContextCache = Caffeine.newBuilder()
            .expireAfterWrite(Duration.ofHours(1))
            .build();
    /**
     * HostnameVerifier Cache.
     */
    private final Cache<KeyStoreProperties, HostnameVerifier>
            hostnameVerifierCache = Caffeine.newBuilder()
            .expireAfterWrite(Duration.ofHours(1))
            .build();

    /**
     * 获取SSLContext.
     *
     * @param properties 属性
     * @return SSLContext
     */
    public SSLContext getSslContext(
            final KeyStoreProperties properties) {
        return sslContextCache.get(properties, k ->
                properties.sslContext());
    }

    /**
     * 获取hostnameVerifier.
     *
     * @param properties 属性
     * @return HostnameVerifier
     */
    public HostnameVerifier getHostnameVerifier(
            final KeyStoreProperties properties) {
        return hostnameVerifierCache.get(properties, k ->
                properties.hostnameVerifier());
    }
}
