package cn.shishuihao.thirdparty.api.pay.fuioupay.sdk.request;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class FuiouPaySmpGateRequestTest {
    final String queryString = "/smpGate.do" +
            "?md5=e49a73c521fed36199a38411eaacf0d6" +
            "&mchnt_cd=0002900F0006944" +
            "&order_id=11032303195062458318" +
            "&order_amt=2000" +
            "&order_pay_type=B2C" +
            "&page_notify_url=http%3A%2F%2Flocalhost%3A8080%2Fpaytest%2Fresult.jsp" +
            "&back_notify_url=http%3A%2F%2Flocalhost%3A8080%2Fpaytest%2Fresult.jsp" +
            "&order_valid_time=10m" +
            "&iss_ins_cd=0803010000" +
            "&goods_name=Sony+W5500+%E6%B6%B2%E6%99%B6%E7%94%B5%E8%A7%86%28test%29" +
            "&goods_display_url=http%3A%2F%2F127.0.0.1%3A8080%2Fpaytest%2Findex.jsp";
    final String key = "vau6p7ldawpezyaugc0kopdrrwm4gkpu";

    @Test
    void test() {
        FuiouPaySmpGateRequest request = FuiouPaySmpGateRequest.builder()
                .merchantCode("0002900F0006944")
                .orderId("11032303195062458318")
                .orderAmount(2000)
                .orderPayType("B2C")
                .pageNotifyUrl("http://localhost:8080/paytest/result.jsp")
                .backNotifyUrl("http://localhost:8080/paytest/result.jsp")
                .orderValidTime("10m")
                .issuingInstitutionCode("0803010000")
                .goodsName("Sony W5500 液晶电视(test)")
                .goodsDisplayUrl("http://127.0.0.1:8080/paytest/index.jsp")
                .build();
        Assertions.assertEquals(queryString, "/smpGate.do?" + request.queryString(key));
    }
}