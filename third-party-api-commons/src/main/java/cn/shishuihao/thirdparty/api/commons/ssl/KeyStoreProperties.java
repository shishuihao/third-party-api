package cn.shishuihao.thirdparty.api.commons.ssl;

import lombok.Getter;
import lombok.Setter;
import nl.altindag.sslcontext.SSLFactory;

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
     * 获取SSLFactory.
     *
     * @return maybe {@code null}
     */
    @Override
    public SSLFactory sslFactory() {
        if (keyStorePath == null) {
            return null;
        }
        if (keyStoreType == null) {
            throw new IllegalArgumentException("keyStoreType is null");
        }
        if (keyStorePassword == null) {
            throw new IllegalArgumentException("keyStorePassword is null");
        }
        return SSLFactory.builder()
                .withIdentityMaterial(
                        keyStorePath,
                        keyStorePassword.toCharArray(),
                        keyStoreType)
                .build();
    }
}
