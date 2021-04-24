package cn.shishuihao.thirdparty.api.pay.wechat.sdk.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

/**
 * {@link "https://pay.weixin.qq.com/wiki/doc/api/micropay.php?chapter=4_3"}
 *
 * @author shishuihao
 * @version 1.0.0
 */
class SignTypeTest {

    @Test
    void sign() throws UnsupportedEncodingException {
        String key = "192006250b4c09247ec02edce69f6a2d";
        Map<String, Object> map = new HashMap<>();
        map.put("appid", "wxd930ea5d5a258f4f");
        map.put("mch_id", "10000100");
        map.put("device_info", "1000");
        map.put("body", "test");
        map.put("nonce_str", "ibuaiVcKdpRxkhJA");
        Assertions.assertEquals("9A0A8659F005D6984697E2CA0A9CF3B7",
                SignType.MD5.sign(key, map).toUpperCase());
        Assertions.assertEquals("6A9AE1657590FD6257D693A078E1C3E4BB6BA4DC30B23E0EE2496E54170DACD6",
                SignType.HMAC_SHA256.sign(key, map).toUpperCase());
    }
}
