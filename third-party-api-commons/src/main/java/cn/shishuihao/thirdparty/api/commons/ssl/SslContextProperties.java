package cn.shishuihao.thirdparty.api.commons.ssl;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public interface SslContextProperties {
    /**
     * 获取sslContext.
     *
     * @return SSLContext
     */
    SSLContext sslContext();

    /**
     * 获取hostnameVerifier.
     *
     * @return HostnameVerifier
     */
    HostnameVerifier hostnameVerifier();
}
