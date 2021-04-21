package cn.shishuihao.thirdparty.api.commons.ssl;

import nl.altindag.sslcontext.SSLFactory;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public interface SslContextProperties {
    /**
     * 获取SSLFactory.
     *
     * @return maybe {@code null}
     */
    SSLFactory sslFactory();
}
