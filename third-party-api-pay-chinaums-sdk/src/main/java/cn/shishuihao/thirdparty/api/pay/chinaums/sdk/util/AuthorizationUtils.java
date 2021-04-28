package cn.shishuihao.thirdparty.api.pay.chinaums.sdk.util;

import cn.shishuihao.thirdparty.api.commons.time.LocalDateTimeUtils;
import cn.shishuihao.thirdparty.api.pay.chinaums.sdk.ChinaumnProperties;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.HmacAlgorithms;
import org.apache.commons.codec.digest.HmacUtils;
import org.apache.commons.lang3.RandomStringUtils;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Base64;

/**
 * @author shishuihao
 * @version 1.0.0
 */

public final class AuthorizationUtils {
    private AuthorizationUtils() {
    }

    /**
     * 获取认证内容.
     *
     * @param appId   appId
     * @param appKey  appKey
     * @param content 正文全部内容
     * @return String
     */
    public static String getAuthorization(
            final String appId,
            final String appKey,
            final String content) {
        final String timestamp = LocalDateTime.now()
                .format(LocalDateTimeUtils.COMPACT_DATE_TIME_FORMATTER);
        final String nonce = RandomStringUtils.randomNumeric(32);
        final byte[] bytesA = content.getBytes(StandardCharsets.UTF_8);
        final String strB = DigestUtils.sha256Hex(bytesA).toLowerCase();
        final String strC = appId + timestamp + nonce + strB;
        final byte[] bytesE = new HmacUtils(HmacAlgorithms.HMAC_SHA_256, appKey)
                .hmac(strC);
        final String strF = Base64.getEncoder()
                .encodeToString(bytesE);
        return "OPEN-BODY-SIG AppId=\""
                + appId + "\", Timestamp=\""
                + timestamp + "\", Nonce=\""
                + nonce + "\", Signature=\""
                + strF + "\"";
    }

    /**
     * 获取认证内容.
     *
     * @param properties 参数
     * @param content    正文全部内容
     * @return String
     */
    public static String getAuthorization(
            final ChinaumnProperties properties,
            final String content) {
        return getAuthorization(
                properties.getAppId(),
                properties.getAppKey(),
                content);
    }
}
