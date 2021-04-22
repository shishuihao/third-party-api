package cn.shishuihao.thirdparty.api.pay.ccb.sdk;

import COM.CCB.EnDecryptAlgorithm.MCipherDecryptor;
import COM.CCB.EnDecryptAlgorithm.MCipherEncryptor;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.time.Duration;
import java.util.Optional;

/**
 * @author shishuihao
 * @version 1.0.0
 */
public final class CcbCryptorManager {
    /**
     * KEY_LENGTH.
     */
    private static final int KEY_LENGTH = 30;
    /**
     * MCipherEncryptor CACHE.
     */
    private static final Cache<String, MCipherEncryptor> EN_CACHE
            = Caffeine.newBuilder()
            .expireAfterWrite(Duration.ofHours(1))
            .build();
    /**
     * MCipherDecryptor CACHE.
     */
    private static final Cache<String, MCipherDecryptor> DE_CACHE
            = Caffeine.newBuilder()
            .expireAfterWrite(Duration.ofHours(1))
            .build();

    private CcbCryptorManager() {
    }

    /**
     * 加密.
     *
     * @param publicKey 公钥
     * @param src       源.
     * @return 密文
     * @throws CcbApiException 异常
     */
    public static String doEncrypt(
            final String publicKey, final String src)
            throws CcbApiException {
        if (publicKey.length() < KEY_LENGTH) {
            throw new CcbApiException("密钥长度不足" + KEY_LENGTH);
        }
        try {
            return Optional.ofNullable(EN_CACHE.get(publicKey, k ->
                    new MCipherEncryptor(publicKey
                            .substring(publicKey.length() - KEY_LENGTH))))
                    .orElseThrow(() -> new NoSuchProviderException("初始化加密器失败"))
                    .doEncrypt(src);
        } catch (InvalidKeyException | NoSuchAlgorithmException
                | NoSuchPaddingException | ShortBufferException
                | IllegalBlockSizeException | BadPaddingException
                | NoSuchProviderException | InvalidAlgorithmParameterException
                | UnsupportedEncodingException e) {
            throw new CcbApiException(e);
        }
    }

    /**
     * 解密.
     *
     * @param publicKey 公钥
     * @param encrypted 密文.
     * @return 源
     * @throws CcbApiException 异常
     */
    public static String doDecrypt(
            final String publicKey, final String encrypted)
            throws CcbApiException {
        if (publicKey.length() < KEY_LENGTH) {
            throw new CcbApiException("密钥长度不足" + KEY_LENGTH);
        }
        try {
            return Optional.ofNullable(DE_CACHE.get(publicKey, k ->
                    new MCipherDecryptor(publicKey
                            .substring(publicKey.length() - KEY_LENGTH))))
                    .orElseThrow(() -> new NoSuchProviderException("初始化解密器失败"))
                    .doDecrypt(encrypted);
        } catch (IOException | InvalidKeyException
                | NoSuchAlgorithmException | NoSuchPaddingException
                | ShortBufferException | IllegalBlockSizeException
                | BadPaddingException | NoSuchProviderException
                | InvalidAlgorithmParameterException e) {
            throw new CcbApiException(e);
        }
    }
}
