package cn.shishuihao.thirdparty.api.pay.ccb.sdk.request;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class CcbPay100RequestTest {
    final String host = "https://ibsbjstar.ccb.com.cn/CCBIS/B2CMainPlat_00_BEPAY";
    final String url = "https://ibsbjstar.ccb.com.cn/CCBIS/B2CMainPlat_00_BEPAY" +
            "?MERCHANTID=105421097080009" +
            "&POSID=902807340" +
            "&BRANCHID=360000000" +
            "&ccbParam=269dE0huScAzmN8oe9dIAaB2El1h1JpjPQ69oH6QPQnQBf%2FM%2CSFeJ5OK0h8ZAl1c0uguePLVn30c%0D%0AnPsPJg18SjTwBf71A2mG4YNeuyhIuwVV3Bd2ZkvHo8SmLHyng9UpwVVPyu0kWurf19P3ntAVLAkx%0D%0AXh74tqOM%2C%2Cq6q9ney4A%3D";
    /**
     * demo 完整公钥
     */
    final String publicKey = "30819d300d06092a864886f70d010101050003818b0030818702818100a32fb2d51dda418f65ca456431bd2f4173e41a82bb75c2338a6f649f8e9216204838d42e2a028c79cee19144a72b5b46fe6a498367bf41" +
            "43f959e4f73c9c4f499f68831f8663d6b946ae9fa31c74c9332bebf3cba1a98481533a37ffad944823bd46c305ec560648f1b6bcc64d54d32e213926b26cd10d342f2c61ff5ac2d78b020111";

    @Test
    void url() {
        final CcbPay100Request request = CcbPay100Request.builder()
                .merchantId("105421097080009")
                .posId("902807340")
                .branchId("360000000")
                .build();
        Assertions.assertEquals(url, request.url(host, publicKey));
    }
}