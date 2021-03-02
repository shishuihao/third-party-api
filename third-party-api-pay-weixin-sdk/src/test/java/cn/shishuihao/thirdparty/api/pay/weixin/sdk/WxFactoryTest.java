package cn.shishuihao.thirdparty.api.pay.weixin.sdk;

import cn.shishuihao.thirdparty.api.pay.weixin.sdk.request.WxPayMicropayRequest;
import cn.shishuihao.thirdparty.api.pay.weixin.sdk.response.WxPayMicropayResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class WxFactoryTest {
    @Test
    void getPayApi() {
        WxPayMicropayResponse response = WxFactory.Payment.codeApi()
                .microPay(WxPayMicropayRequest.Builder.builder()
                        .appId("wx2421b1c4370ec43b")
                        .attach("订单额外描述")
                        .authCode("120269300684844649")
                        .body("付款码支付测试")
                        .deviceInfo("1000")
                        .goodsTag("")
                        .mchId("10000100")
                        .nonceStr("8aaee146b1dee7cec9100add9b96cbe2")
                        .outTradeNo("1415757673")
                        .spBillCreateIp("14.17.22.52")
                        .timeExpire("")
                        .totalFee(1)
                        .sign("C29DB7DB1FD4136B84AE35604756362C")
                        .build());
        Assertions.assertEquals("FAIL", response.getReturnCode());
    }
}