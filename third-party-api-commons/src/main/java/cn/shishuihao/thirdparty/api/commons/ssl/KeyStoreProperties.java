package cn.shishuihao.thirdparty.api.commons.ssl;

import lombok.Getter;
import lombok.Setter;
import nl.altindag.sslcontext.SSLFactory;

import javax.net.ssl.SSLContext;

/**
 * @author shishuihao
 * @version 1.0.0
 */
@Setter
@Getter
public class KeyStoreProperties implements SslContextProperties {
    /**
     * 证书类型.
     */
    private String keyStoreType = "PKCS12";
    /**
     * 证书路径.
     */
    private String keyStorePath;
    /**
     * 证书密码.
     */
    private String keyStorePassword;

    /**
     * 获取sslContext.
     *
     * @return SSLContext
     */
    @Override
    public SSLContext sslContext() {
        return SSLFactory.builder()
                .withIdentityMaterial(
                        keyStorePath,
                        keyStorePassword.toCharArray(),
                        keyStoreType)
                .build()
                .getSslContext();
    }
}
