package cn.shishuihao.thirdparty.api.commons.http;

import cn.shishuihao.thirdparty.api.commons.http.codec.JacksonDecoder;
import cn.shishuihao.thirdparty.api.commons.http.codec.JacksonEncoder;
import cn.shishuihao.thirdparty.api.commons.http.codec.JacksonXmlDecoder;
import cn.shishuihao.thirdparty.api.commons.http.codec.JacksonXmlEncoder;
import cn.shishuihao.thirdparty.api.commons.ssl.KeyStoreProperties;
import cn.shishuihao.thirdparty.api.commons.ssl.SslContexts;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import feign.Client;
import feign.Feign;
import feign.codec.Decoder;
import feign.codec.Encoder;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import java.time.Duration;
import java.util.Optional;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@RequiredArgsConstructor
@Getter
public class HttpClient {
    /**
     * USER_AGENT.
     */
    public static final String USER_AGENT
            = "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)";
    /**
     * SslContexts.
     */
    private final SslContexts sslContexts;
    /**
     * Cache.
     */
    private final Cache<KeyStoreProperties, Object> cache;

    /**
     * HttpClient.
     *
     * @param pUrl          url
     * @param cacheDuration expireAfterWrite
     */
    public HttpClient(final String pUrl,
                      final Duration cacheDuration) {
        this.url = pUrl;
        this.sslContexts = new SslContexts(cacheDuration);
        this.cache = Caffeine.newBuilder()
                .expireAfterWrite(cacheDuration)
                .build();
    }

    /**
     * HttpClient.
     *
     * @param pUrl url
     */
    public HttpClient(final String pUrl) {
        this(pUrl, Duration.ofHours(1));
    }

    /**
     * url.
     */
    @Setter
    private String url;
    /**
     * xmlEncoder.
     */
    @Setter(value = AccessLevel.PROTECTED)
    private Encoder xmlEncoder = JacksonXmlEncoder.INSTANCE;
    /**
     * xmlDecoder.
     */
    @Setter(value = AccessLevel.PROTECTED)
    private Decoder xmlDecoder = JacksonXmlDecoder.INSTANCE;
    /**
     * jsonEncoder.
     */
    @Setter(value = AccessLevel.PROTECTED)
    private Encoder jsonEncoder = JacksonEncoder.INSTANCE;
    /**
     * jsonDecoder.
     */
    @Setter(value = AccessLevel.PROTECTED)
    private Decoder jsonDecoder = JacksonDecoder.INSTANCE;

    /**
     * get new xml api instance.
     *
     * @param properties properties
     * @param apiType    api type
     * @param <T>        api type
     * @return T new api instance
     */
    public <T> T xmlApi(final KeyStoreProperties properties,
                        final Class<T> apiType) {
        return builder(properties)
                .encoder(xmlEncoder)
                .decoder(xmlDecoder)
                .target(apiType, url);
    }

    /**
     * get new json api instance.
     *
     * @param properties properties
     * @param apiType    api type
     * @param <T>        api type
     * @return T new api instance
     */
    public <T> T jsonApi(final KeyStoreProperties properties,
                         final Class<T> apiType) {
        return builder(properties)
                .encoder(jsonEncoder)
                .decoder(jsonDecoder)
                .target(apiType, url);
    }

    private Feign.Builder builder(final Client client) {
        return Feign.builder()
                .client(client);
    }

    private Feign.Builder builder(final SSLSocketFactory sslSocketFactory,
                                  final HostnameVerifier hostnameVerifier) {
        return builder(new Client
                .Default(sslSocketFactory, hostnameVerifier));
    }

    private Feign.Builder builder(final SSLContext sslContext,
                                  final HostnameVerifier hostnameVerifier) {
        return builder(
                Optional.ofNullable(sslContext)
                        .map(SSLContext::getSocketFactory)
                        .orElse(null),
                hostnameVerifier
        );
    }

    private Feign.Builder builder(final KeyStoreProperties properties) {
        return builder(
                Optional.ofNullable(properties)
                        .map(sslContexts::sslContext)
                        .orElse(null),
                Optional.ofNullable(properties)
                        .map(sslContexts::hostnameVerifier)
                        .orElse(null)
        );
    }
}
