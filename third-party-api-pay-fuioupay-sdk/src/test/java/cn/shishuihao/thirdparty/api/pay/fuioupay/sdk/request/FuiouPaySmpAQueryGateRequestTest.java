package cn.shishuihao.thirdparty.api.pay.fuioupay.sdk.request;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class FuiouPaySmpAQueryGateRequestTest {
    final String queryString = "smpAQueryGate.do" +
            "?md5=d81c311f6b820cb1298c1ec906b99493" +
            "&mchnt_cd=0002900F0006944" +
            "&order_id=000001";
    final String key = "vau6p7ldawpezyaugc0kopdrrwm4gkpu";

    @Test
    void test() {
        FuiouPaySmpAQueryGateRequest request = FuiouPaySmpAQueryGateRequest.builder()
                .merchantCode("0002900F0006944")
                .orderId("000001")
                .build();
        Assertions.assertEquals(queryString, "smpAQueryGate.do?" + request.queryString(key));
    }
}