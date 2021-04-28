package cn.shishuihao.thirdparty.api.pay.chinaums.sdk.util;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.HmacAlgorithms;
import org.apache.commons.codec.digest.HmacUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Base64;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class AuthorizationUtilsTest {

    @Test
    void getAuthorization() {
        final String appId = "12345678901234567890123456789012";
        final String timestamp = "20170101120000";
        final String nonce = "09876543210987654321098765432109";
        final byte[] bytesA = new byte[]{65};
        final String strB = DigestUtils.sha256Hex(bytesA).toLowerCase();
        Assertions.assertEquals("559aead08264d5795d3909718cdd05abd49572e84fe55590eef31a88a08fdffd", strB);
        final String strC = appId + timestamp + nonce + strB;
        Assertions.assertEquals("123456789012345678901234567890122017010112000009876543210987654321098765432109" +
                "559aead08264d5795d3909718cdd05abd49572e84fe55590eef31a88a08fdffd", strC);
        final String strD = "67890123456789012345678901234567";
        final byte[] bytesE = new HmacUtils(HmacAlgorithms.HMAC_SHA_256, strD).hmac(strC);
        Assertions.assertArrayEquals(new byte[]{0x18, (byte) 0x83, 0x6c, 0x09, 0x3c, (byte) 0x8d, 0x29, 0x3a, 0x44, 0x23,
                (byte) 0xd2, (byte) 0x97, 0x3b, 0x5e, (byte) 0x8a, (byte) 0xa9, (byte) 0x92, (byte) 0x7a, (byte) 0xe1,
                (byte) 0xf3, (byte) 0xb2, 0x03, 0x2b, 0x44, 0x2a, 0x5f, 0x1a, 0x69, 0x1f, (byte) 0xc3, (byte) 0xcb, 0x4f}, bytesE);
        final String strF = Base64.getEncoder()
                .encodeToString(bytesE);
        Assertions.assertEquals("GINsCTyNKTpEI9KXO16KqZJ64fOyAytEKl8aaR/Dy08=", strF);
    }
}