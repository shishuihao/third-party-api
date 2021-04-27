package cn.shishuihao.thirdparty.api.pay.fuioupay.sdk.request;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class FuiouPaySmpQueryGateRequestTest {
    final String queryString = "smpQueryGate.do" +
            "?md5=5baf5be0d8d35b4428717f112a7a1baf" +
            "&mchnt_cd=0002900F0006944" +
            "&order_id=000001" +
            "&page_notify_url=http%3A%2F%2F127.0.0.1%3A8080%2Fpaytest%2FinfoResult.jsp" +
            "&back_notify_url=http%3A%2F%2F127.0.0.1%3A8080%2Fpaytest%2FinfoResult.jsp";
    final String key = "vau6p7ldawpezyaugc0kopdrrwm4gkpu";

    @Test
    void test() {
        FuiouPaySmpQueryGateRequest request = FuiouPaySmpQueryGateRequest.builder()
                .merchantCode("0002900F0006944")
                .orderId("000001")
                .pageNotifyUrl("http://127.0.0.1:8080/paytest/infoResult.jsp")
                .backNotifyUrl("http://127.0.0.1:8080/paytest/infoResult.jsp")
                .build();
        Assertions.assertEquals(queryString, "smpQueryGate.do?" + request.queryString(key));
    }
}