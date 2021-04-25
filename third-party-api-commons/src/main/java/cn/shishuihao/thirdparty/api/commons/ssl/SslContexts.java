package cn.shishuihao.thirdparty.api.commons.ssl;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import nl.altindag.sslcontext.SSLFactory;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import java.time.Duration;
import java.util.Optional;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public class SslContexts {
    /**
     * SSLFactory Cache.
     */
    private final Cache<SslContextProperties, SSLFactory>
            sslFactoryCache;

    /**
     * SslContexts.
     *
     * @param cacheDuration expireAfterWrite
     */
    public SslContexts(final Duration cacheDuration) {
        this.sslFactoryCache = Caffeine.newBuilder()
                .expireAfterWrite(cacheDuration)
                .build();
    }

    /**
     * 获取SSLFactory.
     *
     * @param properties 属性
     * @return maybe {@code null}
     */
    public SSLFactory sslFactory(
            final SslContextProperties properties) {
        return sslFactoryCache.get(properties, k ->
                properties.sslFactory());
    }

    /**
     * 获取SSLContext.
     *
     * @param properties 属性
     * @return maybe {@code null}
     */
    public SSLContext sslContext(
            final SslContextProperties properties) {
        return Optional.ofNullable(sslFactory(properties))
                .map(SSLFactory::getSslContext)
                .orElse(null);
    }

    /**
     * 获取hostnameVerifier.
     *
     * @param properties 属性
     * @return maybe {@code null}
     */
    public HostnameVerifier hostnameVerifier(
            final SslContextProperties properties) {
        return Optional.ofNullable(sslFactory(properties))
                .map(SSLFactory::getHostnameVerifier)
                .orElse(null);
    }
}
