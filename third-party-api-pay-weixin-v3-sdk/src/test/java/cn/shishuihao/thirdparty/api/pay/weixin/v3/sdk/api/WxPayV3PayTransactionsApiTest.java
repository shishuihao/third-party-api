package cn.shishuihao.thirdparty.api.pay.weixin.v3.sdk.api;

import cn.shishuihao.thirdparty.api.pay.weixin.v3.sdk.WxV3Factory;
import cn.shishuihao.thirdparty.api.pay.weixin.v3.sdk.domain.WxPayV3PayTransaction;
import feign.FeignException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author shishuihao
 * @version 1.0.0
 */

class WxPayV3PayTransactionsApiTest {

    @Test
    void getByTransactionId() {
        FeignException apiException = Assertions.assertThrows(FeignException.class, () -> {
            WxPayV3PayTransaction transaction = WxV3Factory.Payment.payTransactionsApi()
                    .getByTransactionId("1230000109", "1217752501201407033233368018");
            Assertions.assertEquals("1217752501201407033233368018", transaction.getTransactionId());
        });
        Assertions.assertEquals(401, apiException.status());
    }

    @Test
    void getByOutTradeNo() {
        FeignException apiException = Assertions.assertThrows(FeignException.class, () -> {
            WxPayV3PayTransaction transaction = WxV3Factory.Payment.payTransactionsApi()
                    .getByOutTradeNo("1230000109", "1217752501201407033233368018");
            Assertions.assertEquals("1217752501201407033233368018", transaction.getTransactionId());
        });
        Assertions.assertEquals(401, apiException.status());
    }

    @Test
    void close() {
        FeignException apiException = Assertions.assertThrows(FeignException.class, () -> {
            WxV3Factory.Payment.payTransactionsApi()
                    .close("1230000109", "1217752501201407033233368018");
        });
        Assertions.assertEquals(401, apiException.status());
    }
}