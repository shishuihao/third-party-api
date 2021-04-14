package cn.shishuihao.thirdparty.api.commons.ssl;

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
}
